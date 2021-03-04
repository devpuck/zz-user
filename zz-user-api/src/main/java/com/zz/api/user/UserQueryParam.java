package com.zz.api.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.zz.core.api.SortQueryParam;

/**
 * <pre>
 * 用户信息 查询参数对象
 * </pre>
 *
 * @author puck
 * @date 2021-03-02
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "UserQueryParam对象", description = "用户信息查询参数")
public class UserQueryParam extends SortQueryParam
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "真实姓名")
    private String realname;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "租户ID")
    private String keyId;

    @ApiModelProperty(value = "创建方式")
    private String createMethod;

    @ApiModelProperty(value = "公司")
    private String company;

    @ApiModelProperty(value = "身份证号")
    private String identityCardCode;
}
