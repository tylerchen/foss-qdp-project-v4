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
import com.foreveross.qdp.application.system.auth.AuthOrganizationApplication;
import com.foreveross.qdp.infra.vo.system.auth.AuthOrganizationVO;
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
 * AuthOrganization
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2018-07-03
 * @version 1.0.0
 * auto generate by qdp v5.0.
 */
@RestController
@RequestMapping("/api/AuthOrganization")
@Api("AuthOrganization Api")
public class AuthOrganizationRSApplicationImpl {

    @Inject
    AuthOrganizationApplication authOrganizationApplication;

    /**
     * <pre>
     * get AuthOrganizationVO by id.
     * USAGE:
     *   GET /api/AuthOrganization/get/{id}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthOrganizationVO}}
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
    @ApiOperation(value = "get AuthOrganization by id", notes = "get AuthOrganization by id")
    @GetMapping("/get/{id}")
    public ResultBean getAuthOrganizationById(@PathVariable String id) {
        try {
            return ResultBean.success().setBody(authOrganizationApplication.getAuthOrganizationById(id));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find AuthOrganizationVO.
     * USAGE:
     *   GET /api/AuthOrganization/page/{name}/{code}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{AuthOrganizationVO}]}}
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
    @ApiOperation(value = "page find AuthOrganization", notes = "page find AuthOrganization")
    @GetMapping({"/page/{name}/{code}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/page/{name}/{code}/{currentPage}/{pageSize}",
            "/page/{name}/{code}/{currentPage}",
            "/page/{name}/{code}",
            "/page/{name}",
            "/page"})
    public ResultBean pageFindAuthOrganization(
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
            AuthOrganizationVO vo = BeanHelper.copyProperties(AuthOrganizationVO.class, map);
            return ResultBean.success().setBody(authOrganizationApplication.pageFindAuthOrganization(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find AuthOrganizationVO.
     * USAGE:
     *   GET /api/AuthOrganization/pageMap/{name}/{code}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{AuthOrganizationVO}]}}
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
    @ApiOperation(value = "page find AuthOrganization", notes = "page find AuthOrganization")
    @GetMapping({"/pageMap/{name}/{code}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/pageMap/{name}/{code}/{currentPage}/{pageSize}",
            "/pageMap/{name}/{code}/{currentPage}",
            "/pageMap/{name}/{code}",
            "/pageMap/{name}",
            "/pageMap"})
    public ResultBean pageFindAuthOrganizationMap(
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
            AuthOrganizationVO vo = BeanHelper.copyProperties(AuthOrganizationVO.class, map);
            return ResultBean.success().setBody(authOrganizationApplication.pageFindAuthOrganizationMap(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * add AuthOrganization.
     * USAGE:
     *   POST /api/AuthOrganization/
     *   {AuthOrganizationVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthOrganizationVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return AuthOrganizationVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "add AuthOrganization", notes = "add AuthOrganization")
    @PostMapping("/")
    public ResultBean addAuthOrganization(@RequestBody AuthOrganizationVO vo) {
        try {
            return ResultBean.success().setBody(authOrganizationApplication.addAuthOrganization(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * update AuthOrganization.
     * USAGE:
     *   POST /api/AuthOrganization/
     *   {AuthOrganizationVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthOrganizationVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return AuthOrganizationVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "update AuthOrganization", notes = "update AuthOrganization")
    @PutMapping("/")
    public ResultBean updateAuthOrganization(@RequestBody AuthOrganizationVO vo) {
        try {
            return ResultBean.success().setBody(authOrganizationApplication.updateAuthOrganization(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * remove AuthOrganization multi ids join by comma ','.
     * USAGE:
     *   DELETE /api/AuthOrganization/{id}
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
    @ApiOperation(value = "delete AuthOrganization", notes = "delete AuthOrganization")
    @DeleteMapping("/{id}")
    public ResultBean removeAuthOrganizationById(@PathVariable String id) {
        try {
            if (id.indexOf(',') > -1) {
                authOrganizationApplication.removeAuthOrganizationByIds(StringUtils.split(id, ','));
            } else {
                authOrganizationApplication.removeAuthOrganizationById(id);
            }
            return ResultBean.success();
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
    /**
     * <pre>
     * get AuthOrganization by unique name
     * USAGE:
     *   GET /api/AuthOrganization/get/name/{name}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthOrganizationVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "get AuthOrganization by name", notes = "get AuthOrganization by name")
    @GetMapping("/get/name/{name}")
    public ResultBean getByName(@PathVariable String name) {
        try {
            return ResultBean.success().setBody(authOrganizationApplication.getByName(name));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
    /**
     * <pre>
     * get AuthOrganization by unique name
     * USAGE:
     *   GET /api/AuthOrganization/get/code/{code}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthOrganizationVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "get AuthOrganization by code", notes = "get AuthOrganization by code")
    @GetMapping("/get/code/{code}")
    public ResultBean getByCode(@PathVariable String code) {
        try {
            return ResultBean.success().setBody(authOrganizationApplication.getByCode(code));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
	

	
    /**
     * <pre>
     * page find assign AuthMenuVO.
     * USAGE:
     *   GET /api/AuthOrganization/pageAssignAuthMenu/{name}/{code}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{AuthMenuVO}]}}
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
    @ApiOperation(value = "page find assign AuthMenu", notes = "page find assign AuthMenu")
    @GetMapping({"/pageAssignAuthMenu/{name}/{code}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/pageAssignAuthMenu/{name}/{code}/{currentPage}/{pageSize}",
            "/pageAssignAuthMenu/{name}/{code}/{currentPage}",
            "/pageAssignAuthMenu/{name}/{code}",
            "/pageAssignAuthMenu/{name}",
            "/pageAssignAuthMenu"})
    public ResultBean pageFindAssignAuthMenu(
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
            AuthOrganizationVO vo = BeanHelper.copyProperties(AuthOrganizationVO.class, map);
            return ResultBean.success().setBody(authOrganizationApplication.pageFindAssignAuthMenu(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * assign AuthMenu by id(s).
     * USAGE:
     *   POST /api/AuthOrganization/assignAuthMenu
     *   {AuthOrganizationVO}
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
	public ResultBean assignAuthMenu(AuthOrganizationVO vo) {
        try {
            authOrganizationApplication.assignAuthMenu(vo);
            return ResultBean.success();
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
	}

	
    /**
     * <pre>
     * page find assign AuthUserVO.
     * USAGE:
     *   GET /api/AuthOrganization/pageAssignAuthUser/{name}/{code}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{AuthUserVO}]}}
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
    @ApiOperation(value = "page find assign AuthUser", notes = "page find assign AuthUser")
    @GetMapping({"/pageAssignAuthUser/{name}/{code}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/pageAssignAuthUser/{name}/{code}/{currentPage}/{pageSize}",
            "/pageAssignAuthUser/{name}/{code}/{currentPage}",
            "/pageAssignAuthUser/{name}/{code}",
            "/pageAssignAuthUser/{name}",
            "/pageAssignAuthUser"})
    public ResultBean pageFindAssignAuthUser(
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
            AuthOrganizationVO vo = BeanHelper.copyProperties(AuthOrganizationVO.class, map);
            return ResultBean.success().setBody(authOrganizationApplication.pageFindAssignAuthUser(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * assign AuthUser by id(s).
     * USAGE:
     *   POST /api/AuthOrganization/assignAuthUser
     *   {AuthOrganizationVO}
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
    @ApiOperation(value = "assign AuthUser by id(s)", notes = "assign AuthUser by id(s)")
    @PostMapping("/assignAuthUser")
	public ResultBean assignAuthUser(AuthOrganizationVO vo) {
        try {
            authOrganizationApplication.assignAuthUser(vo);
            return ResultBean.success();
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
	}

	
    /**
     * <pre>
     * page find assign AuthRoleVO.
     * USAGE:
     *   GET /api/AuthOrganization/pageAssignAuthRole/{name}/{code}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{AuthRoleVO}]}}
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
    @ApiOperation(value = "page find assign AuthRole", notes = "page find assign AuthRole")
    @GetMapping({"/pageAssignAuthRole/{name}/{code}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/pageAssignAuthRole/{name}/{code}/{currentPage}/{pageSize}",
            "/pageAssignAuthRole/{name}/{code}/{currentPage}",
            "/pageAssignAuthRole/{name}/{code}",
            "/pageAssignAuthRole/{name}",
            "/pageAssignAuthRole"})
    public ResultBean pageFindAssignAuthRole(
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
            AuthOrganizationVO vo = BeanHelper.copyProperties(AuthOrganizationVO.class, map);
            return ResultBean.success().setBody(authOrganizationApplication.pageFindAssignAuthRole(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * assign AuthRole by id(s).
     * USAGE:
     *   POST /api/AuthOrganization/assignAuthRole
     *   {AuthOrganizationVO}
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
    @ApiOperation(value = "assign AuthRole by id(s)", notes = "assign AuthRole by id(s)")
    @PostMapping("/assignAuthRole")
	public ResultBean assignAuthRole(AuthOrganizationVO vo) {
        try {
            authOrganizationApplication.assignAuthRole(vo);
            return ResultBean.success();
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
	}
	
}
