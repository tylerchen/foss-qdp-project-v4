/*******************************************************************************
 * Copyright (c) Oct 10, 2017 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation
 ******************************************************************************/
package com.foreveross.extension.quartz.application;

import com.foreveross.extension.quartz.QuartzJobInfoVO;
import org.iff.infra.util.mybatis.plugin.Page;

/**
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
 * @since Oct 10, 2017
 */
public interface QuartzSchedulerApplication {

    /**
     * <pre>
     * get QuartzJobInfoVO by id.
     * </pre>
     *
     * @param vo
     * @return QuartzJobInfoVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2017-10-10
     * auto generate by qdp v3.0.
     */
    QuartzJobInfoVO getQuartzJob(QuartzJobInfoVO vo);

    /**
     * <pre>
     * page find QuartzJobInfoVO.
     * </pre>
     *
     * @param vo   conditions
     * @param page page setting
     * @return Page
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2017-10-10
     * auto generate by qdp v3.0.
     */
    Page<?> pageFindQuartzJob(QuartzJobInfoVO vo, Page page);

    /**
     * <pre>
     * add SysQuartzJob.
     * </pre>
     *
     * @param vo
     * @return QuartzJobInfoVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2017-10-10
     * auto generate by qdp v3.0.
     */
    QuartzJobInfoVO addQuartzJob(QuartzJobInfoVO vo);

    /**
     * <pre>
     * updateQuartzJob.
     * </pre>
     *
     * @param vo
     * @return QuartzJobInfoVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2017-10-10
     * auto generate by qdp v3.0.
     */
    QuartzJobInfoVO updateQuartzJob(QuartzJobInfoVO vo);

    /**
     * <pre>
     * remove QuartzJob.
     * </pre>
     *
     * @param vo conditions.
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2017-10-10
     * auto generate by qdp v3.0.
     */
    boolean removeQuartzJob(QuartzJobInfoVO vo);

    /**
     * <pre>
     * remove QuartzJob Trigger.
     * </pre>
     *
     * @param vo conditions.
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2017-10-10
     * auto generate by qdp v3.0.
     */
    boolean removeQuartzJobTrigger(QuartzJobInfoVO vo);

    /**
     * <pre>
     * checkExistsQuartzJob.
     * </pre>
     *
     * @param id.
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2017-10-10
     * auto generate by qdp v3.0.
     */
    boolean checkExistsQuartzJob(QuartzJobInfoVO vo);

    /**
     * <pre>
     * rescheduleQuartzJob.
     * </pre>
     *
     * @param vo
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2017-10-10
     * auto generate by qdp v3.0.
     */
    boolean rescheduleQuartzJob(QuartzJobInfoVO vo);

    /**
     * <pre>
     * pauseQuartzJob.
     * </pre>
     *
     * @param vo
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2017-10-10
     * auto generate by qdp v3.0.
     */
    boolean pauseQuartzJob(QuartzJobInfoVO vo);

    /**
     * <pre>
     * resumeQuartzJob.
     * </pre>
     *
     * @param vo
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2017-10-10
     * auto generate by qdp v3.0.
     */
    boolean resumeQuartzJob(QuartzJobInfoVO vo);

    /**
     * <pre>
     * runQuartzJob.
     * </pre>
     *
     * @param vo
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2017-10-10
     * auto generate by qdp v3.0.
     */
    boolean runQuartzJob(QuartzJobInfoVO vo);
}
