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

import com.foreveross.qdp.application.system.auth.rs.AuthResourceRsApplication;
import com.foreveross.qdp.application.system.auth.AuthResourceApplication;
import com.foreveross.qdp.infra.vo.system.auth.AuthResourceVO;
import com.foreveross.qdp.domain.system.auth.AuthResource;

/**
 * AuthResource
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2017-11-09
 * @version 1.0.0
 * auto generate by qdp v3.0.
 */
@Named("authResourceRsApplication")
public class AuthResourceRsApplicationImpl implements AuthResourceRsApplication {

	@Inject
	AuthResourceApplication authResourceApplication;

	/**
	 * <pre>
	 * get AuthResourceVO by id.
	 * </pre>
	 * @param vo
	 * @return AuthResourceVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthResourceApplication#getAuthResource(AuthResourceVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public AuthResourceVO getAuthResource(AuthResourceVO vo) {
		return authResourceApplication.getAuthResource(vo);
	}

	/**
	 * <pre>
	 * get AuthResourceVO by id.
	 * </pre>
	 * @param vo
	 * @return AuthResourceVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthResourceApplication#getAuthResourceById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public AuthResourceVO getAuthResourceById(String id){
		return authResourceApplication.getAuthResourceById(id);
	}
	
	/**
	 * <pre>
	 * page find AuthResourceVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthResourceApplication#pageFindAuthResource(AuthResourceVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindAuthResource(AuthResourceVO vo, Page page) {
		return authResourceApplication.pageFindAuthResource(vo, page);
	}
	
	/**
	 * <pre>
	 * page find AuthResourceVO Map.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthResourceApplication#pageFindAuthResourceMap(AuthResourceVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindAuthResourceMap(AuthResourceVO vo, Page page) {
		return authResourceApplication.pageFindAuthResourceMap(vo, page);
	}

	/**
	 * <pre>
	 * add AuthResource.
	 * </pre>
	 * @param vo
	 * @return AuthResourceVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthResourceApplication#addAuthResource(AuthResourceVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public AuthResourceVO addAuthResource(AuthResourceVO vo) {
		return authResourceApplication.addAuthResource(vo);
	}

	/**
	 * <pre>
	 * update AuthResource.
	 * </pre>
	 * @param vo
	 * @return AuthResourceVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthResourceApplication#updateAuthResource(AuthResourceVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public AuthResourceVO updateAuthResource(AuthResourceVO vo) {
		return authResourceApplication.updateAuthResource(vo);
	}
	
	/**
	 * <pre>
	 * remove AuthResource.
	 * </pre>
	 * @param vo conditions.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthResourceApplication#removeAuthResource(AuthResourceVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeAuthResource(AuthResourceVO vo) {
		authResourceApplication.removeAuthResource(vo);
	}

	/**
	 * <pre>
	 * remove AuthResource.
	 * </pre>
	 * @param id.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthResourceApplication#removeAuthResourceById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeAuthResourceById(String id) {
		authResourceApplication.removeAuthResourceById(id);
	}
	
	/**
	 * <pre>
	 * remove AuthResource.
	 * </pre>
	 * @param ids.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthResourceApplication#removeAuthResourceByIds(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeAuthResourceByIds(String[] ids) {
		authResourceApplication.removeAuthResourceByIds(ids);
	}
	
	
	/**
	 * <pre>
	 * get AuthResource by unique name
	 * </pre>
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.AuthResourceApplication#getByName(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 */
	public AuthResourceVO getByName(String name) {
		return authResourceApplication.getByName(name);
	}
	
	/**
	 * <pre>
	 * get AuthResource by unique code
	 * </pre>
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.AuthResourceApplication#getByCode(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 */
	public AuthResourceVO getByCode(String code) {
		return authResourceApplication.getByCode(code);
	}
	
	
	
}
