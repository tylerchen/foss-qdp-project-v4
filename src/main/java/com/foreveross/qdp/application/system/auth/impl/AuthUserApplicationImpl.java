/*******************************************************************************
 * Copyright (c) 2017-11-09 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation.
 * Auto Generate By foreveross.com Quick Deliver Platform. 
 ******************************************************************************/
package com.foreveross.qdp.application.system.auth.impl;

import com.foreveross.qdp.application.system.auth.AuthUserApplication;
import com.foreveross.qdp.domain.system.auth.AuthUser;
import com.foreveross.qdp.infra.vo.system.auth.AuthUserVO;
import org.apache.commons.lang3.StringUtils;
import org.iff.infra.util.BeanHelper;
import org.iff.infra.util.MapHelper;
import org.iff.infra.util.mybatis.plugin.Page;
import org.iff.infra.util.mybatis.service.Dao;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;

/**
 * AuthUser
 *
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
 * @version 1.0.0
 * auto generate by qdp v3.0.
 * @since 2017-11-09
 */
@Named("authUserApplication")
@Transactional
public class AuthUserApplicationImpl implements AuthUserApplication {

    /**
     * <pre>
     * get AuthUserVO by id.
     * </pre>
     *
     * @param vo
     * @return AuthUserVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthUserApplication#getAuthUser(AuthUserVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public AuthUserVO getAuthUser(AuthUserVO vo) {
        AuthUser authUser = BeanHelper.copyProperties(AuthUser.class, vo);
        authUser = AuthUser.get(authUser);
        return BeanHelper.copyProperties(AuthUserVO.class, authUser);
    }

    /**
     * <pre>
     * get AuthUserVO by id.
     * </pre>
     *
     * @param vo
     * @return AuthUserVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthUserApplication#getAuthUserById(String)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public AuthUserVO getAuthUserById(String id) {
        AuthUser authUser = AuthUser.get(id);
        return BeanHelper.copyProperties(AuthUserVO.class, authUser);
    }

    /**
     * <pre>
     * page find AuthUserVO.
     * </pre>
     *
     * @param vo   conditions
     * @param page page setting
     * @return Page
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthUserApplication#pageFindAuthUser(AuthUserVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public Page pageFindAuthUser(AuthUserVO vo, Page page) {
        page = Page.notNullPage(page);
        page = Dao.queryPage("AuthUser.pageFindAuthUser", MapHelper.toMap("page", page, "vo", vo));
        return page.toPage(AuthUserVO.class);
    }

    /**
     * <pre>
     * page find AuthUser Map.
     * </pre>
     *
     * @param vo   conditions
     * @param page page setting
     * @return Page
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthUserApplication#pageFindAuthUserMap(AuthUserVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public Page pageFindAuthUserMap(AuthUserVO vo, Page page) {
        page = Page.notNullPage(page);
        page = Dao.queryPage("AuthUser.pageFindAuthUserMap", MapHelper.toMap("page", page, "vo", vo));
        return page.toPage(AuthUserVO.class);
    }

    /**
     * <pre>
     * add AuthUser.
     * </pre>
     *
     * @param vo
     * @return AuthUserVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthUserApplication#addAuthUser(AuthUserVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public AuthUserVO addAuthUser(AuthUserVO vo) {
        AuthUser authUser = BeanHelper.copyProperties(AuthUser.class, vo);
        authUser.add();
        AuthUserVO authUserVO = BeanHelper.copyProperties(AuthUserVO.class, authUser);
        return authUserVO;
    }

    /**
     * <pre>
     * update AuthUser.
     * </pre>
     *
     * @param vo
     * @return AuthUserVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthUserApplication#updateAuthUser(AuthUserVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public AuthUserVO updateAuthUser(AuthUserVO vo) {
        AuthUser authUser = BeanHelper.copyProperties(AuthUser.class, vo);
        authUser.update();
        AuthUserVO authUserVO = BeanHelper.copyProperties(AuthUserVO.class, authUser);
        return authUserVO;
    }

    /**
     * <pre>
     * remove AuthUser.
     * </pre>
     *
     * @param vo conditions.
     *           (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthUserApplication#removeAuthUser(AuthUserVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void removeAuthUser(AuthUserVO vo) {
        AuthUser authUser = BeanHelper.copyProperties(AuthUser.class, vo);
        AuthUser.remove(authUser);
    }

    /**
     * <pre>
     * remove AuthUser.
     * </pre>
     *
     * @param id. (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthUserApplication#removeAuthUserById(String)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void removeAuthUserById(String id) {
        if (id instanceof String) {
            AuthUser.remove(StringUtils.split(id, ','));
        } else {
            AuthUser.remove(id);
        }
    }

    /**
     * <pre>
     * remove AuthUser.
     * </pre>
     *
     * @param ids. (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthUserApplication#removeAuthUserByIds(String[])
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void removeAuthUserByIds(String[] ids) {
        AuthUser.remove(ids);
    }


    /**
     * <pre>
     * get AuthUser by unique name
     * </pre>
     * (non-Javadoc)
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthUserApplication#getByName(String[])
     * @since 2017-11-09
     */
    public AuthUserVO getByName(String name) {
        AuthUser authUser = AuthUser.getByName(name);
        return BeanHelper.copyProperties(AuthUserVO.class, authUser);
    }

    /**
     * <pre>
     * get AuthUser by unique email
     * </pre>
     * (non-Javadoc)
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthUserApplication#getByEmail(String[])
     * @since 2017-11-09
     */
    public AuthUserVO getByEmail(String email) {
        AuthUser authUser = AuthUser.getByEmail(email);
        return BeanHelper.copyProperties(AuthUserVO.class, authUser);
    }


}
