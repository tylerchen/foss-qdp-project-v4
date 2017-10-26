/*******************************************************************************
 * Copyright (c) 2017-10-17 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
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

import com.foreveross.qdp.application.system.log.rs.LogOperationRsApplication;
import com.foreveross.qdp.application.system.log.LogOperationApplication;
import com.foreveross.qdp.infra.vo.system.log.LogOperationVO;
import com.foreveross.qdp.domain.system.log.LogOperation;

/**
 * LogOperation
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2017-10-17
 * @version 1.0.0
 * auto generate by qdp v3.0.
 */
@Named("logOperationRsApplication")
public class LogOperationRsApplicationImpl implements LogOperationRsApplication {

	@Inject
	LogOperationApplication logOperationApplication;

	/**
	 * <pre>
	 * get LogOperationVO by id.
	 * </pre>
	 * @param vo
	 * @return LogOperationVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.log.ws.LogOperationApplication#getLogOperation(LogOperationVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public LogOperationVO getLogOperation(LogOperationVO vo) {
		return logOperationApplication.getLogOperation(vo);
	}

	/**
	 * <pre>
	 * get LogOperationVO by id.
	 * </pre>
	 * @param vo
	 * @return LogOperationVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.log.ws.LogOperationApplication#getLogOperationById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public LogOperationVO getLogOperationById(String id){
		return logOperationApplication.getLogOperationById(id);
	}
	
	/**
	 * <pre>
	 * page find LogOperationVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.log.ws.LogOperationApplication#pageFindLogOperation(LogOperationVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindLogOperation(LogOperationVO vo, Page page) {
		return logOperationApplication.pageFindLogOperation(vo, page);
	}
	
	/**
	 * <pre>
	 * page find LogOperationVO Map.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.log.ws.LogOperationApplication#pageFindLogOperationMap(LogOperationVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindLogOperationMap(LogOperationVO vo, Page page) {
		return logOperationApplication.pageFindLogOperationMap(vo, page);
	}

	/**
	 * <pre>
	 * add LogOperation.
	 * </pre>
	 * @param vo
	 * @return LogOperationVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.log.ws.LogOperationApplication#addLogOperation(LogOperationVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public LogOperationVO addLogOperation(LogOperationVO vo) {
		return logOperationApplication.addLogOperation(vo);
	}

	/**
	 * <pre>
	 * update LogOperation.
	 * </pre>
	 * @param vo
	 * @return LogOperationVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.log.ws.LogOperationApplication#updateLogOperation(LogOperationVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public LogOperationVO updateLogOperation(LogOperationVO vo) {
		return logOperationApplication.updateLogOperation(vo);
	}
	
	/**
	 * <pre>
	 * remove LogOperation.
	 * </pre>
	 * @param vo conditions.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.log.ws.LogOperationApplication#removeLogOperation(LogOperationVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public void removeLogOperation(LogOperationVO vo) {
		logOperationApplication.removeLogOperation(vo);
	}

	/**
	 * <pre>
	 * remove LogOperation.
	 * </pre>
	 * @param id.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.log.ws.LogOperationApplication#removeLogOperationById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public void removeLogOperationById(String id) {
		logOperationApplication.removeLogOperationById(id);
	}
	
	/**
	 * <pre>
	 * remove LogOperation.
	 * </pre>
	 * @param ids.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.log.ws.LogOperationApplication#removeLogOperationByIds(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public void removeLogOperationByIds(String[] ids) {
		logOperationApplication.removeLogOperationByIds(ids);
	}
	
	
	
	
}
