/*******************************************************************************
 * Copyright (c) Mar 21, 2018 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation
 ******************************************************************************/
package com.foreveross.common.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 是否为OnceValidAdvice：boolean isOnceValidAdvice = Boolean.TRUE.equals(request.getAttribute(OnceValidAdvice.REQUEST_MARK));
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since Mar 21, 2018
 */
public interface OnceValidAdvice {
	
	public static final String REQUEST_MARK = "OnceValidAdvice";

	boolean preHandle(ServletRequest request, ServletResponse response) throws Exception;
}
