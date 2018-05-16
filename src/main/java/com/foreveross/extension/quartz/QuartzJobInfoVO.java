/*******************************************************************************
 * Copyright (c) Jan 28, 2016 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation
 ******************************************************************************/
package com.foreveross.extension.quartz;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
 * @since Jan 28, 2016
 */
@XmlRootElement(name = "QuartzJobInfo")
@SuppressWarnings("serial")
public class QuartzJobInfoVO implements Serializable {

    private String id;

    private String jobGroup; // 任务组
    private String jobName; // 任务名
    private String jobCron; // 任务执行CRON表达式 【base on quartz】
    private String jobClass; // 任务执行JobBean 【base on quartz】
    private String jobData; // 任务执行数据 Map-JSON-String

    private String author; // 负责人
    private String alarmEmail; // 报警邮件
    private Integer alarmThreshold; // 报警阀值

    private String recovery = "Y";// 失败重做
    private String durably = "Y";// 持久保存，即使无触发器

    // copy from quartz
    private String jobStatus; // 任务状态 【base on quartz】
    private String status; //最后执行状态
    private String body; //最后执行信息

    private String script;//最后执行信息
    /**
     * 描述
     **/
    private String description;
    /**
     * 修改时间
     **/
    private Date updateTime;
    /**
     * 创建时间
     **/
    private Date createTime;

    public static QuartzJobInfoVO create(String jobName, String jobGroup) {
        QuartzJobInfoVO info = new QuartzJobInfoVO();
        info.setJobName(jobName);
        info.setJobGroup(jobGroup);
        return info;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobCron() {
        return jobCron;
    }

    public void setJobCron(String jobCron) {
        this.jobCron = jobCron;
    }

    public String getJobClass() {
        return jobClass;
    }

    public void setJobClass(String jobClass) {
        this.jobClass = jobClass;
    }

    public String getJobData() {
        return jobData;
    }

    public void setJobData(String jobData) {
        this.jobData = jobData;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAlarmEmail() {
        return alarmEmail;
    }

    public void setAlarmEmail(String alarmEmail) {
        this.alarmEmail = alarmEmail;
    }

    public Integer getAlarmThreshold() {
        return alarmThreshold;
    }

    public void setAlarmThreshold(Integer alarmThreshold) {
        this.alarmThreshold = alarmThreshold;
    }

    public String getRecovery() {
        return recovery;
    }

    public void setRecovery(String recovery) {
        this.recovery = recovery;
    }

    public String getDurably() {
        return durably;
    }

    public void setDurably(String durably) {
        this.durably = durably;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "QuartzJobInfoVO [id=" + id + ", jobGroup=" + jobGroup + ", jobName=" + jobName + ", jobCron=" + jobCron
                + ", jobClass=" + jobClass + ", jobData=" + jobData + ", author=" + author + ", alarmEmail="
                + alarmEmail + ", alarmThreshold=" + alarmThreshold + ", recovery=" + recovery + ", durably=" + durably
                + ", jobStatus=" + jobStatus + ", status=" + status + ", body=" + body + ", script=" + script
                + ", description=" + description + ", updateTime=" + updateTime + ", createTime=" + createTime + "]";
    }

}
