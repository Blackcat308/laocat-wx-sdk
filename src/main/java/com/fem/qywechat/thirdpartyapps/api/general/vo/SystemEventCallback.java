package com.fem.qywechat.thirdpartyapps.api.general.vo;

import lombok.Data;
import lombok.ToString;

/**
 * 功能描述:
 * 系统 时间回调 vo
 *
 * @author : blackCat
 * @date : 2019/6/28 16:32
 */
@Data
@ToString
public class SystemEventCallback {

    /**
     * 通用 token
     */
    private String generalToken;
    /**
     * 通用 EncodingAeskey
     */
    private String generalEncodingAeskey;
    /**
     * 通用 应用id
     */
    private String generalAppId;


    private String msgSignature;

    private String timestamp;

    private String nonce;

    private String echostr;
}
