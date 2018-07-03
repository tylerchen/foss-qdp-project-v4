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
import com.foreveross.qdp.application.system.common.SysI18nApplication;
import com.foreveross.qdp.infra.vo.system.common.SysI18nVO;
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
 * SysI18n
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2018-07-03
 * @version 1.0.0
 * auto generate by qdp v5.0.
 */
@RestController
@RequestMapping("/api/SysI18n")
@Api("SysI18n Api")
public class SysI18nRSApplicationImpl {

    @Inject
    SysI18nApplication sysI18nApplication;

    /**
     * <pre>
     * get SysI18nVO by id.
     * USAGE:
     *   GET /api/SysI18n/get/{id}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysI18nVO}}
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
    @ApiOperation(value = "get SysI18n by id", notes = "get SysI18n by id")
    @GetMapping("/get/{id}")
    public ResultBean getSysI18nById(@PathVariable String id) {
        try {
            return ResultBean.success().setBody(sysI18nApplication.getSysI18nById(id));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find SysI18nVO.
     * USAGE:
     *   GET /api/SysI18n/page/{messageKey}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{SysI18nVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param messageKey
     * @param currentPage
     * @param pageSize
     * @param asc
     * @param desc
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0
     */
    @ApiOperation(value = "page find SysI18n", notes = "page find SysI18n")
    @GetMapping({"/page/{messageKey}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/page/{messageKey}/{currentPage}/{pageSize}",
            "/page/{messageKey}/{currentPage}",
            "/page/{messageKey}",
            "/page"})
    public ResultBean pageFindSysI18n(
                                       @PathVariable(required = false, value = "messageKey") String messageKey,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("messageKey", PreCheckHelper.equalsToNull(messageKey, "-"));
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
            SysI18nVO vo = BeanHelper.copyProperties(SysI18nVO.class, map);
            return ResultBean.success().setBody(sysI18nApplication.pageFindSysI18n(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find SysI18nVO.
     * USAGE:
     *   GET /api/SysI18n/pageMap/{messageKey}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{SysI18nVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param messageKey
     * @param currentPage
     * @param pageSize
     * @param asc
     * @param desc
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0
     */
    @ApiOperation(value = "page find SysI18n", notes = "page find SysI18n")
    @GetMapping({"/pageMap/{messageKey}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/pageMap/{messageKey}/{currentPage}/{pageSize}",
            "/pageMap/{messageKey}/{currentPage}",
            "/pageMap/{messageKey}",
            "/pageMap"})
    public ResultBean pageFindSysI18nMap(
                                       @PathVariable(required = false, value = "messageKey") String messageKey,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("messageKey", PreCheckHelper.equalsToNull(messageKey, "-"));
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
            SysI18nVO vo = BeanHelper.copyProperties(SysI18nVO.class, map);
            return ResultBean.success().setBody(sysI18nApplication.pageFindSysI18nMap(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * add SysI18n.
     * USAGE:
     *   POST /api/SysI18n/
     *   {SysI18nVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysI18nVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return SysI18nVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "add SysI18n", notes = "add SysI18n")
    @PostMapping("/")
    public ResultBean addSysI18n(@RequestBody SysI18nVO vo) {
        try {
            return ResultBean.success().setBody(sysI18nApplication.addSysI18n(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * update SysI18n.
     * USAGE:
     *   POST /api/SysI18n/
     *   {SysI18nVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysI18nVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return SysI18nVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "update SysI18n", notes = "update SysI18n")
    @PutMapping("/")
    public ResultBean updateSysI18n(@RequestBody SysI18nVO vo) {
        try {
            return ResultBean.success().setBody(sysI18nApplication.updateSysI18n(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * remove SysI18n multi ids join by comma ','.
     * USAGE:
     *   DELETE /api/SysI18n/{id}
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
    @ApiOperation(value = "delete SysI18n", notes = "delete SysI18n")
    @DeleteMapping("/{id}")
    public ResultBean removeSysI18nById(@PathVariable String id) {
        try {
            if (id.indexOf(',') > -1) {
                sysI18nApplication.removeSysI18nByIds(StringUtils.split(id, ','));
            } else {
                sysI18nApplication.removeSysI18nById(id);
            }
            return ResultBean.success();
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
    /**
     * <pre>
     * get SysI18n by unique name
     * USAGE:
     *   GET /api/SysI18n/get/messageKey/{messageKey}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{SysI18nVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "get SysI18n by messageKey", notes = "get SysI18n by messageKey")
    @GetMapping("/get/messageKey/{messageKey}")
    public ResultBean getByMessageKey(@PathVariable String messageKey) {
        try {
            return ResultBean.success().setBody(sysI18nApplication.getByMessageKey(messageKey));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
	
	
}
