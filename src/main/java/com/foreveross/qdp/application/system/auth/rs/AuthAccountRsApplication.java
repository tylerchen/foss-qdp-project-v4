/*******************************************************************************
 * Copyright (c) 2017-11-09 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation.
 * Auto Generate By foreveross.com Quick Deliver Platform. 
 ******************************************************************************/
package com.foreveross.qdp.application.system.auth.rs;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.iff.infra.util.mybatis.plugin.Page;
import com.foreveross.qdp.infra.vo.system.auth.AuthAccountVO;
import com.foreveross.qdp.infra.vo.system.auth.EditPasswordVO;

/**
 * AuthAccount Application.
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2017-11-09
 * @version 1.0.0
 * auto generate by qdp v3.0.
 */
@Path("authAccountRsApplication")
@Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.MULTIPART_FORM_DATA })
public interface AuthAccountRsApplication {

	/**
	 * <pre>
	 * get AuthAccountVO by id.
	 * </pre>
	 * @param vo
	 * @return AuthAccountVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/getAuthAccount")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	AuthAccountVO getAuthAccount(@FormParam("AuthAccountVO") AuthAccountVO vo);

	/**
	 * <pre>
	 * get AuthAccountVO by id.
	 * </pre>
	 * @param vo
	 * @return AuthAccountVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@GET
	@Path("/getAuthAccountById/{id}")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	AuthAccountVO getAuthAccountById(@PathParam("id") String id);
	
	/**
	 * <pre>
	 * page find AuthAccountVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/pageFindAuthAccount")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	Page pageFindAuthAccount(@FormParam("AuthAccountVO") AuthAccountVO vo, @FormParam("Page") Page page);
	
	/**
	 * <pre>
	 * page find AuthAccountVO Map.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/pageFindAuthAccountMap")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	Page pageFindAuthAccountMap(@FormParam("AuthAccountVO") AuthAccountVO vo, @FormParam("Page") Page page);

	/**
	 * <pre>
	 * add AuthAccount.
	 * </pre>
	 * @param vo
	 * @return AuthAccountVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/addAuthAccount")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	AuthAccountVO addAuthAccount(@FormParam("AuthAccountVO") AuthAccountVO vo);
	
	/**
	 * <pre>
	 * update AuthAccount.
	 * </pre>
	 * @param vo
	 * @return AuthAccountVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/updateAuthAccount")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	AuthAccountVO updateAuthAccount(@FormParam("AuthAccountVO") AuthAccountVO vo);

	/**
	 * <pre>
	 * remove AuthAccount.
	 * </pre>
	 * @param vo conditions.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeAuthAccount")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeAuthAccount(@FormParam("AuthAccountVO") AuthAccountVO vo);
	
	/**
	 * <pre>
	 * remove AuthAccount.
	 * </pre>
	 * @param id.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeAuthAccountById/{id}")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeAuthAccountById(@PathParam("id") String id);
	
	/**
	 * <pre>
	 * remove AuthAccount.
	 * </pre>
	 * @param ids.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeAuthAccountByIds")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeAuthAccountByIds(@FormParam("ids") String[] ids);
	
	
	/**
	 * <pre>
	 * get AuthAccount by unique loginEmail
	 * Usage : AuthAccount.getByLoginEmail(loginEmail)
	 * </pre>
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 */
	@POST
	@Path("/getByLoginEmail")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	AuthAccountVO getByLoginEmail(String loginEmail);
	
	

	
	/**
	 * <pre>
	 * page find assign AuthRoleVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/pageFindAssignAuthRole")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	Page pageFindAssignAuthRole(@FormParam("AuthAccountVO") AuthAccountVO vo, @FormParam("Page") Page page);
	
	/**
	 * <pre>
	 * assign AuthRole by id
	 * </pre>
	 * @param ids AuthRole id
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/assignAuthRoleByIds")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void assignAuthRole(@FormParam("AuthAccountVO") AuthAccountVO vo);
	
	/**
	 * <pre>
	 * editPassword
	 * </pre>
	 * @param vo EditPasswordVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/editPassword")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void editPassword(EditPasswordVO vo);
}
