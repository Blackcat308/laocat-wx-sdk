package com.fem.qywechat.thirdpartyapps.api.base;

import org.jeewx.api.mp.aes.AesException;
import org.jeewx.api.mp.aes.WXBizMsgCrypt;

/**
 * 功能描述:
 * 构造令牌
 *
 * @author : blackCat
 * @date : 2019/6/28 16:56
 */
public class BaseAPI {

    /**
     * 功能描述:
     * 构造  令牌
     *
     * @author : blackCat
     * @date : 2019/6/28 16:55
     */
    protected static WXBizMsgCrypt wxBizMsgCryptConfig(String token, String encodingAESKey, String appid) throws AesException {
        return new WXBizMsgCrypt(token, encodingAESKey, appid);
    }
}
