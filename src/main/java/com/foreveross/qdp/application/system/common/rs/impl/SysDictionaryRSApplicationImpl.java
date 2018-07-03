/*******************************************************************************
 * Copyright (c) 2018-07-03 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation.
 * Auto Generate By foreveross.com Quick Deliver Platform. 
 ******************************************************************************/
package com.foreveross.qdp.application.system.common.rs.impl;

import com.foreveross.common.ResultBean;
import com.foreveross.qdp.application.system.common.SysDictionaryApplication;
import com.foreveross.qdp.infra.vo.system.common.SysDictionaryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.iff.infra.util.BeanHelper;
import org.iff.infra.util.NumberHelper;
import org.iff.infra.util.PreCheckHelper;
import org.iff.infra.util.mybatis.plugin.Page;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;


/**
 * SysDictionary
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2018-07-03
 * @version 1.0.0
 * auto generate by qdp v5.0.
 */
@RestController
@RequestMapping("/api/SysDictionary")
@Api("SysDictionary Api")
public class SysDictionaryRSApplicationImpl {

    @Inject
    SysDictionaryApplication sysDictionaryApplication;

    /**
     * <pre>
     * get SysDictionaryVO by id.
     * USAGE:
     *   GET /api/SysDictionary/get/{id}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysDictionaryVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param id
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0
     */
    @ApiOperation(value = "get SysDictionary by id", notes = "get SysDictionary by id")
    @GetMapping("/get/{id}")
    public ResultBean getSysDictionaryById(@PathVariable String id) {
        try {
            return ResultBean.success().setBody(sysDictionaryApplication.getSysDictionaryById(id));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find SysDictionaryVO.
     * USAGE:
     *   GET /api/SysDictionary/page/{name1}/{code}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{SysDictionaryVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param name1
     * @param code
     * @param currentPage
     * @param pageSize
     * @param asc
     * @param desc
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0
     */
    @ApiOperation(value = "page find SysDictionary", notes = "page find SysDictionary")
    @GetMapping({"/page/{name1}/{code}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/page/{name1}/{code}/{currentPage}/{pageSize}",
            "/page/{name1}/{code}/{currentPage}",
            "/page/{name1}/{code}",
            "/page/{name1}",
            "/page"})
    public ResultBean pageFindSysDictionary(
                                       @PathVariable(required = false, value = "name1") String name1,
                                       @PathVariable(required = false, value = "code") String code,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("name1", PreCheckHelper.equalsToNull(name1, "-"));
                 map.put("code", PreCheckHelper.equalsToNull(code, "-"));
            }
            Page page = new Page();
            {
                page.setCurrentPage(NumberHelper.getInt(currentPage, 1));
                page.setPageSize(NumberHelper.getInt(pageSize, 10));
                asc = PreCheckHelper.equalsToNull(asc, "-");
                desc = PreCheckHelper.equalsToNull(desc, "-");
                if (StringUtils.isNotBlank(asc)) {
                    page.addAscOrderBy(asc);
                }
                if (StringUtils.isNotBlank(desc)) {
                    page.addDescOrderBy(desc);
                }
            }
            SysDictionaryVO vo = BeanHelper.copyProperties(SysDictionaryVO.class, map);
            return ResultBean.success().setBody(sysDictionaryApplication.pageFindSysDictionary(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find SysDictionaryVO.
     * USAGE:
     *   GET /api/SysDictionary/pageMap/{name1}/{code}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{SysDictionaryVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param name1
     * @param code
     * @param currentPage
     * @param pageSize
     * @param asc
     * @param desc
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0
     */
    @ApiOperation(value = "page find SysDictionary", notes = "page find SysDictionary")
    @GetMapping({"/pageMap/{name1}/{code}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/pageMap/{name1}/{code}/{currentPage}/{pageSize}",
            "/pageMap/{name1}/{code}/{currentPage}",
            "/pageMap/{name1}/{code}",
            "/pageMap/{name1}",
            "/pageMap"})
    public ResultBean pageFindSysDictionaryMap(
                                       @PathVariable(required = false, value = "name1") String name1,
                                       @PathVariable(required = false, value = "code") String code,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("name1", PreCheckHelper.equalsToNull(name1, "-"));
                 map.put("code", PreCheckHelper.equalsToNull(code, "-"));
            }
            Page page = new Page();
            {
                page.setCurrentPage(NumberHelper.getInt(currentPage, 1));
                page.setPageSize(NumberHelper.getInt(pageSize, 10));
                asc = PreCheckHelper.equalsToNull(asc, "-");
                desc = PreCheckHelper.equalsToNull(desc, "-");
                if (StringUtils.isNotBlank(asc)) {
                    page.addAscOrderBy(asc);
                }
                if (StringUtils.isNotBlank(desc)) {
                    page.addDescOrderBy(desc);
                }
            }
            SysDictionaryVO vo = BeanHelper.copyProperties(SysDictionaryVO.class, map);
            return ResultBean.success().setBody(sysDictionaryApplication.pageFindSysDictionaryMap(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * add SysDictionary.
     * USAGE:
     *   POST /api/SysDictionary/
     *   {SysDictionaryVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysDictionaryVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return SysDictionaryVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "add SysDictionary", notes = "add SysDictionary")
    @PostMapping("/")
    public ResultBean addSysDictionary(@RequestBody SysDictionaryVO vo) {
        try {
            return ResultBean.success().setBody(sysDictionaryApplication.addSysDictionary(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * update SysDictionary.
     * USAGE:
     *   POST /api/SysDictionary/
     *   {SysDictionaryVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysDictionaryVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return SysDictionaryVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "update SysDictionary", notes = "update SysDictionary")
    @PutMapping("/")
    public ResultBean updateSysDictionary(@RequestBody SysDictionaryVO vo) {
        try {
            return ResultBean.success().setBody(sysDictionaryApplication.updateSysDictionary(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * remove SysDictionary multi ids join by comma ','.
     * USAGE:
     *   DELETE /api/SysDictionary/{id}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param id
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "delete SysDictionary", notes = "delete SysDictionary")
    @DeleteMapping("/{id}")
    public ResultBean removeSysDictionaryById(@PathVariable String id) {
        try {
            if (id.indexOf(',') > -1) {
                sysDictionaryApplication.removeSysDictionaryByIds(StringUtils.split(id, ','));
            } else {
                sysDictionaryApplication.removeSysDictionaryById(id);
            }
            return ResultBean.success();
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
	
	
}
