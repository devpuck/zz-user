package com.zz.controller;

import com.zz.core.util.BeanListUtil;
import com.zz.model.entity.CompanyEntity;
import com.zz.service.CompanyService;
import com.zz.api.company.CompanyQueryParam;
import com.zz.api.company.CompanyVo;
import com.zz.model.bo.company.CompanyBo;
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
 * 公司信息表 前端控制器
 * </pre>
 *
 * @author puck
 * @since 2021-03-04
 */
@Slf4j
@RestController
@RequestMapping("/company")
@Api("公司信息表 API")
public class CompanyController extends BaseController
{

    @Autowired
    private CompanyService companyService;

    /**
     * 添加公司信息表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加Company对象", notes = "添加公司信息表", response = ApiResult.class)
    public ApiResult<Boolean> addCompany(@Valid @RequestBody CompanyVo company) throws Exception
    {
        CompanyBo bo = new CompanyBo();
        BeanUtils.copyProperties(company, bo);

        boolean flag = companyService.saveCompany(bo);
        return ApiResult.result(flag);
    }

    /**
     * 修改公司信息表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改Company对象", notes = "修改公司信息表", response = ApiResult.class)
    public ApiResult<Boolean> updateCompany(@Valid @RequestBody CompanyVo company) throws Exception
    {
        CompanyBo bo = new CompanyBo();
        BeanUtils.copyProperties(company, bo);

        boolean flag = companyService.updateCompany(bo);
        return ApiResult.result(flag);
    }

    /**
     * 删除公司信息表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除Company对象", notes = "删除公司信息表", response = ApiResult.class)
    public ApiResult<Boolean> deleteCompany(@PathVariable("id") Long id) throws Exception
    {
        boolean flag = companyService.deleteCompany(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取公司信息表
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取Company对象详情", notes = "查看公司信息表", response = CompanyVo.class)
    public ApiResult<CompanyVo> getCompany(@PathVariable("id") Long id) throws Exception
    {
        CompanyBo companyBo = companyService.getCompanyById(id);
        CompanyVo queryVo = null;
        if (companyBo != null)
        {
            queryVo = new CompanyVo();
            BeanUtils.copyProperties(companyBo, queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 公司信息表分页列表
     */
    @PostMapping("/pagelist")
    @ApiOperation(value = "获取Company分页列表", notes = "公司信息表分页列表", response = CompanyVo.class)
    public ApiResult<Paging<CompanyVo>> getCompanyPageList(@Valid @RequestBody CompanyQueryParam companyQueryParam) throws Exception
    {
        Paging<CompanyBo> paging = companyService.getCompanyPageList(companyQueryParam);
        Paging<CompanyVo> resultPage = new Paging<>();
        resultPage.setTotal(paging.getTotal());
        resultPage.setRecords(BeanListUtil.copyListProperties(paging.getRecords(), CompanyVo.class));
        return ApiResult.ok(resultPage);
    }

}

