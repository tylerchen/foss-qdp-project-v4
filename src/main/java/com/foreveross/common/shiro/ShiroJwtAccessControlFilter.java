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

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.AdviceFilter;
import org.iff.infra.util.FCS;

/**
 * <pre>
 * JSON Web Token (JWT) is an open standard (RFC 7519) that defines a compact and 
 * self-contained way for securely transmitting information between parties as a JSON object. 
 * This information can be verified and trusted because it is digitally signed. 
 * JWTs can be signed using a secret (with the HMAC algorithm) or a public/private key pair using RSA
 * </pre>
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since Aug 28, 2017
 */
public class ShiroJwtAccessControlFilter extends AdviceFilter implements OnceValidAdvice {

	private static final org.iff.infra.util.Logger.Log Logger = org.iff.infra.util.Logger.get("FOSS-SHIRO");

	public boolean preHandle(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
		try {
			HttpServletRequest request = (HttpServletRequest) servletRequest;
			Subject subject = SecurityUtils.getSubject();
			//是否为OnceValidAdvice。
			//boolean isOnceValidAdvice = Boolean.TRUE.equals(request.getAttribute(OnceValidAdvice.REQUEST_MARK));

			String jwtToken = request.getHeader("Authorization");

			if (!StringUtils.startsWith(jwtToken, "Bearer ")) {
				jwtToken = request.getParameter("_jwt");
				if (StringUtils.isBlank(jwtToken)) {
					return false;
				}
			} else {
				jwtToken = jwtToken.substring(jwtToken.indexOf(" ")).trim();
			}

			Logger.debug(FCS.get("Shiro ShiroJwtAccessControlFilter.preHandle, jwtToken: {0}", jwtToken));

			subject.login(new JWTToken(jwtToken));

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	protected void cleanup(ServletRequest request, ServletResponse response, Exception existing)
			throws ServletException, IOException {
		//ThreadLocalHelper.remove();
		super.cleanup(request, response, existing);
	}
}