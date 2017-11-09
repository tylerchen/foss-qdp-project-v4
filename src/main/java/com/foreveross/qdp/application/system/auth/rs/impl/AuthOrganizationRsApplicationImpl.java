/*******************************************************************************
 * Copyright (c) 2017-11-09 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
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

import com.foreveross.qdp.application.system.auth.rs.AuthOrganizationRsApplication;
import com.foreveross.qdp.application.system.auth.AuthOrganizationApplication;
import com.foreveross.qdp.infra.vo.system.auth.AuthOrganizationVO;

import com.foreveross.qdp.infra.vo.system.auth.AuthMenuVO;

import com.foreveross.qdp.infra.vo.system.auth.AuthUserVO;

import com.foreveross.qdp.infra.vo.system.auth.AuthRoleVO;
import com.foreveross.qdp.domain.system.auth.AuthOrganization;

import com.foreveross.qdp.domain.system.auth.AuthMenu;

import com.foreveross.qdp.domain.system.auth.AuthUser;

import com.foreveross.qdp.domain.system.auth.AuthRole;

/**
 * AuthOrganization
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2017-11-09
 * @version 1.0.0
 * auto generate by qdp v3.0.
 */
@Named("authOrganizationRsApplication")
public class AuthOrganizationRsApplicationImpl implements AuthOrganizationRsApplication {

	@Inject
	AuthOrganizationApplication authOrganizationApplication;

	/**
	 * <pre>
	 * get AuthOrganizationVO by id.
	 * </pre>
	 * @param vo
	 * @return AuthOrganizationVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthOrganizationApplication#getAuthOrganization(AuthOrganizationVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public AuthOrganizationVO getAuthOrganization(AuthOrganizationVO vo) {
		return authOrganizationApplication.getAuthOrganization(vo);
	}

	/**
	 * <pre>
	 * get AuthOrganizationVO by id.
	 * </pre>
	 * @param vo
	 * @return AuthOrganizationVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthOrganizationApplication#getAuthOrganizationById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public AuthOrganizationVO getAuthOrganizationById(String id){
		return authOrganizationApplication.getAuthOrganizationById(id);
	}
	
	/**
	 * <pre>
	 * page find AuthOrganizationVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthOrganizationApplication#pageFindAuthOrganization(AuthOrganizationVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindAuthOrganization(AuthOrganizationVO vo, Page page) {
		return authOrganizationApplication.pageFindAuthOrganization(vo, page);
	}
	
	/**
	 * <pre>
	 * page find AuthOrganizationVO Map.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthOrganizationApplication#pageFindAuthOrganizationMap(AuthOrganizationVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindAuthOrganizationMap(AuthOrganizationVO vo, Page page) {
		return authOrganizationApplication.pageFindAuthOrganizationMap(vo, page);
	}

	/**
	 * <pre>
	 * add AuthOrganization.
	 * </pre>
	 * @param vo
	 * @return AuthOrganizationVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthOrganizationApplication#addAuthOrganization(AuthOrganizationVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public AuthOrganizationVO addAuthOrganization(AuthOrganizationVO vo) {
		return authOrganizationApplication.addAuthOrganization(vo);
	}

	/**
	 * <pre>
	 * update AuthOrganization.
	 * </pre>
	 * @param vo
	 * @return AuthOrganizationVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthOrganizationApplication#updateAuthOrganization(AuthOrganizationVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public AuthOrganizationVO updateAuthOrganization(AuthOrganizationVO vo) {
		return authOrganizationApplication.updateAuthOrganization(vo);
	}
	
	/**
	 * <pre>
	 * remove AuthOrganization.
	 * </pre>
	 * @param vo conditions.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthOrganizationApplication#removeAuthOrganization(AuthOrganizationVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeAuthOrganization(AuthOrganizationVO vo) {
		authOrganizationApplication.removeAuthOrganization(vo);
	}

	/**
	 * <pre>
	 * remove AuthOrganization.
	 * </pre>
	 * @param id.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthOrganizationApplication#removeAuthOrganizationById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeAuthOrganizationById(String id) {
		authOrganizationApplication.removeAuthOrganizationById(id);
	}
	
	/**
	 * <pre>
	 * remove AuthOrganization.
	 * </pre>
	 * @param ids.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthOrganizationApplication#removeAuthOrganizationByIds(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeAuthOrganizationByIds(String[] ids) {
		authOrganizationApplication.removeAuthOrganizationByIds(ids);
	}
	
	
	/**
	 * <pre>
	 * get AuthOrganization by unique name
	 * </pre>
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.AuthOrganizationApplication#getByName(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 */
	public AuthOrganizationVO getByName(String name) {
		return authOrganizationApplication.getByName(name);
	}
	
	/**
	 * <pre>
	 * get AuthOrganization by unique code
	 * </pre>
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.AuthOrganizationApplication#getByCode(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 */
	public AuthOrganizationVO getByCode(String code) {
		return authOrganizationApplication.getByCode(code);
	}
	
	

	
	/**
	 * <pre>
	 * page find assign AuthMenuVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthOrganizationApplication#pageFindAssignAuthMenu(AuthOrganizationVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindAssignAuthMenu(AuthOrganizationVO vo, Page page) {
		return authOrganizationApplication.pageFindAssignAuthMenu(vo, page);
	}
	
	/**
	 * <pre>
	 * assign AuthMenu by id
	 * </pre>
	 * @param ids AuthMenu id
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthOrganizationApplication#assignAuthMenu(AuthOrganizationVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void assignAuthMenu(AuthOrganizationVO vo) {
		authOrganizationApplication.assignAuthMenu(vo);
	}

	
	/**
	 * <pre>
	 * page find assign AuthUserVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthOrganizationApplication#pageFindAssignAuthUser(AuthOrganizationVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindAssignAuthUser(AuthOrganizationVO vo, Page page) {
		return authOrganizationApplication.pageFindAssignAuthUser(vo, page);
	}
	
	/**
	 * <pre>
	 * assign AuthUser by id
	 * </pre>
	 * @param ids AuthUser id
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthOrganizationApplication#assignAuthUser(AuthOrganizationVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void assignAuthUser(AuthOrganizationVO vo) {
		authOrganizationApplication.assignAuthUser(vo);
	}

	
	/**
	 * <pre>
	 * page find assign AuthRoleVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthOrganizationApplication#pageFindAssignAuthRole(AuthOrganizationVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindAssignAuthRole(AuthOrganizationVO vo, Page page) {
		return authOrganizationApplication.pageFindAssignAuthRole(vo, page);
	}
	
	/**
	 * <pre>
	 * assign AuthRole by id
	 * </pre>
	 * @param ids AuthRole id
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthOrganizationApplication#assignAuthRole(AuthOrganizationVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void assignAuthRole(AuthOrganizationVO vo) {
		authOrganizationApplication.assignAuthRole(vo);
	}
	
}
