/*******************************************************************************
 * Copyright (c) Oct 16, 2017 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation
 ******************************************************************************/
package com.foreveross.extension.query.application.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.iff.infra.util.MapHelper;
import org.iff.infra.util.mybatis.plugin.Page;
import org.iff.infra.util.mybatis.service.Dao;
import org.iff.infra.util.mybatis.service.ExDao;
import org.iff.infra.util.mybatis.service.RepositoryService;

import com.foreveross.extension.query.application.SystemQueryApplication;
import com.foreveross.qdp.application.system.common.SysQueryApplication;
import com.foreveross.qdp.infra.vo.system.common.SysQueryVO;

/**
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since Oct 16, 2017
 */
@Named("systemQueryApplication")
public class SystemQueryApplicationImpl implements SystemQueryApplication {

	@Inject
	SysQueryApplication sysQueryApplication;

	@Inject
	@Named("tcSqlService")
	RepositoryService tcSqlService;

	ExDao dao = null;

	public ExDao getDao() {
		if (dao == null) {
			dao = ExDao.get(tcSqlService);
		}
		return dao;
	}

	public Page query(SysQueryVO vo, Object condition, Page page) {
		if (vo == null) {
			return Page.notNullPage(null);
		}
		if (StringUtils.isNotBlank(vo.getId())) {
			vo = sysQueryApplication.getSysQueryById(vo.getId());
		} else if (StringUtils.isNotBlank(vo.getName())) {
			vo = sysQueryApplication.getByName(vo.getName());
		}
		if (vo == null) {
			return Page.notNullPage(null);
		}
		return getDao().queryPage(vo.getQueryContent(),
				MapHelper.toMap("vo", condition, "page", Page.notNullPage(page)));
	}
}
