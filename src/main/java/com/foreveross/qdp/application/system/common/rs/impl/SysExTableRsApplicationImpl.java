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

import com.foreveross.qdp.application.system.common.rs.SysExTableRsApplication;
import com.foreveross.qdp.application.system.common.SysExTableApplication;
import com.foreveross.qdp.infra.vo.system.common.SysExTableVO;
import com.foreveross.qdp.domain.system.common.SysExTable;

/**
 * SysExTable
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2017-11-09
 * @version 1.0.0
 * auto generate by qdp v3.0.
 */
@Named("sysExTableRsApplication")
public class SysExTableRsApplicationImpl implements SysExTableRsApplication {

	@Inject
	SysExTableApplication sysExTableApplication;

	/**
	 * <pre>
	 * get SysExTableVO by id.
	 * </pre>
	 * @param vo
	 * @return SysExTableVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysExTableApplication#getSysExTable(SysExTableVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public SysExTableVO getSysExTable(SysExTableVO vo) {
		return sysExTableApplication.getSysExTable(vo);
	}

	/**
	 * <pre>
	 * get SysExTableVO by id.
	 * </pre>
	 * @param vo
	 * @return SysExTableVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysExTableApplication#getSysExTableById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public SysExTableVO getSysExTableById(String id){
		return sysExTableApplication.getSysExTableById(id);
	}
	
	/**
	 * <pre>
	 * page find SysExTableVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysExTableApplication#pageFindSysExTable(SysExTableVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindSysExTable(SysExTableVO vo, Page page) {
		return sysExTableApplication.pageFindSysExTable(vo, page);
	}
	
	/**
	 * <pre>
	 * page find SysExTableVO Map.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysExTableApplication#pageFindSysExTableMap(SysExTableVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindSysExTableMap(SysExTableVO vo, Page page) {
		return sysExTableApplication.pageFindSysExTableMap(vo, page);
	}

	/**
	 * <pre>
	 * add SysExTable.
	 * </pre>
	 * @param vo
	 * @return SysExTableVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysExTableApplication#addSysExTable(SysExTableVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public SysExTableVO addSysExTable(SysExTableVO vo) {
		return sysExTableApplication.addSysExTable(vo);
	}

	/**
	 * <pre>
	 * update SysExTable.
	 * </pre>
	 * @param vo
	 * @return SysExTableVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysExTableApplication#updateSysExTable(SysExTableVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public SysExTableVO updateSysExTable(SysExTableVO vo) {
		return sysExTableApplication.updateSysExTable(vo);
	}
	
	/**
	 * <pre>
	 * remove SysExTable.
	 * </pre>
	 * @param vo conditions.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysExTableApplication#removeSysExTable(SysExTableVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeSysExTable(SysExTableVO vo) {
		sysExTableApplication.removeSysExTable(vo);
	}

	/**
	 * <pre>
	 * remove SysExTable.
	 * </pre>
	 * @param id.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysExTableApplication#removeSysExTableById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeSysExTableById(String id) {
		sysExTableApplication.removeSysExTableById(id);
	}
	
	/**
	 * <pre>
	 * remove SysExTable.
	 * </pre>
	 * @param ids.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysExTableApplication#removeSysExTableByIds(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeSysExTableByIds(String[] ids) {
		sysExTableApplication.removeSysExTableByIds(ids);
	}
	
	
	
	
}
