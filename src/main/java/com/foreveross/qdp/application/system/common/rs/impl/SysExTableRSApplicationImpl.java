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
import com.foreveross.qdp.application.system.common.SysExTableApplication;
import com.foreveross.qdp.infra.vo.system.common.SysExTableVO;
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
 * SysExTable
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2018-07-03
 * @version 1.0.0
 * auto generate by qdp v5.0.
 */
@RestController
@RequestMapping("/api/SysExTable")
@Api("SysExTable Api")
public class SysExTableRSApplicationImpl {

    @Inject
    SysExTableApplication sysExTableApplication;

    /**
     * <pre>
     * get SysExTableVO by id.
     * USAGE:
     *   GET /api/SysExTable/get/{id}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysExTableVO}}
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
    @ApiOperation(value = "get SysExTable by id", notes = "get SysExTable by id")
    @GetMapping("/get/{id}")
    public ResultBean getSysExTableById(@PathVariable String id) {
        try {
            return ResultBean.success().setBody(sysExTableApplication.getSysExTableById(id));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find SysExTableVO.
     * USAGE:
     *   GET /api/SysExTable/page/{refTable}/{colName}/{colType}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{SysExTableVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param refTable
     * @param colName
     * @param colType
     * @param currentPage
     * @param pageSize
     * @param asc
     * @param desc
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0
     */
    @ApiOperation(value = "page find SysExTable", notes = "page find SysExTable")
    @GetMapping({"/page/{refTable}/{colName}/{colType}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/page/{refTable}/{colName}/{colType}/{currentPage}/{pageSize}",
            "/page/{refTable}/{colName}/{colType}/{currentPage}",
            "/page/{refTable}/{colName}/{colType}",
            "/page/{refTable}/{colName}",
            "/page/{refTable}",
            "/page"})
    public ResultBean pageFindSysExTable(
                                       @PathVariable(required = false, value = "refTable") String refTable,
                                       @PathVariable(required = false, value = "colName") String colName,
                                       @PathVariable(required = false, value = "colType") String colType,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("refTable", PreCheckHelper.equalsToNull(refTable, "-"));
                 map.put("colName", PreCheckHelper.equalsToNull(colName, "-"));
                 map.put("colType", PreCheckHelper.equalsToNull(colType, "-"));
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
            SysExTableVO vo = BeanHelper.copyProperties(SysExTableVO.class, map);
            return ResultBean.success().setBody(sysExTableApplication.pageFindSysExTable(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find SysExTableVO.
     * USAGE:
     *   GET /api/SysExTable/pageMap/{refTable}/{colName}/{colType}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{SysExTableVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param refTable
     * @param colName
     * @param colType
     * @param currentPage
     * @param pageSize
     * @param asc
     * @param desc
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0
     */
    @ApiOperation(value = "page find SysExTable", notes = "page find SysExTable")
    @GetMapping({"/pageMap/{refTable}/{colName}/{colType}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/pageMap/{refTable}/{colName}/{colType}/{currentPage}/{pageSize}",
            "/pageMap/{refTable}/{colName}/{colType}/{currentPage}",
            "/pageMap/{refTable}/{colName}/{colType}",
            "/pageMap/{refTable}/{colName}",
            "/pageMap/{refTable}",
            "/pageMap"})
    public ResultBean pageFindSysExTableMap(
                                       @PathVariable(required = false, value = "refTable") String refTable,
                                       @PathVariable(required = false, value = "colName") String colName,
                                       @PathVariable(required = false, value = "colType") String colType,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("refTable", PreCheckHelper.equalsToNull(refTable, "-"));
                 map.put("colName", PreCheckHelper.equalsToNull(colName, "-"));
                 map.put("colType", PreCheckHelper.equalsToNull(colType, "-"));
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
            SysExTableVO vo = BeanHelper.copyProperties(SysExTableVO.class, map);
            return ResultBean.success().setBody(sysExTableApplication.pageFindSysExTableMap(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * add SysExTable.
     * USAGE:
     *   POST /api/SysExTable/
     *   {SysExTableVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysExTableVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return SysExTableVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "add SysExTable", notes = "add SysExTable")
    @PostMapping("/")
    public ResultBean addSysExTable(@RequestBody SysExTableVO vo) {
        try {
            return ResultBean.success().setBody(sysExTableApplication.addSysExTable(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * update SysExTable.
     * USAGE:
     *   POST /api/SysExTable/
     *   {SysExTableVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysExTableVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return SysExTableVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "update SysExTable", notes = "update SysExTable")
    @PutMapping("/")
    public ResultBean updateSysExTable(@RequestBody SysExTableVO vo) {
        try {
            return ResultBean.success().setBody(sysExTableApplication.updateSysExTable(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * remove SysExTable multi ids join by comma ','.
     * USAGE:
     *   DELETE /api/SysExTable/{id}
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
    @ApiOperation(value = "delete SysExTable", notes = "delete SysExTable")
    @DeleteMapping("/{id}")
    public ResultBean removeSysExTableById(@PathVariable String id) {
        try {
            if (id.indexOf(',') > -1) {
                sysExTableApplication.removeSysExTableByIds(StringUtils.split(id, ','));
            } else {
                sysExTableApplication.removeSysExTableById(id);
            }
            return ResultBean.success();
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
	
	
}
