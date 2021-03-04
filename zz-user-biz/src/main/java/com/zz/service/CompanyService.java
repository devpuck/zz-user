package com.zz.service;

import com.zz.model.entity.CompanyEntity;
import com.zz.core.service.BaseService;
import com.zz.api.company.CompanyQueryParam;
import com.zz.model.bo.company.CompanyBo;
import com.zz.core.api.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 公司信息表 服务类
 * </pre>
 *
 * @author puck
 * @since 2021-03-04
 */
public interface CompanyService extends BaseService<CompanyEntity> {

    /**
     * 保存
     *
     * @param company
     * @return
     * @throws Exception
     */
    boolean saveCompany(CompanyBo company);

    /**
     * 修改
     *
     * @param company
     * @return
     * @throws Exception
     */
    boolean updateCompany(CompanyBo company);

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteCompany(Long id);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    CompanyBo getCompanyById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param companyQueryParam
     * @return
     * @throws Exception
     */
    Paging<CompanyBo> getCompanyPageList(CompanyQueryParam companyQueryParam);

}
