package com.zz.service;

import com.zz.model.entity.DepartmentEntity;
import com.zz.core.service.BaseService;
import com.zz.api.company.DepartmentQueryParam;
import com.zz.model.bo.company.DepartmentBo;
import com.zz.core.api.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 部门 服务类
 * </pre>
 *
 * @author puck
 * @since 2021-03-04
 */
public interface DepartmentService extends BaseService<DepartmentEntity> {

    /**
     * 保存
     *
     * @param department
     * @return
     * @throws Exception
     */
    boolean saveDepartment(DepartmentBo department);

    /**
     * 修改
     *
     * @param department
     * @return
     * @throws Exception
     */
    boolean updateDepartment(DepartmentBo department);

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteDepartment(Long id);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    DepartmentBo getDepartmentById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param departmentQueryParam
     * @return
     * @throws Exception
     */
    Paging<DepartmentBo> getDepartmentPageList(DepartmentQueryParam departmentQueryParam);

}
