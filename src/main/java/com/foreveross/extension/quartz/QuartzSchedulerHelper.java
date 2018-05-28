/*******************************************************************************
 * Copyright (c) Jan 28, 2016 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation
 ******************************************************************************/
package com.foreveross.extension.quartz;

import org.apache.commons.lang3.StringUtils;
import org.iff.infra.util.*;
import org.iff.infra.util.Logger.Log;
import org.iff.infra.util.mybatis.plugin.Page;
import org.iff.infra.util.spring.SpringContextHelper;
import org.quartz.*;
import org.quartz.Trigger.TriggerState;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.util.*;

/**
 * base quartz scheduler util
 *
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
 * @since Jan 28, 2016
 */
public class QuartzSchedulerHelper {

    private static final Log logger = Logger.get("FOSS.QUARTZ");

    /* quartz Scheduler */
    private static Scheduler scheduler;

    public static void setScheduler(Scheduler scheduler) {
        QuartzSchedulerHelper.scheduler = scheduler;
    }

    public static Scheduler getScheduler() {
        if (scheduler == null) {
            scheduler = SpringContextHelper.getBean("quartzScheduler");
        }
        return scheduler;
    }

    public void afterPropertiesSet() throws Exception {
        Assert.notNull(getScheduler(), "quartz scheduler is null");
        logger.info(FCS.get("init quartz scheduler success.[{0}]", getScheduler()));
    }

    public static Page<?> pageFindJob(QuartzJobInfoVO vo) {
        List<QuartzJobInfoVO> list = new ArrayList<QuartzJobInfoVO>(128);
        try {
            Scheduler scheduler = getScheduler();
            GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
            Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
            for (JobKey jobKey : jobKeys) {
                List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
                String jobName = jobKey.getName();
                String jobGroup = jobKey.getGroup();
                JobDetail jobDetail = getScheduler().getJobDetail(jobKey);
                if (triggers == null || triggers.isEmpty()) {
                    triggers.add(null);//如果没有触发器，也可以只显示Job信息
                }
                for (Trigger trigger : triggers) {
                    QuartzJobInfoVO job = QuartzJobInfoVO.create(jobName, jobGroup);
                    if (trigger != null) {//如果没有触发器，也可以只显示Job信息
                        Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
                        if (triggerState != null) {
                            job.setJobStatus(triggerState.name());
                        }
                        if (trigger instanceof CronTrigger) {
                            CronTrigger cronTrigger = (CronTrigger) trigger;
                            String cronExpression = cronTrigger.getCronExpression();
                            job.setJobCron(cronExpression);
                        }
                    }
                    if (jobDetail != null) {
                        JobDataMap jobDataMap = jobDetail.getJobDataMap();
                        String jobClass = jobDetail.getJobClass().getName();
                        job.setJobClass(jobClass);
                        job.setRecovery(jobDetail.requestsRecovery() ? "Y" : "N");
                        job.setDurably(jobDetail.isDurable() ? "Y" : "N");
                        job.setStatus(jobDataMap.getString("STATUS"));
                        job.setBody(jobDataMap.getString("BODY"));
                        job.setScript(jobDataMap.getString("SCRIPT"));
                        {
                            jobDataMap.remove("SCRIPT");
                            jobDataMap.remove("STATUS");
                            jobDataMap.remove("BODY");
                        }
                        job.setJobData(GsonHelper.toJsonString(jobDataMap));
                    }
                    list.add(job);
                }
            }
        } catch (Exception e) {
        }
        return Page.offsetPage(0, list.size(), list);
    }

    /**
     * fill job info
     *
     * @param jobInfo
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since May 9, 2016
     */
    public static QuartzJobInfoVO fillJobInfo(QuartzJobInfoVO jobInfo) {
        /* TriggerKey : name + group */
        TriggerKey triggerKey = TriggerKey.triggerKey(jobInfo.getJobName(), jobInfo.getJobGroup());
        JobKey jobKey = new JobKey(jobInfo.getJobName(), jobInfo.getJobGroup());
        try {
            Trigger trigger = getScheduler().getTrigger(triggerKey);
            JobDetail jobDetail = getScheduler().getJobDetail(jobKey);
            TriggerState triggerState = getScheduler().getTriggerState(triggerKey);

            /* parse params */
            if (trigger != null && trigger instanceof CronTriggerImpl) {
                String cronExpression = ((CronTriggerImpl) trigger).getCronExpression();
                jobInfo.setJobCron(cronExpression);
            }
            if (jobDetail != null) {
                JobDataMap jobDataMap = jobDetail.getJobDataMap();
                String jobClass = jobDetail.getJobClass().getName();
                jobInfo.setJobClass(jobClass);
                jobInfo.setRecovery(jobDetail.requestsRecovery() ? "Y" : "N");
                jobInfo.setDurably(jobDetail.isDurable() ? "Y" : "N");
                jobInfo.setStatus(jobDataMap.getString("STATUS"));
                jobInfo.setBody(jobDataMap.getString("BODY"));
                jobInfo.setScript(jobDataMap.getString("SCRIPT"));
                {
                    jobDataMap.remove("SCRIPT");
                    jobDataMap.remove("STATUS");
                    jobDataMap.remove("BODY");
                }
                jobInfo.setJobData(GsonHelper.toJsonString(jobDataMap));
            }
            if (triggerState != null) {
                jobInfo.setJobStatus(triggerState.name());
            }
        } catch (Exception e) {
            Exceptions.runtime("fill job info error.", e);
        }
        return jobInfo;
    }

