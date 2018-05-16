/*******************************************************************************
 * Copyright (c) 2017-11-09 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation.
 * Auto Generate By foreveross.com Quick Deliver Platform. 
 ******************************************************************************/
package com.foreveross.qdp.application.system.auth.impl;

import com.foreveross.qdp.application.system.auth.AuthOrganizationApplication;
import com.foreveross.qdp.domain.system.auth.AuthOrganization;
import com.foreveross.qdp.infra.vo.system.auth.AuthMenuVO;
import com.foreveross.qdp.infra.vo.system.auth.AuthOrganizationVO;
import com.foreveross.qdp.infra.vo.system.auth.AuthRoleVO;
import com.foreveross.qdp.infra.vo.system.auth.AuthUserVO;
import org.apache.commons.lang3.StringUtils;
import org.iff.infra.util.BeanHelper;
import org.iff.infra.util.MapHelper;
import org.iff.infra.util.mybatis.plugin.Page;
import org.iff.infra.util.mybatis.service.Dao;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;

/**
 * AuthOrganization
 *
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
 * @version 1.0.0
 * auto generate by qdp v3.0.
 * @since 2017-11-09
 */
@Named("authOrganizationApplication")
@Transactional
public class AuthOrganizationApplicationImpl implements AuthOrganizationApplication {

    /**
     * <pre>
     * get AuthOrganizationVO by id.
     * </pre>
     *
     * @param vo
     * @return AuthOrganizationVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthOrganizationApplication#getAuthOrganization(AuthOrganizationVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public AuthOrganizationVO getAuthOrganization(AuthOrganizationVO vo) {
        AuthOrganization authOrganization = BeanHelper.copyProperties(AuthOrganization.class, vo);
        authOrganization = AuthOrganization.get(authOrganization);
        return BeanHelper.copyProperties(AuthOrganizationVO.class, authOrganization);
    }

    /**
     * <pre>
     * get AuthOrganizationVO by id.
     * </pre>
     *
     * @param vo
     * @return AuthOrganizationVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthOrganizationApplication#getAuthOrganizationById(String)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public AuthOrganizationVO getAuthOrganizationById(String id) {
        AuthOrganization authOrganization = AuthOrganization.get(id);
        return BeanHelper.copyProperties(AuthOrganizationVO.class, authOrganization);
    }

    /**
     * <pre>
     * page find AuthOrganizationVO.
     * </pre>
     *
     * @param vo   conditions
     * @param page page setting
     * @return Page
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthOrganizationApplication#pageFindAuthOrganization(AuthOrganizationVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public Page pageFindAuthOrganization(AuthOrganizationVO vo, Page page) {
        page = Page.notNullPage(page);
        page = Dao.queryPage("AuthOrganization.pageFindAuthOrganization", MapHelper.toMap("page", page, "vo", vo));
        return page.toPage(AuthOrganizationVO.class);
    }

    /**
     * <pre>
     * page find AuthOrganization Map.
     * </pre>
     *
     * @param vo   conditions
     * @param page page setting
     * @return Page
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthOrganizationApplication#pageFindAuthOrganizationMap(AuthOrganizationVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public Page pageFindAuthOrganizationMap(AuthOrganizationVO vo, Page page) {
        page = Page.notNullPage(page);
        page = Dao.queryPage("AuthOrganization.pageFindAuthOrganizationMap", MapHelper.toMap("page", page, "vo", vo));
        return page.toPage(AuthOrganizationVO.class);
    }

    /**
     * <pre>
     * add AuthOrganization.
     * </pre>
     *
     * @param vo
     * @return AuthOrganizationVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthOrganizationApplication#addAuthOrganization(AuthOrganizationVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public AuthOrganizationVO addAuthOrganization(AuthOrganizationVO vo) {
        AuthOrganization authOrganization = BeanHelper.copyProperties(AuthOrganization.class, vo);
        authOrganization.add();

        // 关联中间表设值: 分配菜单管理，当值为null时，表示不更新该字段，如果设置为长度为0，则表示清空所有分配值。
        if (vo.getMenuId() != null) {
            authOrganization.assignAuthMenuByIds(StringUtils.split(vo.getMenuId(), ','));
        }

        // 关联中间表设值: 分配用户管理，当值为null时，表示不更新该字段，如果设置为长度为0，则表示清空所有分配值。
        if (vo.getUserId() != null) {
            authOrganization.assignAuthUserByIds(StringUtils.split(vo.getUserId(), ','));
        }

        // 关联中间表设值: 分配角色管理，当值为null时，表示不更新该字段，如果设置为长度为0，则表示清空所有分配值。
        if (vo.getRoleId() != null) {
            authOrganization.assignAuthRoleByIds(StringUtils.split(vo.getRoleId(), ','));
        }
        AuthOrganizationVO authOrganizationVO = BeanHelper.copyProperties(AuthOrganizationVO.class, authOrganization);
        return authOrganizationVO;
    }

    /**
     * <pre>
     * update AuthOrganization.
     * </pre>
     *
     * @param vo
     * @return AuthOrganizationVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthOrganizationApplication#updateAuthOrganization(AuthOrganizationVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public AuthOrganizationVO updateAuthOrganization(AuthOrganizationVO vo) {
        AuthOrganization authOrganization = BeanHelper.copyProperties(AuthOrganization.class, vo);
        authOrganization.update();

        // 关联中间表设值: 分配菜单管理，当值为null时，表示不更新该字段，如果设置为长度为0，则表示清空所有分配值。
        if (vo.getMenuId() != null) {
            authOrganization.assignAuthMenuByIds(StringUtils.split(vo.getMenuId(), ','));
        }

        // 关联中间表设值: 分配用户管理，当值为null时，表示不更新该字段，如果设置为长度为0，则表示清空所有分配值。
        if (vo.getUserId() != null) {
            authOrganization.assignAuthUserByIds(StringUtils.split(vo.getUserId(), ','));
        }

        // 关联中间表设值: 分配角色管理，当值为null时，表示不更新该字段，如果设置为长度为0，则表示清空所有分配值。
        if (vo.getRoleId() != null) {
            authOrganization.assignAuthRoleByIds(StringUtils.split(vo.getRoleId(), ','));
        }
        AuthOrganizationVO authOrganizationVO = BeanHelper.copyProperties(AuthOrganizationVO.class, authOrganization);
        return authOrganizationVO;
    }

    /**
     * <pre>
     * remove AuthOrganization.
     * </pre>
     *
     * @param vo conditions.
     *           (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthOrganizationApplication#removeAuthOrganization(AuthOrganizationVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void removeAuthOrganization(AuthOrganizationVO vo) {
        AuthOrganization authOrganization = BeanHelper.copyProperties(AuthOrganization.class, vo);
        AuthOrganization.remove(authOrganization);
    }

    /**
     * <pre>
     * remove AuthOrganization.
     * </pre>
     *
     * @param id. (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthOrganizationApplication#removeAuthOrganizationById(String)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void removeAuthOrganizationById(String id) {
        if (id instanceof String) {
            AuthOrganization.remove(StringUtils.split(id, ','));
        } else {
            AuthOrganization.remove(id);
        }
    }

    /**
     * <pre>
     * remove AuthOrganization.
     * </pre>
     *
     * @param ids. (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthOrganizationApplication#removeAuthOrganizationByIds(String[])
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void removeAuthOrganizationByIds(String[] ids) {
        AuthOrganization.remove(ids);
    }


    /**
     * <pre>
     * get AuthOrganization by unique name
     * </pre>
     * (non-Javadoc)
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthOrganizationApplication#getByName(String[])
     * @since 2017-11-09
     */
    public AuthOrganizationVO getByName(String name) {
        AuthOrganization authOrganization = AuthOrganization.getByName(name);
        return BeanHelper.copyProperties(AuthOrganizationVO.class, authOrganization);
    }

