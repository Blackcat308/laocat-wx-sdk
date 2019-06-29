package com.fem.qywechat.thirdpartyapps.api.core.common;

import lombok.Data;

/**
 * 功能描述:
 * AccessPreAuthCode
 *
 * @author : blackCat
 * @date : 2019/6/29 11:14
 */
@Data
public class AccessPreAuthCode {

    private Integer errcode;

    private String errmsg;

    private String pre_auth_code;

    private String expires_in;

}
