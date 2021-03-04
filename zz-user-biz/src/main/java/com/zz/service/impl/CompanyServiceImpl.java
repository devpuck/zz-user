package com.zz.service.impl;

import com.zz.core.constant.CoreConstant;
import com.zz.model.entity.CompanyEntity;
import com.zz.mapper.company.CompanyMapper;
import com.zz.service.CompanyService;
import com.zz.api.company.CompanyQueryParam;
import com.zz.model.bo.company.CompanyBo;
import com.zz.core.service.impl.BaseServiceImpl;
import com.zz.core.api.Paging;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;


/**
 * <pre>
 * 公司信息表 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2021-03-04
 */
@Slf4j
@Service
public class CompanyServiceImpl extends BaseServiceImpl<CompanyMapper, CompanyEntity> implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveCompany(CompanyBo company)
    {
        CompanyEntity entity = new CompanyEntity();
        BeanUtils.copyProperties(company , entity);
        return super.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateCompany(CompanyBo company)
    {
        CompanyEntity entity = new CompanyEntity();
        BeanUtils.copyProperties(company , entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteCompany(Long id) {
        return super.removeById(id);
    }

    @Override
    public CompanyBo getCompanyById(Serializable id) {
        return companyMapper.getCompanyById(id);
    }

    @Override
    public Paging<CompanyBo> getCompanyPageList(CompanyQueryParam companyQueryParam) {
        Page page = setPageParam(companyQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<CompanyBo> iPage = companyMapper.getCompanyPageList(page, companyQueryParam);
        return new Paging(iPage);
    }

}
