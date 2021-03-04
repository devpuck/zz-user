package com.zz.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
 * 公司信息表
 * </pre>
 *
 * @author puck
 * @since 2021-03-04
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("COMPANY")
public class CompanyEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

@TableId(value = "ID", type = IdType.AUTO)
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
