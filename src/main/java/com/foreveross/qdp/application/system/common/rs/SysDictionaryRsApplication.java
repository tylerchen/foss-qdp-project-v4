/*******************************************************************************
 * Copyright (c) 2017-10-17 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation.
 * Auto Generate By foreveross.com Quick Deliver Platform. 
 ******************************************************************************/
package com.foreveross.qdp.application.system.common.rs;

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
import com.foreveross.qdp.infra.vo.system.common.SysDictionaryVO;

/**
 * SysDictionary Application.
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2017-10-17
 * @version 1.0.0
 * auto generate by qdp v3.0.
 */
@Path("sysDictionaryRsApplication")
@Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.MULTIPART_FORM_DATA })
public interface SysDictionaryRsApplication {

	/**
	 * <pre>
	 * get SysDictionaryVO by id.
	 * </pre>
	 * @param vo
	 * @return SysDictionaryVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/getSysDictionary")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	SysDictionaryVO getSysDictionary(@FormParam("SysDictionaryVO") SysDictionaryVO vo);

	/**
	 * <pre>
	 * get SysDictionaryVO by id.
	 * </pre>
	 * @param vo
	 * @return SysDictionaryVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@GET
	@Path("/getSysDictionaryById/{id}")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	SysDictionaryVO getSysDictionaryById(@PathParam("id") String id);
	
	/**
	 * <pre>
	 * page find SysDictionaryVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/pageFindSysDictionary")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	Page pageFindSysDictionary(@FormParam("SysDictionaryVO") SysDictionaryVO vo, @FormParam("Page") Page page);
	
	/**
	 * <pre>
	 * page find SysDictionaryVO Map.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/pageFindSysDictionaryMap")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	Page pageFindSysDictionaryMap(@FormParam("SysDictionaryVO") SysDictionaryVO vo, @FormParam("Page") Page page);

	/**
	 * <pre>
	 * add SysDictionary.
	 * </pre>
	 * @param vo
	 * @return SysDictionaryVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/addSysDictionary")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	SysDictionaryVO addSysDictionary(@FormParam("SysDictionaryVO") SysDictionaryVO vo);
	
	/**
	 * <pre>
	 * update SysDictionary.
	 * </pre>
	 * @param vo
	 * @return SysDictionaryVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/updateSysDictionary")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	SysDictionaryVO updateSysDictionary(@FormParam("SysDictionaryVO") SysDictionaryVO vo);

	/**
	 * <pre>
	 * remove SysDictionary.
	 * </pre>
	 * @param vo conditions.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeSysDictionary")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeSysDictionary(@FormParam("SysDictionaryVO") SysDictionaryVO vo);
	
	/**
	 * <pre>
	 * remove SysDictionary.
	 * </pre>
	 * @param id.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeSysDictionaryById/{id}")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeSysDictionaryById(@PathParam("id") String id);
	
	/**
	 * <pre>
	 * remove SysDictionary.
	 * </pre>
	 * @param ids.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeSysDictionaryByIds")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeSysDictionaryByIds(@FormParam("ids") String[] ids);
	
	
	
	
}
