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

import com.foreveross.qdp.application.system.common.rs.SysOpenreportRsApplication;
import com.foreveross.qdp.application.system.common.SysOpenreportApplication;
import com.foreveross.qdp.infra.vo.system.common.SysOpenreportVO;
import com.foreveross.qdp.domain.system.common.SysOpenreport;

/**
 * SysOpenreport
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2017-11-09
 * @version 1.0.0
 * auto generate by qdp v3.0.
 */
@Named("sysOpenreportRsApplication")
public class SysOpenreportRsApplicationImpl implements SysOpenreportRsApplication {

	@Inject
	SysOpenreportApplication sysOpenreportApplication;

	/**
	 * <pre>
	 * get SysOpenreportVO by id.
	 * </pre>
	 * @param vo
	 * @return SysOpenreportVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysOpenreportApplication#getSysOpenreport(SysOpenreportVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public SysOpenreportVO getSysOpenreport(SysOpenreportVO vo) {
		return sysOpenreportApplication.getSysOpenreport(vo);
	}

	/**
	 * <pre>
	 * get SysOpenreportVO by id.
	 * </pre>
	 * @param vo
	 * @return SysOpenreportVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysOpenreportApplication#getSysOpenreportById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public SysOpenreportVO getSysOpenreportById(String id){
		return sysOpenreportApplication.getSysOpenreportById(id);
	}
	
	/**
	 * <pre>
	 * page find SysOpenreportVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysOpenreportApplication#pageFindSysOpenreport(SysOpenreportVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindSysOpenreport(SysOpenreportVO vo, Page page) {
		return sysOpenreportApplication.pageFindSysOpenreport(vo, page);
	}
	
	/**
	 * <pre>
	 * page find SysOpenreportVO Map.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysOpenreportApplication#pageFindSysOpenreportMap(SysOpenreportVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindSysOpenreportMap(SysOpenreportVO vo, Page page) {
		return sysOpenreportApplication.pageFindSysOpenreportMap(vo, page);
	}

	/**
	 * <pre>
	 * add SysOpenreport.
	 * </pre>
	 * @param vo
	 * @return SysOpenreportVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysOpenreportApplication#addSysOpenreport(SysOpenreportVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public SysOpenreportVO addSysOpenreport(SysOpenreportVO vo) {
		return sysOpenreportApplication.addSysOpenreport(vo);
	}

	/**
	 * <pre>
	 * update SysOpenreport.
	 * </pre>
	 * @param vo
	 * @return SysOpenreportVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysOpenreportApplication#updateSysOpenreport(SysOpenreportVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public SysOpenreportVO updateSysOpenreport(SysOpenreportVO vo) {
		return sysOpenreportApplication.updateSysOpenreport(vo);
	}
	
	/**
	 * <pre>
	 * remove SysOpenreport.
	 * </pre>
	 * @param vo conditions.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysOpenreportApplication#removeSysOpenreport(SysOpenreportVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeSysOpenreport(SysOpenreportVO vo) {
		sysOpenreportApplication.removeSysOpenreport(vo);
	}

	/**
	 * <pre>
	 * remove SysOpenreport.
	 * </pre>
	 * @param id.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysOpenreportApplication#removeSysOpenreportById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeSysOpenreportById(String id) {
		sysOpenreportApplication.removeSysOpenreportById(id);
	}
	
	/**
	 * <pre>
	 * remove SysOpenreport.
	 * </pre>
	 * @param ids.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysOpenreportApplication#removeSysOpenreportByIds(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeSysOpenreportByIds(String[] ids) {
		sysOpenreportApplication.removeSysOpenreportByIds(ids);
	}
	
	
	/**
	 * <pre>
	 * get SysOpenreport by unique name
	 * </pre>
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.SysOpenreportApplication#getByName(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 */
	public SysOpenreportVO getByName(String name) {
		return sysOpenreportApplication.getByName(name);
	}
	
	
	
}
