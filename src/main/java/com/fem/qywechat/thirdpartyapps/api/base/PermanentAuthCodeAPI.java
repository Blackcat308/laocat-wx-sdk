package com.fem.qywechat.thirdpartyapps.api.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fem.qywechat.thirdpartyapps.api.base.vo.AuthCodeEntity;
import com.jeecg.qywx.api.core.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能描述:
 * 获取企业永久授权码
 *
 * @author : blackCat
 * @date : 2019/6/29 15:13
 */
public class PermanentAuthCodeAPI {

    private static final Logger logger = LoggerFactory.getLogger(PermanentAuthCodeAPI.class);
    /**
     * 获取 access_suite_token
     */
    private static final String get_permanent_code = "https://qyapi.weixin.qq.com/cgi-bin/service/get_permanent_code?suite_access_token=SUITE_ACCESS_TOKEN";

    /**
     * 功能描述:
     * 获取永久code
     * @author : blackCat
     * @date : 2019/6/29 15:17
     */
    public static JSONObject getPermanentCode(String suite_access_token, AuthCodeEntity authCodeEntity) {
        logger.info("[getPermanentCode] 接收参数:{},{}", suite_access_token,authCodeEntity);
        String requestUrl = get_permanent_code.replace("SUITE_ACCESS_TOKEN", suite_access_token);
        JSONObject jObject = HttpUtil.sendPost(requestUrl, JSON.toJSONString(authCodeEntity));
        if (null == jObject) {
            return null;
        }
        return jObject;
    }
}
