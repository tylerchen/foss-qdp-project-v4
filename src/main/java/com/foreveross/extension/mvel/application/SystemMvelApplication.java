/*******************************************************************************
 * Copyright (c) Aug 11, 2016 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation
 ******************************************************************************/
package com.foreveross.extension.mvel.application;

import java.util.Map;

import com.foreveross.qdp.infra.vo.system.common.SysScriptVO;

/**
 * Mvel脚本执行。
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since Aug 11, 2016
 */
public interface SystemMvelApplication {
	/**
	 * 脚本执行
	 * @param vo 通过vo条件查询得脚本
	 * @param condition 脚本执行的参数
	 * @return
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since Oct 17, 2017
	 */
	Object script(SysScriptVO vo, Map<?, ?> condition);
}
