package com.fem.qywechat.thirdpartyapps.api.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fem.qywechat.thirdpartyapps.api.admin.vo.AdminEntity;
import com.jeecg.qywx.api.core.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能描述:
 * 获取应用的管理员列表
 *
 * @author : blackCat
 * @date : 2019/6/29 16:01
 */
public class AdminAPI {

    private static final Logger logger = LoggerFactory.getLogger(AdminAPI.class);
    /**
     * 获取应用的管理员列表
     */
    private static final String get_admin_list = "https://qyapi.weixin.qq.com/cgi-bin/service/get_admin_list?suite_access_token=SUITE_ACCESS_TOKEN";

    /**
     * 功能描述:
     * 获取应用的管理员列表
     *
     * @author : blackCat
     * @date : 2019/6/29 11:42
     */
    public static JSONObject getAdminList(String suite_access_token, AdminEntity adminEntity) {
        logger.info("[getAdminList] 接收参数:{},{}", suite_access_token, adminEntity);
        String requestUrl = get_admin_list.replace("SUITE_ACCESS_TOKEN", suite_access_token);
        JSONObject jObject = HttpUtil.sendPost(requestUrl, JSON.toJSONString(adminEntity));
        if (null != jObject) {
            return null;
        }
        return jObject;
    }
}
