/*******************************************************************************
 * Copyright (c) Aug 28, 2017 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation
 ******************************************************************************/
package com.foreveross.common.application.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.iff.infra.util.CacheHelper.CacheCallback;
import org.iff.infra.util.MapHelper;
import org.iff.infra.util.mybatis.plugin.Page;
import org.iff.infra.util.mybatis.service.Dao;

import com.foreveross.common.application.AuthorizationApplication;

/**
 * 授权
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since Aug 28, 2017
 */
@Named("authorizationApplication")
@SuppressWarnings("unchecked")
public class AuthorizationApplicationImpl implements AuthorizationApplication {

	/**
	 * 30分钟失效
	 */
	private static final int timeToLive = 1800;
	/**
	 * 不失效
	 */
	private static final int timeToIdle = 0;

	public boolean isAdminByAccountId(final String id) {
		if (StringUtils.isBlank(id)) {
			return false;
		}

		return CacheCallback.process("AuthorizationApplication-isAdminByAccountId-" + id + "-" + getSessionId(),
				timeToIdle, timeToLive, new CacheCallback<Boolean>() {
					public Boolean call() {
						Page<?> page = Dao.queryPage("SystemAuth.pageFindAuthRoleByAuthAccountMap",
								MapHelper.toMap(//
										"page", Page.offsetPage(0, 10000, null), //
										"vo", MapHelper.toMap("id", id), //
										"AuthRole", MapHelper.toMap("code", "ADMIN")//
						));
						boolean value = page.getRows().size() > 0;
						return value;
					}

					public void storeKey(String key) {
						storeKeyInSession(key);
					}
				});
	}

	public boolean isAdminByLoginId(final String loginId) {
		if (StringUtils.isBlank(loginId)) {
			return false;
		}
		return CacheCallback.process("AuthorizationApplication-isAdminByLoginId-" + loginId + "-" + getSessionId(),
				timeToIdle, timeToLive, new CacheCallback<Boolean>() {
					public Boolean call() {
						Page<?> page = Dao.queryPage("SystemAuth.pageFindAuthRoleByAuthAccountMap",
								MapHelper.toMap(//
										"page", Page.offsetPage(0, 10000, null), //
										"vo", MapHelper.toMap("loginEmail", loginId), //
										"AuthRole", MapHelper.toMap("code", "ADMIN")//
						));
						boolean value = page.getRows().size() > 0;
						return value;
					}

					public void storeKey(String key) {
						storeKeyInSession(key);
					}
				});
	}

	public Page<?> pageFindAuthResourceByAccountIdMap(final String id) {
		if (StringUtils.isBlank(id)) {
			return Page.offsetPage(0, 0, null);
		}
		return CacheCallback.process(
				"AuthorizationApplication-pageFindAuthResourceByAccountIdMap-" + id + "-" + getSessionId(), timeToIdle,
				timeToLive, new CacheCallback<Page<?>>() {
					public Page<?> call() {
						if (isAdminByAccountId(id)) {
							return Page.offsetPage(0, 10000, Arrays.asList(MapHelper.toMap("code", "*")));
						}
						Page<?> value = Dao.queryPage("SystemAuth.pageFindAuthResourceByAuthAccountMap",
								MapHelper.toMap(//
										"page", Page.offsetPage(0, 10000, null), //
										"vo", MapHelper.toMap("id", id)//
						));
						return value;
					}

					public void storeKey(String key) {
						storeKeyInSession(key);
					}
				});
	}

	public Page<?> pageFindAuthResourceByLoginIdMap(final String loginId) {
		if (StringUtils.isBlank(loginId)) {
			return Page.offsetPage(0, 0, null);
		}
		return CacheCallback.process(
				"AuthorizationApplication-pageFindAuthResourceByLoginIdMap-" + loginId + "-" + getSessionId(),
				timeToIdle, timeToLive, new CacheCallback<Page<?>>() {
					public Page<?> call() {
						if (isAdminByLoginId(loginId)) {
							return Page.offsetPage(0, 10000, Arrays.asList(MapHelper.toMap("code", "*")));
						}
						Page<?> value = Dao.queryPage("SystemAuth.pageFindAuthResourceByAuthAccountMap",
								MapHelper.toMap(//
										"page", Page.offsetPage(0, 10000, null), //
										"vo", MapHelper.toMap("loginEmail", loginId)//
						));
						return value;
					}

					public void storeKey(String key) {
						storeKeyInSession(key);
					}
				});
	}

