package com.fem.qywechat.thirdpartyapps.api.core.common;

import lombok.Data;
import lombok.ToString;

/**
 * 功能描述:
 * 封装 suite token
 *
 * @author : blackCat
 * @date : 2019/6/28 18:14
 */
@Data
@ToString
public class AccessSuiteToken {

    private String errcode;

    private String errmsg;

    private String suite_access_token;

    private String expires_in;
}
