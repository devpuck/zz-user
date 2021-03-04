package com.zz.service.impl;

import com.zz.core.constant.CoreConstant;
import com.zz.model.entity.UserEntity;
import com.zz.mapper.user.UserMapper;
import com.zz.service.UserService;
import com.zz.api.user.UserQueryParam;
import com.zz.model.bo.user.UserBo;
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
 * 用户信息 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2021-03-02
 */
@Slf4j
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, UserEntity> implements UserService
{

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveUser(UserBo user)
    {
        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(user, entity);
        return super.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateUser(UserBo user)
    {
        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(user, entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteUser(Long id)
    {
        return super.removeById(id);
    }

    @Override
    public UserBo getUserById(Serializable id)
    {
        return userMapper.getUserById(id);
    }

    @Override
    public Paging<UserBo> getUserPageList(UserQueryParam userQueryParam)
    {
        Page page = setPageParam(userQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<UserBo> iPage = userMapper.getUserPageList(page, userQueryParam);
        return new Paging(iPage);
    }

}
