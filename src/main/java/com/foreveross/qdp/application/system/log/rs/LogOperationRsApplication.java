/*******************************************************************************
 * Copyright (c) 2017-11-09 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation.
 * Auto Generate By foreveross.com Quick Deliver Platform. 
 ******************************************************************************/
package com.foreveross.qdp.application.system.log.rs;

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
import com.foreveross.qdp.infra.vo.system.log.LogOperationVO;

/**
 * LogOperation Application.
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2017-11-09
 * @version 1.0.0
 * auto generate by qdp v3.0.
 */
@Path("logOperationRsApplication")
@Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.MULTIPART_FORM_DATA })
public interface LogOperationRsApplication {

	/**
	 * <pre>
	 * get LogOperationVO by id.
	 * </pre>
	 * @param vo
	 * @return LogOperationVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/getLogOperation")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	LogOperationVO getLogOperation(@FormParam("LogOperationVO") LogOperationVO vo);

	/**
	 * <pre>
	 * get LogOperationVO by id.
	 * </pre>
	 * @param vo
	 * @return LogOperationVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@GET
	@Path("/getLogOperationById/{id}")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	LogOperationVO getLogOperationById(@PathParam("id") String id);
	
	/**
	 * <pre>
	 * page find LogOperationVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/pageFindLogOperation")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	Page pageFindLogOperation(@FormParam("LogOperationVO") LogOperationVO vo, @FormParam("Page") Page page);
	
	/**
	 * <pre>
	 * page find LogOperationVO Map.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/pageFindLogOperationMap")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	Page pageFindLogOperationMap(@FormParam("LogOperationVO") LogOperationVO vo, @FormParam("Page") Page page);

	/**
	 * <pre>
	 * add LogOperation.
	 * </pre>
	 * @param vo
	 * @return LogOperationVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/addLogOperation")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	LogOperationVO addLogOperation(@FormParam("LogOperationVO") LogOperationVO vo);
	
	/**
	 * <pre>
	 * update LogOperation.
	 * </pre>
	 * @param vo
	 * @return LogOperationVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/updateLogOperation")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	LogOperationVO updateLogOperation(@FormParam("LogOperationVO") LogOperationVO vo);

	/**
	 * <pre>
	 * remove LogOperation.
	 * </pre>
	 * @param vo conditions.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeLogOperation")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeLogOperation(@FormParam("LogOperationVO") LogOperationVO vo);
	
	/**
	 * <pre>
	 * remove LogOperation.
	 * </pre>
	 * @param id.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeLogOperationById/{id}")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeLogOperationById(@PathParam("id") String id);
	
	/**
	 * <pre>
	 * remove LogOperation.
	 * </pre>
	 * @param ids.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeLogOperationByIds")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeLogOperationByIds(@FormParam("ids") String[] ids);
	
	
	
	
}
