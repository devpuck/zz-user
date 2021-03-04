package com.zz.api.company;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.zz.core.api.SortQueryParam;

/**
 * <pre>
 * 部门 查询参数对象
 * </pre>
 *
 * @author puck
 * @date 2021-03-04
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "DepartmentQueryParam对象", description = "部门查询参数")
public class DepartmentQueryParam extends SortQueryParam {
    private static final long serialVersionUID = 1L;
}
