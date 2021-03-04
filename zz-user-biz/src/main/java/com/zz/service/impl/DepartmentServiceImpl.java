package com.zz.service.impl;

import com.zz.core.constant.CoreConstant;
import com.zz.model.entity.DepartmentEntity;
import com.zz.mapper.company.DepartmentMapper;
import com.zz.service.DepartmentService;
import com.zz.api.company.DepartmentQueryParam;
import com.zz.model.bo.company.DepartmentBo;
import com.zz.core.service.impl.BaseServiceImpl;
import com.zz.core.api.Paging;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;


/**
 * <pre>
 * 部门 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2021-03-04
 */
@Slf4j
@Service
public class DepartmentServiceImpl extends BaseServiceImpl<DepartmentMapper, DepartmentEntity> implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveDepartment(DepartmentBo department)
    {
        DepartmentEntity entity = new DepartmentEntity();
        BeanUtils.copyProperties(department , entity);
        return super.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateDepartment(DepartmentBo department)
    {
        DepartmentEntity entity = new DepartmentEntity();
        BeanUtils.copyProperties(department , entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteDepartment(Long id) {
        return super.removeById(id);
    }

    @Override
    public DepartmentBo getDepartmentById(Serializable id) {
        return departmentMapper.getDepartmentById(id);
    }

    @Override
    public Paging<DepartmentBo> getDepartmentPageList(DepartmentQueryParam departmentQueryParam) {
        Page page = setPageParam(departmentQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<DepartmentBo> iPage = departmentMapper.getDepartmentPageList(page, departmentQueryParam);
        return new Paging(iPage);
    }

}
