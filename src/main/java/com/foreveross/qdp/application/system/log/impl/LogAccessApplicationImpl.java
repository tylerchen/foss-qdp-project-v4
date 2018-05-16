/*******************************************************************************
 * Copyright (c) 2017-11-09 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation.
 * Auto Generate By foreveross.com Quick Deliver Platform. 
 ******************************************************************************/
package com.foreveross.qdp.application.system.log.impl;

import com.foreveross.qdp.application.system.log.LogAccessApplication;
import com.foreveross.qdp.domain.system.log.LogAccess;
import com.foreveross.qdp.infra.vo.system.log.LogAccessVO;
import org.apache.commons.lang3.StringUtils;
import org.iff.infra.util.BeanHelper;
import org.iff.infra.util.MapHelper;
import org.iff.infra.util.mybatis.plugin.Page;
import org.iff.infra.util.mybatis.service.Dao;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;

/**
 * LogAccess
 *
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
 * @version 1.0.0
 * auto generate by qdp v3.0.
 * @since 2017-11-09
 */
@Named("logAccessApplication")
@Transactional
public class LogAccessApplicationImpl implements LogAccessApplication {

    /**
     * <pre>
     * get LogAccessVO by id.
     * </pre>
     *
     * @param vo
     * @return LogAccessVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.log.LogAccessApplication#getLogAccess(LogAccessVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public LogAccessVO getLogAccess(LogAccessVO vo) {
        LogAccess logAccess = BeanHelper.copyProperties(LogAccess.class, vo);
        logAccess = LogAccess.get(logAccess);
        return BeanHelper.copyProperties(LogAccessVO.class, logAccess);
    }

    /**
     * <pre>
     * get LogAccessVO by id.
     * </pre>
     *
     * @param vo
     * @return LogAccessVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.log.LogAccessApplication#getLogAccessById(String)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public LogAccessVO getLogAccessById(String id) {
        LogAccess logAccess = LogAccess.get(id);
        return BeanHelper.copyProperties(LogAccessVO.class, logAccess);
    }

    /**
     * <pre>
     * page find LogAccessVO.
     * </pre>
     *
     * @param vo   conditions
     * @param page page setting
     * @return Page
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.log.LogAccessApplication#pageFindLogAccess(LogAccessVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public Page pageFindLogAccess(LogAccessVO vo, Page page) {
        page = Page.notNullPage(page);
        page = Dao.queryPage("LogAccess.pageFindLogAccess", MapHelper.toMap("page", page, "vo", vo));
        return page.toPage(LogAccessVO.class);
    }

    /**
     * <pre>
     * page find LogAccess Map.
     * </pre>
     *
     * @param vo   conditions
     * @param page page setting
     * @return Page
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.log.LogAccessApplication#pageFindLogAccessMap(LogAccessVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public Page pageFindLogAccessMap(LogAccessVO vo, Page page) {
        page = Page.notNullPage(page);
        page = Dao.queryPage("LogAccess.pageFindLogAccessMap", MapHelper.toMap("page", page, "vo", vo));
        return page.toPage(LogAccessVO.class);
    }

    /**
     * <pre>
     * add LogAccess.
     * </pre>
     *
     * @param vo
     * @return LogAccessVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.log.LogAccessApplication#addLogAccess(LogAccessVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public LogAccessVO addLogAccess(LogAccessVO vo) {
        LogAccess logAccess = BeanHelper.copyProperties(LogAccess.class, vo);
        logAccess.add();
        LogAccessVO logAccessVO = BeanHelper.copyProperties(LogAccessVO.class, logAccess);
        return logAccessVO;
    }

    /**
     * <pre>
     * update LogAccess.
     * </pre>
     *
     * @param vo
     * @return LogAccessVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.log.LogAccessApplication#updateLogAccess(LogAccessVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public LogAccessVO updateLogAccess(LogAccessVO vo) {
        LogAccess logAccess = BeanHelper.copyProperties(LogAccess.class, vo);
        logAccess.update();
        LogAccessVO logAccessVO = BeanHelper.copyProperties(LogAccessVO.class, logAccess);
        return logAccessVO;
    }

    /**
     * <pre>
     * remove LogAccess.
     * </pre>
     *
     * @param vo conditions.
     *           (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.log.LogAccessApplication#removeLogAccess(LogAccessVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void removeLogAccess(LogAccessVO vo) {
        LogAccess logAccess = BeanHelper.copyProperties(LogAccess.class, vo);
        LogAccess.remove(logAccess);
    }

    /**
     * <pre>
     * remove LogAccess.
     * </pre>
     *
     * @param id. (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.log.LogAccessApplication#removeLogAccessById(String)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void removeLogAccessById(String id) {
        if (id instanceof String) {
            LogAccess.remove(StringUtils.split(id, ','));
        } else {
            LogAccess.remove(id);
        }
    }

    /**
     * <pre>
     * remove LogAccess.
     * </pre>
     *
     * @param ids. (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.log.LogAccessApplication#removeLogAccessByIds(String[])
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void removeLogAccessByIds(String[] ids) {
        LogAccess.remove(ids);
    }


}
