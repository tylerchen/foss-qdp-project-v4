/*******************************************************************************
 * Copyright (c) 2017-11-09 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation.
 * Auto Generate By foreveross.com Quick Deliver Platform. 
 ******************************************************************************/
package com.foreveross.qdp.application.system.common.impl;

import com.foreveross.qdp.application.system.common.SysOpenreportApplication;
import com.foreveross.qdp.domain.system.common.SysOpenreport;
import com.foreveross.qdp.infra.vo.system.common.SysOpenreportVO;
import org.apache.commons.lang3.StringUtils;
import org.iff.infra.util.BeanHelper;
import org.iff.infra.util.MapHelper;
import org.iff.infra.util.mybatis.plugin.Page;
import org.iff.infra.util.mybatis.service.Dao;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;

/**
 * SysOpenreport
 *
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
 * @version 1.0.0
 * auto generate by qdp v3.0.
 * @since 2017-11-09
 */
@Named("sysOpenreportApplication")
@Transactional
public class SysOpenreportApplicationImpl implements SysOpenreportApplication {

    /**
     * <pre>
     * get SysOpenreportVO by id.
     * </pre>
     *
     * @param vo
     * @return SysOpenreportVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysOpenreportApplication#getSysOpenreport(SysOpenreportVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public SysOpenreportVO getSysOpenreport(SysOpenreportVO vo) {
        SysOpenreport sysOpenreport = BeanHelper.copyProperties(SysOpenreport.class, vo);
        sysOpenreport = SysOpenreport.get(sysOpenreport);
        return BeanHelper.copyProperties(SysOpenreportVO.class, sysOpenreport);
    }

    /**
     * <pre>
     * get SysOpenreportVO by id.
     * </pre>
     *
     * @param vo
     * @return SysOpenreportVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysOpenreportApplication#getSysOpenreportById(String)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public SysOpenreportVO getSysOpenreportById(String id) {
        SysOpenreport sysOpenreport = SysOpenreport.get(id);
        return BeanHelper.copyProperties(SysOpenreportVO.class, sysOpenreport);
    }

    /**
     * <pre>
     * page find SysOpenreportVO.
     * </pre>
     *
     * @param vo   conditions
     * @param page page setting
     * @return Page
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysOpenreportApplication#pageFindSysOpenreport(SysOpenreportVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public Page pageFindSysOpenreport(SysOpenreportVO vo, Page page) {
        page = Page.notNullPage(page);
        page = Dao.queryPage("SysOpenreport.pageFindSysOpenreport", MapHelper.toMap("page", page, "vo", vo));
        return page.toPage(SysOpenreportVO.class);
    }

    /**
     * <pre>
     * page find SysOpenreport Map.
     * </pre>
     *
     * @param vo   conditions
     * @param page page setting
     * @return Page
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysOpenreportApplication#pageFindSysOpenreportMap(SysOpenreportVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public Page pageFindSysOpenreportMap(SysOpenreportVO vo, Page page) {
        page = Page.notNullPage(page);
        page = Dao.queryPage("SysOpenreport.pageFindSysOpenreportMap", MapHelper.toMap("page", page, "vo", vo));
        return page.toPage(SysOpenreportVO.class);
    }

    /**
     * <pre>
     * add SysOpenreport.
     * </pre>
     *
     * @param vo
     * @return SysOpenreportVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysOpenreportApplication#addSysOpenreport(SysOpenreportVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public SysOpenreportVO addSysOpenreport(SysOpenreportVO vo) {
        SysOpenreport sysOpenreport = BeanHelper.copyProperties(SysOpenreport.class, vo);
        sysOpenreport.add();
        SysOpenreportVO sysOpenreportVO = BeanHelper.copyProperties(SysOpenreportVO.class, sysOpenreport);
        return sysOpenreportVO;
    }

    /**
     * <pre>
     * update SysOpenreport.
     * </pre>
     *
     * @param vo
     * @return SysOpenreportVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysOpenreportApplication#updateSysOpenreport(SysOpenreportVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public SysOpenreportVO updateSysOpenreport(SysOpenreportVO vo) {
        SysOpenreport sysOpenreport = BeanHelper.copyProperties(SysOpenreport.class, vo);
        sysOpenreport.update();
        SysOpenreportVO sysOpenreportVO = BeanHelper.copyProperties(SysOpenreportVO.class, sysOpenreport);
        return sysOpenreportVO;
    }

    /**
     * <pre>
     * remove SysOpenreport.
     * </pre>
     *
     * @param vo conditions.
     *           (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysOpenreportApplication#removeSysOpenreport(SysOpenreportVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void removeSysOpenreport(SysOpenreportVO vo) {
        SysOpenreport sysOpenreport = BeanHelper.copyProperties(SysOpenreport.class, vo);
        SysOpenreport.remove(sysOpenreport);
    }

    /**
     * <pre>
     * remove SysOpenreport.
     * </pre>
     *
     * @param id. (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysOpenreportApplication#removeSysOpenreportById(String)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void removeSysOpenreportById(String id) {
        if (id instanceof String) {
            SysOpenreport.remove(StringUtils.split(id, ','));
        } else {
            SysOpenreport.remove(id);
        }
    }

    /**
     * <pre>
     * remove SysOpenreport.
     * </pre>
     *
     * @param ids. (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysOpenreportApplication#removeSysOpenreportByIds(String[])
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void removeSysOpenreportByIds(String[] ids) {
        SysOpenreport.remove(ids);
    }


    /**
     * <pre>
     * get SysOpenreport by unique name
     * </pre>
     * (non-Javadoc)
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysOpenreportApplication#getByName(String[])
     * @since 2017-11-09
     */
    public SysOpenreportVO getByName(String name) {
        SysOpenreport sysOpenreport = SysOpenreport.getByName(name);
        return BeanHelper.copyProperties(SysOpenreportVO.class, sysOpenreport);
    }


}
