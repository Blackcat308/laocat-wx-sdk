package com.fem.qywechat.thirdpartyapps.api.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fem.qywechat.thirdpartyapps.api.core.common.AccessPreAuthCode;
import com.jeecg.qywx.api.core.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能描述:
 * 获取  pre_auth_code
 *
 * @author : blackCat
 * @date : 2019/6/29 11:12
 */
public class AccessPreAuthCodeAPI {
    private static final Logger logger = LoggerFactory.getLogger(AccessPreAuthCodeAPI.class);
    /**
     * 获取suite token url
     */
    private static final String access_pre_auth_code = "https://qyapi.weixin.qq.com/cgi-bin/service/get_pre_auth_code?suite_access_token=SUITE_ACCESS_TOKEN";


    /**
     * 功能描述:
     * 获取预授权码
     *
     * @author : blackCat
     * @date : 2019/6/29 11:16
     */
    public static AccessPreAuthCode getAccessPreAuthCode(String suite_access_token) {
        logger.info("[getAccessPreAuthCode] 接收参数:{}", suite_access_token);
        AccessPreAuthCode accessPreAuthCode = null;
        String requestUrl = access_pre_auth_code.replace("SUITE_ACCESS_TOKEN", suite_access_token);
        JSONObject jsonObject = HttpUtil.sendGet(requestUrl);
        if (null != jsonObject) {
            accessPreAuthCode = JSON.toJavaObject(jsonObject, AccessPreAuthCode.class);
            logger.info("[getAccessPreAuthCode] 得到的PreAuthCode为:{}", accessPreAuthCode);
        }
        return null;
    }
}
