package com.fem.qywechat.thirdpartyapps.api.authconfig.vo;

import lombok.Data;
import lombok.ToString;

/**
 * 功能描述:
 * 设置授权配置 请求包体
 *
 * @author : blackCat
 * @date : 2019/6/29 11:33
 */
@Data
@ToString
public class AuthConfigEntity {

    private String pre_auth_code;

    private SessionInfo session_info;
}
