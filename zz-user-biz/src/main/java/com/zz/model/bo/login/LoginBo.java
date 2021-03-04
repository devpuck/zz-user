package com.zz.model.bo.login;

import com.zz.core.bo.BaseBo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 登陆信息 查询结果业务对象
 * </pre>
 *
 * @author puck
 * @date 2021-03-02
 */
@Data
@Accessors(chain = true)
public class LoginBo extends BaseBo implements Serializable {
    private static final long serialVersionUID = 1L;

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
