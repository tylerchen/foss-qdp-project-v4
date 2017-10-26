/*******************************************************************************
 * Copyright (c) 2017-10-17 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
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
import com.foreveross.qdp.infra.vo.system.auth.AuthRoleVO;

/**
 * AuthRole Application.
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2017-10-17
 * @version 1.0.0
 * auto generate by qdp v3.0.
 */
@Path("authRoleRsApplication")
@Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.MULTIPART_FORM_DATA })
public interface AuthRoleRsApplication {

	/**
	 * <pre>
	 * get AuthRoleVO by id.
	 * </pre>
	 * @param vo
	 * @return AuthRoleVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/getAuthRole")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	AuthRoleVO getAuthRole(@FormParam("AuthRoleVO") AuthRoleVO vo);

	/**
	 * <pre>
	 * get AuthRoleVO by id.
	 * </pre>
	 * @param vo
	 * @return AuthRoleVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@GET
	@Path("/getAuthRoleById/{id}")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	AuthRoleVO getAuthRoleById(@PathParam("id") String id);
	
	/**
	 * <pre>
	 * page find AuthRoleVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/pageFindAuthRole")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	Page pageFindAuthRole(@FormParam("AuthRoleVO") AuthRoleVO vo, @FormParam("Page") Page page);
	
	/**
	 * <pre>
	 * page find AuthRoleVO Map.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/pageFindAuthRoleMap")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	Page pageFindAuthRoleMap(@FormParam("AuthRoleVO") AuthRoleVO vo, @FormParam("Page") Page page);

	/**
	 * <pre>
	 * add AuthRole.
	 * </pre>
	 * @param vo
	 * @return AuthRoleVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/addAuthRole")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	AuthRoleVO addAuthRole(@FormParam("AuthRoleVO") AuthRoleVO vo);
	
	/**
	 * <pre>
	 * update AuthRole.
	 * </pre>
	 * @param vo
	 * @return AuthRoleVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/updateAuthRole")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	AuthRoleVO updateAuthRole(@FormParam("AuthRoleVO") AuthRoleVO vo);

	/**
	 * <pre>
	 * remove AuthRole.
	 * </pre>
	 * @param vo conditions.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeAuthRole")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeAuthRole(@FormParam("AuthRoleVO") AuthRoleVO vo);
	
	/**
	 * <pre>
	 * remove AuthRole.
	 * </pre>
	 * @param id.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeAuthRoleById/{id}")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeAuthRoleById(@PathParam("id") String id);
	
	/**
	 * <pre>
	 * remove AuthRole.
	 * </pre>
	 * @param ids.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeAuthRoleByIds")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeAuthRoleByIds(@FormParam("ids") String[] ids);
	
	
	/**
	 * <pre>
	 * get AuthRole by unique name
	 * Usage : AuthRole.getByName(name)
	 * </pre>
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 */
	@POST
	@Path("/getByName")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	AuthRoleVO getByName(String name);
	
	/**
	 * <pre>
	 * get AuthRole by unique code
	 * Usage : AuthRole.getByCode(code)
	 * </pre>
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 */
	@POST
	@Path("/getByCode")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	AuthRoleVO getByCode(String code);
	
	

	
	/**
	 * <pre>
	 * page find assign AuthResourceVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/pageFindAssignAuthResource")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	Page pageFindAssignAuthResource(@FormParam("AuthRoleVO") AuthRoleVO vo, @FormParam("Page") Page page);
	
	/**
	 * <pre>
	 * assign AuthResource by id
	 * </pre>
	 * @param ids AuthResource id
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/assignAuthResourceByIds")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void assignAuthResource(@FormParam("AuthRoleVO") AuthRoleVO vo);

	
	/**
	 * <pre>
	 * page find assign AuthMenuVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/pageFindAssignAuthMenu")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	Page pageFindAssignAuthMenu(@FormParam("AuthRoleVO") AuthRoleVO vo, @FormParam("Page") Page page);
	
	/**
	 * <pre>
	 * assign AuthMenu by id
	 * </pre>
	 * @param ids AuthMenu id
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/assignAuthMenuByIds")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void assignAuthMenu(@FormParam("AuthRoleVO") AuthRoleVO vo);
	
}
