/*******************************************************************************
 * Copyright (c) 2017-10-17 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
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

import com.foreveross.qdp.application.system.common.rs.SysI18nRsApplication;
import com.foreveross.qdp.application.system.common.SysI18nApplication;
import com.foreveross.qdp.infra.vo.system.common.SysI18nVO;
import com.foreveross.qdp.domain.system.common.SysI18n;

/**
 * SysI18n
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2017-10-17
 * @version 1.0.0
 * auto generate by qdp v3.0.
 */
@Named("sysI18nRsApplication")
public class SysI18nRsApplicationImpl implements SysI18nRsApplication {

	@Inject
	SysI18nApplication sysI18nApplication;

	/**
	 * <pre>
	 * get SysI18nVO by id.
	 * </pre>
	 * @param vo
	 * @return SysI18nVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysI18nApplication#getSysI18n(SysI18nVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public SysI18nVO getSysI18n(SysI18nVO vo) {
		return sysI18nApplication.getSysI18n(vo);
	}

	/**
	 * <pre>
	 * get SysI18nVO by id.
	 * </pre>
	 * @param vo
	 * @return SysI18nVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysI18nApplication#getSysI18nById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public SysI18nVO getSysI18nById(String id){
		return sysI18nApplication.getSysI18nById(id);
	}
	
	/**
	 * <pre>
	 * page find SysI18nVO.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysI18nApplication#pageFindSysI18n(SysI18nVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindSysI18n(SysI18nVO vo, Page page) {
		return sysI18nApplication.pageFindSysI18n(vo, page);
	}
	
	/**
	 * <pre>
	 * page find SysI18nVO Map.
	 * </pre>
	 * @param vo conditions
	 * @param page page setting
	 * @return Page
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysI18nApplication#pageFindSysI18nMap(SysI18nVO, Page)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public Page pageFindSysI18nMap(SysI18nVO vo, Page page) {
		return sysI18nApplication.pageFindSysI18nMap(vo, page);
	}

	/**
	 * <pre>
	 * add SysI18n.
	 * </pre>
	 * @param vo
	 * @return SysI18nVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysI18nApplication#addSysI18n(SysI18nVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public SysI18nVO addSysI18n(SysI18nVO vo) {
		return sysI18nApplication.addSysI18n(vo);
	}

	/**
	 * <pre>
	 * update SysI18n.
	 * </pre>
	 * @param vo
	 * @return SysI18nVO
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysI18nApplication#updateSysI18n(SysI18nVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public SysI18nVO updateSysI18n(SysI18nVO vo) {
		return sysI18nApplication.updateSysI18n(vo);
	}
	
	/**
	 * <pre>
	 * remove SysI18n.
	 * </pre>
	 * @param vo conditions.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysI18nApplication#removeSysI18n(SysI18nVO)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public void removeSysI18n(SysI18nVO vo) {
		sysI18nApplication.removeSysI18n(vo);
	}

	/**
	 * <pre>
	 * remove SysI18n.
	 * </pre>
	 * @param id.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysI18nApplication#removeSysI18nById(String)
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public void removeSysI18nById(String id) {
		sysI18nApplication.removeSysI18nById(id);
	}
	
	/**
	 * <pre>
	 * remove SysI18n.
	 * </pre>
	 * @param ids.
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.ws.SysI18nApplication#removeSysI18nByIds(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 * auto generate by qdp v3.0.
	 */
	public void removeSysI18nByIds(String[] ids) {
		sysI18nApplication.removeSysI18nByIds(ids);
	}
	
	
	/**
	 * <pre>
	 * get SysI18n by unique messageKey
	 * </pre>
	 * (non-Javadoc)
	 * @see com.foreveross.qdp.application.system.common.SysI18nApplication#getByMessageKey(String[])
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since 2017-10-17
	 */
	public SysI18nVO getByMessageKey(String messageKey) {
		return sysI18nApplication.getByMessageKey(messageKey);
	}
	
	
	
}
