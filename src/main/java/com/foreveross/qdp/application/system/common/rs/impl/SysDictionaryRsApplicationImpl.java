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

import com.foreveross.qdp.application.system.common.rs.SysDictionaryRsApplication;
import com.foreveross.qdp.application.system.common.SysDictionaryApplication;
import com.foreveross.qdp.infra.vo.system.common.SysDictionaryVO;
import com.foreveross.qdp.domain.system.common.SysDictionary;

/**
 * SysDictionary
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2017-11-09
 * @version 1.0.0
 * auto generate by qdp v3.0.
 */
@Named("sysDictionaryRsApplication")
public class SysDictionaryRsApplicationImpl implements SysDictionaryRsApplication {

	@Inject
	SysDictionaryApplication sysDictionaryApplication;

	/**
	 * <pre>
	 * get SysDictionaryVO by id.
	 * </pre>
	 * @param vo
	 * @return SysDictionaryVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysDictionaryApplication#getSysDictionary(SysDictionaryVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public SysDictionaryVO getSysDictionary(SysDictionaryVO vo) {
		return sysDictionaryApplication.getSysDictionary(vo);
	}

	/**
	 * <pre>
	 * get SysDictionaryVO by id.
	 * </pre>
	 * @param vo
	 * @return SysDictionaryVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysDictionaryApplication#getSysDictionaryById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public SysDictionaryVO getSysDictionaryById(String id){
		return sysDictionaryApplication.getSysDictionaryById(id);
	}
	
	/**
	 * <pre>
	 * page find SysDictionaryVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysDictionaryApplication#pageFindSysDictionary(SysDictionaryVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindSysDictionary(SysDictionaryVO vo, Page page) {
		return sysDictionaryApplication.pageFindSysDictionary(vo, page);
	}
	
	/**
	 * <pre>
	 * page find SysDictionaryVO Map.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysDictionaryApplication#pageFindSysDictionaryMap(SysDictionaryVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindSysDictionaryMap(SysDictionaryVO vo, Page page) {
		return sysDictionaryApplication.pageFindSysDictionaryMap(vo, page);
	}

	/**
	 * <pre>
	 * add SysDictionary.
	 * </pre>
	 * @param vo
	 * @return SysDictionaryVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysDictionaryApplication#addSysDictionary(SysDictionaryVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public SysDictionaryVO addSysDictionary(SysDictionaryVO vo) {
		return sysDictionaryApplication.addSysDictionary(vo);
	}

	/**
	 * <pre>
	 * update SysDictionary.
	 * </pre>
	 * @param vo
	 * @return SysDictionaryVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysDictionaryApplication#updateSysDictionary(SysDictionaryVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public SysDictionaryVO updateSysDictionary(SysDictionaryVO vo) {
		return sysDictionaryApplication.updateSysDictionary(vo);
	}
	
	/**
	 * <pre>
	 * remove SysDictionary.
	 * </pre>
	 * @param vo conditions.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysDictionaryApplication#removeSysDictionary(SysDictionaryVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeSysDictionary(SysDictionaryVO vo) {
		sysDictionaryApplication.removeSysDictionary(vo);
	}

	/**
	 * <pre>
	 * remove SysDictionary.
	 * </pre>
	 * @param id.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysDictionaryApplication#removeSysDictionaryById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeSysDictionaryById(String id) {
		sysDictionaryApplication.removeSysDictionaryById(id);
	}
	
	/**
	 * <pre>
	 * remove SysDictionary.
	 * </pre>
	 * @param ids.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysDictionaryApplication#removeSysDictionaryByIds(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-11-09
	 * auto generate by qdp v3.0.
	 */
	public void removeSysDictionaryByIds(String[] ids) {
		sysDictionaryApplication.removeSysDictionaryByIds(ids);
	}
	
	
	
	
}
