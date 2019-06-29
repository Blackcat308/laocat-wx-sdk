package com.fem.qywechat.thirdpartyapps.api.authconfig;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fem.qywechat.thirdpartyapps.api.authconfig.vo.AuthConfigEntity;
import com.fem.qywechat.thirdpartyapps.api.base.vo.BaseResponse;
import com.jeecg.qywx.api.core.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能描述:
 * 设置授权配置
 *
 * @author : blackCat
 * @date : 2019/6/29 11:26
 */
public class AuthConfigAPI {
    private static final Logger logger = LoggerFactory.getLogger(AuthConfigAPI.class);
    /**
     * 设置授权配置
     */
    private static final String set_session_info = "https://qyapi.weixin.qq.com/cgi-bin/service/set_session_info?suite_access_token=SUITE_ACCESS_TOKEN";

    /**
     * 功能描述:
     * 设置授权配置
     *
     * @author : blackCat
     * @date : 2019/6/29 11:42
     */
    public static BaseResponse AuthConfiguration(String suite_access_token, AuthConfigEntity authConfigEntity) {
        logger.info("[AuthConfiguration] 接收参数:{},{}", suite_access_token, authConfigEntity);
        BaseResponse baseResponse = null;
        String requestUrl = set_session_info.replace("SUITE_ACCESS_TOKEN", suite_access_token);
        JSONObject jObject = HttpUtil.sendPost(requestUrl, JSON.toJSONString(authConfigEntity));
        if (null != jObject) {
            baseResponse = JSON.toJavaObject(jObject, BaseResponse.class);
            logger.info("[AuthConfiguration] 返回的包体为:{}", baseResponse);
        }
        return null;
    }
}
