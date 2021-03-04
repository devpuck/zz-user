package com.zz.mapper.company;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.model.entity.DepartmentEntity;
import com.zz.api.company.DepartmentQueryParam;
import com.zz.model.bo.company.DepartmentBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 部门 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2021-03-04
 */
@Repository
public interface DepartmentMapper extends BaseMapper<DepartmentEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    DepartmentBo getDepartmentById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param departmentQueryParam
     * @return
     */
    IPage<DepartmentBo> getDepartmentPageList(@Param("page") Page page, @Param("param") DepartmentQueryParam departmentQueryParam);

}
