package com.zz.mapper.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.model.entity.EmployeeEntity;
import com.zz.api.user.EmployeeQueryParam;
import com.zz.model.bo.user.EmployeeBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 雇员 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2021-03-04
 */
@Repository
public interface EmployeeMapper extends BaseMapper<EmployeeEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    EmployeeBo getEmployeeById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param employeeQueryParam
     * @return
     */
    IPage<EmployeeBo> getEmployeePageList(@Param("page") Page page, @Param("param") EmployeeQueryParam employeeQueryParam);

}
