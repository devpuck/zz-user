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
 * 登陆信息
 * </pre>
 *
 * @author puck
 * @since 2021-03-02
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("LOGIN")
public class LoginEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

@TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 用户识别码，唯一校验，自动生成
     */
    private String userCode;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * openid
     */
    private String xcxOpenid;

    /**
     * app_openid
     */
    private String appOpenid;

    /**
     * gzh_openid
     */
    private String gzhOpenid;

    /**
     * unionid
     */
    private String unionid;

    /**
     * three_part_id
     */
    private String threePartId;

    /**
     * 登陆类型
     */
    private String loginType;

    /**
     * 账号类型
     */
    private String accountType;

    /**
     * 租户KEY
     */
    private String keyId;

    /**
     * 状态，默认ok
     */
    private String status;

}
