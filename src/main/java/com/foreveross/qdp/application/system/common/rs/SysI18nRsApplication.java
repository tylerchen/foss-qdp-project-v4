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
import com.foreveross.qdp.infra.vo.system.common.SysI18nVO;

/**
 * SysI18n Application.
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2017-11-09
 * @version 1.0.0
 * auto generate by qdp v3.0.
 */
@Path("sysI18nRsApplication")
@Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.MULTIPART_FORM_DATA })
public interface SysI18nRsApplication {

	/**
	 * <pre>
	 * get SysI18nVO by id.
	 * </pre>
	 * @param vo
	 * @return SysI18nVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/getSysI18n")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	SysI18nVO getSysI18n(@FormParam("SysI18nVO") SysI18nVO vo);

	/**
	 * <pre>
	 * get SysI18nVO by id.
	 * </pre>
	 * @param vo
	 * @return SysI18nVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@GET
	@Path("/getSysI18nById/{id}")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	SysI18nVO getSysI18nById(@PathParam("id") String id);
	
	/**
	 * <pre>
	 * page find SysI18nVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/pageFindSysI18n")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	Page pageFindSysI18n(@FormParam("SysI18nVO") SysI18nVO vo, @FormParam("Page") Page page);
	
	/**
	 * <pre>
	 * page find SysI18nVO Map.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/pageFindSysI18nMap")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	Page pageFindSysI18nMap(@FormParam("SysI18nVO") SysI18nVO vo, @FormParam("Page") Page page);

	/**
	 * <pre>
	 * add SysI18n.
	 * </pre>
	 * @param vo
	 * @return SysI18nVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/addSysI18n")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	SysI18nVO addSysI18n(@FormParam("SysI18nVO") SysI18nVO vo);
	
	/**
	 * <pre>
	 * update SysI18n.
	 * </pre>
	 * @param vo
	 * @return SysI18nVO
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@POST
	@Path("/updateSysI18n")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	SysI18nVO updateSysI18n(@FormParam("SysI18nVO") SysI18nVO vo);

	/**
	 * <pre>
	 * remove SysI18n.
	 * </pre>
	 * @param vo conditions.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeSysI18n")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeSysI18n(@FormParam("SysI18nVO") SysI18nVO vo);
	
	/**
	 * <pre>
	 * remove SysI18n.
	 * </pre>
	 * @param id.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeSysI18nById/{id}")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeSysI18nById(@PathParam("id") String id);
	
	/**
	 * <pre>
	 * remove SysI18n.
	 * </pre>
	 * @param ids.
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	@DELETE
	@Path("/removeSysI18nByIds")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	void removeSysI18nByIds(@FormParam("ids") String[] ids);
	
	
	/**
	 * <pre>
	 * get SysI18n by unique messageKey
	 * Usage : SysI18n.getByMessageKey(messageKey)
	 * </pre>
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 */
	@POST
	@Path("/getByMessageKey")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
	SysI18nVO getByMessageKey(String messageKey);
	
	
	
}
