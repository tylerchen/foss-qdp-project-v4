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
import com.foreveross.qdp.application.system.common.SysExDataApplication;
import com.foreveross.qdp.infra.vo.system.common.SysExDataVO;
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
 * SysExData
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2018-07-03
 * @version 1.0.0
 * auto generate by qdp v5.0.
 */
@RestController
@RequestMapping("/api/SysExData")
@Api("SysExData Api")
public class SysExDataRSApplicationImpl {

    @Inject
    SysExDataApplication sysExDataApplication;

    /**
     * <pre>
     * get SysExDataVO by id.
     * USAGE:
     *   GET /api/SysExData/get/{id}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysExDataVO}}
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
    @ApiOperation(value = "get SysExData by id", notes = "get SysExData by id")
    @GetMapping("/get/{id}")
    public ResultBean getSysExDataById(@PathVariable String id) {
        try {
            return ResultBean.success().setBody(sysExDataApplication.getSysExDataById(id));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find SysExDataVO.
     * USAGE:
     *   GET /api/SysExData/page/{refTable}/{refId}/{colName}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{SysExDataVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param refTable
     * @param refId
     * @param colName
     * @param currentPage
     * @param pageSize
     * @param asc
     * @param desc
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0
     */
    @ApiOperation(value = "page find SysExData", notes = "page find SysExData")
    @GetMapping({"/page/{refTable}/{refId}/{colName}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/page/{refTable}/{refId}/{colName}/{currentPage}/{pageSize}",
            "/page/{refTable}/{refId}/{colName}/{currentPage}",
            "/page/{refTable}/{refId}/{colName}",
            "/page/{refTable}/{refId}",
            "/page/{refTable}",
            "/page"})
    public ResultBean pageFindSysExData(
                                       @PathVariable(required = false, value = "refTable") String refTable,
                                       @PathVariable(required = false, value = "refId") String refId,
                                       @PathVariable(required = false, value = "colName") String colName,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("refTable", PreCheckHelper.equalsToNull(refTable, "-"));
                 map.put("refId", PreCheckHelper.equalsToNull(refId, "-"));
                 map.put("colName", PreCheckHelper.equalsToNull(colName, "-"));
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
            SysExDataVO vo = BeanHelper.copyProperties(SysExDataVO.class, map);
            return ResultBean.success().setBody(sysExDataApplication.pageFindSysExData(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find SysExDataVO.
     * USAGE:
     *   GET /api/SysExData/pageMap/{refTable}/{refId}/{colName}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{SysExDataVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param refTable
     * @param refId
     * @param colName
     * @param currentPage
     * @param pageSize
     * @param asc
     * @param desc
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0
     */
    @ApiOperation(value = "page find SysExData", notes = "page find SysExData")
    @GetMapping({"/pageMap/{refTable}/{refId}/{colName}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/pageMap/{refTable}/{refId}/{colName}/{currentPage}/{pageSize}",
            "/pageMap/{refTable}/{refId}/{colName}/{currentPage}",
            "/pageMap/{refTable}/{refId}/{colName}",
            "/pageMap/{refTable}/{refId}",
            "/pageMap/{refTable}",
            "/pageMap"})
    public ResultBean pageFindSysExDataMap(
                                       @PathVariable(required = false, value = "refTable") String refTable,
                                       @PathVariable(required = false, value = "refId") String refId,
                                       @PathVariable(required = false, value = "colName") String colName,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("refTable", PreCheckHelper.equalsToNull(refTable, "-"));
                 map.put("refId", PreCheckHelper.equalsToNull(refId, "-"));
                 map.put("colName", PreCheckHelper.equalsToNull(colName, "-"));
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
            SysExDataVO vo = BeanHelper.copyProperties(SysExDataVO.class, map);
            return ResultBean.success().setBody(sysExDataApplication.pageFindSysExDataMap(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * add SysExData.
     * USAGE:
     *   POST /api/SysExData/
     *   {SysExDataVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysExDataVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return SysExDataVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "add SysExData", notes = "add SysExData")
    @PostMapping("/")
    public ResultBean addSysExData(@RequestBody SysExDataVO vo) {
        try {
            return ResultBean.success().setBody(sysExDataApplication.addSysExData(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * update SysExData.
     * USAGE:
     *   POST /api/SysExData/
     *   {SysExDataVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysExDataVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return SysExDataVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "update SysExData", notes = "update SysExData")
    @PutMapping("/")
    public ResultBean updateSysExData(@RequestBody SysExDataVO vo) {
        try {
            return ResultBean.success().setBody(sysExDataApplication.updateSysExData(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * remove SysExData multi ids join by comma ','.
     * USAGE:
     *   DELETE /api/SysExData/{id}
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
    @ApiOperation(value = "delete SysExData", notes = "delete SysExData")
    @DeleteMapping("/{id}")
    public ResultBean removeSysExDataById(@PathVariable String id) {
        try {
            if (id.indexOf(',') > -1) {
                sysExDataApplication.removeSysExDataByIds(StringUtils.split(id, ','));
            } else {
                sysExDataApplication.removeSysExDataById(id);
            }
            return ResultBean.success();
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
	
	
}