    /**
     * <pre>
     * get AuthOrganization by unique code
     * </pre>
     * (non-Javadoc)
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthOrganizationApplication#getByCode(String[])
     * @since 2017-11-09
     */
    public AuthOrganizationVO getByCode(String code) {
        AuthOrganization authOrganization = AuthOrganization.getByCode(code);
        return BeanHelper.copyProperties(AuthOrganizationVO.class, authOrganization);
    }


    /**
     * <pre>
     * page find assign AuthMenuVO.
     * </pre>
     *
     * @param vo   conditions
     * @param page page setting
     * @return Page
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthOrganizationApplication#pageFindAssignAuthMenu(AuthOrganizationVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public Page pageFindAssignAuthMenu(AuthOrganizationVO vo, Page page) {
        page = Dao.queryPage("AuthOrganization.pageFindAuthMenuByAuthAutherMenuMap", MapHelper.toMap("page", Page.notNullPage(page), "vo", vo));
        return page.toPage(AuthMenuVO.class);
    }

    /**
     * <pre>
     * assign AuthMenu by id
     * </pre>
     *
     * @param ids AuthMenu id
     *            (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthOrganizationApplication#assignAuthMenu(AuthOrganizationVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void assignAuthMenu(AuthOrganizationVO vo) {
        AuthOrganization domain = BeanHelper.copyProperties(AuthOrganization.class, vo);
        domain.assignAuthMenuByIds(StringUtils.split(vo.getMenuId(), ","));
    }


    /**
     * <pre>
     * page find assign AuthUserVO.
     * </pre>
     *
     * @param vo   conditions
     * @param page page setting
     * @return Page
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthOrganizationApplication#pageFindAssignAuthUser(AuthOrganizationVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public Page pageFindAssignAuthUser(AuthOrganizationVO vo, Page page) {
        page = Dao.queryPage("AuthOrganization.pageFindAuthUserByAuthOrganizationUserMap", MapHelper.toMap("page", Page.notNullPage(page), "vo", vo));
        return page.toPage(AuthUserVO.class);
    }

    /**
     * <pre>
     * assign AuthUser by id
     * </pre>
     *
     * @param ids AuthUser id
     *            (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthOrganizationApplication#assignAuthUser(AuthOrganizationVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void assignAuthUser(AuthOrganizationVO vo) {
        AuthOrganization domain = BeanHelper.copyProperties(AuthOrganization.class, vo);
        domain.assignAuthUserByIds(StringUtils.split(vo.getUserId(), ","));
    }


    /**
     * <pre>
     * page find assign AuthRoleVO.
     * </pre>
     *
     * @param vo   conditions
     * @param page page setting
     * @return Page
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthOrganizationApplication#pageFindAssignAuthRole(AuthOrganizationVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public Page pageFindAssignAuthRole(AuthOrganizationVO vo, Page page) {
        page = Dao.queryPage("AuthOrganization.pageFindAuthRoleByAuthAutherRoleMap", MapHelper.toMap("page", Page.notNullPage(page), "vo", vo));
        return page.toPage(AuthRoleVO.class);
    }

    /**
     * <pre>
     * assign AuthRole by id
     * </pre>
     *
     * @param ids AuthRole id
     *            (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthOrganizationApplication#assignAuthRole(AuthOrganizationVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void assignAuthRole(AuthOrganizationVO vo) {
        AuthOrganization domain = BeanHelper.copyProperties(AuthOrganization.class, vo);
        domain.assignAuthRoleByIds(StringUtils.split(vo.getRoleId(), ","));
    }

}
