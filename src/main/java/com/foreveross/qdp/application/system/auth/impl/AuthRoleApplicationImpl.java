/*******************************************************************************
 * Copyright (c) 2017-11-09 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation.
 * Auto Generate By foreveross.com Quick Deliver Platform. 
 ******************************************************************************/
package com.foreveross.qdp.application.system.auth.impl;

import com.foreveross.qdp.application.system.auth.AuthRoleApplication;
import com.foreveross.qdp.domain.system.auth.AuthRole;
import com.foreveross.qdp.infra.vo.system.auth.AuthMenuVO;
import com.foreveross.qdp.infra.vo.system.auth.AuthResourceVO;
import com.foreveross.qdp.infra.vo.system.auth.AuthRoleVO;
import org.apache.commons.lang3.StringUtils;
import org.iff.infra.util.BeanHelper;
import org.iff.infra.util.MapHelper;
import org.iff.infra.util.mybatis.plugin.Page;
import org.iff.infra.util.mybatis.service.Dao;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;

/**
 * AuthRole
 *
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
 * @version 1.0.0
 * auto generate by qdp v3.0.
 * @since 2017-11-09
 */
@Named("authRoleApplication")
@Transactional
public class AuthRoleApplicationImpl implements AuthRoleApplication {

    /**
     * <pre>
     * get AuthRoleVO by id.
     * </pre>
     *
     * @param vo
     * @return AuthRoleVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthRoleApplication#getAuthRole(AuthRoleVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public AuthRoleVO getAuthRole(AuthRoleVO vo) {
        AuthRole authRole = BeanHelper.copyProperties(AuthRole.class, vo);
        authRole = AuthRole.get(authRole);
        return BeanHelper.copyProperties(AuthRoleVO.class, authRole);
    }

    /**
     * <pre>
     * get AuthRoleVO by id.
     * </pre>
     *
     * @param vo
     * @return AuthRoleVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthRoleApplication#getAuthRoleById(String)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public AuthRoleVO getAuthRoleById(String id) {
        AuthRole authRole = AuthRole.get(id);
        return BeanHelper.copyProperties(AuthRoleVO.class, authRole);
    }

    /**
     * <pre>
     * page find AuthRoleVO.
     * </pre>
     *
     * @param vo   conditions
     * @param page page setting
     * @return Page
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthRoleApplication#pageFindAuthRole(AuthRoleVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public Page pageFindAuthRole(AuthRoleVO vo, Page page) {
        page = Page.notNullPage(page);
        page = Dao.queryPage("AuthRole.pageFindAuthRole", MapHelper.toMap("page", page, "vo", vo));
        return page.toPage(AuthRoleVO.class);
    }

    /**
     * <pre>
     * page find AuthRole Map.
     * </pre>
     *
     * @param vo   conditions
     * @param page page setting
     * @return Page
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthRoleApplication#pageFindAuthRoleMap(AuthRoleVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public Page pageFindAuthRoleMap(AuthRoleVO vo, Page page) {
        page = Page.notNullPage(page);
        page = Dao.queryPage("AuthRole.pageFindAuthRoleMap", MapHelper.toMap("page", page, "vo", vo));
        return page.toPage(AuthRoleVO.class);
    }

    /**
     * <pre>
     * add AuthRole.
     * </pre>
     *
     * @param vo
     * @return AuthRoleVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthRoleApplication#addAuthRole(AuthRoleVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public AuthRoleVO addAuthRole(AuthRoleVO vo) {
        AuthRole authRole = BeanHelper.copyProperties(AuthRole.class, vo);
        authRole.add();

        // 关联中间表设值: 分配资源管理，当值为null时，表示不更新该字段，如果设置为长度为0，则表示清空所有分配值。
        if (vo.getResourceId() != null) {
            authRole.assignAuthResourceByIds(StringUtils.split(vo.getResourceId(), ','));
        }

        // 关联中间表设值: 分配菜单管理，当值为null时，表示不更新该字段，如果设置为长度为0，则表示清空所有分配值。
        if (vo.getMenuId() != null) {
            authRole.assignAuthMenuByIds(StringUtils.split(vo.getMenuId(), ','));
        }
        AuthRoleVO authRoleVO = BeanHelper.copyProperties(AuthRoleVO.class, authRole);
        return authRoleVO;
    }

    /**
     * <pre>
     * update AuthRole.
     * </pre>
     *
     * @param vo
     * @return AuthRoleVO
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthRoleApplication#updateAuthRole(AuthRoleVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public AuthRoleVO updateAuthRole(AuthRoleVO vo) {
        AuthRole authRole = BeanHelper.copyProperties(AuthRole.class, vo);
        authRole.update();

        // 关联中间表设值: 分配资源管理，当值为null时，表示不更新该字段，如果设置为长度为0，则表示清空所有分配值。
        if (vo.getResourceId() != null) {
            authRole.assignAuthResourceByIds(StringUtils.split(vo.getResourceId(), ','));
        }

        // 关联中间表设值: 分配菜单管理，当值为null时，表示不更新该字段，如果设置为长度为0，则表示清空所有分配值。
        if (vo.getMenuId() != null) {
            authRole.assignAuthMenuByIds(StringUtils.split(vo.getMenuId(), ','));
        }
        AuthRoleVO authRoleVO = BeanHelper.copyProperties(AuthRoleVO.class, authRole);
        return authRoleVO;
    }

    /**
     * <pre>
     * remove AuthRole.
     * </pre>
     *
     * @param vo conditions.
     *           (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthRoleApplication#removeAuthRole(AuthRoleVO)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void removeAuthRole(AuthRoleVO vo) {
        AuthRole authRole = BeanHelper.copyProperties(AuthRole.class, vo);
        AuthRole.remove(authRole);
    }

    /**
     * <pre>
     * remove AuthRole.
     * </pre>
     *
     * @param id. (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthRoleApplication#removeAuthRoleById(String)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void removeAuthRoleById(String id) {
        if (id instanceof String) {
            AuthRole.remove(StringUtils.split(id, ','));
        } else {
            AuthRole.remove(id);
        }
    }

    /**
     * <pre>
     * remove AuthRole.
     * </pre>
     *
     * @param ids. (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthRoleApplication#removeAuthRoleByIds(String[])
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void removeAuthRoleByIds(String[] ids) {
        AuthRole.remove(ids);
    }


    /**
     * <pre>
     * get AuthRole by unique name
     * </pre>
     * (non-Javadoc)
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthRoleApplication#getByName(String[])
     * @since 2017-11-09
     */
    public AuthRoleVO getByName(String name) {
        AuthRole authRole = AuthRole.getByName(name);
        return BeanHelper.copyProperties(AuthRoleVO.class, authRole);
    }

