/*******************************************************************************
 * Copyright (c) Aug 28, 2017 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation
 ******************************************************************************/
package com.foreveross.extension.mvel.application.impl;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.iff.infra.util.Assert;
import org.iff.infra.util.GsonHelper;
import org.iff.infra.util.mybatis.plugin.Page;
import org.mvel2.MVEL;

import com.foreveross.extension.mvel.application.SystemMvelApplication;
import com.foreveross.qdp.application.system.common.SysScriptApplication;
import com.foreveross.qdp.infra.vo.system.common.SysScriptVO;

/**
 * Mvel脚本执行。
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since Aug 28, 2017
 */
@Named("systemMvelApplication")
@SuppressWarnings("rawtypes")
public class SystemMvelApplicationImpl implements SystemMvelApplication {

	@Inject
	SysScriptApplication sysScriptApplication;

	public Object script(SysScriptVO vo, Map<?, ?> condition) {
		Assert.notNull(vo);
		if (StringUtils.isNotBlank(vo.getId())) {
			vo = sysScriptApplication.getSysScriptById(vo.getId());
		} else if (StringUtils.isNotBlank(vo.getCode())) {
			vo = sysScriptApplication.getByCode(vo.getCode());
		} else if (StringUtils.isNotBlank(vo.getName())) {
			vo = sysScriptApplication.getByName(vo.getName());
		}
		Assert.notNull(vo);
		Assert.notBlank(vo.getContent());
		Map params = new HashMap();
		{
			condition = condition == null ? new HashMap() : condition;
			params.putAll(condition);
			if (StringUtils.isNotBlank(vo.getParameter())) {
				Map map = GsonHelper.toJsonMap(vo.getParameter());
				params.putAll(map);
			}
		}
		Object eval = MVEL.eval(vo.getContent(), params);
		if (eval == null) {
			return null;
		}
		if (eval.getClass().getName().startsWith("org.mvel2.")) {
			return null;
		}
		return eval;
	}

}
