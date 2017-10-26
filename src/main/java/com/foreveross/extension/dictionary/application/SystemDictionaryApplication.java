/*******************************************************************************
 * Copyright (c) Aug 11, 2016 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation
 ******************************************************************************/
package com.foreveross.extension.dictionary.application;

import java.util.Map;

/**
 * 系统字典。
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since Aug 11, 2016
 */
public interface SystemDictionaryApplication {

	/**
	 * 所有字典一级分类。
	 * @return
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since Oct 17, 2017
	 */
	Map<String, String> findType1();

	/**
	 * 拿到字典的二级分类。
	 * @param type1
	 * @return
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since Oct 17, 2017
	 */
	Map<String, String> findType2(String type1);

	/**
	 * 根据一级二级分类返回字典。
	 * @param type1
	 * @param type2
	 * @return
	 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
	 * @since Oct 17, 2017
	 */
	Map<String, String> findDictionary(String type1, String type2);
}
