package com.zz.service;

import com.zz.model.entity.UserEntity;
import com.zz.core.service.BaseService;
import com.zz.api.user.UserQueryParam;
import com.zz.model.bo.user.UserBo;
import com.zz.core.api.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 用户信息 服务类
 * </pre>
 *
 * @author puck
 * @since 2021-03-02
 */
public interface UserService extends BaseService<UserEntity> {

    /**
     * 保存
     *
     * @param user
     * @return
     * @throws Exception
     */
    boolean saveUser(UserBo user);

    /**
     * 修改
     *
     * @param user
     * @return
     * @throws Exception
     */
    boolean updateUser(UserBo user);

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteUser(Long id);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserBo getUserById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param userQueryParam
     * @return
     * @throws Exception
     */
    Paging<UserBo> getUserPageList(UserQueryParam userQueryParam);

}
