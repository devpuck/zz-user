package com.zz.model.bo.user;

import com.zz.core.bo.BaseBo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 用户信息 查询结果业务对象
 * </pre>
 *
 * @author puck
 * @date 2021-03-02
 */
@Data
@Accessors(chain = true)
public class UserBo extends BaseBo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 用户识别码，唯一校验，自动生成
     */
    private String userCode;

    /**
     * 客户级别
     */
    private String customerLevel;

    /**
     * 客户状态是否被领取
     */
    private String customerState;

    /**
     * 性别
     */
    private String sex;

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 地址
     */
    private String address;

    /**
     * 租户ID
     */
    private String keyId;

    private String createMethod;

    /**
     * 公司
     */
    private String company;

    /**
     * 来源
     */
    private String sourceFrom;

    /**
     * 身份证号
     */
    private String identityCardCode;

    /**
     * 身份证照片正面
     */
    private String identityCardMainPic;

    /**
     * 身份证照片正面
     */
    private String identityCardBackPic;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 简介，可用于个人主页等富文本边际
     */
    private String introduce;

    /**
     * 状态，默认ok
     */
    private String status;

    /**
     * 头像
     */
    private String headPic;

}
