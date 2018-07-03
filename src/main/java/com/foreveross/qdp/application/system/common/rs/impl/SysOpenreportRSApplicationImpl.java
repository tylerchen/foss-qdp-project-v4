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
import com.foreveross.qdp.application.system.common.SysOpenreportApplication;
import com.foreveross.qdp.infra.vo.system.common.SysOpenreportVO;
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
 * SysOpenreport
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2018-07-03
 * @version 1.0.0
 * auto generate by qdp v5.0.
 */
@RestController
@RequestMapping("/api/SysOpenreport")
@Api("SysOpenreport Api")
public class SysOpenreportRSApplicationImpl {

    @Inject
    SysOpenreportApplication sysOpenreportApplication;

    /**
     * <pre>
     * get SysOpenreportVO by id.
     * USAGE:
     *   GET /api/SysOpenreport/get/{id}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysOpenreportVO}}
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
    @ApiOperation(value = "get SysOpenreport by id", notes = "get SysOpenreport by id")
    @GetMapping("/get/{id}")
    public ResultBean getSysOpenreportById(@PathVariable String id) {
        try {
            return ResultBean.success().setBody(sysOpenreportApplication.getSysOpenreportById(id));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find SysOpenreportVO.
     * USAGE:
     *   GET /api/SysOpenreport/page/{name}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{SysOpenreportVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param name
     * @param currentPage
     * @param pageSize
     * @param asc
     * @param desc
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0
     */
    @ApiOperation(value = "page find SysOpenreport", notes = "page find SysOpenreport")
    @GetMapping({"/page/{name}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/page/{name}/{currentPage}/{pageSize}",
            "/page/{name}/{currentPage}",
            "/page/{name}",
            "/page"})
    public ResultBean pageFindSysOpenreport(
                                       @PathVariable(required = false, value = "name") String name,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("name", PreCheckHelper.equalsToNull(name, "-"));
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
            SysOpenreportVO vo = BeanHelper.copyProperties(SysOpenreportVO.class, map);
            return ResultBean.success().setBody(sysOpenreportApplication.pageFindSysOpenreport(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find SysOpenreportVO.
     * USAGE:
     *   GET /api/SysOpenreport/pageMap/{name}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{SysOpenreportVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param name
     * @param currentPage
     * @param pageSize
     * @param asc
     * @param desc
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0
     */
    @ApiOperation(value = "page find SysOpenreport", notes = "page find SysOpenreport")
    @GetMapping({"/pageMap/{name}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/pageMap/{name}/{currentPage}/{pageSize}",
            "/pageMap/{name}/{currentPage}",
            "/pageMap/{name}",
            "/pageMap"})
    public ResultBean pageFindSysOpenreportMap(
                                       @PathVariable(required = false, value = "name") String name,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("name", PreCheckHelper.equalsToNull(name, "-"));
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
            SysOpenreportVO vo = BeanHelper.copyProperties(SysOpenreportVO.class, map);
            return ResultBean.success().setBody(sysOpenreportApplication.pageFindSysOpenreportMap(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * add SysOpenreport.
     * USAGE:
     *   POST /api/SysOpenreport/
     *   {SysOpenreportVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysOpenreportVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return SysOpenreportVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "add SysOpenreport", notes = "add SysOpenreport")
    @PostMapping("/")
    public ResultBean addSysOpenreport(@RequestBody SysOpenreportVO vo) {
        try {
            return ResultBean.success().setBody(sysOpenreportApplication.addSysOpenreport(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * update SysOpenreport.
     * USAGE:
     *   POST /api/SysOpenreport/
     *   {SysOpenreportVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysOpenreportVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return SysOpenreportVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "update SysOpenreport", notes = "update SysOpenreport")
    @PutMapping("/")
    public ResultBean updateSysOpenreport(@RequestBody SysOpenreportVO vo) {
        try {
            return ResultBean.success().setBody(sysOpenreportApplication.updateSysOpenreport(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * remove SysOpenreport multi ids join by comma ','.
     * USAGE:
     *   DELETE /api/SysOpenreport/{id}
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
    @ApiOperation(value = "delete SysOpenreport", notes = "delete SysOpenreport")
    @DeleteMapping("/{id}")
    public ResultBean removeSysOpenreportById(@PathVariable String id) {
        try {
            if (id.indexOf(',') > -1) {
                sysOpenreportApplication.removeSysOpenreportByIds(StringUtils.split(id, ','));
            } else {
                sysOpenreportApplication.removeSysOpenreportById(id);
            }
            return ResultBean.success();
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
    /**
     * <pre>
     * get SysOpenreport by unique name
     * USAGE:
     *   GET /api/SysOpenreport/get/name/{name}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysOpenreportVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "get SysOpenreport by name", notes = "get SysOpenreport by name")
    @GetMapping("/get/name/{name}")
    public ResultBean getByName(@PathVariable String name) {
        try {
            return ResultBean.success().setBody(sysOpenreportApplication.getByName(name));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
	
	
}
