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
 * 用户信息 查询结果对象
 * </pre>
 *
 * @author puck
 * @date 2021-03-02
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserVo对象", description = "用户信息查询参数")
public class UserVo extends BaseVo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "用户识别码，唯一校验，自动生成")
    private String userCode;

    @ApiModelProperty(value = "客户级别")
    private String customerLevel;

    @ApiModelProperty(value = "客户状态是否被领取")
    private String customerState;

    @ApiModelProperty(value = "性别")
    private String sex;

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

    @ApiModelProperty(value = "来源")
    private String sourceFrom;

    @ApiModelProperty(value = "身份证号")
    private String identityCardCode;

    @ApiModelProperty(value = "身份证照片正面")
    private String identityCardMainPic;

    @ApiModelProperty(value = "身份证照片正面")
    private String identityCardBackPic;

    @ApiModelProperty(value = "头像")
    private String headPic;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "简介，可用于个人主页等富文本边际")
    private String introduce;

    @ApiModelProperty(value = "状态，默认ok")
    private String status;

}
