/*******************************************************************************
 * Copyright (c) 2017-11-09 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
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
import com.foreveross.qdp.infra.vo.system.common.SysExDataVO;

/**
 * SysExData Application.
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2017-11-09
 * @version 1.0.0
 * auto generate by qdp v3.0.
 */
@Path("sysExDataRsApplication")
@Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.MULTIPART_FORM_DATA })
public interface SysExDataRsApplication {

	/**
	 * <pre>
	 * get SysExDataVO by id.
	 * </pre>
	 * @param vo
	 * @return SysExDataVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/getSysExData")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	SysExDataVO getSysExData(@FormParam("SysExDataVO") SysExDataVO vo);

	/**
	 * <pre>
	 * get SysExDataVO by id.
	 * </pre>
	 * @param vo
	 * @return SysExDataVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@GET
	@Path("/getSysExDataById/{id}")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	SysExDataVO getSysExDataById(@PathParam("id") String id);
	
	/**
	 * <pre>
	 * page find SysExDataVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/pageFindSysExData")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	Page pageFindSysExData(@FormParam("SysExDataVO") SysExDataVO vo, @FormParam("Page") Page page);
	
	/**
	 * <pre>
	 * page find SysExDataVO Map.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/pageFindSysExDataMap")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	Page pageFindSysExDataMap(@FormParam("SysExDataVO") SysExDataVO vo, @FormParam("Page") Page page);

	/**
	 * <pre>
	 * add SysExData.
	 * </pre>
	 * @param vo
	 * @return SysExDataVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/addSysExData")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	SysExDataVO addSysExData(@FormParam("SysExDataVO") SysExDataVO vo);
	
	/**
	 * <pre>
	 * update SysExData.
	 * </pre>
	 * @param vo
	 * @return SysExDataVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/updateSysExData")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	SysExDataVO updateSysExData(@FormParam("SysExDataVO") SysExDataVO vo);

	/**
	 * <pre>
	 * remove SysExData.
	 * </pre>
	 * @param vo conditions.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeSysExData")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeSysExData(@FormParam("SysExDataVO") SysExDataVO vo);
	
	/**
	 * <pre>
	 * remove SysExData.
	 * </pre>
	 * @param id.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeSysExDataById/{id}")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeSysExDataById(@PathParam("id") String id);
	
	/**
	 * <pre>
	 * remove SysExData.
	 * </pre>
	 * @param ids.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeSysExDataByIds")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeSysExDataByIds(@FormParam("ids") String[] ids);
	
	
	
	
}