	public Page<?> pageFindAuthRoleByAccountIdMap(final String id) {
		if (StringUtils.isBlank(id)) {
			return Page.offsetPage(0, 0, null);
		}
		return CacheCallback.process(
				"AuthorizationApplication-pageFindAuthRoleByAccountIdMap-" + id + "-" + getSessionId(), timeToIdle,
				timeToLive, new CacheCallback<Page<?>>() {
					public Page<?> call() {
						Page<?> value = Dao.queryPage("SystemAuth.pageFindAuthRoleByAuthAccountMap",
								MapHelper.toMap(//
										"page", Page.offsetPage(0, 10000, null), //
										"vo", MapHelper.toMap("id", id)//
						));
						return value;
					}

					public void storeKey(String key) {
						storeKeyInSession(key);
					}
				});
	}

	public Page<?> pageFindAuthRoleByLoginIdMap(final String loginId) {
		if (StringUtils.isBlank(loginId)) {
			return Page.offsetPage(0, 0, null);
		}
		return CacheCallback.process(
				"AuthorizationApplication-pageFindAuthRoleByLoginIdMap-" + loginId + "-" + getSessionId(), timeToIdle,
				timeToLive, new CacheCallback<Page<?>>() {
					public Page<?> call() {
						Page<?> value = Dao.queryPage("SystemAuth.pageFindAuthRoleByAuthAccountMap",
								MapHelper.toMap(//
										"page", Page.offsetPage(0, 10000, null), //
										"vo", MapHelper.toMap("loginEmail", loginId)//
						));
						return value;
					}

					public void storeKey(String key) {
						storeKeyInSession(key);
					}
				});
	}

	public Page<?> pageFindAuthOrganizationByAccountIdMap(final String id) {
		if (StringUtils.isBlank(id)) {
			return Page.offsetPage(0, 0, null);
		}
		return CacheCallback.process(
				"AuthorizationApplication-pageFindAuthOrganizationByAccountIdMap-" + id + "-" + getSessionId(),
				timeToIdle, timeToLive, new CacheCallback<Page<?>>() {
					public Page<?> call() {
						Page<?> value = Dao.queryPage("SystemAuth.pageFindAuthOrganizationByAuthAccountMap",
								MapHelper.toMap(//
										"page", Page.offsetPage(0, 10000, null), //
										"vo", MapHelper.toMap("id", id)//
						));
						return value;
					}

					public void storeKey(String key) {
						storeKeyInSession(key);
					}
				});
	}

	public Page<?> pageFindAuthOrganizationByLoginIdMap(final String loginId) {
		if (StringUtils.isBlank(loginId)) {
			return Page.offsetPage(0, 0, null);
		}
		return CacheCallback.process(
				"AuthorizationApplication-pageFindAuthOrganizationByLoginIdMap-" + loginId + "-" + getSessionId(),
				timeToIdle, timeToLive, new CacheCallback<Page<?>>() {
					public Page<?> call() {
						Page<?> value = Dao.queryPage("SystemAuth.pageFindAuthOrganizationByAuthAccountMap",
								MapHelper.toMap(//
										"page", Page.offsetPage(0, 10000, null), //
										"vo", MapHelper.toMap("loginEmail", loginId)//
						));
						return value;
					}

					public void storeKey(String key) {
						storeKeyInSession(key);
					}
				});
	}

	public Page<?> pageFindAuthMenuByAccountIdMap(final String id) {
		if (StringUtils.isBlank(id)) {
			return Page.offsetPage(0, 0, null);
		}
		return CacheCallback.process(
				"AuthorizationApplication-pageFindAuthMenuByAccountIdMap-" + id + "-" + getSessionId(), timeToIdle,
				timeToLive, new CacheCallback<Page<?>>() {
					public Page<?> call() {
						if (isAdminByAccountId(id)) {
							Page<?> value = Dao.queryPage("SystemAuth.pageFindAuthMenuByAdminMap",
									MapHelper.toMap(//
											"page", Page.offsetPage(0, 10000, null), //
											"vo", null//
							));
							return value;
						}
						Page<?> value = Dao.queryPage("SystemAuth.pageFindAuthMenuByAuthAccountMap",
								MapHelper.toMap(//
										"page", Page.offsetPage(0, 10000, null), //
										"vo", MapHelper.toMap("id", id)//
						));
						return value;
					}

					public void storeKey(String key) {
						storeKeyInSession(key);
					}
				});
	}

