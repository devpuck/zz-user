package com.zz.mapper.login;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.model.entity.LoginEntity;
import com.zz.api.login.LoginQueryParam;
import com.zz.model.bo.login.LoginBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 登陆信息 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2021-03-02
 */
@Repository
public interface LoginMapper extends BaseMapper<LoginEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    LoginBo getLoginById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param loginQueryParam
     * @return
     */
    IPage<LoginBo> getLoginPageList(@Param("page") Page page, @Param("param") LoginQueryParam loginQueryParam);

    /**
     * 检查手机号是否被注册
     * @param phone
     * @param keyID
     * @return
     */
    public Long checkPhoneExist(String phone, String keyID);

    /**
     * 检查邮箱是否被注册
     * @param email
     * @param keyID
     * @return
     */
    public Long checkEmailExist(String email, String keyID);

    /**
     * 肩擦用户名是否被注册
     * @param userName
     * @param keyID
     * @return
     */
    public Long checkUserNameExist(String userName, String keyID);

    /**
     * 更新密码
     * @param id
     * @param password
     * @return
     */
    public boolean updatePassword(Long id, String password);

    /**
     * 更新邮箱
     * @param id
     * @param email
     * @return
     */
    public boolean updateEmail(Long id, String email);

    /**
     * 更新手机
     * @param id
     * @param phone
     * @return
     */
    public boolean updatePhone(Long id, String phone);

    /**
     * 更新用户名
     * @param id
     * @param userName
     * @return
     */
    public boolean updateUserName(Long id,String userName);



}
