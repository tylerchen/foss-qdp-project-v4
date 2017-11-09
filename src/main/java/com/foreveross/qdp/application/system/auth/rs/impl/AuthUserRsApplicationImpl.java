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

import com.foreveross.qdp.application.system.auth.rs.AuthUserRsApplication;
import com.foreveross.qdp.application.system.auth.AuthUserApplication;
import com.foreveross.qdp.infra.vo.system.auth.AuthUserVO;
import com.foreveross.qdp.domain.system.auth.AuthUser;

/**
 * AuthUser
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2017-11-09
 * @version 1.0.0
 * auto generate by qdp v3.0.
 */
@Named("authUserRsApplication")
public class AuthUserRsApplicationImpl implements AuthUserRsApplication {

	@Inject
	AuthUserApplication authUserApplication;

	/**
	 * <pre>
	 * get AuthUserVO by id.
	 * </pre>
	 * @param vo
	 * @return AuthUserVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthUserApplication#getAuthUser(AuthUserVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public AuthUserVO getAuthUser(AuthUserVO vo) {
		return authUserApplication.getAuthUser(vo);
	}

	/**
	 * <pre>
	 * get AuthUserVO by id.
	 * </pre>
	 * @param vo
	 * @return AuthUserVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthUserApplication#getAuthUserById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public AuthUserVO getAuthUserById(String id){
		return authUserApplication.getAuthUserById(id);
	}
	
	/**
	 * <pre>
	 * page find AuthUserVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthUserApplication#pageFindAuthUser(AuthUserVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindAuthUser(AuthUserVO vo, Page page) {
		return authUserApplication.pageFindAuthUser(vo, page);
	}
	
	/**
	 * <pre>
	 * page find AuthUserVO Map.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthUserApplication#pageFindAuthUserMap(AuthUserVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindAuthUserMap(AuthUserVO vo, Page page) {
		return authUserApplication.pageFindAuthUserMap(vo, page);
	}

	/**
	 * <pre>
	 * add AuthUser.
	 * </pre>
	 * @param vo
	 * @return AuthUserVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthUserApplication#addAuthUser(AuthUserVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public AuthUserVO addAuthUser(AuthUserVO vo) {
		return authUserApplication.addAuthUser(vo);
	}

	/**
	 * <pre>
	 * update AuthUser.
	 * </pre>
	 * @param vo
	 * @return AuthUserVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthUserApplication#updateAuthUser(AuthUserVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public AuthUserVO updateAuthUser(AuthUserVO vo) {
		return authUserApplication.updateAuthUser(vo);
	}
	
	/**
	 * <pre>
	 * remove AuthUser.
	 * </pre>
	 * @param vo conditions.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthUserApplication#removeAuthUser(AuthUserVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeAuthUser(AuthUserVO vo) {
		authUserApplication.removeAuthUser(vo);
	}

	/**
	 * <pre>
	 * remove AuthUser.
	 * </pre>
	 * @param id.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthUserApplication#removeAuthUserById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeAuthUserById(String id) {
		authUserApplication.removeAuthUserById(id);
	}
	
	/**
	 * <pre>
	 * remove AuthUser.
	 * </pre>
	 * @param ids.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthUserApplication#removeAuthUserByIds(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeAuthUserByIds(String[] ids) {
		authUserApplication.removeAuthUserByIds(ids);
	}
	
	
	/**
	 * <pre>
	 * get AuthUser by unique name
	 * </pre>
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.AuthUserApplication#getByName(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 */
	public AuthUserVO getByName(String name) {
		return authUserApplication.getByName(name);
	}
	
	/**
	 * <pre>
	 * get AuthUser by unique email
	 * </pre>
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.AuthUserApplication#getByEmail(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 */
	public AuthUserVO getByEmail(String email) {
		return authUserApplication.getByEmail(email);
	}
	
	
	
}
