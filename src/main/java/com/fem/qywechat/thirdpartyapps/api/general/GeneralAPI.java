package com.fem.qywechat.thirdpartyapps.api.general;

import com.fem.qywechat.thirdpartyapps.api.base.BaseAPI;
import com.fem.qywechat.thirdpartyapps.api.general.vo.SystemEventCallback;
import org.jeewx.api.mp.aes.AesException;
import org.jeewx.api.mp.aes.WXBizMsgCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能描述:
 * 通用参数设置
 *
 * @author : blackCat
 * @date : 2019/6/28 16:23
 */
public class GeneralAPI extends BaseAPI {
    private static final Logger logger = LoggerFactory.getLogger(GeneralAPI.class);

    /**
     * 功能描述:
     * 设置系统时间 回调
     *
     * @author : blackCat
     * @date : 2019/6/28 16:36
     */
    public static String systemEventCallback(SystemEventCallback systemEventCallback) throws AesException {
        logger.info("[systemEventCallback] 接收参数:{}", systemEventCallback);
        WXBizMsgCrypt wxBizMsgCrypt =
                wxBizMsgCryptConfig(systemEventCallback.getGeneralToken(),
                        systemEventCallback.getGeneralEncodingAeskey(), systemEventCallback.getGeneralAppId());

        return wxBizMsgCrypt.verifyUrl(systemEventCallback.getMsgSignature(),
                systemEventCallback.getTimestamp(), systemEventCallback.getNonce(), systemEventCallback.getEchostr());
    }


}
