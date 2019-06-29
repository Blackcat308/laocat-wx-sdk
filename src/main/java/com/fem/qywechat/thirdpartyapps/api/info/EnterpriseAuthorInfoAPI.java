package com.fem.qywechat.thirdpartyapps.api.info;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fem.qywechat.thirdpartyapps.api.base.AccessSuiteTokenAPI;
import com.fem.qywechat.thirdpartyapps.api.info.vo.EnterpriseAuth;
import com.jeecg.qywx.api.core.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能描述:
 * 获取企业授权信息
 *
 * @author : blackCat
 * @date : 2019/6/29 15:47
 */
public class EnterpriseAuthInfoAPI {
    private static final Logger logger = LoggerFactory.getLogger(AccessSuiteTokenAPI.class);
    /**
     * 获取 access_suite_token
     */
    private static final String get_auth_info = "https://qyapi.weixin.qq.com/cgi-bin/service/get_auth_info?suite_access_token=SUITE_ACCESS_TOKEN";

    /**
     * 功能描述:
     * 获取企业授权信息
     *
     * @author : blackCat
     * @date : 2019/6/29 15:51
     */
    public static JSONObject getEnterpriseAuthInfo(String suite_access_token, EnterpriseAuth enterpriseAuth) {
        logger.info("[getEnterpriseAuthInfo] 接收参数:{},{}", suite_access_token, enterpriseAuth);
        String requestUrl = get_auth_info.replace("SUITE_ACCESS_TOKEN", suite_access_token);
        JSONObject jObject = HttpUtil.sendPost(requestUrl, JSON.toJSONString(enterpriseAuth));
        if (null == jObject) {
            return null;
        }
        return jObject;
    }

}