    /**
     * <pre>
     * get AuthRole by unique code
     * </pre>
     * (non-Javadoc)
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthRoleApplication#getByCode(String[])
     * @since 2017-11-09
     */
    public AuthRoleVO getByCode(String code) {
        AuthRole authRole = AuthRole.getByCode(code);
        return BeanHelper.copyProperties(AuthRoleVO.class, authRole);
    }


    /**
     * <pre>
     * page find assign AuthResourceVO.
     * </pre>
     *
     * @param vo   conditions
     * @param page page setting
     * @return Page
     * (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthRoleApplication#pageFindAssignAuthResource(AuthRoleVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public Page pageFindAssignAuthResource(AuthRoleVO vo, Page page) {
        page = Dao.queryPage("AuthRole.pageFindAuthResourceByAuthRoleResourceMap", MapHelper.toMap("page", Page.notNullPage(page), "vo", vo));
        return page.toPage(AuthResourceVO.class);
    }

    /**
     * <pre>
     * assign AuthResource by id
     * </pre>
     *
     * @param ids AuthResource id
     *            (non-Javadoc)
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see com.foreveross.qdp.application.system.auth.AuthRoleApplication#assignAuthResource(AuthRoleVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void assignAuthResource(AuthRoleVO vo) {
        AuthRole domain = BeanHelper.copyProperties(AuthRole.class, vo);
        domain.assignAuthResourceByIds(StringUtils.split(vo.getResourceId(), ","));
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
     * @see com.foreveross.qdp.application.system.auth.AuthRoleApplication#pageFindAssignAuthMenu(AuthRoleVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public Page pageFindAssignAuthMenu(AuthRoleVO vo, Page page) {
        page = Dao.queryPage("AuthRole.pageFindAuthMenuByAuthAutherMenuMap", MapHelper.toMap("page", Page.notNullPage(page), "vo", vo));
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
     * @see com.foreveross.qdp.application.system.auth.AuthRoleApplication#assignAuthMenu(AuthRoleVO, Page)
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    public void assignAuthMenu(AuthRoleVO vo) {
        AuthRole domain = BeanHelper.copyProperties(AuthRole.class, vo);
        domain.assignAuthMenuByIds(StringUtils.split(vo.getMenuId(), ","));
    }

}
