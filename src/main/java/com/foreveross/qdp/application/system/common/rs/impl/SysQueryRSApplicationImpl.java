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
import com.foreveross.qdp.application.system.common.SysQueryApplication;
import com.foreveross.qdp.infra.vo.system.common.SysQueryVO;
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
 * SysQuery
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2018-07-03
 * @version 1.0.0
 * auto generate by qdp v5.0.
 */
@RestController
@RequestMapping("/api/SysQuery")
@Api("SysQuery Api")
public class SysQueryRSApplicationImpl {

    @Inject
    SysQueryApplication sysQueryApplication;

    /**
     * <pre>
     * get SysQueryVO by id.
     * USAGE:
     *   GET /api/SysQuery/get/{id}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysQueryVO}}
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
    @ApiOperation(value = "get SysQuery by id", notes = "get SysQuery by id")
    @GetMapping("/get/{id}")
    public ResultBean getSysQueryById(@PathVariable String id) {
        try {
            return ResultBean.success().setBody(sysQueryApplication.getSysQueryById(id));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find SysQueryVO.
     * USAGE:
     *   GET /api/SysQuery/page/{name}/{code}/{dataSource}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{SysQueryVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param name
     * @param code
     * @param dataSource
     * @param currentPage
     * @param pageSize
     * @param asc
     * @param desc
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0
     */
    @ApiOperation(value = "page find SysQuery", notes = "page find SysQuery")
    @GetMapping({"/page/{name}/{code}/{dataSource}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/page/{name}/{code}/{dataSource}/{currentPage}/{pageSize}",
            "/page/{name}/{code}/{dataSource}/{currentPage}",
            "/page/{name}/{code}/{dataSource}",
            "/page/{name}/{code}",
            "/page/{name}",
            "/page"})
    public ResultBean pageFindSysQuery(
                                       @PathVariable(required = false, value = "name") String name,
                                       @PathVariable(required = false, value = "code") String code,
                                       @PathVariable(required = false, value = "dataSource") String dataSource,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("name", PreCheckHelper.equalsToNull(name, "-"));
                 map.put("code", PreCheckHelper.equalsToNull(code, "-"));
                 map.put("dataSource", PreCheckHelper.equalsToNull(dataSource, "-"));
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
            SysQueryVO vo = BeanHelper.copyProperties(SysQueryVO.class, map);
            return ResultBean.success().setBody(sysQueryApplication.pageFindSysQuery(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find SysQueryVO.
     * USAGE:
     *   GET /api/SysQuery/pageMap/{name}/{code}/{dataSource}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{SysQueryVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param name
     * @param code
     * @param dataSource
     * @param currentPage
     * @param pageSize
     * @param asc
     * @param desc
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0
     */
    @ApiOperation(value = "page find SysQuery", notes = "page find SysQuery")
    @GetMapping({"/pageMap/{name}/{code}/{dataSource}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/pageMap/{name}/{code}/{dataSource}/{currentPage}/{pageSize}",
            "/pageMap/{name}/{code}/{dataSource}/{currentPage}",
            "/pageMap/{name}/{code}/{dataSource}",
            "/pageMap/{name}/{code}",
            "/pageMap/{name}",
            "/pageMap"})
    public ResultBean pageFindSysQueryMap(
                                       @PathVariable(required = false, value = "name") String name,
                                       @PathVariable(required = false, value = "code") String code,
                                       @PathVariable(required = false, value = "dataSource") String dataSource,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("name", PreCheckHelper.equalsToNull(name, "-"));
                 map.put("code", PreCheckHelper.equalsToNull(code, "-"));
                 map.put("dataSource", PreCheckHelper.equalsToNull(dataSource, "-"));
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
            SysQueryVO vo = BeanHelper.copyProperties(SysQueryVO.class, map);
            return ResultBean.success().setBody(sysQueryApplication.pageFindSysQueryMap(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * add SysQuery.
     * USAGE:
     *   POST /api/SysQuery/
     *   {SysQueryVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysQueryVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return SysQueryVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "add SysQuery", notes = "add SysQuery")
    @PostMapping("/")
    public ResultBean addSysQuery(@RequestBody SysQueryVO vo) {
        try {
            return ResultBean.success().setBody(sysQueryApplication.addSysQuery(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * update SysQuery.
     * USAGE:
     *   POST /api/SysQuery/
     *   {SysQueryVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysQueryVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return SysQueryVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "update SysQuery", notes = "update SysQuery")
    @PutMapping("/")
    public ResultBean updateSysQuery(@RequestBody SysQueryVO vo) {
        try {
            return ResultBean.success().setBody(sysQueryApplication.updateSysQuery(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * remove SysQuery multi ids join by comma ','.
     * USAGE:
     *   DELETE /api/SysQuery/{id}
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
    @ApiOperation(value = "delete SysQuery", notes = "delete SysQuery")
    @DeleteMapping("/{id}")
    public ResultBean removeSysQueryById(@PathVariable String id) {
        try {
            if (id.indexOf(',') > -1) {
                sysQueryApplication.removeSysQueryByIds(StringUtils.split(id, ','));
            } else {
                sysQueryApplication.removeSysQueryById(id);
            }
            return ResultBean.success();
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
    /**
     * <pre>
     * get SysQuery by unique name
     * USAGE:
     *   GET /api/SysQuery/get/name/{name}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysQueryVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "get SysQuery by name", notes = "get SysQuery by name")
    @GetMapping("/get/name/{name}")
    public ResultBean getByName(@PathVariable String name) {
        try {
            return ResultBean.success().setBody(sysQueryApplication.getByName(name));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
    /**
     * <pre>
     * get SysQuery by unique name
     * USAGE:
     *   GET /api/SysQuery/get/code/{code}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysQueryVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "get SysQuery by code", notes = "get SysQuery by code")
    @GetMapping("/get/code/{code}")
    public ResultBean getByCode(@PathVariable String code) {
        try {
            return ResultBean.success().setBody(sysQueryApplication.getByCode(code));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
	
	
}
