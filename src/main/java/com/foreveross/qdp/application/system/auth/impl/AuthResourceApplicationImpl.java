/*******************************************************************************
 * Copyright (c) 2017-11-09 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation.
 * Auto Generate By foreveross.com Quick Deliver Platform. 
 ******************************************************************************/
package com.foreveross.qdp.application.system.auth.impl;

import com.foreveross.qdp.application.system.auth.AuthResourceApplication;
import com.foreveross.qdp.domain.system.auth.AuthResource;
import com.foreveross.qdp.infra.vo.system.auth.AuthResourceVO;
import org.apache.commons.lang3.StringUtils;
import org.iff.infra.util.BeanHelper;
import org.iff.infra.util.MapHelper;
import org.iff.infra.util.mybatis.plugin.Page;
import org.iff.infra.util.mybatis.service.Dao;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;

/**
 * AuthResource
 *
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
 * @version 1.0.0
 * auto generate by qdp v3.0.
 * @since 2017-11-09
 */
@Named("authResourceApplication")
@Transactional
public class AuthResourceApplicationImpl implements AuthResourceApplication {

    /**
     * <pre>
     * get AuthResourceVO by id.
     * </pre>
     *
     * @param vo
     * @return AuthResourceVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthResourceApplication#getAuthResource(AuthResourceVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public AuthResourceVO getAuthResource(AuthResourceVO vo) {
        AuthResource authResource = BeanHelper.copyProperties(AuthResource.class, vo);
        authResource = AuthResource.get(authResource);
        return BeanHelper.copyProperties(AuthResourceVO.class, authResource);
    }

    /**
     * <pre>
     * get AuthResourceVO by id.
     * </pre>
     *
     * @param vo
     * @return AuthResourceVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthResourceApplication#getAuthResourceById(String)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public AuthResourceVO getAuthResourceById(String id) {
        AuthResource authResource = AuthResource.get(id);
        return BeanHelper.copyProperties(AuthResourceVO.class, authResource);
    }

    /**
     * <pre>
     * page find AuthResourceVO.
     * </pre>
     *
     * @param vo   conditions
     * @param page page setting
     * @return Page
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthResourceApplication#pageFindAuthResource(AuthResourceVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public Page pageFindAuthResource(AuthResourceVO vo, Page page) {
        page = Page.notNullPage(page);
        page = Dao.queryPage("AuthResource.pageFindAuthResource", MapHelper.toMap("page", page, "vo", vo));
        return page.toPage(AuthResourceVO.class);
    }

    /**
     * <pre>
     * page find AuthResource Map.
     * </pre>
     *
     * @param vo   conditions
     * @param page page setting
     * @return Page
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthResourceApplication#pageFindAuthResourceMap(AuthResourceVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public Page pageFindAuthResourceMap(AuthResourceVO vo, Page page) {
        page = Page.notNullPage(page);
        page = Dao.queryPage("AuthResource.pageFindAuthResourceMap", MapHelper.toMap("page", page, "vo", vo));
        return page.toPage(AuthResourceVO.class);
    }

    /**
     * <pre>
     * add AuthResource.
     * </pre>
     *
     * @param vo
     * @return AuthResourceVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthResourceApplication#addAuthResource(AuthResourceVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public AuthResourceVO addAuthResource(AuthResourceVO vo) {
        AuthResource authResource = BeanHelper.copyProperties(AuthResource.class, vo);
        authResource.add();
        AuthResourceVO authResourceVO = BeanHelper.copyProperties(AuthResourceVO.class, authResource);
        return authResourceVO;
    }

    /**
     * <pre>
     * update AuthResource.
     * </pre>
     *
     * @param vo
     * @return AuthResourceVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthResourceApplication#updateAuthResource(AuthResourceVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public AuthResourceVO updateAuthResource(AuthResourceVO vo) {
        AuthResource authResource = BeanHelper.copyProperties(AuthResource.class, vo);
        authResource.update();
        AuthResourceVO authResourceVO = BeanHelper.copyProperties(AuthResourceVO.class, authResource);
        return authResourceVO;
    }

    /**
     * <pre>
     * remove AuthResource.
     * </pre>
     *
     * @param vo conditions.
     *           (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthResourceApplication#removeAuthResource(AuthResourceVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void removeAuthResource(AuthResourceVO vo) {
        AuthResource authResource = BeanHelper.copyProperties(AuthResource.class, vo);
        AuthResource.remove(authResource);
    }

    /**
     * <pre>
     * remove AuthResource.
     * </pre>
     *
     * @param id. (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthResourceApplication#removeAuthResourceById(String)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void removeAuthResourceById(String id) {
        if (id instanceof String) {
            AuthResource.remove(StringUtils.split(id, ','));
        } else {
            AuthResource.remove(id);
        }
    }

    /**
     * <pre>
     * remove AuthResource.
     * </pre>
     *
     * @param ids. (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthResourceApplication#removeAuthResourceByIds(String[])
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void removeAuthResourceByIds(String[] ids) {
        AuthResource.remove(ids);
    }


    /**
     * <pre>
     * get AuthResource by unique name
     * </pre>
     * (non-Javadoc)
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthResourceApplication#getByName(String[])
     * @since 2017-11-09
     */
    public AuthResourceVO getByName(String name) {
        AuthResource authResource = AuthResource.getByName(name);
        return BeanHelper.copyProperties(AuthResourceVO.class, authResource);
    }

    /**
     * <pre>
     * get AuthResource by unique code
     * </pre>
     * (non-Javadoc)
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthResourceApplication#getByCode(String[])
     * @since 2017-11-09
     */
    public AuthResourceVO getByCode(String code) {
        AuthResource authResource = AuthResource.getByCode(code);
        return BeanHelper.copyProperties(AuthResourceVO.class, authResource);
    }


}
