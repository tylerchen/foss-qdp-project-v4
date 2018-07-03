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
import com.foreveross.qdp.application.system.auth.AuthRoleApplication;
import com.foreveross.qdp.infra.vo.system.auth.AuthRoleVO;
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
 * AuthRole
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2018-07-03
 * @version 1.0.0
 * auto generate by qdp v5.0.
 */
@RestController
@RequestMapping("/api/AuthRole")
@Api("AuthRole Api")
public class AuthRoleRSApplicationImpl {

    @Inject
    AuthRoleApplication authRoleApplication;

    /**
     * <pre>
     * get AuthRoleVO by id.
     * USAGE:
     *   GET /api/AuthRole/get/{id}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthRoleVO}}
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
    @ApiOperation(value = "get AuthRole by id", notes = "get AuthRole by id")
    @GetMapping("/get/{id}")
    public ResultBean getAuthRoleById(@PathVariable String id) {
        try {
            return ResultBean.success().setBody(authRoleApplication.getAuthRoleById(id));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find AuthRoleVO.
     * USAGE:
     *   GET /api/AuthRole/page/{name}/{code}/{status}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{AuthRoleVO}]}}
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
    @ApiOperation(value = "page find AuthRole", notes = "page find AuthRole")
    @GetMapping({"/page/{name}/{code}/{status}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/page/{name}/{code}/{status}/{currentPage}/{pageSize}",
            "/page/{name}/{code}/{status}/{currentPage}",
            "/page/{name}/{code}/{status}",
            "/page/{name}/{code}",
            "/page/{name}",
            "/page"})
    public ResultBean pageFindAuthRole(
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
            AuthRoleVO vo = BeanHelper.copyProperties(AuthRoleVO.class, map);
            return ResultBean.success().setBody(authRoleApplication.pageFindAuthRole(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find AuthRoleVO.
     * USAGE:
     *   GET /api/AuthRole/pageMap/{name}/{code}/{status}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{AuthRoleVO}]}}
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
    @ApiOperation(value = "page find AuthRole", notes = "page find AuthRole")
    @GetMapping({"/pageMap/{name}/{code}/{status}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/pageMap/{name}/{code}/{status}/{currentPage}/{pageSize}",
            "/pageMap/{name}/{code}/{status}/{currentPage}",
            "/pageMap/{name}/{code}/{status}",
            "/pageMap/{name}/{code}",
            "/pageMap/{name}",
            "/pageMap"})
    public ResultBean pageFindAuthRoleMap(
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
            AuthRoleVO vo = BeanHelper.copyProperties(AuthRoleVO.class, map);
            return ResultBean.success().setBody(authRoleApplication.pageFindAuthRoleMap(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * add AuthRole.
     * USAGE:
     *   POST /api/AuthRole/
     *   {AuthRoleVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthRoleVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return AuthRoleVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "add AuthRole", notes = "add AuthRole")
    @PostMapping("/")
    public ResultBean addAuthRole(@RequestBody AuthRoleVO vo) {
        try {
            return ResultBean.success().setBody(authRoleApplication.addAuthRole(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * update AuthRole.
     * USAGE:
     *   POST /api/AuthRole/
     *   {AuthRoleVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthRoleVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return AuthRoleVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "update AuthRole", notes = "update AuthRole")
    @PutMapping("/")
    public ResultBean updateAuthRole(@RequestBody AuthRoleVO vo) {
        try {
            return ResultBean.success().setBody(authRoleApplication.updateAuthRole(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * remove AuthRole multi ids join by comma ','.
     * USAGE:
     *   DELETE /api/AuthRole/{id}
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
    @ApiOperation(value = "delete AuthRole", notes = "delete AuthRole")
    @DeleteMapping("/{id}")
    public ResultBean removeAuthRoleById(@PathVariable String id) {
        try {
            if (id.indexOf(',') > -1) {
                authRoleApplication.removeAuthRoleByIds(StringUtils.split(id, ','));
            } else {
                authRoleApplication.removeAuthRoleById(id);
            }
            return ResultBean.success();
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
    /**
     * <pre>
     * get AuthRole by unique name
     * USAGE:
     *   GET /api/AuthRole/get/name/{name}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthRoleVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "get AuthRole by name", notes = "get AuthRole by name")
    @GetMapping("/get/name/{name}")
    public ResultBean getByName(@PathVariable String name) {
        try {
            return ResultBean.success().setBody(authRoleApplication.getByName(name));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
    /**
     * <pre>
     * get AuthRole by unique name
     * USAGE:
     *   GET /api/AuthRole/get/code/{code}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthRoleVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "get AuthRole by code", notes = "get AuthRole by code")
    @GetMapping("/get/code/{code}")
    public ResultBean getByCode(@PathVariable String code) {
        try {
            return ResultBean.success().setBody(authRoleApplication.getByCode(code));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
	

	
    /**
     * <pre>
     * page find assign AuthResourceVO.
     * USAGE:
     *   GET /api/AuthRole/pageAssignAuthResource/{name}/{code}/{status}/{currentPage}/{pageSize}/{asc}/{desc}
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
    @ApiOperation(value = "page find assign AuthResource", notes = "page find assign AuthResource")
    @GetMapping({"/pageAssignAuthResource/{name}/{code}/{status}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/pageAssignAuthResource/{name}/{code}/{status}/{currentPage}/{pageSize}",
            "/pageAssignAuthResource/{name}/{code}/{status}/{currentPage}",
            "/pageAssignAuthResource/{name}/{code}/{status}",
            "/pageAssignAuthResource/{name}/{code}",
            "/pageAssignAuthResource/{name}",
            "/pageAssignAuthResource"})
    public ResultBean pageFindAssignAuthResource(
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
            AuthRoleVO vo = BeanHelper.copyProperties(AuthRoleVO.class, map);
            return ResultBean.success().setBody(authRoleApplication.pageFindAssignAuthResource(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * assign AuthResource by id(s).
     * USAGE:
     *   POST /api/AuthRole/assignAuthResource
     *   {AuthRoleVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "assign AuthResource by id(s)", notes = "assign AuthResource by id(s)")
    @PostMapping("/assignAuthResource")
	public ResultBean assignAuthResource(AuthRoleVO vo) {
        try {
            authRoleApplication.assignAuthResource(vo);
            return ResultBean.success();
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
	}

	
    /**
     * <pre>
     * page find assign AuthMenuVO.
     * USAGE:
     *   GET /api/AuthRole/pageAssignAuthMenu/{name}/{code}/{status}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{AuthMenuVO}]}}
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
    @ApiOperation(value = "page find assign AuthMenu", notes = "page find assign AuthMenu")
    @GetMapping({"/pageAssignAuthMenu/{name}/{code}/{status}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/pageAssignAuthMenu/{name}/{code}/{status}/{currentPage}/{pageSize}",
            "/pageAssignAuthMenu/{name}/{code}/{status}/{currentPage}",
            "/pageAssignAuthMenu/{name}/{code}/{status}",
            "/pageAssignAuthMenu/{name}/{code}",
            "/pageAssignAuthMenu/{name}",
            "/pageAssignAuthMenu"})
    public ResultBean pageFindAssignAuthMenu(
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
            AuthRoleVO vo = BeanHelper.copyProperties(AuthRoleVO.class, map);
            return ResultBean.success().setBody(authRoleApplication.pageFindAssignAuthMenu(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * assign AuthMenu by id(s).
     * USAGE:
     *   POST /api/AuthRole/assignAuthMenu
     *   {AuthRoleVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "assign AuthMenu by id(s)", notes = "assign AuthMenu by id(s)")
    @PostMapping("/assignAuthMenu")
	public ResultBean assignAuthMenu(AuthRoleVO vo) {
        try {
            authRoleApplication.assignAuthMenu(vo);
            return ResultBean.success();
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
	}
	
}
