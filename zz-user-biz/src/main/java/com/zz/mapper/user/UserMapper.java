package com.zz.mapper.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.model.entity.UserEntity;
import com.zz.api.user.UserQueryParam;
import com.zz.model.bo.user.UserBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 用户信息 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2021-03-02
 */
@Repository
public interface UserMapper extends BaseMapper<UserEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    UserBo getUserById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param userQueryParam
     * @return
     */
    IPage<UserBo> getUserPageList(@Param("page") Page page, @Param("param") UserQueryParam userQueryParam);

}
