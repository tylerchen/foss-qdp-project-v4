/*******************************************************************************
 * Copyright (c) 2017-11-09 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation.
 * Auto Generate By foreveross.com Quick Deliver Platform. 
 ******************************************************************************/
package com.foreveross.qdp.application.system.common.impl;

import com.foreveross.qdp.application.system.common.SysExTableApplication;
import com.foreveross.qdp.domain.system.common.SysExTable;
import com.foreveross.qdp.infra.vo.system.common.SysExTableVO;
import org.apache.commons.lang3.StringUtils;
import org.iff.infra.util.BeanHelper;
import org.iff.infra.util.MapHelper;
import org.iff.infra.util.mybatis.plugin.Page;
import org.iff.infra.util.mybatis.service.Dao;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;

/**
 * SysExTable
 *
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
 * @version 1.0.0
 * auto generate by qdp v3.0.
 * @since 2017-11-09
 */
@Named("sysExTableApplication")
@Transactional
public class SysExTableApplicationImpl implements SysExTableApplication {

    /**
     * <pre>
     * get SysExTableVO by id.
     * </pre>
     *
     * @param vo
     * @return SysExTableVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysExTableApplication#getSysExTable(SysExTableVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public SysExTableVO getSysExTable(SysExTableVO vo) {
        SysExTable sysExTable = BeanHelper.copyProperties(SysExTable.class, vo);
        sysExTable = SysExTable.get(sysExTable);
        return BeanHelper.copyProperties(SysExTableVO.class, sysExTable);
    }

    /**
     * <pre>
     * get SysExTableVO by id.
     * </pre>
     *
     * @param vo
     * @return SysExTableVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysExTableApplication#getSysExTableById(String)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public SysExTableVO getSysExTableById(String id) {
        SysExTable sysExTable = SysExTable.get(id);
        return BeanHelper.copyProperties(SysExTableVO.class, sysExTable);
    }

    /**
     * <pre>
     * page find SysExTableVO.
     * </pre>
     *
     * @param vo   conditions
     * @param page page setting
     * @return Page
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysExTableApplication#pageFindSysExTable(SysExTableVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public Page pageFindSysExTable(SysExTableVO vo, Page page) {
        page = Page.notNullPage(page);
        page = Dao.queryPage("SysExTable.pageFindSysExTable", MapHelper.toMap("page", page, "vo", vo));
        return page.toPage(SysExTableVO.class);
    }

    /**
     * <pre>
     * page find SysExTable Map.
     * </pre>
     *
     * @param vo   conditions
     * @param page page setting
     * @return Page
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysExTableApplication#pageFindSysExTableMap(SysExTableVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public Page pageFindSysExTableMap(SysExTableVO vo, Page page) {
        page = Page.notNullPage(page);
        page = Dao.queryPage("SysExTable.pageFindSysExTableMap", MapHelper.toMap("page", page, "vo", vo));
        return page.toPage(SysExTableVO.class);
    }

    /**
     * <pre>
     * add SysExTable.
     * </pre>
     *
     * @param vo
     * @return SysExTableVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysExTableApplication#addSysExTable(SysExTableVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public SysExTableVO addSysExTable(SysExTableVO vo) {
        SysExTable sysExTable = BeanHelper.copyProperties(SysExTable.class, vo);
        sysExTable.add();
        SysExTableVO sysExTableVO = BeanHelper.copyProperties(SysExTableVO.class, sysExTable);
        return sysExTableVO;
    }

    /**
     * <pre>
     * update SysExTable.
     * </pre>
     *
     * @param vo
     * @return SysExTableVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysExTableApplication#updateSysExTable(SysExTableVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public SysExTableVO updateSysExTable(SysExTableVO vo) {
        SysExTable sysExTable = BeanHelper.copyProperties(SysExTable.class, vo);
        sysExTable.update();
        SysExTableVO sysExTableVO = BeanHelper.copyProperties(SysExTableVO.class, sysExTable);
        return sysExTableVO;
    }

    /**
     * <pre>
     * remove SysExTable.
     * </pre>
     *
     * @param vo conditions.
     *           (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysExTableApplication#removeSysExTable(SysExTableVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void removeSysExTable(SysExTableVO vo) {
        SysExTable sysExTable = BeanHelper.copyProperties(SysExTable.class, vo);
        SysExTable.remove(sysExTable);
    }

    /**
     * <pre>
     * remove SysExTable.
     * </pre>
     *
     * @param id. (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysExTableApplication#removeSysExTableById(String)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void removeSysExTableById(String id) {
        if (id instanceof String) {
            SysExTable.remove(StringUtils.split(id, ','));
        } else {
            SysExTable.remove(id);
        }
    }

    /**
     * <pre>
     * remove SysExTable.
     * </pre>
     *
     * @param ids. (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysExTableApplication#removeSysExTableByIds(String[])
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void removeSysExTableByIds(String[] ids) {
        SysExTable.remove(ids);
    }


}
