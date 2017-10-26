/*******************************************************************************
 * Copyright (c) Oct 16, 2017 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation
 ******************************************************************************/
package com.foreveross.extension.query.application;

import org.iff.infra.util.mybatis.plugin.Page;

import com.foreveross.qdp.infra.vo.system.common.SysQueryVO;

/**
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since Oct 16, 2017
 */
public interface SystemQueryApplication {

	/**
	 * <pre>
	 * 输出SQL查询。
	 * 如果输出Mybatis的Mapper XML类型的SQL，需要使用script标签包裹起来。
	 * &lt;script&gt;
	 * SELECT * FROM TEST &lt;where&gt; ID = ? &lt;/where&gt;
	 * &lt;/script&gt;
	 * </pre>
	 * @param vo 这个是SysQueryVO对象，用于加载查询语句。
	 * @param condition 查询语句的条件
	 * @param page 分页
	 * @return
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since Oct 16, 2017
	 */
	Page query(SysQueryVO vo, Object condition, Page page);
}
