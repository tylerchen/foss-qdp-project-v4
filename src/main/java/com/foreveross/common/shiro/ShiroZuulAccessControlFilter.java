/*******************************************************************************
 * Copyright (c) Aug 28, 2017 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation
 ******************************************************************************/
package com.foreveross.common.shiro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.servlet.AdviceFilter;
import org.iff.infra.util.FCS;
import org.iff.infra.util.HttpHelper;

/**
 * Shiro ZUUL验证过滤器
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since Aug 11, 2016
 */
public class ShiroZuulAccessControlFilter extends AdviceFilter implements OnceValidAdvice {

	private static final org.iff.infra.util.Logger.Log Logger = org.iff.infra.util.Logger.get("FOSS-SHIRO");

	public boolean preHandle(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
		HttpServletRequest request = (HttpServletRequest) servletRequest;

		//是否为OnceValidAdvice。
		//boolean isOnceValidAdvice = Boolean.TRUE.equals(request.getAttribute(OnceValidAdvice.REQUEST_MARK));

		String ip = HttpHelper.getRemoteIpAddr(request);
		/**
		 * 验证： 如果Header[zuul]采用了约定的加密方式（把客户端的所有IP进行md5(md5(ip).reverse())拼接），服务端拿到客户端的IP也进行相同的加密方式，最后对比是否包含加密段即可，【非严谨验证方式】。
		 */
		String zuul = request.getHeader("zuul");

		Logger.debug(FCS.get("Shiro ShiroZuulAccessControlFilter.preHandle, ip: {0}, zuul: {1}", ip, zuul));

		boolean valid = HttpHelper.validateIpMd5(ip, zuul);
		//		if (!valid) {
		//			//enable localhost, if you don't want to enable localhost use ShiroIpAccessControlFilter
		//			String[] ips = new String[] { "0:0:0:0:0:0:0:*", "127.0.0.*" };
		//			for (String aip : ips) {
		//				valid = StringHelper.wildCardMatch(ip, aip.trim());
		//				if (valid) {
		//					break;
		//				}
		//			}
		//		}
		if (valid) {
			return true;
		} else {
			return false;
		}
	}

	protected void cleanup(ServletRequest request, ServletResponse response, Exception existing)
			throws ServletException, IOException {
		super.cleanup(request, response, existing);
	}

}