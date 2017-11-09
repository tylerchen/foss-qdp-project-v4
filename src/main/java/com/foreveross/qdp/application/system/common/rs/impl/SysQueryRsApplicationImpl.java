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

import com.foreveross.qdp.application.system.common.rs.SysQueryRsApplication;
import com.foreveross.qdp.application.system.common.SysQueryApplication;
import com.foreveross.qdp.infra.vo.system.common.SysQueryVO;
import com.foreveross.qdp.domain.system.common.SysQuery;

/**
 * SysQuery
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2017-11-09
 * @version 1.0.0
 * auto generate by qdp v3.0.
 */
@Named("sysQueryRsApplication")
public class SysQueryRsApplicationImpl implements SysQueryRsApplication {

	@Inject
	SysQueryApplication sysQueryApplication;

	/**
	 * <pre>
	 * get SysQueryVO by id.
	 * </pre>
	 * @param vo
	 * @return SysQueryVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysQueryApplication#getSysQuery(SysQueryVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public SysQueryVO getSysQuery(SysQueryVO vo) {
		return sysQueryApplication.getSysQuery(vo);
	}

	/**
	 * <pre>
	 * get SysQueryVO by id.
	 * </pre>
	 * @param vo
	 * @return SysQueryVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysQueryApplication#getSysQueryById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public SysQueryVO getSysQueryById(String id){
		return sysQueryApplication.getSysQueryById(id);
	}
	
	/**
	 * <pre>
	 * page find SysQueryVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysQueryApplication#pageFindSysQuery(SysQueryVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindSysQuery(SysQueryVO vo, Page page) {
		return sysQueryApplication.pageFindSysQuery(vo, page);
	}
	
	/**
	 * <pre>
	 * page find SysQueryVO Map.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysQueryApplication#pageFindSysQueryMap(SysQueryVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindSysQueryMap(SysQueryVO vo, Page page) {
		return sysQueryApplication.pageFindSysQueryMap(vo, page);
	}

	/**
	 * <pre>
	 * add SysQuery.
	 * </pre>
	 * @param vo
	 * @return SysQueryVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysQueryApplication#addSysQuery(SysQueryVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public SysQueryVO addSysQuery(SysQueryVO vo) {
		return sysQueryApplication.addSysQuery(vo);
	}

	/**
	 * <pre>
	 * update SysQuery.
	 * </pre>
	 * @param vo
	 * @return SysQueryVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysQueryApplication#updateSysQuery(SysQueryVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public SysQueryVO updateSysQuery(SysQueryVO vo) {
		return sysQueryApplication.updateSysQuery(vo);
	}
	
	/**
	 * <pre>
	 * remove SysQuery.
	 * </pre>
	 * @param vo conditions.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysQueryApplication#removeSysQuery(SysQueryVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeSysQuery(SysQueryVO vo) {
		sysQueryApplication.removeSysQuery(vo);
	}

	/**
	 * <pre>
	 * remove SysQuery.
	 * </pre>
	 * @param id.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysQueryApplication#removeSysQueryById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeSysQueryById(String id) {
		sysQueryApplication.removeSysQueryById(id);
	}
	
	/**
	 * <pre>
	 * remove SysQuery.
	 * </pre>
	 * @param ids.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysQueryApplication#removeSysQueryByIds(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeSysQueryByIds(String[] ids) {
		sysQueryApplication.removeSysQueryByIds(ids);
	}
	
	
	/**
	 * <pre>
	 * get SysQuery by unique name
	 * </pre>
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.SysQueryApplication#getByName(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 */
	public SysQueryVO getByName(String name) {
		return sysQueryApplication.getByName(name);
	}
	
	/**
	 * <pre>
	 * get SysQuery by unique code
	 * </pre>
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.SysQueryApplication#getByCode(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 */
	public SysQueryVO getByCode(String code) {
		return sysQueryApplication.getByCode(code);
	}
	
	
	
}
