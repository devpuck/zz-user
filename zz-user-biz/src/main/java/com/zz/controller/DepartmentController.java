package com.zz.controller;

import com.zz.core.util.BeanListUtil;
import com.zz.model.entity.DepartmentEntity;
import com.zz.service.DepartmentService;
import com.zz.api.company.DepartmentQueryParam;
import com.zz.api.company.DepartmentVo;
import com.zz.model.bo.company.DepartmentBo;
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
 * 部门 前端控制器
 * </pre>
 *
 * @author puck
 * @since 2021-03-04
 */
@Slf4j
@RestController
@RequestMapping("/department")
@Api("部门 API")
public class DepartmentController extends BaseController
{

    @Autowired
    private DepartmentService departmentService;

    /**
     * 添加部门
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加Department对象", notes = "添加部门", response = ApiResult.class)
    public ApiResult<Boolean> addDepartment(@Valid @RequestBody DepartmentVo department) throws Exception
    {
        DepartmentBo bo = new DepartmentBo();
        BeanUtils.copyProperties(department, bo);

        boolean flag = departmentService.saveDepartment(bo);
        return ApiResult.result(flag);
    }

    /**
     * 修改部门
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改Department对象", notes = "修改部门", response = ApiResult.class)
    public ApiResult<Boolean> updateDepartment(@Valid @RequestBody DepartmentVo department) throws Exception
    {
        DepartmentBo bo = new DepartmentBo();
        BeanUtils.copyProperties(department, bo);

        boolean flag = departmentService.updateDepartment(bo);
        return ApiResult.result(flag);
    }

    /**
     * 删除部门
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除Department对象", notes = "删除部门", response = ApiResult.class)
    public ApiResult<Boolean> deleteDepartment(@PathVariable("id") Long id) throws Exception
    {
        boolean flag = departmentService.deleteDepartment(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取部门
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取Department对象详情", notes = "查看部门", response = DepartmentVo.class)
    public ApiResult<DepartmentVo> getDepartment(@PathVariable("id") Long id) throws Exception
    {
        DepartmentBo departmentBo = departmentService.getDepartmentById(id);
        DepartmentVo queryVo = null;
        if (departmentBo != null)
        {
            queryVo = new DepartmentVo();
            BeanUtils.copyProperties(departmentBo, queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 部门分页列表
     */
    @PostMapping("/pagelist")
    @ApiOperation(value = "获取Department分页列表", notes = "部门分页列表", response = DepartmentVo.class)
    public ApiResult<Paging<DepartmentVo>> getDepartmentPageList(@Valid @RequestBody DepartmentQueryParam departmentQueryParam) throws Exception
    {
        Paging<DepartmentBo> paging = departmentService.getDepartmentPageList(departmentQueryParam);
        Paging<DepartmentVo> resultPage = new Paging<>();
        resultPage.setTotal(paging.getTotal());
        resultPage.setRecords(BeanListUtil.copyListProperties(paging.getRecords(), DepartmentVo.class));
        return ApiResult.ok(resultPage);
    }

}

