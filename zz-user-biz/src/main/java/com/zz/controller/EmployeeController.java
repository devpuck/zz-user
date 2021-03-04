package com.zz.controller;

import com.zz.core.util.BeanListUtil;
import com.zz.model.entity.EmployeeEntity;
import com.zz.service.EmployeeService;
import com.zz.api.user.EmployeeQueryParam;
import com.zz.api.user.EmployeeVo;
import com.zz.model.bo.user.EmployeeBo;
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
 * 雇员 前端控制器
 * </pre>
 *
 * @author puck
 * @since 2021-03-04
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Api("雇员 API")
public class EmployeeController extends BaseController
{

    @Autowired
    private EmployeeService employeeService;

    /**
     * 添加雇员
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加Employee对象", notes = "添加雇员", response = ApiResult.class)
    public ApiResult<Boolean> addEmployee(@Valid @RequestBody EmployeeVo employee) throws Exception
    {
        EmployeeBo bo = new EmployeeBo();
        BeanUtils.copyProperties(employee, bo);

        boolean flag = employeeService.saveEmployee(bo);
        return ApiResult.result(flag);
    }

    /**
     * 修改雇员
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改Employee对象", notes = "修改雇员", response = ApiResult.class)
    public ApiResult<Boolean> updateEmployee(@Valid @RequestBody EmployeeVo employee) throws Exception
    {
        EmployeeBo bo = new EmployeeBo();
        BeanUtils.copyProperties(employee, bo);

        boolean flag = employeeService.updateEmployee(bo);
        return ApiResult.result(flag);
    }

    /**
     * 删除雇员
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除Employee对象", notes = "删除雇员", response = ApiResult.class)
    public ApiResult<Boolean> deleteEmployee(@PathVariable("id") Long id) throws Exception
    {
        boolean flag = employeeService.deleteEmployee(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取雇员
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取Employee对象详情", notes = "查看雇员", response = EmployeeVo.class)
    public ApiResult<EmployeeVo> getEmployee(@PathVariable("id") Long id) throws Exception
    {
        EmployeeBo employeeBo = employeeService.getEmployeeById(id);
        EmployeeVo queryVo = null;
        if (employeeBo != null)
        {
            queryVo = new EmployeeVo();
            BeanUtils.copyProperties(employeeBo, queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 雇员分页列表
     */
    @PostMapping("/pagelist")
    @ApiOperation(value = "获取Employee分页列表", notes = "雇员分页列表", response = EmployeeVo.class)
    public ApiResult<Paging<EmployeeVo>> getEmployeePageList(@Valid @RequestBody EmployeeQueryParam employeeQueryParam) throws Exception
    {
        Paging<EmployeeBo> paging = employeeService.getEmployeePageList(employeeQueryParam);
        Paging<EmployeeVo> resultPage = new Paging<>();
        resultPage.setTotal(paging.getTotal());
        resultPage.setRecords(BeanListUtil.copyListProperties(paging.getRecords(), EmployeeVo.class));
        return ApiResult.ok(resultPage);
    }

}

