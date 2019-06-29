package com.fem.qywechat.thirdpartyapps.api.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fem.qywechat.thirdpartyapps.api.core.common.AccessSuiteEntity;
import com.fem.qywechat.thirdpartyapps.api.core.common.AccessSuiteToken;
import com.jeecg.qywx.api.core.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能描述:
 * 申请 suite token
 *
 * @author : blackCat
 * @date : 2019/6/28 18:01
 */
public class AccessSuiteTokenAPI {

    private static final Logger logger = LoggerFactory.getLogger(AccessSuiteTokenAPI.class);
    /**
     * 获取 access_suite_token
     */
    private static final String access_suite_token = "https://qyapi.weixin.qq.com/cgi-bin/service/get_suite_token";

    /**
     * 功能描述:
     * 获取  SuiteToken
     * 请及时保存  2h
     *
     * @author : blackCat
     * @date : 2019/6/28 18:13
     */
    public static AccessSuiteToken getAccessSuiteToken(AccessSuiteEntity accessSuiteEntity) {
        logger.info("[getAccessSuiteToken] 接收参数:{}", accessSuiteEntity);
        AccessSuiteToken accessSuiteToken = null;
        JSONObject jObject = null;
        try {
            jObject = HttpUtil.sendPost(access_suite_token, JSON.toJSONString(accessSuiteEntity));
            accessSuiteToken = JSON.toJavaObject(jObject, AccessSuiteToken.class);
        } catch (Exception e) {
            accessSuiteToken = JSON.toJavaObject(jObject, AccessSuiteToken.class);
            logger.info("[getAccessSuiteToken] 获取token失败:{}", accessSuiteToken);
            e.printStackTrace();
        }
        return accessSuiteToken;
    }
}
