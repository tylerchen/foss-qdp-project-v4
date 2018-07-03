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
import com.foreveross.qdp.application.system.auth.AuthMenuApplication;
import com.foreveross.qdp.infra.vo.system.auth.AuthMenuVO;
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
 * AuthMenu
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since 2018-07-03
 * @version 1.0.0
 * auto generate by qdp v5.0.
 */
@RestController
@RequestMapping("/api/AuthMenu")
@Api("AuthMenu Api")
public class AuthMenuRSApplicationImpl {

    @Inject
    AuthMenuApplication authMenuApplication;

    /**
     * <pre>
     * get AuthMenuVO by id.
     * USAGE:
     *   GET /api/AuthMenu/get/{id}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthMenuVO}}
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
    @ApiOperation(value = "get AuthMenu by id", notes = "get AuthMenu by id")
    @GetMapping("/get/{id}")
    public ResultBean getAuthMenuById(@PathVariable String id) {
        try {
            return ResultBean.success().setBody(authMenuApplication.getAuthMenuById(id));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find AuthMenuVO.
     * USAGE:
     *   GET /api/AuthMenu/page/{name}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{AuthMenuVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param name
     * @param currentPage
     * @param pageSize
     * @param asc
     * @param desc
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0
     */
    @ApiOperation(value = "page find AuthMenu", notes = "page find AuthMenu")
    @GetMapping({"/page/{name}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/page/{name}/{currentPage}/{pageSize}",
            "/page/{name}/{currentPage}",
            "/page/{name}",
            "/page"})
    public ResultBean pageFindAuthMenu(
                                       @PathVariable(required = false, value = "name") String name,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("name", PreCheckHelper.equalsToNull(name, "-"));
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
            AuthMenuVO vo = BeanHelper.copyProperties(AuthMenuVO.class, map);
            return ResultBean.success().setBody(authMenuApplication.pageFindAuthMenu(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * page find AuthMenuVO.
     * USAGE:
     *   GET /api/AuthMenu/pageMap/{name}/{currentPage}/{pageSize}/{asc}/{desc}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{pageSize,totalCount,currentPage,offset,offsetPage,orderBy:[],rows:[{AuthMenuVO}]}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param name
     * @param currentPage
     * @param pageSize
     * @param asc
     * @param desc
     * @return ResultBean
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0
     */
    @ApiOperation(value = "page find AuthMenu", notes = "page find AuthMenu")
    @GetMapping({"/pageMap/{name}/{currentPage}/{pageSize}/{asc}/{desc}",
            "/pageMap/{name}/{currentPage}/{pageSize}",
            "/pageMap/{name}/{currentPage}",
            "/pageMap/{name}",
            "/pageMap"})
    public ResultBean pageFindAuthMenuMap(
                                       @PathVariable(required = false, value = "name") String name,
                                       @PathVariable(required = false, value = "currentPage") Integer currentPage,
                                       @PathVariable(required = false, value = "pageSize") Integer pageSize,
                                       @PathVariable(required = false, value = "asc") String asc,
                                       @PathVariable(required = false, value = "desc") String desc) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            {
                 map.put("name", PreCheckHelper.equalsToNull(name, "-"));
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
            AuthMenuVO vo = BeanHelper.copyProperties(AuthMenuVO.class, map);
            return ResultBean.success().setBody(authMenuApplication.pageFindAuthMenuMap(vo, page));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * add AuthMenu.
     * USAGE:
     *   POST /api/AuthMenu/
     *   {AuthMenuVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthMenuVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return AuthMenuVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "add AuthMenu", notes = "add AuthMenu")
    @PostMapping("/")
    public ResultBean addAuthMenu(@RequestBody AuthMenuVO vo) {
        try {
            return ResultBean.success().setBody(authMenuApplication.addAuthMenu(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * update AuthMenu.
     * USAGE:
     *   POST /api/AuthMenu/
     *   {AuthMenuVO}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthMenuVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @param vo
     * @return AuthMenuVO
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "update AuthMenu", notes = "update AuthMenu")
    @PutMapping("/")
    public ResultBean updateAuthMenu(@RequestBody AuthMenuVO vo) {
        try {
            return ResultBean.success().setBody(authMenuApplication.updateAuthMenu(vo));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }

    /**
     * <pre>
     * remove AuthMenu multi ids join by comma ','.
     * USAGE:
     *   DELETE /api/AuthMenu/{id}
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
    @ApiOperation(value = "delete AuthMenu", notes = "delete AuthMenu")
    @DeleteMapping("/{id}")
    public ResultBean removeAuthMenuById(@PathVariable String id) {
        try {
            if (id.indexOf(',') > -1) {
                authMenuApplication.removeAuthMenuByIds(StringUtils.split(id, ','));
            } else {
                authMenuApplication.removeAuthMenuById(id);
            }
            return ResultBean.success();
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
    /**
     * <pre>
     * get AuthMenu by unique name
     * USAGE:
     *   GET /api/AuthMenu/get/name/{name}
     * SUCCESS:
     *   {header:{status:success},
     *   body:{AuthMenuVO}}
     * ERROR:
     *   {header: {status: error}, body:{Exception.getMessage()}}
     * </pre>
     *
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since 2018-07-03
     * auto generate by qdp v5.0.
     */
    @ApiOperation(value = "get AuthMenu by name", notes = "get AuthMenu by name")
    @GetMapping("/get/name/{name}")
    public ResultBean getByName(@PathVariable String name) {
        try {
            return ResultBean.success().setBody(authMenuApplication.getByName(name));
        } catch (Exception e) {
            return ResultBean.error().setBody(e.getMessage());
        }
    }
	
	
	
}
