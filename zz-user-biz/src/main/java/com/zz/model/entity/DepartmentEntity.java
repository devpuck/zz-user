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
 * 部门
 * </pre>
 *
 * @author puck
 * @since 2021-03-04
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("DEPARTMENT")
public class DepartmentEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

@TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 部门联系人或者负责人
     */
    private String userNamee;

    /**
     * 部门联系人或者负责人联系电话
     */
    private String userPhone;

    /**
     * 部门编码
     */
    private String departmentCode;

    /**
     * 上级部门
     */
    private String superiorDepartment;

    /**
     * 简介
     */
    private String introduce;

    /**
     * 租户ID
     */
    private String keyId;

    /**
     * 状态，默认ok
     */
    private String status;

}
