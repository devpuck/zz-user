package com.zz.api.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.zz.core.vo.BaseVo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 雇员 查询结果对象
 * </pre>
 *
 * @author puck
 * @date 2021-03-04
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "EmployeeVo对象", description = "雇员查询参数")
public class EmployeeVo extends BaseVo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "用户识别码，唯一校验，自动生成")
    private String userCode;

    @ApiModelProperty(value = "部门编码")
    private String departmentCode;

    @ApiModelProperty(value = "领导编号")
    private String leaderCode;

    @ApiModelProperty(value = "工号")
    private String workCode;

    @ApiModelProperty(value = "职位")
    private String position;

    @ApiModelProperty(value = "租户ID")
    private String keyId;

    @ApiModelProperty(value = "状态，默认ok")
    private String status;

}
