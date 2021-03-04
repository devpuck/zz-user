package com.zz.service;

import com.zz.core.vo.LoginUserTokenVo;
import com.zz.model.entity.LoginEntity;
import com.zz.core.service.BaseService;
import com.zz.api.login.LoginQueryParam;
import com.zz.model.bo.login.LoginBo;
import com.zz.core.api.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 登陆信息 服务类
 * </pre>
 *
 * @author puck
 * @since 2021-03-02
 */
public interface LoginService extends BaseService<LoginEntity> {

    /**
     * 保存
     *
     * @param login
     * @return
     * @throws Exception
     */
    int saveLogin(LoginBo login);

    /**
     * 修改
     *
     * @param login
     * @return
     * @throws Exception
     */
    boolean updateLogin(LoginBo login);

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteLogin(Long id);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    LoginBo getLoginById(Serializable id);

    /**
     * 根据用户编码查询用户登陆信息
     * @param userCode
     * @return
     */
    public LoginBo queryLoginByUserCode(String userCode);

    /**
     * 登陆
     * @param loginBo
     * @param loginUserTokenVo
     * @return
     */
    public int login(LoginBo loginBo, LoginUserTokenVo loginUserTokenVo);

    /**
     * 更新邮箱
     * @param id
     * @param email
     * @return
     */
    public int updateEmail(Long id, String email);

    /**
     * 更新密码
     * @param id
     * @param password
     * @return
     */
    public int updatePassword(Long id, String password);

    /**
     * 更新用户名
     * @param id
     * @param userName
     * @return
     */
    public int updateUserName(Long id, String userName);
    /**
     * 获取分页对象
     *
     * @param loginQueryParam
     * @return
     * @throws Exception
     */
    Paging<LoginBo> getLoginPageList(LoginQueryParam loginQueryParam);

    /**
     * 更新手机号
     * @param id
     * @param phone
     * @return
     */
    public int updatePhone(Long id, String phone);

}
