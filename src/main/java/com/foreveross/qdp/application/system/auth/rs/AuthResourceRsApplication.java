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
import com.foreveross.qdp.infra.vo.system.auth.AuthResourceVO;

/**
 * AuthResource Application.
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2017-10-17
 * @version 1.0.0
 * auto generate by qdp v3.0.
 */
@Path("authResourceRsApplication")
@Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.MULTIPART_FORM_DATA })
public interface AuthResourceRsApplication {

	/**
	 * <pre>
	 * get AuthResourceVO by id.
	 * </pre>
	 * @param vo
	 * @return AuthResourceVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/getAuthResource")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	AuthResourceVO getAuthResource(@FormParam("AuthResourceVO") AuthResourceVO vo);

	/**
	 * <pre>
	 * get AuthResourceVO by id.
	 * </pre>
	 * @param vo
	 * @return AuthResourceVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@GET
	@Path("/getAuthResourceById/{id}")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	AuthResourceVO getAuthResourceById(@PathParam("id") String id);
	
	/**
	 * <pre>
	 * page find AuthResourceVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/pageFindAuthResource")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	Page pageFindAuthResource(@FormParam("AuthResourceVO") AuthResourceVO vo, @FormParam("Page") Page page);
	
	/**
	 * <pre>
	 * page find AuthResourceVO Map.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/pageFindAuthResourceMap")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	Page pageFindAuthResourceMap(@FormParam("AuthResourceVO") AuthResourceVO vo, @FormParam("Page") Page page);

	/**
	 * <pre>
	 * add AuthResource.
	 * </pre>
	 * @param vo
	 * @return AuthResourceVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/addAuthResource")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	AuthResourceVO addAuthResource(@FormParam("AuthResourceVO") AuthResourceVO vo);
	
	/**
	 * <pre>
	 * update AuthResource.
	 * </pre>
	 * @param vo
	 * @return AuthResourceVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/updateAuthResource")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	AuthResourceVO updateAuthResource(@FormParam("AuthResourceVO") AuthResourceVO vo);

	/**
	 * <pre>
	 * remove AuthResource.
	 * </pre>
	 * @param vo conditions.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeAuthResource")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeAuthResource(@FormParam("AuthResourceVO") AuthResourceVO vo);
	
	/**
	 * <pre>
	 * remove AuthResource.
	 * </pre>
	 * @param id.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeAuthResourceById/{id}")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeAuthResourceById(@PathParam("id") String id);
	
	/**
	 * <pre>
	 * remove AuthResource.
	 * </pre>
	 * @param ids.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeAuthResourceByIds")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeAuthResourceByIds(@FormParam("ids") String[] ids);
	
	
	/**
	 * <pre>
	 * get AuthResource by unique name
	 * Usage : AuthResource.getByName(name)
	 * </pre>
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 */
	@POST
	@Path("/getByName")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	AuthResourceVO getByName(String name);
	
	/**
	 * <pre>
	 * get AuthResource by unique code
	 * Usage : AuthResource.getByCode(code)
	 * </pre>
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 */
	@POST
	@Path("/getByCode")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	AuthResourceVO getByCode(String code);
	
	
	
}
