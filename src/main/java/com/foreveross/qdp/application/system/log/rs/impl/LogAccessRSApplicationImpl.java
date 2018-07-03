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
import com.foreveross.qdp.application.system.log.LogAccessApplication;
import com.foreveross.qdp.infra.vo.system.log.LogAccessVO;
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
 * LogAccess
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2018-07-03
 * @version 1.0.0
 * auto generate by qdp v5.0.
 */
@RestController
@RequestMapping("/api/LogAccess")
@Api("LogAccess Api")
public class LogAccessRSApplicationImpl {

    @Inject
    LogAccessApplication logAccessApplication;

    /**
     * <pre>
     * get LogAccessVO by id.
     * USAGE:
     *   GET /api/LogAccess/get/{id}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{LogAccessVO}}
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
    @ApiOperation(value = "get LogAccess by id", notes = "get LogAccess by id")
    @GetMapping("/get/{id}")
    public ResultBean getLogAccessById(@PathVariable String id) {
        try {
            return ResultBean.success().setBody(logAccessApplication.getLogAccessById(id));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find LogAccessVO.
     * USAGE:
     *   GET /api/LogAccess/page/{type}/{user}/{source}/{target}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{LogAccessVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param type
     * @param user
     * @param source
     * @param target
     * @param currentPage
     * @param pageSize
     * @param asc
     * @param desc
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0
     */
    @ApiOperation(value = "page find LogAccess", notes = "page find LogAccess")
    @GetMapping({"/page/{type}/{user}/{source}/{target}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/page/{type}/{user}/{source}/{target}/{currentPage}/{pageSize}",
            "/page/{type}/{user}/{source}/{target}/{currentPage}",
            "/page/{type}/{user}/{source}/{target}",
            "/page/{type}/{user}/{source}",
            "/page/{type}/{user}",
            "/page/{type}",
            "/page"})
    public ResultBean pageFindLogAccess(
                                       @PathVariable(required = false, value = "type") String type,
                                       @PathVariable(required = false, value = "user") String user,
                                       @PathVariable(required = false, value = "source") String source,
                                       @PathVariable(required = false, value = "target") String target,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("type", PreCheckHelper.equalsToNull(type, "-"));
                 map.put("user", PreCheckHelper.equalsToNull(user, "-"));
                 map.put("source", PreCheckHelper.equalsToNull(source, "-"));
                 map.put("target", PreCheckHelper.equalsToNull(target, "-"));
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
            LogAccessVO vo = BeanHelper.copyProperties(LogAccessVO.class, map);
            return ResultBean.success().setBody(logAccessApplication.pageFindLogAccess(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find LogAccessVO.
     * USAGE:
     *   GET /api/LogAccess/pageMap/{type}/{user}/{source}/{target}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{LogAccessVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param type
     * @param user
     * @param source
     * @param target
     * @param currentPage
     * @param pageSize
     * @param asc
     * @param desc
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0
     */
    @ApiOperation(value = "page find LogAccess", notes = "page find LogAccess")
    @GetMapping({"/pageMap/{type}/{user}/{source}/{target}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/pageMap/{type}/{user}/{source}/{target}/{currentPage}/{pageSize}",
            "/pageMap/{type}/{user}/{source}/{target}/{currentPage}",
            "/pageMap/{type}/{user}/{source}/{target}",
            "/pageMap/{type}/{user}/{source}",
            "/pageMap/{type}/{user}",
            "/pageMap/{type}",
            "/pageMap"})
    public ResultBean pageFindLogAccessMap(
                                       @PathVariable(required = false, value = "type") String type,
                                       @PathVariable(required = false, value = "user") String user,
                                       @PathVariable(required = false, value = "source") String source,
                                       @PathVariable(required = false, value = "target") String target,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("type", PreCheckHelper.equalsToNull(type, "-"));
                 map.put("user", PreCheckHelper.equalsToNull(user, "-"));
                 map.put("source", PreCheckHelper.equalsToNull(source, "-"));
                 map.put("target", PreCheckHelper.equalsToNull(target, "-"));
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
            LogAccessVO vo = BeanHelper.copyProperties(LogAccessVO.class, map);
            return ResultBean.success().setBody(logAccessApplication.pageFindLogAccessMap(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * add LogAccess.
     * USAGE:
     *   POST /api/LogAccess/
     *   {LogAccessVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{LogAccessVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return LogAccessVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "add LogAccess", notes = "add LogAccess")
    @PostMapping("/")
    public ResultBean addLogAccess(@RequestBody LogAccessVO vo) {
        try {
            return ResultBean.success().setBody(logAccessApplication.addLogAccess(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * update LogAccess.
     * USAGE:
     *   POST /api/LogAccess/
     *   {LogAccessVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{LogAccessVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return LogAccessVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "update LogAccess", notes = "update LogAccess")
    @PutMapping("/")
    public ResultBean updateLogAccess(@RequestBody LogAccessVO vo) {
        try {
            return ResultBean.success().setBody(logAccessApplication.updateLogAccess(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * remove LogAccess multi ids join by comma ','.
     * USAGE:
     *   DELETE /api/LogAccess/{id}
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
    @ApiOperation(value = "delete LogAccess", notes = "delete LogAccess")
    @DeleteMapping("/{id}")
    public ResultBean removeLogAccessById(@PathVariable String id) {
        try {
            if (id.indexOf(',') > -1) {
                logAccessApplication.removeLogAccessByIds(StringUtils.split(id, ','));
            } else {
                logAccessApplication.removeLogAccessById(id);
            }
            return ResultBean.success();
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
	
	
}
