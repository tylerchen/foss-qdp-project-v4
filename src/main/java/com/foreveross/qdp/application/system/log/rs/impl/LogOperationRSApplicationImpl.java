/*******************************************************************************
 * Copyright (c) 2018-07-03 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation.
 * Auto Generate By foreveross.com Quick Deliver Platform. 
 ******************************************************************************/
package com.foreveross.qdp.application.system.log.rs.impl;

import com.foreveross.common.ResultBean;
import com.foreveross.qdp.application.system.log.LogOperationApplication;
import com.foreveross.qdp.infra.vo.system.log.LogOperationVO;
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
 * LogOperation
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2018-07-03
 * @version 1.0.0
 * auto generate by qdp v5.0.
 */
@RestController
@RequestMapping("/api/LogOperation")
@Api("LogOperation Api")
public class LogOperationRSApplicationImpl {

    @Inject
    LogOperationApplication logOperationApplication;

    /**
     * <pre>
     * get LogOperationVO by id.
     * USAGE:
     *   GET /api/LogOperation/get/{id}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{LogOperationVO}}
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
    @ApiOperation(value = "get LogOperation by id", notes = "get LogOperation by id")
    @GetMapping("/get/{id}")
    public ResultBean getLogOperationById(@PathVariable String id) {
        try {
            return ResultBean.success().setBody(logOperationApplication.getLogOperationById(id));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find LogOperationVO.
     * USAGE:
     *   GET /api/LogOperation/page/{type}/{operator}/{target}/{startTime}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{LogOperationVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param type
     * @param operator
     * @param target
     * @param startTime
     * @param currentPage
     * @param pageSize
     * @param asc
     * @param desc
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0
     */
    @ApiOperation(value = "page find LogOperation", notes = "page find LogOperation")
    @GetMapping({"/page/{type}/{operator}/{target}/{startTime}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/page/{type}/{operator}/{target}/{startTime}/{currentPage}/{pageSize}",
            "/page/{type}/{operator}/{target}/{startTime}/{currentPage}",
            "/page/{type}/{operator}/{target}/{startTime}",
            "/page/{type}/{operator}/{target}",
            "/page/{type}/{operator}",
            "/page/{type}",
            "/page"})
    public ResultBean pageFindLogOperation(
                                       @PathVariable(required = false, value = "type") String type,
                                       @PathVariable(required = false, value = "operator") String operator,
                                       @PathVariable(required = false, value = "target") String target,
                                       @PathVariable(required = false, value = "startTime") String startTime,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("type", PreCheckHelper.equalsToNull(type, "-"));
                 map.put("operator", PreCheckHelper.equalsToNull(operator, "-"));
                 map.put("target", PreCheckHelper.equalsToNull(target, "-"));
                 map.put("startTime", PreCheckHelper.equalsToNull(startTime, "-"));
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
            LogOperationVO vo = BeanHelper.copyProperties(LogOperationVO.class, map);
            return ResultBean.success().setBody(logOperationApplication.pageFindLogOperation(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find LogOperationVO.
     * USAGE:
     *   GET /api/LogOperation/pageMap/{type}/{operator}/{target}/{startTime}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{LogOperationVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param type
     * @param operator
     * @param target
     * @param startTime
     * @param currentPage
     * @param pageSize
     * @param asc
     * @param desc
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0
     */
    @ApiOperation(value = "page find LogOperation", notes = "page find LogOperation")
    @GetMapping({"/pageMap/{type}/{operator}/{target}/{startTime}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/pageMap/{type}/{operator}/{target}/{startTime}/{currentPage}/{pageSize}",
            "/pageMap/{type}/{operator}/{target}/{startTime}/{currentPage}",
            "/pageMap/{type}/{operator}/{target}/{startTime}",
            "/pageMap/{type}/{operator}/{target}",
            "/pageMap/{type}/{operator}",
            "/pageMap/{type}",
            "/pageMap"})
    public ResultBean pageFindLogOperationMap(
                                       @PathVariable(required = false, value = "type") String type,
                                       @PathVariable(required = false, value = "operator") String operator,
                                       @PathVariable(required = false, value = "target") String target,
                                       @PathVariable(required = false, value = "startTime") String startTime,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("type", PreCheckHelper.equalsToNull(type, "-"));
                 map.put("operator", PreCheckHelper.equalsToNull(operator, "-"));
                 map.put("target", PreCheckHelper.equalsToNull(target, "-"));
                 map.put("startTime", PreCheckHelper.equalsToNull(startTime, "-"));
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
            LogOperationVO vo = BeanHelper.copyProperties(LogOperationVO.class, map);
            return ResultBean.success().setBody(logOperationApplication.pageFindLogOperationMap(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * add LogOperation.
     * USAGE:
     *   POST /api/LogOperation/
     *   {LogOperationVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{LogOperationVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return LogOperationVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "add LogOperation", notes = "add LogOperation")
    @PostMapping("/")
    public ResultBean addLogOperation(@RequestBody LogOperationVO vo) {
        try {
            return ResultBean.success().setBody(logOperationApplication.addLogOperation(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * update LogOperation.
     * USAGE:
     *   POST /api/LogOperation/
     *   {LogOperationVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{LogOperationVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return LogOperationVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "update LogOperation", notes = "update LogOperation")
    @PutMapping("/")
    public ResultBean updateLogOperation(@RequestBody LogOperationVO vo) {
        try {
            return ResultBean.success().setBody(logOperationApplication.updateLogOperation(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * remove LogOperation multi ids join by comma ','.
     * USAGE:
     *   DELETE /api/LogOperation/{id}
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
    @ApiOperation(value = "delete LogOperation", notes = "delete LogOperation")
    @DeleteMapping("/{id}")
    public ResultBean removeLogOperationById(@PathVariable String id) {
        try {
            if (id.indexOf(',') > -1) {
                logOperationApplication.removeLogOperationByIds(StringUtils.split(id, ','));
            } else {
                logOperationApplication.removeLogOperationById(id);
            }
            return ResultBean.success();
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
	
	
}
