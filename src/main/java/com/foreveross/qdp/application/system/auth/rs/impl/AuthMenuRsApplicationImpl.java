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

import com.foreveross.qdp.application.system.auth.rs.AuthMenuRsApplication;
import com.foreveross.qdp.application.system.auth.AuthMenuApplication;
import com.foreveross.qdp.infra.vo.system.auth.AuthMenuVO;
import com.foreveross.qdp.domain.system.auth.AuthMenu;

/**
 * AuthMenu
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2017-11-09
 * @version 1.0.0
 * auto generate by qdp v3.0.
 */
@Named("authMenuRsApplication")
public class AuthMenuRsApplicationImpl implements AuthMenuRsApplication {

	@Inject
	AuthMenuApplication authMenuApplication;

	/**
	 * <pre>
	 * get AuthMenuVO by id.
	 * </pre>
	 * @param vo
	 * @return AuthMenuVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthMenuApplication#getAuthMenu(AuthMenuVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public AuthMenuVO getAuthMenu(AuthMenuVO vo) {
		return authMenuApplication.getAuthMenu(vo);
	}

	/**
	 * <pre>
	 * get AuthMenuVO by id.
	 * </pre>
	 * @param vo
	 * @return AuthMenuVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthMenuApplication#getAuthMenuById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public AuthMenuVO getAuthMenuById(String id){
		return authMenuApplication.getAuthMenuById(id);
	}
	
	/**
	 * <pre>
	 * page find AuthMenuVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthMenuApplication#pageFindAuthMenu(AuthMenuVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindAuthMenu(AuthMenuVO vo, Page page) {
		return authMenuApplication.pageFindAuthMenu(vo, page);
	}
	
	/**
	 * <pre>
	 * page find AuthMenuVO Map.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthMenuApplication#pageFindAuthMenuMap(AuthMenuVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindAuthMenuMap(AuthMenuVO vo, Page page) {
		return authMenuApplication.pageFindAuthMenuMap(vo, page);
	}

	/**
	 * <pre>
	 * add AuthMenu.
	 * </pre>
	 * @param vo
	 * @return AuthMenuVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthMenuApplication#addAuthMenu(AuthMenuVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public AuthMenuVO addAuthMenu(AuthMenuVO vo) {
		return authMenuApplication.addAuthMenu(vo);
	}

	/**
	 * <pre>
	 * update AuthMenu.
	 * </pre>
	 * @param vo
	 * @return AuthMenuVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthMenuApplication#updateAuthMenu(AuthMenuVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public AuthMenuVO updateAuthMenu(AuthMenuVO vo) {
		return authMenuApplication.updateAuthMenu(vo);
	}
	
	/**
	 * <pre>
	 * remove AuthMenu.
	 * </pre>
	 * @param vo conditions.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthMenuApplication#removeAuthMenu(AuthMenuVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeAuthMenu(AuthMenuVO vo) {
		authMenuApplication.removeAuthMenu(vo);
	}

	/**
	 * <pre>
	 * remove AuthMenu.
	 * </pre>
	 * @param id.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthMenuApplication#removeAuthMenuById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeAuthMenuById(String id) {
		authMenuApplication.removeAuthMenuById(id);
	}
	
	/**
	 * <pre>
	 * remove AuthMenu.
	 * </pre>
	 * @param ids.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.ws.AuthMenuApplication#removeAuthMenuByIds(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeAuthMenuByIds(String[] ids) {
		authMenuApplication.removeAuthMenuByIds(ids);
	}
	
	
	/**
	 * <pre>
	 * get AuthMenu by unique name
	 * </pre>
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.auth.AuthMenuApplication#getByName(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 */
	public AuthMenuVO getByName(String name) {
		return authMenuApplication.getByName(name);
	}
	
	
	
}
