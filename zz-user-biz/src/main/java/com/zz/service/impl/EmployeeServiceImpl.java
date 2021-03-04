package com.zz.service.impl;

import com.zz.core.constant.CoreConstant;
import com.zz.model.entity.EmployeeEntity;
import com.zz.mapper.user.EmployeeMapper;
import com.zz.service.EmployeeService;
import com.zz.api.user.EmployeeQueryParam;
import com.zz.model.bo.user.EmployeeBo;
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
 * 雇员 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2021-03-04
 */
@Slf4j
@Service
public class EmployeeServiceImpl extends BaseServiceImpl<EmployeeMapper, EmployeeEntity> implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveEmployee(EmployeeBo employee)
    {
        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(employee , entity);
        return super.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateEmployee(EmployeeBo employee)
    {
        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(employee , entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteEmployee(Long id) {
        return super.removeById(id);
    }

    @Override
    public EmployeeBo getEmployeeById(Serializable id) {
        return employeeMapper.getEmployeeById(id);
    }

    @Override
    public Paging<EmployeeBo> getEmployeePageList(EmployeeQueryParam employeeQueryParam) {
        Page page = setPageParam(employeeQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<EmployeeBo> iPage = employeeMapper.getEmployeePageList(page, employeeQueryParam);
        return new Paging(iPage);
    }

}
