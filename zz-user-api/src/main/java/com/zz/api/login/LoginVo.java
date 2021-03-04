package com.zz.api.login;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.zz.core.vo.BaseVo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 登陆信息 查询结果对象
 * </pre>
 *
 * @author puck
 * @date 2021-03-02
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "LoginVo对象", description = "登陆信息查询参数")
public class LoginVo extends BaseVo implements Serializable {
    private static final long serialVersionUID = 1L;

private Long id;

    @ApiModelProperty(value = "用户识别码，唯一校验，自动生成")
    private String userCode;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "openid")
    private String xcxOpenid;

    @ApiModelProperty(value = "app_openid")
    private String appOpenid;

    @ApiModelProperty(value = "gzh_openid")
    private String gzhOpenid;

    @ApiModelProperty(value = "unionid")
    private String unionid;

    @ApiModelProperty(value = "three_part_id")
    private String threePartId;

    @ApiModelProperty(value = "登陆类型")
    private String loginType;

    @ApiModelProperty(value = "账号类型")
    private String accountType;

    @ApiModelProperty(value = "租户KEY")
    private String keyId;

    @ApiModelProperty(value = "状态，默认ok")
    private String status;

}
