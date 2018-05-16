/*******************************************************************************
 * Copyright (c) 2017-11-09 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation.
 * Auto Generate By foreveross.com Quick Deliver Platform. 
 ******************************************************************************/
package com.foreveross.qdp.application.system.common.impl;

import com.foreveross.qdp.application.system.common.SysI18nApplication;
import com.foreveross.qdp.domain.system.common.SysI18n;
import com.foreveross.qdp.infra.vo.system.common.SysI18nVO;
import org.apache.commons.lang3.StringUtils;
import org.iff.infra.util.BeanHelper;
import org.iff.infra.util.MapHelper;
import org.iff.infra.util.mybatis.plugin.Page;
import org.iff.infra.util.mybatis.service.Dao;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;

/**
 * SysI18n
 *
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
 * @version 1.0.0
 * auto generate by qdp v3.0.
 * @since 2017-11-09
 */
@Named("sysI18nApplication")
@Transactional
public class SysI18nApplicationImpl implements SysI18nApplication {

    /**
     * <pre>
     * get SysI18nVO by id.
     * </pre>
     *
     * @param vo
     * @return SysI18nVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysI18nApplication#getSysI18n(SysI18nVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public SysI18nVO getSysI18n(SysI18nVO vo) {
        SysI18n sysI18n = BeanHelper.copyProperties(SysI18n.class, vo);
        sysI18n = SysI18n.get(sysI18n);
        return BeanHelper.copyProperties(SysI18nVO.class, sysI18n);
    }

    /**
     * <pre>
     * get SysI18nVO by id.
     * </pre>
     *
     * @param vo
     * @return SysI18nVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysI18nApplication#getSysI18nById(String)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public SysI18nVO getSysI18nById(String id) {
        SysI18n sysI18n = SysI18n.get(id);
        return BeanHelper.copyProperties(SysI18nVO.class, sysI18n);
    }

    /**
     * <pre>
     * page find SysI18nVO.
     * </pre>
     *
     * @param vo   conditions
     * @param page page setting
     * @return Page
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysI18nApplication#pageFindSysI18n(SysI18nVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public Page pageFindSysI18n(SysI18nVO vo, Page page) {
        page = Page.notNullPage(page);
        page = Dao.queryPage("SysI18n.pageFindSysI18n", MapHelper.toMap("page", page, "vo", vo));
        return page.toPage(SysI18nVO.class);
    }

    /**
     * <pre>
     * page find SysI18n Map.
     * </pre>
     *
     * @param vo   conditions
     * @param page page setting
     * @return Page
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysI18nApplication#pageFindSysI18nMap(SysI18nVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public Page pageFindSysI18nMap(SysI18nVO vo, Page page) {
        page = Page.notNullPage(page);
        page = Dao.queryPage("SysI18n.pageFindSysI18nMap", MapHelper.toMap("page", page, "vo", vo));
        return page.toPage(SysI18nVO.class);
    }

    /**
     * <pre>
     * add SysI18n.
     * </pre>
     *
     * @param vo
     * @return SysI18nVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysI18nApplication#addSysI18n(SysI18nVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public SysI18nVO addSysI18n(SysI18nVO vo) {
        SysI18n sysI18n = BeanHelper.copyProperties(SysI18n.class, vo);
        sysI18n.add();
        SysI18nVO sysI18nVO = BeanHelper.copyProperties(SysI18nVO.class, sysI18n);
        return sysI18nVO;
    }

    /**
     * <pre>
     * update SysI18n.
     * </pre>
     *
     * @param vo
     * @return SysI18nVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysI18nApplication#updateSysI18n(SysI18nVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public SysI18nVO updateSysI18n(SysI18nVO vo) {
        SysI18n sysI18n = BeanHelper.copyProperties(SysI18n.class, vo);
        sysI18n.update();
        SysI18nVO sysI18nVO = BeanHelper.copyProperties(SysI18nVO.class, sysI18n);
        return sysI18nVO;
    }

    /**
     * <pre>
     * remove SysI18n.
     * </pre>
     *
     * @param vo conditions.
     *           (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysI18nApplication#removeSysI18n(SysI18nVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void removeSysI18n(SysI18nVO vo) {
        SysI18n sysI18n = BeanHelper.copyProperties(SysI18n.class, vo);
        SysI18n.remove(sysI18n);
    }

    /**
     * <pre>
     * remove SysI18n.
     * </pre>
     *
     * @param id. (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysI18nApplication#removeSysI18nById(String)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void removeSysI18nById(String id) {
        if (id instanceof String) {
            SysI18n.remove(StringUtils.split(id, ','));
        } else {
            SysI18n.remove(id);
        }
    }

    /**
     * <pre>
     * remove SysI18n.
     * </pre>
     *
     * @param ids. (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysI18nApplication#removeSysI18nByIds(String[])
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void removeSysI18nByIds(String[] ids) {
        SysI18n.remove(ids);
    }


    /**
     * <pre>
     * get SysI18n by unique messageKey
     * </pre>
     * (non-Javadoc)
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.common.SysI18nApplication#getByMessageKey(String[])
     * @since 2017-11-09
     */
    public SysI18nVO getByMessageKey(String messageKey) {
        SysI18n sysI18n = SysI18n.getByMessageKey(messageKey);
        return BeanHelper.copyProperties(SysI18nVO.class, sysI18n);
    }


}
