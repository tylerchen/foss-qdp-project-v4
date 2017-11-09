/*******************************************************************************
 * Copyright (c) 2017-11-09 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation.
 * Auto Generate By foreveross.com Quick Deliver Platform. 
 ******************************************************************************/
package com.foreveross.qdp.application.system.common.rs.impl;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.iff.infra.util.BeanHelper;
import org.iff.infra.util.MapHelper;
import org.iff.infra.util.mybatis.plugin.Page;
import org.iff.infra.util.mybatis.service.Dao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import com.foreveross.qdp.application.system.common.rs.SysScriptRsApplication;
import com.foreveross.qdp.application.system.common.SysScriptApplication;
import com.foreveross.qdp.infra.vo.system.common.SysScriptVO;
import com.foreveross.qdp.domain.system.common.SysScript;

/**
 * SysScript
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2017-11-09
 * @version 1.0.0
 * auto generate by qdp v3.0.
 */
@Named("sysScriptRsApplication")
public class SysScriptRsApplicationImpl implements SysScriptRsApplication {

	@Inject
	SysScriptApplication sysScriptApplication;

	/**
	 * <pre>
	 * get SysScriptVO by id.
	 * </pre>
	 * @param vo
	 * @return SysScriptVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysScriptApplication#getSysScript(SysScriptVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public SysScriptVO getSysScript(SysScriptVO vo) {
		return sysScriptApplication.getSysScript(vo);
	}

	/**
	 * <pre>
	 * get SysScriptVO by id.
	 * </pre>
	 * @param vo
	 * @return SysScriptVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysScriptApplication#getSysScriptById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public SysScriptVO getSysScriptById(String id){
		return sysScriptApplication.getSysScriptById(id);
	}
	
	/**
	 * <pre>
	 * page find SysScriptVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysScriptApplication#pageFindSysScript(SysScriptVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindSysScript(SysScriptVO vo, Page page) {
		return sysScriptApplication.pageFindSysScript(vo, page);
	}
	
	/**
	 * <pre>
	 * page find SysScriptVO Map.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysScriptApplication#pageFindSysScriptMap(SysScriptVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindSysScriptMap(SysScriptVO vo, Page page) {
		return sysScriptApplication.pageFindSysScriptMap(vo, page);
	}

	/**
	 * <pre>
	 * add SysScript.
	 * </pre>
	 * @param vo
	 * @return SysScriptVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysScriptApplication#addSysScript(SysScriptVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public SysScriptVO addSysScript(SysScriptVO vo) {
		return sysScriptApplication.addSysScript(vo);
	}

	/**
	 * <pre>
	 * update SysScript.
	 * </pre>
	 * @param vo
	 * @return SysScriptVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysScriptApplication#updateSysScript(SysScriptVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public SysScriptVO updateSysScript(SysScriptVO vo) {
		return sysScriptApplication.updateSysScript(vo);
	}
	
	/**
	 * <pre>
	 * remove SysScript.
	 * </pre>
	 * @param vo conditions.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysScriptApplication#removeSysScript(SysScriptVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeSysScript(SysScriptVO vo) {
		sysScriptApplication.removeSysScript(vo);
	}

	/**
	 * <pre>
	 * remove SysScript.
	 * </pre>
	 * @param id.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysScriptApplication#removeSysScriptById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeSysScriptById(String id) {
		sysScriptApplication.removeSysScriptById(id);
	}
	
	/**
	 * <pre>
	 * remove SysScript.
	 * </pre>
	 * @param ids.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysScriptApplication#removeSysScriptByIds(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeSysScriptByIds(String[] ids) {
		sysScriptApplication.removeSysScriptByIds(ids);
	}
	
	
	/**
	 * <pre>
	 * get SysScript by unique name
	 * </pre>
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.SysScriptApplication#getByName(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 */
	public SysScriptVO getByName(String name) {
		return sysScriptApplication.getByName(name);
	}
	
	/**
	 * <pre>
	 * get SysScript by unique code
	 * </pre>
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.SysScriptApplication#getByCode(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 */
	public SysScriptVO getByCode(String code) {
		return sysScriptApplication.getByCode(code);
	}
	
	
	
}
