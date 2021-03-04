package com.zz.api.company;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.zz.core.vo.BaseVo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 部门 查询结果对象
 * </pre>
 *
 * @author puck
 * @date 2021-03-04
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "DepartmentVo对象", description = "部门查询参数")
public class DepartmentVo extends BaseVo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "部门联系人或者负责人")
    private String userNamee;

    @ApiModelProperty(value = "部门联系人或者负责人联系电话")
    private String userPhone;

    @ApiModelProperty(value = "部门编码")
    private String departmentCode;

    @ApiModelProperty(value = "上级部门")
    private String superiorDepartment;

    @ApiModelProperty(value = "简介")
    private String introduce;

    @ApiModelProperty(value = "租户ID")
    private String keyId;

    @ApiModelProperty(value = "状态，默认ok")
    private String status;

}
