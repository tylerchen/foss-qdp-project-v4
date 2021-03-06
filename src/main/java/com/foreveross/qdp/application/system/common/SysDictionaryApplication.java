/*******************************************************************************
 * Copyright (c) 2017-11-09 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation.
 * Auto Generate By foreveross.com Quick Deliver Platform. 
 ******************************************************************************/
package com.foreveross.qdp.application.system.common;

import com.foreveross.qdp.infra.vo.system.common.SysDictionaryVO;
import org.iff.infra.util.mybatis.plugin.Page;

/**
 * SysDictionary Application.
 *
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
 * @version 1.0.0
 * auto generate by qdp v3.0.
 * @since 2017-11-09
 */
public interface SysDictionaryApplication {

    /**
     * <pre>
     * get SysDictionaryVO by id.
     * </pre>
     *
     * @param vo
     * @return SysDictionaryVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    SysDictionaryVO getSysDictionary(SysDictionaryVO vo);

    /**
     * <pre>
     * get SysDictionaryVO by id.
     * </pre>
     *
     * @param vo
     * @return SysDictionaryVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    SysDictionaryVO getSysDictionaryById(String id);

    /**
     * <pre>
     * page find SysDictionaryVO.
     * </pre>
     *
     * @param vo   conditions
     * @param page page setting
     * @return Page
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    Page pageFindSysDictionary(SysDictionaryVO vo, Page page);

    /**
     * <pre>
     * page find SysDictionary Map.
     * </pre>
     *
     * @param vo   conditions
     * @param page page setting
     * @return Page
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    Page pageFindSysDictionaryMap(SysDictionaryVO vo, Page page);

    /**
     * <pre>
     * add SysDictionary.
     * </pre>
     *
     * @param vo
     * @return SysDictionaryVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    SysDictionaryVO addSysDictionary(SysDictionaryVO vo);

    /**
     * <pre>
     * update SysDictionary.
     * </pre>
     *
     * @param vo
     * @return SysDictionaryVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    SysDictionaryVO updateSysDictionary(SysDictionaryVO vo);

    /**
     * <pre>
     * remove SysDictionary.
     * </pre>
     *
     * @param vo conditions.
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    void removeSysDictionary(SysDictionaryVO vo);

    /**
     * <pre>
     * remove SysDictionary.
     * </pre>
     *
     * @param id.
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    void removeSysDictionaryById(String id);

    /**
     * <pre>
     * remove SysDictionary.
     * </pre>
     *
     * @param ids.
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2017-11-09
     * auto generate by qdp v3.0.
     */
    void removeSysDictionaryByIds(String[] ids);


}
