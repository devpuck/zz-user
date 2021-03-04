package com.zz.model.bo.company;

import com.zz.core.bo.BaseBo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 部门 查询结果业务对象
 * </pre>
 *
 * @author puck
 * @date 2021-03-04
 */
@Data
@Accessors(chain = true)
public class DepartmentBo extends BaseBo implements Serializable {
    private static final long serialVersionUID = 1L;

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
