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
import com.foreveross.qdp.application.system.common.SysScriptApplication;
import com.foreveross.qdp.infra.vo.system.common.SysScriptVO;
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
 * SysScript
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2018-07-03
 * @version 1.0.0
 * auto generate by qdp v5.0.
 */
@RestController
@RequestMapping("/api/SysScript")
@Api("SysScript Api")
public class SysScriptRSApplicationImpl {

    @Inject
    SysScriptApplication sysScriptApplication;

    /**
     * <pre>
     * get SysScriptVO by id.
     * USAGE:
     *   GET /api/SysScript/get/{id}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysScriptVO}}
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
    @ApiOperation(value = "get SysScript by id", notes = "get SysScript by id")
    @GetMapping("/get/{id}")
    public ResultBean getSysScriptById(@PathVariable String id) {
        try {
            return ResultBean.success().setBody(sysScriptApplication.getSysScriptById(id));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find SysScriptVO.
     * USAGE:
     *   GET /api/SysScript/page/{name}/{code}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{SysScriptVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param name
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
    @ApiOperation(value = "page find SysScript", notes = "page find SysScript")
    @GetMapping({"/page/{name}/{code}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/page/{name}/{code}/{currentPage}/{pageSize}",
            "/page/{name}/{code}/{currentPage}",
            "/page/{name}/{code}",
            "/page/{name}",
            "/page"})
    public ResultBean pageFindSysScript(
                                       @PathVariable(required = false, value = "name") String name,
                                       @PathVariable(required = false, value = "code") String code,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("name", PreCheckHelper.equalsToNull(name, "-"));
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
            SysScriptVO vo = BeanHelper.copyProperties(SysScriptVO.class, map);
            return ResultBean.success().setBody(sysScriptApplication.pageFindSysScript(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find SysScriptVO.
     * USAGE:
     *   GET /api/SysScript/pageMap/{name}/{code}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{SysScriptVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param name
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
    @ApiOperation(value = "page find SysScript", notes = "page find SysScript")
    @GetMapping({"/pageMap/{name}/{code}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/pageMap/{name}/{code}/{currentPage}/{pageSize}",
            "/pageMap/{name}/{code}/{currentPage}",
            "/pageMap/{name}/{code}",
            "/pageMap/{name}",
            "/pageMap"})
    public ResultBean pageFindSysScriptMap(
                                       @PathVariable(required = false, value = "name") String name,
                                       @PathVariable(required = false, value = "code") String code,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("name", PreCheckHelper.equalsToNull(name, "-"));
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
            SysScriptVO vo = BeanHelper.copyProperties(SysScriptVO.class, map);
            return ResultBean.success().setBody(sysScriptApplication.pageFindSysScriptMap(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * add SysScript.
     * USAGE:
     *   POST /api/SysScript/
     *   {SysScriptVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysScriptVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return SysScriptVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "add SysScript", notes = "add SysScript")
    @PostMapping("/")
    public ResultBean addSysScript(@RequestBody SysScriptVO vo) {
        try {
            return ResultBean.success().setBody(sysScriptApplication.addSysScript(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * update SysScript.
     * USAGE:
     *   POST /api/SysScript/
     *   {SysScriptVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysScriptVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return SysScriptVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "update SysScript", notes = "update SysScript")
    @PutMapping("/")
    public ResultBean updateSysScript(@RequestBody SysScriptVO vo) {
        try {
            return ResultBean.success().setBody(sysScriptApplication.updateSysScript(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * remove SysScript multi ids join by comma ','.
     * USAGE:
     *   DELETE /api/SysScript/{id}
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
    @ApiOperation(value = "delete SysScript", notes = "delete SysScript")
    @DeleteMapping("/{id}")
    public ResultBean removeSysScriptById(@PathVariable String id) {
        try {
            if (id.indexOf(',') > -1) {
                sysScriptApplication.removeSysScriptByIds(StringUtils.split(id, ','));
            } else {
                sysScriptApplication.removeSysScriptById(id);
            }
            return ResultBean.success();
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
    /**
     * <pre>
     * get SysScript by unique name
     * USAGE:
     *   GET /api/SysScript/get/name/{name}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysScriptVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "get SysScript by name", notes = "get SysScript by name")
    @GetMapping("/get/name/{name}")
    public ResultBean getByName(@PathVariable String name) {
        try {
            return ResultBean.success().setBody(sysScriptApplication.getByName(name));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
    /**
     * <pre>
     * get SysScript by unique name
     * USAGE:
     *   GET /api/SysScript/get/code/{code}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysScriptVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "get SysScript by code", notes = "get SysScript by code")
    @GetMapping("/get/code/{code}")
    public ResultBean getByCode(@PathVariable String code) {
        try {
            return ResultBean.success().setBody(sysScriptApplication.getByCode(code));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
	
	
}
