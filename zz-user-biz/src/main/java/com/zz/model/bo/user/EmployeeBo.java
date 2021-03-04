package com.zz.model.bo.user;

import com.zz.core.bo.BaseBo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 雇员 查询结果业务对象
 * </pre>
 *
 * @author puck
 * @date 2021-03-04
 */
@Data
@Accessors(chain = true)
public class EmployeeBo extends BaseBo implements Serializable {
    private static final long serialVersionUID = 1L;

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
