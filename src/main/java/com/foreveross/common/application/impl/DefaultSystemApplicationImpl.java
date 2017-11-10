/*******************************************************************************
 * Copyright (c) Aug 28, 2017 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation
 ******************************************************************************/
package com.foreveross.common.application.impl;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.iff.infra.util.Assert;
import org.iff.infra.util.I18nHelper;
import org.iff.infra.util.MD5Helper;
import org.iff.infra.util.CacheHelper.CacheCallback;
import org.iff.infra.util.mybatis.plugin.Page;

import com.foreveross.common.application.SystemApplication;
import com.foreveross.common.shiro.ShiroUser;
import com.foreveross.qdp.application.system.auth.AuthAccountApplication;
import com.foreveross.qdp.application.system.common.SysI18nApplication;
import com.foreveross.qdp.infra.vo.system.auth.AuthAccountVO;
import com.foreveross.qdp.infra.vo.system.common.SysI18nVO;

/**
 * 系统初始化及登录
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since Aug 28, 2017
 */
@Named("defaultSystemApplication")
public class DefaultSystemApplicationImpl implements SystemApplication {

	@Inject
	AuthAccountApplication authAccountApplication;
	@Inject
	SysI18nApplication sysI18nApplication;

	public int initI18n() {
		Page<?> page = sysI18nApplication.pageFindSysI18n(null, Page.offsetPage(0, 10000, null));
		Map<String, String> map = new HashMap<String, String>();
		for (Object obj : page.getRows()) {
			SysI18nVO vo = (SysI18nVO) obj;
			map.put(vo.getMessageKey(), vo.getMessageContent());
		}
		I18nHelper.addMessages(map);
		return page.getRows().size();
	}

	public ShiroUser login(ShiroUser user) {
		Assert.notNull(user);
		Assert.notBlank(user.getLoginId());
		Assert.notBlank(user.getLoginPasswd());
		AuthAccountVO account = authAccountApplication.getByLoginEmail(user.getLoginId());
		if (account == null) {
			return null;
		}
		if (StringUtils.equalsIgnoreCase(account.getLoginPasswd(),
				MD5Helper.secondSalt(MD5Helper.firstSalt(user.getLoginPasswd())))) {
			user = authAccountVO2ShiroUser(account);
			return user;
		}
		return null;
	}

	public ShiroUser getShiroUserByLoginId(final String loginId) {
		if (StringUtils.isBlank(loginId)) {
			return null;
		}
		return CacheCallback.process("SystemApplication.getShiroUserByLoginId-" + loginId, 5 * 60/*缓存5分钟*/, 0,
				new CacheCallback<ShiroUser>() {
					public ShiroUser call() {
						AuthAccountVO account = authAccountApplication.getByLoginEmail(loginId);
						ShiroUser user = authAccountVO2ShiroUser(account);
						return user;
					}
				});
	}

	ShiroUser authAccountVO2ShiroUser(AuthAccountVO account) {
		if (account == null) {
			return null;
		}
		ShiroUser user = new ShiroUser();
		{
			user.setCreateTime(account.getCreateTime());
			user.setDescription(account.getDescription());
			user.setId(account.getId());
			user.setLoginId(account.getLoginEmail());
			user.setLoginPasswd(account.getLoginPasswd());
			user.setStatus(account.getStatus());
			user.setType(account.getType());
			user.setUpdateTime(account.getUpdateTime());
			user.setUserId(account.getUserId());
			user.setUserIdName(account.getUserIdName());
			user.setLoginTryTimes(account.getLoginTryTimes());
			user.setLastLogin(account.getLastLogin());
		}
		return user;
	}

	AuthAccountVO shiroUser2AuthAccountVO(ShiroUser user) {
		if (user == null) {
			return null;
		}
		AuthAccountVO account = new AuthAccountVO();
		{
			account.setCreateTime(user.getCreateTime());
			account.setDescription(user.getDescription());
			account.setId(user.getId());
			account.setLoginEmail(user.getLoginId());
			account.setStatus(user.getStatus());
			account.setType(user.getType());
			account.setUpdateTime(user.getUpdateTime());
			account.setUserId(user.getUserId());
			account.setUserIdName(account.getUserIdName());
		}
		return account;
	}

}
