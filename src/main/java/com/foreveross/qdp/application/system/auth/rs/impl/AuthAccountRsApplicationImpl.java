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

import com.foreveross.qdp.application.system.auth.rs.AuthAccountRsApplication;
import com.foreveross.qdp.application.system.auth.AuthAccountApplication;
import com.foreveross.qdp.infra.vo.system.auth.AuthAccountVO;
import com.foreveross.qdp.infra.vo.system.auth.EditPasswordVO;

import com.foreveross.qdp.infra.vo.system.auth.AuthRoleVO;
import com.foreveross.qdp.domain.system.auth.AuthAccount;

import com.foreveross.qdp.domain.system.auth.AuthRole;

/**
 * AuthAccount
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2017-10-17
 * @version 1.0.0
 * auto generate by qdp v3.0.
 */
@Named("authAccountRsApplication")
public class AuthAccountRsApplicationImpl implements AuthAccountRsApplication {

	@Inject
	AuthAccountApplication authAccountApplication;

	/**
	 * <pre>
	 * get AuthAccountVO by id.
	 * </pre>
	 * @param vo
	 * @return AuthAccountVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthAccountApplication#getAuthAccount(AuthAccountVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public AuthAccountVO getAuthAccount(AuthAccountVO vo) {
		return authAccountApplication.getAuthAccount(vo);
	}

	/**
	 * <pre>
	 * get AuthAccountVO by id.
	 * </pre>
	 * @param vo
	 * @return AuthAccountVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthAccountApplication#getAuthAccountById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public AuthAccountVO getAuthAccountById(String id){
		return authAccountApplication.getAuthAccountById(id);
	}
	
	/**
	 * <pre>
	 * page find AuthAccountVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthAccountApplication#pageFindAuthAccount(AuthAccountVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindAuthAccount(AuthAccountVO vo, Page page) {
		return authAccountApplication.pageFindAuthAccount(vo, page);
	}
	
	/**
	 * <pre>
	 * page find AuthAccountVO Map.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthAccountApplication#pageFindAuthAccountMap(AuthAccountVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindAuthAccountMap(AuthAccountVO vo, Page page) {
		return authAccountApplication.pageFindAuthAccountMap(vo, page);
	}

	/**
	 * <pre>
	 * add AuthAccount.
	 * </pre>
	 * @param vo
	 * @return AuthAccountVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthAccountApplication#addAuthAccount(AuthAccountVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public AuthAccountVO addAuthAccount(AuthAccountVO vo) {
		return authAccountApplication.addAuthAccount(vo);
	}

	/**
	 * <pre>
	 * update AuthAccount.
	 * </pre>
	 * @param vo
	 * @return AuthAccountVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthAccountApplication#updateAuthAccount(AuthAccountVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public AuthAccountVO updateAuthAccount(AuthAccountVO vo) {
		return authAccountApplication.updateAuthAccount(vo);
	}
	
	/**
	 * <pre>
	 * remove AuthAccount.
	 * </pre>
	 * @param vo conditions.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthAccountApplication#removeAuthAccount(AuthAccountVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public void removeAuthAccount(AuthAccountVO vo) {
		authAccountApplication.removeAuthAccount(vo);
	}

	/**
	 * <pre>
	 * remove AuthAccount.
	 * </pre>
	 * @param id.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthAccountApplication#removeAuthAccountById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public void removeAuthAccountById(String id) {
		authAccountApplication.removeAuthAccountById(id);
	}
	
	/**
	 * <pre>
	 * remove AuthAccount.
	 * </pre>
	 * @param ids.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthAccountApplication#removeAuthAccountByIds(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public void removeAuthAccountByIds(String[] ids) {
		authAccountApplication.removeAuthAccountByIds(ids);
	}
	
	
	/**
	 * <pre>
	 * get AuthAccount by unique loginEmail
	 * </pre>
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.AuthAccountApplication#getByLoginEmail(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 */
	public AuthAccountVO getByLoginEmail(String loginEmail) {
		return authAccountApplication.getByLoginEmail(loginEmail);
	}
	
	

	
	/**
	 * <pre>
	 * page find assign AuthRoleVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthAccountApplication#pageFindAssignAuthRole(AuthAccountVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindAssignAuthRole(AuthAccountVO vo, Page page) {
		return authAccountApplication.pageFindAssignAuthRole(vo, page);
	}
	
	/**
	 * <pre>
	 * assign AuthRole by id
	 * </pre>
	 * @param ids AuthRole id
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthAccountApplication#assignAuthRole(AuthAccountVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public void assignAuthRole(AuthAccountVO vo) {
		authAccountApplication.assignAuthRole(vo);
	}
	
	/**
	 * <pre>
	 * editPassword
	 * </pre>
	 * @param vo EditPasswordVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthAccountApplication#editPassword(EditPasswordVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public void editPassword(EditPasswordVO vo) {
		authAccountApplication.editPassword(vo);
	}
}
