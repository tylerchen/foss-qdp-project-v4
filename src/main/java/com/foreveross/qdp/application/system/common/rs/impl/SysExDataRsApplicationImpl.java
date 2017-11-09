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

import com.foreveross.qdp.application.system.common.rs.SysExDataRsApplication;
import com.foreveross.qdp.application.system.common.SysExDataApplication;
import com.foreveross.qdp.infra.vo.system.common.SysExDataVO;
import com.foreveross.qdp.domain.system.common.SysExData;

/**
 * SysExData
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2017-11-09
 * @version 1.0.0
 * auto generate by qdp v3.0.
 */
@Named("sysExDataRsApplication")
public class SysExDataRsApplicationImpl implements SysExDataRsApplication {

	@Inject
	SysExDataApplication sysExDataApplication;

	/**
	 * <pre>
	 * get SysExDataVO by id.
	 * </pre>
	 * @param vo
	 * @return SysExDataVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysExDataApplication#getSysExData(SysExDataVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public SysExDataVO getSysExData(SysExDataVO vo) {
		return sysExDataApplication.getSysExData(vo);
	}

	/**
	 * <pre>
	 * get SysExDataVO by id.
	 * </pre>
	 * @param vo
	 * @return SysExDataVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysExDataApplication#getSysExDataById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public SysExDataVO getSysExDataById(String id){
		return sysExDataApplication.getSysExDataById(id);
	}
	
	/**
	 * <pre>
	 * page find SysExDataVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysExDataApplication#pageFindSysExData(SysExDataVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindSysExData(SysExDataVO vo, Page page) {
		return sysExDataApplication.pageFindSysExData(vo, page);
	}
	
	/**
	 * <pre>
	 * page find SysExDataVO Map.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysExDataApplication#pageFindSysExDataMap(SysExDataVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindSysExDataMap(SysExDataVO vo, Page page) {
		return sysExDataApplication.pageFindSysExDataMap(vo, page);
	}

	/**
	 * <pre>
	 * add SysExData.
	 * </pre>
	 * @param vo
	 * @return SysExDataVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysExDataApplication#addSysExData(SysExDataVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public SysExDataVO addSysExData(SysExDataVO vo) {
		return sysExDataApplication.addSysExData(vo);
	}

	/**
	 * <pre>
	 * update SysExData.
	 * </pre>
	 * @param vo
	 * @return SysExDataVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysExDataApplication#updateSysExData(SysExDataVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public SysExDataVO updateSysExData(SysExDataVO vo) {
		return sysExDataApplication.updateSysExData(vo);
	}
	
	/**
	 * <pre>
	 * remove SysExData.
	 * </pre>
	 * @param vo conditions.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysExDataApplication#removeSysExData(SysExDataVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeSysExData(SysExDataVO vo) {
		sysExDataApplication.removeSysExData(vo);
	}

	/**
	 * <pre>
	 * remove SysExData.
	 * </pre>
	 * @param id.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysExDataApplication#removeSysExDataById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeSysExDataById(String id) {
		sysExDataApplication.removeSysExDataById(id);
	}
	
	/**
	 * <pre>
	 * remove SysExData.
	 * </pre>
	 * @param ids.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysExDataApplication#removeSysExDataByIds(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeSysExDataByIds(String[] ids) {
		sysExDataApplication.removeSysExDataByIds(ids);
	}
	
	
	
	
}
