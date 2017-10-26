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
import com.foreveross.qdp.infra.vo.system.common.SysOpenreportVO;

/**
 * SysOpenreport Application.
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2017-10-17
 * @version 1.0.0
 * auto generate by qdp v3.0.
 */
@Path("sysOpenreportRsApplication")
@Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.MULTIPART_FORM_DATA })
public interface SysOpenreportRsApplication {

	/**
	 * <pre>
	 * get SysOpenreportVO by id.
	 * </pre>
	 * @param vo
	 * @return SysOpenreportVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/getSysOpenreport")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	SysOpenreportVO getSysOpenreport(@FormParam("SysOpenreportVO") SysOpenreportVO vo);

	/**
	 * <pre>
	 * get SysOpenreportVO by id.
	 * </pre>
	 * @param vo
	 * @return SysOpenreportVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@GET
	@Path("/getSysOpenreportById/{id}")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	SysOpenreportVO getSysOpenreportById(@PathParam("id") String id);
	
	/**
	 * <pre>
	 * page find SysOpenreportVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/pageFindSysOpenreport")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	Page pageFindSysOpenreport(@FormParam("SysOpenreportVO") SysOpenreportVO vo, @FormParam("Page") Page page);
	
	/**
	 * <pre>
	 * page find SysOpenreportVO Map.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/pageFindSysOpenreportMap")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	Page pageFindSysOpenreportMap(@FormParam("SysOpenreportVO") SysOpenreportVO vo, @FormParam("Page") Page page);

	/**
	 * <pre>
	 * add SysOpenreport.
	 * </pre>
	 * @param vo
	 * @return SysOpenreportVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/addSysOpenreport")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	SysOpenreportVO addSysOpenreport(@FormParam("SysOpenreportVO") SysOpenreportVO vo);
	
	/**
	 * <pre>
	 * update SysOpenreport.
	 * </pre>
	 * @param vo
	 * @return SysOpenreportVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/updateSysOpenreport")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	SysOpenreportVO updateSysOpenreport(@FormParam("SysOpenreportVO") SysOpenreportVO vo);

	/**
	 * <pre>
	 * remove SysOpenreport.
	 * </pre>
	 * @param vo conditions.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeSysOpenreport")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeSysOpenreport(@FormParam("SysOpenreportVO") SysOpenreportVO vo);
	
	/**
	 * <pre>
	 * remove SysOpenreport.
	 * </pre>
	 * @param id.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeSysOpenreportById/{id}")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeSysOpenreportById(@PathParam("id") String id);
	
	/**
	 * <pre>
	 * remove SysOpenreport.
	 * </pre>
	 * @param ids.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeSysOpenreportByIds")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeSysOpenreportByIds(@FormParam("ids") String[] ids);
	
	
	/**
	 * <pre>
	 * get SysOpenreport by unique name
	 * Usage : SysOpenreport.getByName(name)
	 * </pre>
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 */
	@POST
	@Path("/getByName")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	SysOpenreportVO getByName(String name);
	
	
	
}
