/*******************************************************************************
 * Copyright (c) 2017-11-09 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation.
 * Auto Generate By foreveross.com Quick Deliver Platform. 
 ******************************************************************************/
package com.foreveross.qdp.application.system.log.rs.impl;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.iff.infra.util.BeanHelper;
import org.iff.infra.util.MapHelper;
import org.iff.infra.util.mybatis.plugin.Page;
import org.iff.infra.util.mybatis.service.Dao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import com.foreveross.qdp.application.system.log.rs.LogAccessRsApplication;
import com.foreveross.qdp.application.system.log.LogAccessApplication;
import com.foreveross.qdp.infra.vo.system.log.LogAccessVO;
import com.foreveross.qdp.domain.system.log.LogAccess;

/**
 * LogAccess
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2017-11-09
 * @version 1.0.0
 * auto generate by qdp v3.0.
 */
@Named("logAccessRsApplication")
public class LogAccessRsApplicationImpl implements LogAccessRsApplication {

	@Inject
	LogAccessApplication logAccessApplication;

	/**
	 * <pre>
	 * get LogAccessVO by id.
	 * </pre>
	 * @param vo
	 * @return LogAccessVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.log.ws.LogAccessApplication#getLogAccess(LogAccessVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public LogAccessVO getLogAccess(LogAccessVO vo) {
		return logAccessApplication.getLogAccess(vo);
	}

	/**
	 * <pre>
	 * get LogAccessVO by id.
	 * </pre>
	 * @param vo
	 * @return LogAccessVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.log.ws.LogAccessApplication#getLogAccessById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public LogAccessVO getLogAccessById(String id){
		return logAccessApplication.getLogAccessById(id);
	}
	
	/**
	 * <pre>
	 * page find LogAccessVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.log.ws.LogAccessApplication#pageFindLogAccess(LogAccessVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindLogAccess(LogAccessVO vo, Page page) {
		return logAccessApplication.pageFindLogAccess(vo, page);
	}
	
	/**
	 * <pre>
	 * page find LogAccessVO Map.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.log.ws.LogAccessApplication#pageFindLogAccessMap(LogAccessVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindLogAccessMap(LogAccessVO vo, Page page) {
		return logAccessApplication.pageFindLogAccessMap(vo, page);
	}

	/**
	 * <pre>
	 * add LogAccess.
	 * </pre>
	 * @param vo
	 * @return LogAccessVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.log.ws.LogAccessApplication#addLogAccess(LogAccessVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public LogAccessVO addLogAccess(LogAccessVO vo) {
		return logAccessApplication.addLogAccess(vo);
	}

	/**
	 * <pre>
	 * update LogAccess.
	 * </pre>
	 * @param vo
	 * @return LogAccessVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.log.ws.LogAccessApplication#updateLogAccess(LogAccessVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public LogAccessVO updateLogAccess(LogAccessVO vo) {
		return logAccessApplication.updateLogAccess(vo);
	}
	
	/**
	 * <pre>
	 * remove LogAccess.
	 * </pre>
	 * @param vo conditions.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.log.ws.LogAccessApplication#removeLogAccess(LogAccessVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeLogAccess(LogAccessVO vo) {
		logAccessApplication.removeLogAccess(vo);
	}

	/**
	 * <pre>
	 * remove LogAccess.
	 * </pre>
	 * @param id.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.log.ws.LogAccessApplication#removeLogAccessById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeLogAccessById(String id) {
		logAccessApplication.removeLogAccessById(id);
	}
	
	/**
	 * <pre>
	 * remove LogAccess.
	 * </pre>
	 * @param ids.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.log.ws.LogAccessApplication#removeLogAccessByIds(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeLogAccessByIds(String[] ids) {
		logAccessApplication.removeLogAccessByIds(ids);
	}
	
	
	
	
}
