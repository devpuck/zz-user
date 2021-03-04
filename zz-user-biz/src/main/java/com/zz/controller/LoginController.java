package com.zz.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.zz.core.api.ApiResultCode;
import com.zz.core.util.BeanListUtil;
import com.zz.core.util.CheckParameter;
import com.zz.core.vo.LoginUserTokenVo;
import com.zz.model.entity.LoginEntity;
import com.zz.service.LoginService;
import com.zz.api.login.LoginQueryParam;
import com.zz.api.login.LoginVo;
import com.zz.model.bo.login.LoginBo;
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
 * 登陆信息 前端控制器
 * </pre>
 *
 * @author puck
 * @since 2021-02-23
 */
@Slf4j
@RestController
@RequestMapping("/login")
@Api("登陆信息 API")
public class LoginController extends BaseController
{

    @Autowired
    private LoginService loginService;

    /**
     * 添加登陆信息
     */
    @PostMapping("/add")
    @ApiOperation(value = "注册", notes = "注册", response = ApiResult.class)
    public ApiResult addLogin(@Valid @RequestBody LoginVo login) throws Exception
    {
        String password = login.getPassword();
        String keyID = login.getKeyId();
        String phone = login.getPhone();
        String userName = login.getUsername();
        String email = login.getEmail();

        //密码和keyID都不可为空
        if (ApiResultCode.SUCCESS.getCode() != CheckParameter.checkParameter(password, keyID))
        {
            return ApiResult.result(ApiResultCode.PARAMETER_EXCEPTION);
        }

        //phone,username,email 三个不能都为空
        if (ApiResultCode.SUCCESS.getCode() != CheckParameter.checkParameter(phone) && ApiResultCode.SUCCESS.getCode() != CheckParameter.checkParameter(userName) && ApiResultCode.SUCCESS.getCode() != CheckParameter.checkParameter(email))
        {
            return ApiResult.result(ApiResultCode.PARAMETER_EXCEPTION);
        }

        LoginBo bo = new LoginBo();
        BeanUtils.copyProperties(login, bo);

        int result = loginService.saveLogin(bo);

        return ApiResult.result(ApiResultCode.getApiCode(result));
    }

//
//    /**
//     * 修改登陆信息
//     */
//    @PostMapping("/update")
//    @ApiOperation(value = "修改Login对象", notes = "修改登陆信息", response = ApiResult.class)
//    public ApiResult<Boolean> updateLogin(@Valid @RequestBody LoginVo login) throws Exception
//    {
//        LoginBo bo = new LoginBo();
//        BeanUtils.copyProperties(login, bo);
//
//        boolean flag = loginService.updateLogin(bo);
//        return ApiResult.result(flag);
//    }

    /**
     * 删除登陆信息
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除Login对象", notes = "删除登陆信息", response = ApiResult.class)
    public ApiResult<Boolean> deleteLogin(@PathVariable("id") Long id) throws Exception
    {
        boolean flag = loginService.deleteLogin(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取登陆信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取Login对象详情", notes = "查看登陆信息", response = LoginVo.class)
    public ApiResult<LoginVo> getLogin(@PathVariable("id") Long id) throws Exception
    {
        LoginBo loginBo = loginService.getLoginById(id);
        LoginVo queryVo = null;
        if (loginBo != null)
        {
            queryVo = new LoginVo();
            BeanUtils.copyProperties(loginBo, queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 登陆信息分页列表
     */
    @PostMapping("/pagelist")
    @ApiOperation(value = "获取Login分页列表", notes = "登陆信息分页列表", response = LoginVo.class)
    public ApiResult<Paging<LoginVo>> getLoginPageList(@Valid @RequestBody LoginQueryParam loginQueryParam) throws Exception
    {
        Paging<LoginBo> paging = loginService.getLoginPageList(loginQueryParam);
        Paging<LoginVo> resultPage = new Paging<>();
        resultPage.setTotal(paging.getTotal());
        resultPage.setRecords(BeanListUtil.copyListProperties(paging.getRecords(), LoginVo.class));
        return ApiResult.ok(resultPage);
    }

    @PostMapping("/login")
    @ApiOperation(value = "登陆", notes = "登陆", response = ApiResult.class)
    public ApiResult<LoginUserTokenVo> login(@Valid @RequestBody LoginVo login) throws Exception
    {
        String password = login.getPassword();
        String keyID = login.getKeyId();
        String phone = login.getPhone();
        String userName = login.getUsername();
        String email = login.getEmail();
        String loginType = login.getLoginType();

        //密码和keyID都不可为空
        if (ApiResultCode.SUCCESS.getCode() != CheckParameter.checkParameter(password, keyID,loginType))
        {
            return ApiResult.result(ApiResultCode.PARAMETER_EXCEPTION);
        }

        //phone,username,email 三个不能都为空
        if (ApiResultCode.SUCCESS.getCode() != CheckParameter.checkParameter(phone) && ApiResultCode.SUCCESS.getCode() != CheckParameter.checkParameter(userName) && ApiResultCode.SUCCESS.getCode() != CheckParameter.checkParameter(email))
        {
            return ApiResult.result(ApiResultCode.PARAMETER_EXCEPTION);
        }

        LoginBo bo = new LoginBo();
        BeanUtils.copyProperties(login, bo);

        LoginUserTokenVo loginUserTokenVo = new LoginUserTokenVo();
        int result = loginService.login(bo,loginUserTokenVo);
        if(ApiResultCode.SUCCESS.getCode() == result)
        {
            return ApiResult.ok(loginUserTokenVo);
        }else
        {
            return ApiResult.result(result);
        }
//        String token = JWT.create().withClaim("ABC","abc").sign(Algorithm.HMAC256("66666"));
//        System.out.println("TOKEN:"+token);
//
//        String ABC = JWT.decode(token).getClaim("ABC").asString();
//        System.out.println("ABC:"+ ABC);


    }

}

