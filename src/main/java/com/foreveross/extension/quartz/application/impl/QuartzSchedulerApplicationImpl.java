/*******************************************************************************
 * Copyright (c) Oct 10, 2017 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation
 ******************************************************************************/
package com.foreveross.extension.quartz.application.impl;

import javax.inject.Named;

import org.iff.infra.util.Exceptions;
import org.iff.infra.util.mybatis.plugin.Page;

import com.foreveross.extension.quartz.QuartzJobInfoVO;
import com.foreveross.extension.quartz.QuartzSchedulerHelper;
import com.foreveross.extension.quartz.application.QuartzSchedulerApplication;

/**
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since Oct 10, 2017
 */
@Named("quartzSchedulerApplication")
public class QuartzSchedulerApplicationImpl implements QuartzSchedulerApplication {

	public QuartzJobInfoVO getQuartzJob(QuartzJobInfoVO vo) {
		QuartzSchedulerHelper.fillJobInfo(vo);
		return vo;
	}

	public Page<?> pageFindQuartzJob(QuartzJobInfoVO vo, Page page) {
		return QuartzSchedulerHelper.pageFindJob(vo);
	}

	public QuartzJobInfoVO addQuartzJob(QuartzJobInfoVO vo) {
		if (QuartzSchedulerHelper.addJob(vo)) {
			return vo;
		} else {
			Exceptions.runtime("Fail to add quartz job: " + vo);
			return null;
		}
	}

	public QuartzJobInfoVO updateQuartzJob(QuartzJobInfoVO vo) {
		if (QuartzSchedulerHelper.rescheduleJob(vo)) {
			return vo;
		} else {
			Exceptions.runtime("Fail to rescheduleJob quartz job: " + vo);
			return null;
		}
	}

	public boolean removeQuartzJob(QuartzJobInfoVO vo) {
		return QuartzSchedulerHelper.deleteJob(vo.getJobName(), vo.getJobGroup());
	}

	public boolean removeQuartzJobTrigger(QuartzJobInfoVO vo) {
		return QuartzSchedulerHelper.removeJob(vo.getJobName(), vo.getJobGroup());
	}

	public boolean checkExistsQuartzJob(QuartzJobInfoVO vo) {
		return QuartzSchedulerHelper.checkExists(vo.getJobName(), vo.getJobGroup());
	}

	public boolean rescheduleQuartzJob(QuartzJobInfoVO vo) {
		return QuartzSchedulerHelper.rescheduleJob(vo);
	}

	public boolean pauseQuartzJob(QuartzJobInfoVO vo) {
		return QuartzSchedulerHelper.pauseJob(vo.getJobName(), vo.getJobGroup());
	}

	public boolean resumeQuartzJob(QuartzJobInfoVO vo) {
		return QuartzSchedulerHelper.resumeJob(vo.getJobName(), vo.getJobGroup());
	}

	public boolean runQuartzJob(QuartzJobInfoVO vo) {
		return QuartzSchedulerHelper.runJob(vo.getJobName(), vo.getJobGroup());
	}

}
