/*******************************************************************************
 * Copyright (c) Aug 28, 2017 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation
 ******************************************************************************/
package com.foreveross.common.shiro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.servlet.AdviceFilter;
import org.iff.infra.util.FCS;
import org.iff.infra.util.GsonHelper;
import org.iff.infra.util.StringHelper;
import org.iff.infra.util.ThreadLocalHelper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import com.foreveross.common.ConstantBean;
import com.foreveross.common.ResultBean;
import com.foreveross.extension.log.LogHelper;

/**
 * Shiro登录验证过滤器，当存在多种登录验证方式时，并只满足一种登录就可以访问，那么就可以使用这个Filter。
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since Aug 11, 2016
 */
public class ShiroOnceValidAccessControlFilter extends AdviceFilter implements OnceValidAdvice {

	private static final org.iff.infra.util.Logger.Log Logger = org.iff.infra.util.Logger.get("FOSS-SHIRO");

	private List<OnceValidAdvice> onceFilterChains = new ArrayList<OnceValidAdvice>();

	public boolean preHandle(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String url = StringUtils.removeStart(request.getRequestURI(), request.getContextPath());
		{
			Logger.debug(FCS.get("Shiro filter " + getClass().getSimpleName() + " preHandle, uri: {0}", url));
			LogHelper.accessLog(null, request.getRemoteAddr(), url, "URL", new Date());
		}
		{
			request.setAttribute(OnceValidAdvice.REQUEST_MARK, true);
		}
		for (OnceValidAdvice filter : onceFilterChains) {
			if (filter.preHandle(request, response)) {
				return true;
			}
		}
		if (!sendRedirect(response, url)) {
			response.reset();
			response.setStatus(401);
			response.getWriter().write(GsonHelper.toJsonString(ResultBean.error().setBody("Unauthorized")));
		}
		return false;
	}

	protected void cleanup(ServletRequest request, ServletResponse response, Exception existing)
			throws ServletException, IOException {
		ThreadLocalHelper.remove();
		super.cleanup(request, response, existing);
	}

	public List<OnceValidAdvice> getOnceFilterChains() {
		return onceFilterChains;
	}

	public void setOnceFilterChains(List<OnceValidAdvice> onceFilterChains) {
		this.onceFilterChains = onceFilterChains;
	}

	private String unauthorizedUrl = "";
	private String toUrl = "";
	private String[] unauthorizedUrls = new String[0];

	/**
	 * 根据配置决定是否发送重定向，如果发送就返回true，否则就返回false。
	 * @param response
	 * @param url
	 * @return
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since Mar 21, 2018
	 */
	private boolean sendRedirect(HttpServletResponse response, String url) {
		if (unauthorizedUrl.length() < 1) {
			unauthorizedUrl = ConstantBean.getProperty("shiro.redirect.unauthorized.url", "");
			if (StringUtils.isEmpty(unauthorizedUrl)) {
				return false;
			}
		}
		if (toUrl.length() < 1) {
			toUrl = ConstantBean.getProperty("shiro.redirect.to.url", "");
			if (StringUtils.isEmpty(toUrl)) {
				return false;
			}
		}
		if (unauthorizedUrls.length < 1) {
			unauthorizedUrls = StringUtils.split(unauthorizedUrl, ',');
		}
		boolean match = false;
		for (String redirectUrl : unauthorizedUrls) {
			if (redirectUrl.indexOf('*') < 0 && redirectUrl.equals(url)) {
				match = true;
				break;
			} else {
				match = StringHelper.wildCardMatch(url, redirectUrl);
				if (match == true) {
					break;
				}
			}
		}
		if (match) {
			Logger.debug(FCS.get("Shiro unauthorized url configured and redirect: {0} to {1}.", url, toUrl));
			response.reset();
			response.setHeader(HttpHeaders.LOCATION, toUrl);
			response.setStatus(HttpStatus.FOUND.value());
			return true;
		} else {
			Logger.debug(FCS.get("Shiro unauthorized url configured and not match to redirect: {0} not match {1}.", url,
					unauthorizedUrl));
		}
		return false;
	}
}