package com.zz.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.zz.core.entity.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <pre>
 * 雇员
 * </pre>
 *
 * @author puck
 * @since 2021-03-04
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("EMPLOYEE")
public class EmployeeEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

@TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 用户识别码，唯一校验，自动生成
     */
    private String userCode;

    /**
     * 部门编码
     */
    private String departmentCode;

    /**
     * 领导编号
     */
    private String leaderCode;

    /**
     * 工号
     */
    private String workCode;

    /**
     * 职位
     */
    private String position;

    /**
     * 租户ID
     */
    private String keyId;

    /**
     * 状态，默认ok
     */
    private String status;

}
