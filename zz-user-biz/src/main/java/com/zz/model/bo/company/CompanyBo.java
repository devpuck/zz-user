package com.zz.model.bo.company;

import com.zz.core.bo.BaseBo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 公司信息表 查询结果业务对象
 * </pre>
 *
 * @author puck
 * @date 2021-03-04
 */
@Data
@Accessors(chain = true)
public class CompanyBo extends BaseBo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 行业
     */
    private String industry;

    /**
     * 评分
     */
    private Double score;

    /**
     * 服务费
     */
    private Double serviceMoney;

    /**
     * 服务开始日期
     */
    private Date serviceBeginTime;

    /**
     * 服务结束
     */
    private Date serviceEndTime;

    /**
     * 营业执照
     */
    private String licenseNo;

    /**
     * 营业执照审批状态
     */
    private String licenseStatus;

    /**
     * 营业执照审批失败原因
     */
    private String licenseRefuseReason;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 纬度
     */
    private String phone;

    /**
     * 开户行
     */
    private String bank;

    /**
     * 开户银行卡号
     */
    private String bankNo;

    /**
     * 开户许可证地址
     */
    private String bankFile;

    /**
     * 平台KEY ID，仅对平台下的租户
     */
    private String platformKeyId;

    /**
     * 租户ID
     */
    private String keyId;

    /**
     * 营业执照地址
     */
    private String licensePic;

    /**
     * logo
     */
    private String logo;

    /**
     * 地址
     */
    private String address;

    /**
     * 简介
     */
    private String briefIntroduction;

    /**
     * 详情
     */
    private String detailsIntroduction;

    /**
     * 状态，默认ok
     */
    private String status;

}
