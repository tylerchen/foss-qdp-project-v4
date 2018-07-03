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
import com.foreveross.qdp.application.system.auth.AuthAccountApplication;
import com.foreveross.qdp.infra.vo.system.auth.AuthAccountVO;
import com.foreveross.qdp.infra.vo.system.auth.EditPasswordVO;
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
 * AuthAccount
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2018-07-03
 * @version 1.0.0
 * auto generate by qdp v5.0.
 */
@RestController
@RequestMapping("/api/AuthAccount")
@Api("AuthAccount Api")
public class AuthAccountRSApplicationImpl {

    @Inject
    AuthAccountApplication authAccountApplication;

    /**
     * <pre>
     * get AuthAccountVO by id.
     * USAGE:
     *   GET /api/AuthAccount/get/{id}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthAccountVO}}
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
    @ApiOperation(value = "get AuthAccount by id", notes = "get AuthAccount by id")
    @GetMapping("/get/{id}")
    public ResultBean getAuthAccountById(@PathVariable String id) {
        try {
            return ResultBean.success().setBody(authAccountApplication.getAuthAccountById(id));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find AuthAccountVO.
     * USAGE:
     *   GET /api/AuthAccount/page/{loginEmail}/{status}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{AuthAccountVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param loginEmail
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
    @ApiOperation(value = "page find AuthAccount", notes = "page find AuthAccount")
    @GetMapping({"/page/{loginEmail}/{status}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/page/{loginEmail}/{status}/{currentPage}/{pageSize}",
            "/page/{loginEmail}/{status}/{currentPage}",
            "/page/{loginEmail}/{status}",
            "/page/{loginEmail}",
            "/page"})
    public ResultBean pageFindAuthAccount(
                                       @PathVariable(required = false, value = "loginEmail") String loginEmail,
                                       @PathVariable(required = false, value = "status") String status,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("loginEmail", PreCheckHelper.equalsToNull(loginEmail, "-"));
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
            AuthAccountVO vo = BeanHelper.copyProperties(AuthAccountVO.class, map);
            return ResultBean.success().setBody(authAccountApplication.pageFindAuthAccount(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find AuthAccountVO.
     * USAGE:
     *   GET /api/AuthAccount/pageMap/{loginEmail}/{status}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{AuthAccountVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param loginEmail
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
    @ApiOperation(value = "page find AuthAccount", notes = "page find AuthAccount")
    @GetMapping({"/pageMap/{loginEmail}/{status}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/pageMap/{loginEmail}/{status}/{currentPage}/{pageSize}",
            "/pageMap/{loginEmail}/{status}/{currentPage}",
            "/pageMap/{loginEmail}/{status}",
            "/pageMap/{loginEmail}",
            "/pageMap"})
    public ResultBean pageFindAuthAccountMap(
                                       @PathVariable(required = false, value = "loginEmail") String loginEmail,
                                       @PathVariable(required = false, value = "status") String status,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("loginEmail", PreCheckHelper.equalsToNull(loginEmail, "-"));
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
            AuthAccountVO vo = BeanHelper.copyProperties(AuthAccountVO.class, map);
            return ResultBean.success().setBody(authAccountApplication.pageFindAuthAccountMap(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * add AuthAccount.
     * USAGE:
     *   POST /api/AuthAccount/
     *   {AuthAccountVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthAccountVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return AuthAccountVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "add AuthAccount", notes = "add AuthAccount")
    @PostMapping("/")
    public ResultBean addAuthAccount(@RequestBody AuthAccountVO vo) {
        try {
            return ResultBean.success().setBody(authAccountApplication.addAuthAccount(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * update AuthAccount.
     * USAGE:
     *   POST /api/AuthAccount/
     *   {AuthAccountVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthAccountVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return AuthAccountVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "update AuthAccount", notes = "update AuthAccount")
    @PutMapping("/")
    public ResultBean updateAuthAccount(@RequestBody AuthAccountVO vo) {
        try {
            return ResultBean.success().setBody(authAccountApplication.updateAuthAccount(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * remove AuthAccount multi ids join by comma ','.
     * USAGE:
     *   DELETE /api/AuthAccount/{id}
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
    @ApiOperation(value = "delete AuthAccount", notes = "delete AuthAccount")
    @DeleteMapping("/{id}")
    public ResultBean removeAuthAccountById(@PathVariable String id) {
        try {
            if (id.indexOf(',') > -1) {
                authAccountApplication.removeAuthAccountByIds(StringUtils.split(id, ','));
            } else {
                authAccountApplication.removeAuthAccountById(id);
            }
            return ResultBean.success();
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
    /**
     * <pre>
     * get AuthAccount by unique name
     * USAGE:
     *   GET /api/AuthAccount/get/loginEmail/{loginEmail}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthAccountVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "get AuthAccount by loginEmail", notes = "get AuthAccount by loginEmail")
    @GetMapping("/get/loginEmail/{loginEmail}")
    public ResultBean getByLoginEmail(@PathVariable String loginEmail) {
        try {
            return ResultBean.success().setBody(authAccountApplication.getByLoginEmail(loginEmail));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
	

	
    /**
     * <pre>
     * page find assign AuthRoleVO.
     * USAGE:
     *   GET /api/AuthAccount/pageAssignAuthRole/{loginEmail}/{status}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{AuthRoleVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param loginEmail
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
    @ApiOperation(value = "page find assign AuthRole", notes = "page find assign AuthRole")
    @GetMapping({"/pageAssignAuthRole/{loginEmail}/{status}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/pageAssignAuthRole/{loginEmail}/{status}/{currentPage}/{pageSize}",
            "/pageAssignAuthRole/{loginEmail}/{status}/{currentPage}",
            "/pageAssignAuthRole/{loginEmail}/{status}",
            "/pageAssignAuthRole/{loginEmail}",
            "/pageAssignAuthRole"})
    public ResultBean pageFindAssignAuthRole(
                                       @PathVariable(required = false, value = "loginEmail") String loginEmail,
                                       @PathVariable(required = false, value = "status") String status,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("loginEmail", PreCheckHelper.equalsToNull(loginEmail, "-"));
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
            AuthAccountVO vo = BeanHelper.copyProperties(AuthAccountVO.class, map);
            return ResultBean.success().setBody(authAccountApplication.pageFindAssignAuthRole(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * assign AuthRole by id(s).
     * USAGE:
     *   POST /api/AuthAccount/assignAuthRole
     *   {AuthAccountVO}
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
	public ResultBean assignAuthRole(AuthAccountVO vo) {
        try {
            authAccountApplication.assignAuthRole(vo);
            return ResultBean.success();
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
	}
	
    /**
     * <pre>
     * editPassword.
     * USAGE:
     *   POST /api/AuthAccount/editPassword
     *   {EditPasswordVO}
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
    @ApiOperation(value = "operation editPassword", notes = "operation editPassword")
    @PostMapping("/editPassword")
	public ResultBean editPassword(EditPasswordVO vo) {
        try {
            authAccountApplication.editPassword(vo);
            return ResultBean.success();
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
	}
}
