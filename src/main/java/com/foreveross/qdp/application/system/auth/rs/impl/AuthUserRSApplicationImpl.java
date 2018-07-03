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
import com.foreveross.qdp.application.system.auth.AuthUserApplication;
import com.foreveross.qdp.infra.vo.system.auth.AuthUserVO;
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
 * AuthUser
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2018-07-03
 * @version 1.0.0
 * auto generate by qdp v5.0.
 */
@RestController
@RequestMapping("/api/AuthUser")
@Api("AuthUser Api")
public class AuthUserRSApplicationImpl {

    @Inject
    AuthUserApplication authUserApplication;

    /**
     * <pre>
     * get AuthUserVO by id.
     * USAGE:
     *   GET /api/AuthUser/get/{id}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthUserVO}}
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
    @ApiOperation(value = "get AuthUser by id", notes = "get AuthUser by id")
    @GetMapping("/get/{id}")
    public ResultBean getAuthUserById(@PathVariable String id) {
        try {
            return ResultBean.success().setBody(authUserApplication.getAuthUserById(id));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find AuthUserVO.
     * USAGE:
     *   GET /api/AuthUser/page/{name}/{status}/{email}/{sex}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{AuthUserVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param name
     * @param status
     * @param email
     * @param sex
     * @param currentPage
     * @param pageSize
     * @param asc
     * @param desc
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0
     */
    @ApiOperation(value = "page find AuthUser", notes = "page find AuthUser")
    @GetMapping({"/page/{name}/{status}/{email}/{sex}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/page/{name}/{status}/{email}/{sex}/{currentPage}/{pageSize}",
            "/page/{name}/{status}/{email}/{sex}/{currentPage}",
            "/page/{name}/{status}/{email}/{sex}",
            "/page/{name}/{status}/{email}",
            "/page/{name}/{status}",
            "/page/{name}",
            "/page"})
    public ResultBean pageFindAuthUser(
                                       @PathVariable(required = false, value = "name") String name,
                                       @PathVariable(required = false, value = "status") String status,
                                       @PathVariable(required = false, value = "email") String email,
                                       @PathVariable(required = false, value = "sex") String sex,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("name", PreCheckHelper.equalsToNull(name, "-"));
                 map.put("status", PreCheckHelper.equalsToNull(status, "-"));
                 map.put("email", PreCheckHelper.equalsToNull(email, "-"));
                 map.put("sex", PreCheckHelper.equalsToNull(sex, "-"));
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
            AuthUserVO vo = BeanHelper.copyProperties(AuthUserVO.class, map);
            return ResultBean.success().setBody(authUserApplication.pageFindAuthUser(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find AuthUserVO.
     * USAGE:
     *   GET /api/AuthUser/pageMap/{name}/{status}/{email}/{sex}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{AuthUserVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param name
     * @param status
     * @param email
     * @param sex
     * @param currentPage
     * @param pageSize
     * @param asc
     * @param desc
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0
     */
    @ApiOperation(value = "page find AuthUser", notes = "page find AuthUser")
    @GetMapping({"/pageMap/{name}/{status}/{email}/{sex}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/pageMap/{name}/{status}/{email}/{sex}/{currentPage}/{pageSize}",
            "/pageMap/{name}/{status}/{email}/{sex}/{currentPage}",
            "/pageMap/{name}/{status}/{email}/{sex}",
            "/pageMap/{name}/{status}/{email}",
            "/pageMap/{name}/{status}",
            "/pageMap/{name}",
            "/pageMap"})
    public ResultBean pageFindAuthUserMap(
                                       @PathVariable(required = false, value = "name") String name,
                                       @PathVariable(required = false, value = "status") String status,
                                       @PathVariable(required = false, value = "email") String email,
                                       @PathVariable(required = false, value = "sex") String sex,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("name", PreCheckHelper.equalsToNull(name, "-"));
                 map.put("status", PreCheckHelper.equalsToNull(status, "-"));
                 map.put("email", PreCheckHelper.equalsToNull(email, "-"));
                 map.put("sex", PreCheckHelper.equalsToNull(sex, "-"));
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
            AuthUserVO vo = BeanHelper.copyProperties(AuthUserVO.class, map);
            return ResultBean.success().setBody(authUserApplication.pageFindAuthUserMap(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * add AuthUser.
     * USAGE:
     *   POST /api/AuthUser/
     *   {AuthUserVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthUserVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return AuthUserVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "add AuthUser", notes = "add AuthUser")
    @PostMapping("/")
    public ResultBean addAuthUser(@RequestBody AuthUserVO vo) {
        try {
            return ResultBean.success().setBody(authUserApplication.addAuthUser(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * update AuthUser.
     * USAGE:
     *   POST /api/AuthUser/
     *   {AuthUserVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthUserVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return AuthUserVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "update AuthUser", notes = "update AuthUser")
    @PutMapping("/")
    public ResultBean updateAuthUser(@RequestBody AuthUserVO vo) {
        try {
            return ResultBean.success().setBody(authUserApplication.updateAuthUser(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * remove AuthUser multi ids join by comma ','.
     * USAGE:
     *   DELETE /api/AuthUser/{id}
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
    @ApiOperation(value = "delete AuthUser", notes = "delete AuthUser")
    @DeleteMapping("/{id}")
    public ResultBean removeAuthUserById(@PathVariable String id) {
        try {
            if (id.indexOf(',') > -1) {
                authUserApplication.removeAuthUserByIds(StringUtils.split(id, ','));
            } else {
                authUserApplication.removeAuthUserById(id);
            }
            return ResultBean.success();
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
    /**
     * <pre>
     * get AuthUser by unique name
     * USAGE:
     *   GET /api/AuthUser/get/name/{name}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthUserVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "get AuthUser by name", notes = "get AuthUser by name")
    @GetMapping("/get/name/{name}")
    public ResultBean getByName(@PathVariable String name) {
        try {
            return ResultBean.success().setBody(authUserApplication.getByName(name));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
    /**
     * <pre>
     * get AuthUser by unique name
     * USAGE:
     *   GET /api/AuthUser/get/email/{email}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthUserVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "get AuthUser by email", notes = "get AuthUser by email")
    @GetMapping("/get/email/{email}")
    public ResultBean getByEmail(@PathVariable String email) {
        try {
            return ResultBean.success().setBody(authUserApplication.getByEmail(email));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
	
	
}
