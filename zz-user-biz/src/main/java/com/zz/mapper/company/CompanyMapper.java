package com.zz.mapper.company;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.model.entity.CompanyEntity;
import com.zz.api.company.CompanyQueryParam;
import com.zz.model.bo.company.CompanyBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 公司信息表 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2021-03-04
 */
@Repository
public interface CompanyMapper extends BaseMapper<CompanyEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    CompanyBo getCompanyById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param companyQueryParam
     * @return
     */
    IPage<CompanyBo> getCompanyPageList(@Param("page") Page page, @Param("param") CompanyQueryParam companyQueryParam);

}