    /**
     * check if exists
     *
     * @param jobName
     * @param jobGroup
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since May 9, 2016
     */
    public static boolean checkExists(String jobName, String jobGroup) {
        boolean result = false;
        try {
            JobKey jobKey = new JobKey(jobName, jobGroup);
            result = getScheduler().checkExists(jobKey);
        } catch (Exception e) {
            Exceptions.runtime("check exists a job error.", e);
        }
        return result;
    }

    /**
     * add a job.
     *
     * @param jobInfo
     * @return
     * @throws SchedulerException
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since May 9, 2016
     */
    @SuppressWarnings("unchecked")
    public static boolean addJob(QuartzJobInfoVO jobInfo) {
        boolean result = false;
        try {
            /* TriggerKey : name + group */
            TriggerKey triggerKey = TriggerKey.triggerKey(jobInfo.getJobName(), jobInfo.getJobGroup());
            JobKey jobKey = new JobKey(jobInfo.getJobName(), jobInfo.getJobGroup());

            /* TriggerKey valid if_exists */
            if (checkExists(jobInfo.getJobName(), jobInfo.getJobGroup())) {
                logger.info(FCS.get("addJob fail, job already exist, jobInfo:{0}", jobInfo));
                return result;
            }

            /* CronTrigger : TriggerKey + cronExpression	withMisfireHandlingInstructionDoNothing 忽略掉调度终止过程中忽略的调度 */
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(jobInfo.getJobCron())
                    .withMisfireHandlingInstructionDoNothing();
            CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerKey)// 给该Trigger起一个id
                    .withSchedule(cronScheduleBuilder).build();

            /* JobDetail : jobClass */
            Class<? extends Job> jobClass_ = null;
            try {
                jobClass_ = (Class<? extends Job>) Class.forName(jobInfo.getJobClass());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            JobBuilder builder = JobBuilder.newJob(jobClass_);// 实现的Job类
            {
                builder.withIdentity(jobKey);// 可以给该JobDetail起一个id，便于之后的检索;
                if ("Y".equals(jobInfo.getRecovery())) {
                    builder.requestRecovery(); // 执行中应用发生故障，需要重新执行
                }
                if ("Y".equals(jobInfo.getDurably())) {
                    builder.storeDurably(); // 即使没有Trigger关联时，也不需要删除该JobDetail
                }
            }
            JobDetail jobDetail = builder.build();
            JobDataMap jobDataMap = jobDetail.getJobDataMap();
            if (!StringUtils.isBlank(jobInfo.getJobData()) && !"{}".equals(jobInfo.getJobData())) {
                jobDataMap.putAll(GsonHelper.toJsonMap(jobInfo.getJobData()));
            }
            jobDataMap.put("SCRIPT", jobInfo.getScript());

            /* schedule : jobDetail + cronTrigger */
            Date date = getScheduler().scheduleJob(jobDetail, cronTrigger);

            logger.info(
                    FCS.get("addJob success, jobDetail:{0}, cronTrigger:{1}, date:{2}", jobDetail, cronTrigger, date));
            result = true;
        } catch (Exception e) {
            Exceptions.runtime("add a job error.", e);
        }
        return result;
    }

