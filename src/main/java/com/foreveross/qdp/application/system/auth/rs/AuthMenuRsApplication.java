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
import com.foreveross.qdp.infra.vo.system.auth.AuthMenuVO;

/**
 * AuthMenu Application.
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2017-10-17
 * @version 1.0.0
 * auto generate by qdp v3.0.
 */
@Path("authMenuRsApplication")
@Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.MULTIPART_FORM_DATA })
public interface AuthMenuRsApplication {

	/**
	 * <pre>
	 * get AuthMenuVO by id.
	 * </pre>
	 * @param vo
	 * @return AuthMenuVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/getAuthMenu")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	AuthMenuVO getAuthMenu(@FormParam("AuthMenuVO") AuthMenuVO vo);

	/**
	 * <pre>
	 * get AuthMenuVO by id.
	 * </pre>
	 * @param vo
	 * @return AuthMenuVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@GET
	@Path("/getAuthMenuById/{id}")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	AuthMenuVO getAuthMenuById(@PathParam("id") String id);
	
	/**
	 * <pre>
	 * page find AuthMenuVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/pageFindAuthMenu")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	Page pageFindAuthMenu(@FormParam("AuthMenuVO") AuthMenuVO vo, @FormParam("Page") Page page);
	
	/**
	 * <pre>
	 * page find AuthMenuVO Map.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/pageFindAuthMenuMap")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	Page pageFindAuthMenuMap(@FormParam("AuthMenuVO") AuthMenuVO vo, @FormParam("Page") Page page);

	/**
	 * <pre>
	 * add AuthMenu.
	 * </pre>
	 * @param vo
	 * @return AuthMenuVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/addAuthMenu")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	AuthMenuVO addAuthMenu(@FormParam("AuthMenuVO") AuthMenuVO vo);
	
	/**
	 * <pre>
	 * update AuthMenu.
	 * </pre>
	 * @param vo
	 * @return AuthMenuVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/updateAuthMenu")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	AuthMenuVO updateAuthMenu(@FormParam("AuthMenuVO") AuthMenuVO vo);

	/**
	 * <pre>
	 * remove AuthMenu.
	 * </pre>
	 * @param vo conditions.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeAuthMenu")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeAuthMenu(@FormParam("AuthMenuVO") AuthMenuVO vo);
	
	/**
	 * <pre>
	 * remove AuthMenu.
	 * </pre>
	 * @param id.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeAuthMenuById/{id}")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeAuthMenuById(@PathParam("id") String id);
	
	/**
	 * <pre>
	 * remove AuthMenu.
	 * </pre>
	 * @param ids.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeAuthMenuByIds")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeAuthMenuByIds(@FormParam("ids") String[] ids);
	
	
	/**
	 * <pre>
	 * get AuthMenu by unique name
	 * Usage : AuthMenu.getByName(name)
	 * </pre>
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 */
	@POST
	@Path("/getByName")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	AuthMenuVO getByName(String name);
	
	
	
}
