package com.zz.controller;

import com.zz.core.util.BeanListUtil;
import com.zz.model.entity.UserEntity;
import com.zz.service.UserService;
import com.zz.api.user.UserQueryParam;
import com.zz.api.user.UserVo;
import com.zz.model.bo.user.UserBo;
import com.zz.core.api.ApiResult;
import com.zz.core.api.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;


import javax.validation.Valid;

import com.zz.core.api.Paging;

/**
 * <pre>
 * 用户信息 前端控制器
 * </pre>
 *
 * @author puck
 * @since 2021-03-02
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Api("用户信息 API")
public class UserController extends BaseController
{

    @Autowired
    private UserService userService;

    /**
     * 添加用户信息
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加User对象", notes = "添加用户信息", response = ApiResult.class)
    public ApiResult<Boolean> addUser(@Valid @RequestBody UserVo user) throws Exception
    {
        UserBo bo = new UserBo();
        BeanUtils.copyProperties(user, bo);

        boolean flag = userService.saveUser(bo);
        return ApiResult.result(flag);
    }

    /**
     * 修改用户信息
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改User对象", notes = "修改用户信息", response = ApiResult.class)
    public ApiResult<Boolean> updateUser(@Valid @RequestBody UserVo user) throws Exception
    {
        UserBo bo = new UserBo();
        BeanUtils.copyProperties(user, bo);

        boolean flag = userService.updateUser(bo);
        return ApiResult.result(flag);
    }

    /**
     * 删除用户信息
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除User对象", notes = "删除用户信息", response = ApiResult.class)
    public ApiResult<Boolean> deleteUser(@PathVariable("id") Long id) throws Exception
    {
        boolean flag = userService.deleteUser(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取用户信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取User对象详情", notes = "查看用户信息", response = UserVo.class)
    public ApiResult<UserVo> getUser(@PathVariable("id") Long id) throws Exception
    {
        UserBo userBo = userService.getUserById(id);
        UserVo queryVo = null;
        if (userBo != null)
        {
            queryVo = new UserVo();
            BeanUtils.copyProperties(userBo, queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 用户信息分页列表
     */
    @PostMapping("/pagelist")
    @ApiOperation(value = "获取User分页列表", notes = "用户信息分页列表", response = UserVo.class)
    public ApiResult<Paging<UserVo>> getUserPageList(@Valid @RequestBody UserQueryParam userQueryParam) throws Exception
    {
        Paging<UserBo> paging = userService.getUserPageList(userQueryParam);
        Paging<UserVo> resultPage = new Paging<>();
        resultPage.setTotal(paging.getTotal());
        resultPage.setRecords(BeanListUtil.copyListProperties(paging.getRecords(), UserVo.class));
        return ApiResult.ok(resultPage);
    }

}

