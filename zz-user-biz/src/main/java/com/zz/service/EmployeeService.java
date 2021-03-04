package com.zz.service;

import com.zz.model.entity.EmployeeEntity;
import com.zz.core.service.BaseService;
import com.zz.api.user.EmployeeQueryParam;
import com.zz.model.bo.user.EmployeeBo;
import com.zz.core.api.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 雇员 服务类
 * </pre>
 *
 * @author puck
 * @since 2021-03-04
 */
public interface EmployeeService extends BaseService<EmployeeEntity> {

    /**
     * 保存
     *
     * @param employee
     * @return
     * @throws Exception
     */
    boolean saveEmployee(EmployeeBo employee);

    /**
     * 修改
     *
     * @param employee
     * @return
     * @throws Exception
     */
    boolean updateEmployee(EmployeeBo employee);

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteEmployee(Long id);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    EmployeeBo getEmployeeById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param employeeQueryParam
     * @return
     * @throws Exception
     */
    Paging<EmployeeBo> getEmployeePageList(EmployeeQueryParam employeeQueryParam);

}
