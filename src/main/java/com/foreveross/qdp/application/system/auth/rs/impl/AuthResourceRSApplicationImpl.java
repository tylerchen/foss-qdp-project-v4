/*******************************************************************************
 * Copyright (c) 2018-07-03 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation.
 * Auto Generate By foreveross.com Quick Deliver Platform. 
 ******************************************************************************/
package com.foreveross.qdp.application.system.auth.rs.impl;

import com.foreveross.common.ResultBean;
import com.foreveross.qdp.application.system.auth.AuthResourceApplication;
import com.foreveross.qdp.infra.vo.system.auth.AuthResourceVO;
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
 * AuthResource
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2018-07-03
 * @version 1.0.0
 * auto generate by qdp v5.0.
 */
@RestController
@RequestMapping("/api/AuthResource")
@Api("AuthResource Api")
public class AuthResourceRSApplicationImpl {

    @Inject
    AuthResourceApplication authResourceApplication;

    /**
     * <pre>
     * get AuthResourceVO by id.
     * USAGE:
     *   GET /api/AuthResource/get/{id}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthResourceVO}}
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
    @ApiOperation(value = "get AuthResource by id", notes = "get AuthResource by id")
    @GetMapping("/get/{id}")
    public ResultBean getAuthResourceById(@PathVariable String id) {
        try {
            return ResultBean.success().setBody(authResourceApplication.getAuthResourceById(id));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find AuthResourceVO.
     * USAGE:
     *   GET /api/AuthResource/page/{name}/{code}/{status}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{AuthResourceVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param name
     * @param code
     * @param status
     * @param currentPage
     * @param pageSize
     * @param asc
     * @param desc
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0
     */
    @ApiOperation(value = "page find AuthResource", notes = "page find AuthResource")
    @GetMapping({"/page/{name}/{code}/{status}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/page/{name}/{code}/{status}/{currentPage}/{pageSize}",
            "/page/{name}/{code}/{status}/{currentPage}",
            "/page/{name}/{code}/{status}",
            "/page/{name}/{code}",
            "/page/{name}",
            "/page"})
    public ResultBean pageFindAuthResource(
                                       @PathVariable(required = false, value = "name") String name,
                                       @PathVariable(required = false, value = "code") String code,
                                       @PathVariable(required = false, value = "status") String status,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("name", PreCheckHelper.equalsToNull(name, "-"));
                 map.put("code", PreCheckHelper.equalsToNull(code, "-"));
                 map.put("status", PreCheckHelper.equalsToNull(status, "-"));
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
            AuthResourceVO vo = BeanHelper.copyProperties(AuthResourceVO.class, map);
            return ResultBean.success().setBody(authResourceApplication.pageFindAuthResource(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find AuthResourceVO.
     * USAGE:
     *   GET /api/AuthResource/pageMap/{name}/{code}/{status}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{AuthResourceVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param name
     * @param code
     * @param status
     * @param currentPage
     * @param pageSize
     * @param asc
     * @param desc
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0
     */
    @ApiOperation(value = "page find AuthResource", notes = "page find AuthResource")
    @GetMapping({"/pageMap/{name}/{code}/{status}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/pageMap/{name}/{code}/{status}/{currentPage}/{pageSize}",
            "/pageMap/{name}/{code}/{status}/{currentPage}",
            "/pageMap/{name}/{code}/{status}",
            "/pageMap/{name}/{code}",
            "/pageMap/{name}",
            "/pageMap"})
    public ResultBean pageFindAuthResourceMap(
                                       @PathVariable(required = false, value = "name") String name,
                                       @PathVariable(required = false, value = "code") String code,
                                       @PathVariable(required = false, value = "status") String status,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("name", PreCheckHelper.equalsToNull(name, "-"));
                 map.put("code", PreCheckHelper.equalsToNull(code, "-"));
                 map.put("status", PreCheckHelper.equalsToNull(status, "-"));
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
            AuthResourceVO vo = BeanHelper.copyProperties(AuthResourceVO.class, map);
            return ResultBean.success().setBody(authResourceApplication.pageFindAuthResourceMap(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * add AuthResource.
     * USAGE:
     *   POST /api/AuthResource/
     *   {AuthResourceVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthResourceVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return AuthResourceVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "add AuthResource", notes = "add AuthResource")
    @PostMapping("/")
    public ResultBean addAuthResource(@RequestBody AuthResourceVO vo) {
        try {
            return ResultBean.success().setBody(authResourceApplication.addAuthResource(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * update AuthResource.
     * USAGE:
     *   POST /api/AuthResource/
     *   {AuthResourceVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthResourceVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return AuthResourceVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "update AuthResource", notes = "update AuthResource")
    @PutMapping("/")
    public ResultBean updateAuthResource(@RequestBody AuthResourceVO vo) {
        try {
            return ResultBean.success().setBody(authResourceApplication.updateAuthResource(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * remove AuthResource multi ids join by comma ','.
     * USAGE:
     *   DELETE /api/AuthResource/{id}
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
    @ApiOperation(value = "delete AuthResource", notes = "delete AuthResource")
    @DeleteMapping("/{id}")
    public ResultBean removeAuthResourceById(@PathVariable String id) {
        try {
            if (id.indexOf(',') > -1) {
                authResourceApplication.removeAuthResourceByIds(StringUtils.split(id, ','));
            } else {
                authResourceApplication.removeAuthResourceById(id);
            }
            return ResultBean.success();
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
    /**
     * <pre>
     * get AuthResource by unique name
     * USAGE:
     *   GET /api/AuthResource/get/name/{name}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthResourceVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "get AuthResource by name", notes = "get AuthResource by name")
    @GetMapping("/get/name/{name}")
    public ResultBean getByName(@PathVariable String name) {
        try {
            return ResultBean.success().setBody(authResourceApplication.getByName(name));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
    /**
     * <pre>
     * get AuthResource by unique name
     * USAGE:
     *   GET /api/AuthResource/get/code/{code}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthResourceVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "get AuthResource by code", notes = "get AuthResource by code")
    @GetMapping("/get/code/{code}")
    public ResultBean getByCode(@PathVariable String code) {
        try {
            return ResultBean.success().setBody(authResourceApplication.getByCode(code));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
	
	
}
