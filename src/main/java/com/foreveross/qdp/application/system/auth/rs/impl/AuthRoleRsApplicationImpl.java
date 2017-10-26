/*******************************************************************************
 * Copyright (c) 2017-10-17 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation.
 * Auto Generate By foreveross.com Quick Deliver Platform. 
 ******************************************************************************/
package com.foreveross.qdp.application.system.auth.rs.impl;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.iff.infra.util.BeanHelper;
import org.iff.infra.util.MapHelper;
import org.iff.infra.util.mybatis.plugin.Page;
import org.iff.infra.util.mybatis.service.Dao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import com.foreveross.qdp.application.system.auth.rs.AuthRoleRsApplication;
import com.foreveross.qdp.application.system.auth.AuthRoleApplication;
import com.foreveross.qdp.infra.vo.system.auth.AuthRoleVO;

import com.foreveross.qdp.infra.vo.system.auth.AuthResourceVO;

import com.foreveross.qdp.infra.vo.system.auth.AuthMenuVO;
import com.foreveross.qdp.domain.system.auth.AuthRole;

import com.foreveross.qdp.domain.system.auth.AuthResource;

import com.foreveross.qdp.domain.system.auth.AuthMenu;

/**
 * AuthRole
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2017-10-17
 * @version 1.0.0
 * auto generate by qdp v3.0.
 */
@Named("authRoleRsApplication")
public class AuthRoleRsApplicationImpl implements AuthRoleRsApplication {

	@Inject
	AuthRoleApplication authRoleApplication;

	/**
	 * <pre>
	 * get AuthRoleVO by id.
	 * </pre>
	 * @param vo
	 * @return AuthRoleVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthRoleApplication#getAuthRole(AuthRoleVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public AuthRoleVO getAuthRole(AuthRoleVO vo) {
		return authRoleApplication.getAuthRole(vo);
	}

	/**
	 * <pre>
	 * get AuthRoleVO by id.
	 * </pre>
	 * @param vo
	 * @return AuthRoleVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthRoleApplication#getAuthRoleById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public AuthRoleVO getAuthRoleById(String id){
		return authRoleApplication.getAuthRoleById(id);
	}
	
	/**
	 * <pre>
	 * page find AuthRoleVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthRoleApplication#pageFindAuthRole(AuthRoleVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindAuthRole(AuthRoleVO vo, Page page) {
		return authRoleApplication.pageFindAuthRole(vo, page);
	}
	
	/**
	 * <pre>
	 * page find AuthRoleVO Map.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthRoleApplication#pageFindAuthRoleMap(AuthRoleVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindAuthRoleMap(AuthRoleVO vo, Page page) {
		return authRoleApplication.pageFindAuthRoleMap(vo, page);
	}

	/**
	 * <pre>
	 * add AuthRole.
	 * </pre>
	 * @param vo
	 * @return AuthRoleVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthRoleApplication#addAuthRole(AuthRoleVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public AuthRoleVO addAuthRole(AuthRoleVO vo) {
		return authRoleApplication.addAuthRole(vo);
	}

	/**
	 * <pre>
	 * update AuthRole.
	 * </pre>
	 * @param vo
	 * @return AuthRoleVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthRoleApplication#updateAuthRole(AuthRoleVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public AuthRoleVO updateAuthRole(AuthRoleVO vo) {
		return authRoleApplication.updateAuthRole(vo);
	}
	
	/**
	 * <pre>
	 * remove AuthRole.
	 * </pre>
	 * @param vo conditions.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthRoleApplication#removeAuthRole(AuthRoleVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public void removeAuthRole(AuthRoleVO vo) {
		authRoleApplication.removeAuthRole(vo);
	}

	/**
	 * <pre>
	 * remove AuthRole.
	 * </pre>
	 * @param id.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthRoleApplication#removeAuthRoleById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public void removeAuthRoleById(String id) {
		authRoleApplication.removeAuthRoleById(id);
	}
	
	/**
	 * <pre>
	 * remove AuthRole.
	 * </pre>
	 * @param ids.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthRoleApplication#removeAuthRoleByIds(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public void removeAuthRoleByIds(String[] ids) {
		authRoleApplication.removeAuthRoleByIds(ids);
	}
	
	
	/**
	 * <pre>
	 * get AuthRole by unique name
	 * </pre>
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.AuthRoleApplication#getByName(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 */
	public AuthRoleVO getByName(String name) {
		return authRoleApplication.getByName(name);
	}
	
	/**
	 * <pre>
	 * get AuthRole by unique code
	 * </pre>
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.AuthRoleApplication#getByCode(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 */
	public AuthRoleVO getByCode(String code) {
		return authRoleApplication.getByCode(code);
	}
	
	

	
	/**
	 * <pre>
	 * page find assign AuthResourceVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthRoleApplication#pageFindAssignAuthResource(AuthRoleVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindAssignAuthResource(AuthRoleVO vo, Page page) {
		return authRoleApplication.pageFindAssignAuthResource(vo, page);
	}
	
	/**
	 * <pre>
	 * assign AuthResource by id
	 * </pre>
	 * @param ids AuthResource id
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthRoleApplication#assignAuthResource(AuthRoleVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public void assignAuthResource(AuthRoleVO vo) {
		authRoleApplication.assignAuthResource(vo);
	}

	
	/**
	 * <pre>
	 * page find assign AuthMenuVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthRoleApplication#pageFindAssignAuthMenu(AuthRoleVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindAssignAuthMenu(AuthRoleVO vo, Page page) {
		return authRoleApplication.pageFindAssignAuthMenu(vo, page);
	}
	
	/**
	 * <pre>
	 * assign AuthMenu by id
	 * </pre>
	 * @param ids AuthMenu id
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthRoleApplication#assignAuthMenu(AuthRoleVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public void assignAuthMenu(AuthRoleVO vo) {
		authRoleApplication.assignAuthMenu(vo);
	}
	
}
