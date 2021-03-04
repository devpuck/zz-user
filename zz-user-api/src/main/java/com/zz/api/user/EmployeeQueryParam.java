package com.zz.api.user;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.zz.core.api.SortQueryParam;

/**
 * <pre>
 * 雇员 查询参数对象
 * </pre>
 *
 * @author puck
 * @date 2021-03-04
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "EmployeeQueryParam对象", description = "雇员查询参数")
public class EmployeeQueryParam extends SortQueryParam {
    private static final long serialVersionUID = 1L;
}
