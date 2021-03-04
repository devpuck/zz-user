package com.zz.api.login;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.zz.core.api.SortQueryParam;

/**
 * <pre>
 * 登陆信息 查询参数对象
 * </pre>
 *
 * @author puck
 * @date 2021-03-02
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "LoginQueryParam对象", description = "登陆信息查询参数")
public class LoginQueryParam extends SortQueryParam {
    private static final long serialVersionUID = 1L;
}