	public Page<?> pageFindAuthMenuByLoginIdMap(final String loginId) {
		if (StringUtils.isBlank(loginId)) {
			return Page.offsetPage(0, 0, null);
		}
		return CacheCallback.process(
				"AuthorizationApplication-pageFindAuthMenuByLoginIdMap-" + loginId + "-" + getSessionId(), timeToIdle,
				timeToLive, new CacheCallback<Page<?>>() {
					public Page<?> call() {
						if (isAdminByLoginId(loginId)) {
							Page<?> value = Dao.queryPage("SystemAuth.pageFindAuthMenuByAdminMap",
									MapHelper.toMap(//
											"page", Page.offsetPage(0, 10000, null), //
											"vo", null//
							));
							return value;
						}
						Page<?> value = Dao.queryPage("SystemAuth.pageFindAuthMenuByAuthAccountMap",
								MapHelper.toMap(//
										"page", Page.offsetPage(0, 10000, null), //
										"vo", MapHelper.toMap("loginEmail", loginId)//
						));
						return value;
					}

					public void storeKey(String key) {
						storeKeyInSession(key);
					}
				});
	}

	public Set<String> findAuthResourceByAccountId(final String id) {
		return CacheCallback.process(
				"AuthorizationApplication-findAuthResourceByAccountId-" + id + "-" + getSessionId(), timeToIdle,
				timeToLive, new CacheCallback<Set<String>>() {
					public Set<String> call() {
						Page<?> page = pageFindAuthResourceByAccountIdMap(id);
						Set<String> value = new HashSet<String>();
						for (Map<String, Object> resource : (List<Map<String, Object>>) page.getRows()) {
							value.add((String) resource.get("code"));
						}
						return value;
					}

					public void storeKey(String key) {
						storeKeyInSession(key);
					}
				});
	}

	public Set<String> findAuthResourceByLoginId(final String loginId) {
		return CacheCallback.process(
				"AuthorizationApplication-findAuthResourceByLoginId-" + loginId + "-" + getSessionId(), timeToIdle,
				timeToLive, new CacheCallback<Set<String>>() {
					public Set<String> call() {
						Page<?> page = pageFindAuthResourceByLoginIdMap(loginId);
						Set<String> value = new HashSet<String>();
						for (Map<String, Object> resource : (List<Map<String, Object>>) page.getRows()) {
							value.add((String) resource.get("code"));
						}
						return value;
					}

					public void storeKey(String key) {
						storeKeyInSession(key);
					}
				});
	}

	public Set<String> findAuthRoleByAccountId(final String id) {
		return CacheCallback.process("AuthorizationApplication-findAuthRoleByAccountId-" + id + "-" + getSessionId(),
				timeToIdle, timeToLive, new CacheCallback<Set<String>>() {
					public Set<String> call() {
						Page<?> page = pageFindAuthRoleByAccountIdMap(id);
						Set<String> value = new HashSet<String>();
						for (Map<String, Object> resource : (List<Map<String, Object>>) page.getRows()) {
							value.add((String) resource.get("code"));
						}
						return value;
					}

					public void storeKey(String key) {
						storeKeyInSession(key);
					}
				});
	}

	public Set<String> findAuthRoleByLoginId(final String loginId) {
		return CacheCallback.process("AuthorizationApplication-findAuthRoleByLoginId-" + loginId + "-" + getSessionId(),
				timeToIdle, timeToLive, new CacheCallback<Set<String>>() {
					public Set<String> call() {
						Page<?> page = pageFindAuthRoleByLoginIdMap(loginId);
						Set<String> value = new HashSet<String>();
						for (Map<String, Object> resource : (List<Map<String, Object>>) page.getRows()) {
							value.add((String) resource.get("code"));
						}
						return value;
					}

					public void storeKey(String key) {
						storeKeyInSession(key);
					}
				});
	}

	String getSessionId() {
		Subject currentUser = SecurityUtils.getSubject();
		String sessionId = "NOSESSION";
		if (currentUser.isAuthenticated()) {
			sessionId = currentUser.getSession().getId().toString();
		}
		return sessionId;
	}

	void storeKeyInSession(String key) {
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser.isAuthenticated()) {
			Set<String> cacheKeys = (Set<String>) currentUser.getSession().getAttribute("CACHE_KEY_SET");
			if (cacheKeys == null) {
				cacheKeys = new HashSet<String>(128);
			}
			cacheKeys.add(key);
			currentUser.getSession().setAttribute("CACHE_KEY_SET", cacheKeys);
		}
	}
}
