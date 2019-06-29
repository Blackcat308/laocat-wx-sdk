package com.fem.qywechat.thirdpartyapps.api.apps.common;

/**
 * 功能描述:
 * 通知类型
 *
 * @author : blackCat
 * @date : 2019/6/29 14:20
 */
public interface NoticeType {

    /**
     * 配置key
     */
    String CONFIGURATION_KEY = "suite_ticket";
    /**
     *  创建授权 key
     */
    String AUTH_CREATE_KEY = "create_auth";
    /**
     *  取消授权  key
     */
    String AUTH_CANCEL_KEY = "cancel_auth";
    /**
     * 改变授权 key
     */
    String AUTH_CHANGE_KEY = "change_auth";
    /**
     * 判断标识
     */
    String JUDGE_FLAG = "InfoType";
}
