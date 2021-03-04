package com.zz.api.company;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.zz.core.vo.BaseVo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 公司信息表 查询结果对象
 * </pre>
 *
 * @author puck
 * @date 2021-03-04
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyVo对象", description = "公司信息表查询参数")
public class CompanyVo extends BaseVo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "行业")
    private String industry;

    @ApiModelProperty(value = "评分")
    private Double score;

    @ApiModelProperty(value = "服务费")
    private Double serviceMoney;

    @ApiModelProperty(value = "服务开始日期")
    private Date serviceBeginTime;

    @ApiModelProperty(value = "服务结束")
    private Date serviceEndTime;

    @ApiModelProperty(value = "营业执照")
    private String licenseNo;

    @ApiModelProperty(value = "营业执照审批状态")
    private String licenseStatus;

    @ApiModelProperty(value = "营业执照审批失败原因")
    private String licenseRefuseReason;

    @ApiModelProperty(value = "经度")
    private String longitude;

    @ApiModelProperty(value = "纬度")
    private String latitude;

    @ApiModelProperty(value = "纬度")
    private String phone;

    @ApiModelProperty(value = "开户行")
    private String bank;

    @ApiModelProperty(value = "开户银行卡号")
    private String bankNo;

    @ApiModelProperty(value = "开户许可证地址")
    private String bankFile;

    @ApiModelProperty(value = "平台KEY ID，仅对平台下的租户")
    private String platformKeyId;

    @ApiModelProperty(value = "租户ID")
    private String keyId;

    @ApiModelProperty(value = "营业执照地址")
    private String licensePic;

    @ApiModelProperty(value = "logo")
    private String logo;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "简介")
    private String briefIntroduction;

    @ApiModelProperty(value = "详情")
    private String detailsIntroduction;

    @ApiModelProperty(value = "状态，默认ok")
    private String status;

}