    /**
     * reschedule a job.
     *
     * @param jobInfo
     * @return
     * @throws SchedulerException
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since May 9, 2016
     */
    @SuppressWarnings("unchecked")
    public static boolean rescheduleJob(QuartzJobInfoVO jobInfo) {
        boolean result = false;
        try {
            /* TriggerKey valid if_exists */
            if (!checkExists(jobInfo.getJobName(), jobInfo.getJobGroup())) {
                logger.info(FCS.get("rescheduleJob fail, job not exists, jobInfo:{0}", jobInfo));
                return result;
            }

            /* TriggerKey : name + group */
            TriggerKey triggerKey = TriggerKey.triggerKey(jobInfo.getJobName(), jobInfo.getJobGroup());
            JobKey jobKey = new JobKey(jobInfo.getJobName(), jobInfo.getJobGroup());

            /* CronTrigger : TriggerKey + cronExpression */
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(jobInfo.getJobCron())
                    .withMisfireHandlingInstructionDoNothing();
            CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerKey)
                    .withSchedule(cronScheduleBuilder).build();

            //getScheduler().rescheduleJob(triggerKey, cronTrigger);

            /* JobDetail-JobDataMap fresh */
            JobDetail jobDetail = getScheduler().getJobDetail(jobKey);
            JobDataMap jobDataMap = jobDetail.getJobDataMap();
            jobDataMap.clear();
            if (!StringUtils.isBlank(jobInfo.getJobData()) && !"{}".equals(jobInfo.getJobData())) {
                jobDataMap.putAll(GsonHelper.toJsonMap(jobInfo.getJobData()));
            }
            jobDataMap.put("SCRIPT", jobInfo.getScript());

            /* Trigger fresh */
            HashSet<Trigger> triggerSet = new HashSet<Trigger>();
            triggerSet.add(cronTrigger);

            getScheduler().scheduleJob(jobDetail, triggerSet, true);
            logger.info(FCS.get("resumeJob success, jobInfo:{0}", jobInfo));
            result = true;
        } catch (Exception e) {
            Exceptions.runtime("reschedule a job error.", e);
        }
        return result;
    }

    /**
     * remove(unschedule) a job.
     *
     * @param jobName
     * @param jobGroup
     * @return
     * @throws SchedulerException
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since May 9, 2016
     */
    public static boolean removeJob(String jobName, String jobGroup) {
        boolean result = false;
        try {
            /* TriggerKey : name + group */
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
            if (checkExists(jobName, jobGroup)) {
                result = getScheduler().unscheduleJob(triggerKey);
                logger.info(FCS.get("removeJob, triggerKey:{0}, result [{1}]", triggerKey, result));
            }
        } catch (Exception e) {
            Exceptions.runtime("remove(unschedule) a job error.", e);
        }
        return result;
    }

    /**
     * delete a job.
     *
     * @param jobName
     * @param jobGroup
     * @return
     * @throws SchedulerException
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since May 9, 2016
     */
    public static boolean deleteJob(String jobName, String jobGroup) {
        boolean result = false;
        try {
            removeJob(jobName, jobGroup);
            /* JobKey : name + group */
            JobKey jobKey = new JobKey(jobName, jobGroup);
            if (checkExists(jobName, jobGroup)) {
                result = getScheduler().deleteJob(jobKey);
                logger.info(FCS.get("removeJob, jobKey:{0}, result [{1}]", jobKey, result));
            }
        } catch (Exception e) {
            Exceptions.runtime("delete a job error.", e);
        }
        return result;
    }

    /**
     * Pause a job.
     *
     * @param jobName
     * @param jobGroup
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since May 9, 2016
     */
    public static boolean pauseJob(String jobName, String jobGroup) {
        boolean result = false;
        try {
            /* TriggerKey : name + group */
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);

            if (checkExists(jobName, jobGroup)) {
                getScheduler().pauseTrigger(triggerKey);
                result = true;
                logger.info(FCS.get("pauseJob success, triggerKey:{0}", triggerKey));
            } else {
                logger.info(FCS.get("pauseJob fail, triggerKey:{0}", triggerKey));
            }
        } catch (Exception e) {
            Exceptions.runtime("Pause a job error.", e);
        }
        return result;
    }

    /**
     * resume a job.
     *
     * @param jobName
     * @param jobGroup
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since May 9, 2016
     */
    public static boolean resumeJob(String jobName, String jobGroup) {
        boolean result = false;
        try {
            /* TriggerKey : name + group */
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);

            if (checkExists(jobName, jobGroup)) {
                getScheduler().resumeTrigger(triggerKey);
                result = true;
                logger.info(FCS.get("resumeJob success, triggerKey:{0}", triggerKey));
            } else {
                logger.info(FCS.get("resumeJob fail, triggerKey:{0}", triggerKey));
            }
        } catch (Exception e) {
            Exceptions.runtime("resume a job error.", e);
        }
        return result;
    }

    /**
     * run/trigger a job.
     *
     * @param jobName
     * @param jobGroup
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since May 9, 2016
     */
    public static boolean runJob(String jobName, String jobGroup) {
        boolean result = false;
        try {
            /* TriggerKey : name + group */
            JobKey jobKey = new JobKey(jobName, jobGroup);
            if (checkExists(jobName, jobGroup)) {
                getScheduler().triggerJob(jobKey);
                result = true;
                logger.info(FCS.get("runJob success, jobKey:{0}", jobKey));
            } else {
                logger.info(FCS.get("runJob fail, jobKey:{0}", jobKey));
            }
        } catch (Exception e) {
            Exceptions.runtime("run/trigger a job error.", e);
        }
        return result;
    }

}