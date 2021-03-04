package com.zz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.api.login.AccountType;
import com.zz.api.login.BaseLoginType;
import com.zz.core.api.ApiResultCode;
import com.zz.core.auth.JwtProperties;
import com.zz.core.auth.JwtUtil;
import com.zz.core.constant.CoreConstant;
import com.zz.core.db.ExcludeEmptyQueryWrapper;
import com.zz.core.util.EncryptSHA;
import com.zz.core.vo.LoginUserTokenVo;
import com.zz.model.bo.user.UserBo;
import com.zz.model.entity.LoginEntity;
import com.zz.mapper.login.LoginMapper;
import com.zz.service.LoginService;
import com.zz.api.login.LoginQueryParam;
import com.zz.model.bo.login.LoginBo;
import com.zz.core.service.impl.BaseServiceImpl;
import com.zz.core.api.Paging;
import com.zz.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;

import java.time.Duration;
import java.util.Date;
import java.util.UUID;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;


/**
 * <pre>
 * 登陆信息 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2021-02-23
 */
@Slf4j
@Service
public class LoginServiceImpl extends BaseServiceImpl<LoginMapper, LoginEntity> implements LoginService
{
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProperties jwtProperties;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveLogin(LoginBo login)
    {
        String userCode = UUID.randomUUID().toString().replaceAll("-", "");
        login.setUserCode(userCode);

        login.setCreatedDate(new Date());

        LoginEntity entity = new LoginEntity();
        BeanUtils.copyProperties(login, entity);

        String accountType = login.getAccountType();
        if(null == accountType)
        {
            accountType = AccountType.SAAS_NORMAL;
        }

        //如果是saas管理员、paas、platform管理员，则只允许在这几种类型中注册一次
        boolean checkInSaasManager = checkInSaasManager(accountType);
        LoginEntity queryLoginEntity = null;
        if(checkInSaasManager)
        {
            //判断用户名，邮箱、手机号是否重复，通常使用一个即可
            queryLoginEntity = loginMapper.selectOne(new ExcludeEmptyQueryWrapper<LoginEntity>()
                    .eq("USERNAME", login.getUsername())
                    .eq("PHONE", login.getPhone())
                    .eq("EMAIL", login.getEmail())
                    .ne("ACCOUNT_TYPE",AccountType.SAAS_NORMAL));
        }else
        {
            //判断用户名，邮箱、手机号是否重复，通常使用一个即可
            queryLoginEntity = loginMapper.selectOne(new ExcludeEmptyQueryWrapper<LoginEntity>()
                    .eq("USERNAME", login.getUsername())
                    .eq("PHONE", login.getPhone())
                    .eq("EMAIL", login.getEmail())
                    .eq("KEY_ID", login.getKeyId()));
        }

        if (null != queryLoginEntity)
        {
            return ApiResultCode.USER_ALREADY_EXIST_EXCEPTION.getCode();
        }

        EncryptSHA encryptSHA = EncryptSHA.getInstances();
        String encryptPassword = encryptSHA.encrypt(login.getPassword());
        entity.setPassword(encryptPassword);

        boolean saveResult = super.save(entity);
        if (!saveResult)
        {
            return ApiResultCode.FAIL.getCode();
        }

        //注册成功后，自动创建用户信息，并将必要信息拷贝
        UserBo userBo = new UserBo();
//        userBo.setUuid(uuid);
        userBo.setEmail(login.getEmail());
        userBo.setPhone(login.getPhone());
        userBo.setUsername(login.getUsername());
        userBo.setKeyId(login.getKeyId());
        userBo.setCreatedDate(new Date());

        saveResult = userService.saveUser(userBo);
        if (!saveResult)
        {
            return ApiResultCode.FAIL.getCode();
        }

        return ApiResultCode.SUCCESS.getCode();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateLogin(LoginBo login)
    {
        LoginEntity entity = new LoginEntity();
        BeanUtils.copyProperties(login, entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteLogin(Long id)
    {
        return super.removeById(id);
    }

    @Override
    public LoginBo getLoginById(Serializable id)
    {
        return loginMapper.getLoginById(id);
    }

    @Override
    public LoginBo queryLoginByUserCode(String userCode)
    {
        LoginEntity loginEntity = loginMapper.selectOne(new QueryWrapper<LoginEntity>().lambda().eq(LoginEntity::getUserCode, userCode));
        if (null != loginEntity)
        {
            LoginBo loginBo = new LoginBo();
            BeanUtils.copyProperties(loginEntity, loginBo);
            return loginBo;
        }
        return null;
    }

    @Override
    public Paging<LoginBo> getLoginPageList(LoginQueryParam loginQueryParam)
    {
        Page page = setPageParam(loginQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<LoginBo> iPage = loginMapper.getLoginPageList(page, loginQueryParam);
        return new Paging(iPage);
    }

    @Override
    public int updatePhone(Long id, String phone)
    {
        boolean updateResult = false;

        LoginBo loginBo = getLoginById(id);
        if (null == loginBo)
        {
            return ApiResultCode.USER_NOT_EXIST_EXCEPTION.getCode();
        }

        String keyID = loginBo.getKeyId();
        Long checkID = loginMapper.checkPhoneExist(phone, keyID);
        if (null == checkID)
        {
            updateResult = loginMapper.updatePhone(id, phone);
        }
        else
        {
            if (id.equals(checkID))
            {
                updateResult = loginMapper.updatePhone(id, phone);
            }
            else
            {
                //被其它用户占用
                return ApiResultCode.USER_ALREADY_EXIST_EXCEPTION.getCode();
            }
        }

        return ApiResultCode.SUCCESS.getCode();
    }

    @Override
    public int updateUserName(Long id, String userName)
    {
        boolean updateResult = false;

        LoginBo loginBo = getLoginById(id);
        if (null == loginBo)
        {
            return ApiResultCode.USER_NOT_EXIST_EXCEPTION.getCode();
        }

        String keyID = loginBo.getKeyId();
        Long checkID = loginMapper.checkUserNameExist(userName, keyID);
        if (null == checkID)
        {
            updateResult = loginMapper.updateUserName(id, userName);
        }
        else
        {
            if (id.equals(checkID))
            {
                updateResult = loginMapper.updateUserName(id, userName);
            }
            else
            {
                //被其它用户占用
                return ApiResultCode.USER_ALREADY_EXIST_EXCEPTION.getCode();
            }
        }

        return ApiResultCode.SUCCESS.getCode();
    }

    @Override
    public int updateEmail(Long id, String email)
    {
        boolean updateResult = false;
        LoginBo loginBo = getLoginById(id);
        if (null == loginBo)
        {
            return ApiResultCode.USER_NOT_EXIST_EXCEPTION.getCode();
        }

        String keyID = loginBo.getKeyId();
        Long checkID = loginMapper.checkEmailExist(email, keyID);
        if (null == checkID)
        {
            updateResult = loginMapper.updateEmail(id, email);
        }
        else
        {
            if (id.equals(checkID))
            {
                updateResult = loginMapper.updateEmail(id, email);
            }
            else
            {
                //被其它用户占用
                return ApiResultCode.USER_ALREADY_EXIST_EXCEPTION.getCode();
            }
        }

        return ApiResultCode.SUCCESS.getCode();
    }

    @Override
    public int updatePassword(Long id, String password)
    {
        boolean updateResult = false;

        LoginBo loginBo = getLoginById(id);
        if (null == loginBo)
        {
            return ApiResultCode.USER_NOT_EXIST_EXCEPTION.getCode();
        }

        EncryptSHA encryptSHA = EncryptSHA.getInstances();
        String encryptPassword = encryptSHA.encrypt(password);

        updateResult = loginMapper.updatePassword(id, password);
        if (updateResult)
        {
            return ApiResultCode.SUCCESS.getCode();
        }
        return ApiResultCode.FAIL.getCode();
    }

    @Override
    public int login(LoginBo loginBo, LoginUserTokenVo loginUserTokenVo)
    {
        String phone = loginBo.getPhone();
        String userName = loginBo.getUsername();
        String email = loginBo.getUsername();
        String keyID = loginBo.getKeyId();

        //用户名、手机号、邮箱不能全部为空
        LoginEntity queryLoginEntity = loginMapper.selectOne(new ExcludeEmptyQueryWrapper<LoginEntity>()
                .eq("USERNAME", userName)
                .eq("PHONE", phone)
                .eq("EMAIL", email)
                .eq("KEY_ID", keyID));
        if (null == queryLoginEntity)
        {
            return ApiResultCode.USER_NOT_EXIST_EXCEPTION.getCode();
        }

        String accountType = queryLoginEntity.getAccountType();
        String loginType = loginBo.getLoginType();
        String baseLoginType = getBaseLoginType(loginType);

        //saas 管理权限验证
        if (BaseLoginType.SAAS_MANAGER.equals(baseLoginType))
        {
            if (!checkInSaasManager(accountType))
            {
                return ApiResultCode.USER_TYPE_EXCEPTION.getCode();
            }
        }

        //paas 管理权限验证
        if (BaseLoginType.PAAS.equals(baseLoginType))
        {
            if (!checkInPaasManager(accountType))
            {
                return ApiResultCode.USER_TYPE_EXCEPTION.getCode();
            }
        }

        //platform 管理权限验证
        if (BaseLoginType.PLATFORM.equals(baseLoginType))
        {
            if (!checkInPlatformManager(accountType))
            {
                return ApiResultCode.USER_TYPE_EXCEPTION.getCode();
            }
        }

        EncryptSHA encryptSHA = EncryptSHA.getInstances();
        String encryptPassword = encryptSHA.encrypt(loginBo.getPassword());
        if (encryptPassword.equals(queryLoginEntity.getPassword()))
        {
            // 获取数据库中保存的盐值
            String newSalt = this.getSalt(queryLoginEntity.getUserCode(), jwtProperties);

            // 生成token字符串并返回
            Long expireSecond = jwtProperties.getExpireSecond();
            String token = JwtUtil.generateToken(queryLoginEntity.getUserCode(), newSalt, Duration.ofSeconds(expireSecond));

            log.info("TOKEN:"+token);

            loginUserTokenVo.setToken(token);
            loginUserTokenVo.setId(queryLoginEntity.getId());
            loginUserTokenVo.setUserKey(queryLoginEntity.getKeyId());

            return ApiResultCode.SUCCESS.getCode();
        }
        return ApiResultCode.LOGIN_EXCEPTION.getCode();
    }

    /**
     * 获取基础登陆类型
     *
     * @param loginType
     * @return
     */
    public String getBaseLoginType(String loginType)
    {
        if (loginType.contains(BaseLoginType.SAAS_MANAGER))
        {
            return BaseLoginType.SAAS_MANAGER;
        }

        if (loginType.contains(BaseLoginType.PAAS))
        {
            return BaseLoginType.PAAS;
        }

        if (loginType.contains(BaseLoginType.PLATFORM))
        {
            return BaseLoginType.PLATFORM;
        }

        if (loginType.contains(BaseLoginType.SAAS))
        {
            return BaseLoginType.SAAS;
        }
        return "normal";
    }

    /**
     * 检查是否可以进行saas登陆，paas、platform账号均可以登陆saas
     *
     * @param accountType
     * @return
     */
    public boolean checkInSaasManager(String accountType)
    {
        if (AccountType.SAAS_MANAGER.equals(accountType) || AccountType.PAAS_MANAGER.equals(accountType) || AccountType.PLATFORM_MANAGER.equals(accountType))
        {
            return true;
        }
        return false;
    }

    /**
     * 是否可以进行paas登陆，platform账户也可以进行paas登陆
     *
     * @param accountType
     * @return
     */
    public boolean checkInPaasManager(String accountType)
    {
        if (AccountType.PAAS_MANAGER.equals(accountType) || AccountType.PLATFORM_MANAGER.equals(accountType))
        {
            return true;
        }
        return false;
    }

    public boolean checkInPlatformManager(String accountType)
    {
        if (AccountType.PLATFORM_MANAGER.equals(accountType))
        {
            return true;
        }
        return false;
    }

    /**
     * 加工盐值
     *
     * @param salt
     * @param jwtProperties
     * @return
     */
    private String getSalt(String salt, JwtProperties jwtProperties)
    {
        String newSalt;
        if (jwtProperties.isSaltCheck())
        {
            // 包装盐值
            newSalt = getSalt(jwtProperties.getSecret(), salt);
        }
        else
        {
            newSalt = jwtProperties.getSecret();
        }
        return newSalt;
    }

    /**
     * 盐值包装
     *
     * @param secret 配置文件中配置的附加盐值
     * @param salt   数据库中保存的盐值
     * @return
     */
    private String getSalt(String secret, String salt)
    {
        if (StringUtils.isBlank(secret) && StringUtils.isBlank(salt))
        {
            return null;
        }
        // 加密方法
        String newSalt = secret + salt;
        return newSalt;
    }

}
