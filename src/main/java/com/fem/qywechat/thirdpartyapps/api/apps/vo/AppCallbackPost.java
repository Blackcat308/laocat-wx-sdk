package com.fem.qywechat.thirdpartyapps.api.apps.vo;

import lombok.Data;
import lombok.ToString;

/**
 * 功能描述:
 * app 主动发起 返回用
 *
 * @author : blackCat
 * @date : 2019/6/28 16:45
 */
@Data
@ToString
public class AppCallbackPost {
    /**
     * app token
     */
    private String appToken;
    /**
     * app EncodingAeskey
     */
    private String appEncodingAeskey;
    /**
     * app 应用id
     */
    private String appId;


    private String msgSignature;

    private String timestamp;

    private String nonce;

    private String echostr;

    private String suiteSecret;
}
