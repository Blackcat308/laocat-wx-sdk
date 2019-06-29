package com.fem.qywechat.thirdpartyapps.api.apps;

import cn.hutool.json.JSONObject;
import com.fem.qywechat.thirdpartyapps.api.apps.common.NoticeType;
import com.fem.qywechat.thirdpartyapps.api.apps.vo.AppCallbackPost;
import com.fem.qywechat.thirdpartyapps.api.core.common.AccessSuiteEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * 功能描述:
 *  根据通知事件的不同返回不同的参数
 * @author : blackCat
 * @date : 2019/6/29 14:24
 */
public class AuthNotice {

    private static final Logger logger = LoggerFactory.getLogger(AuthNotice.class);

    protected static AccessSuiteEntity getAccessSuiteEntityByAuthNoticeType(JSONObject jObject, AppCallbackPost appCallbackPost) {
        AccessSuiteEntity accessSuiteEntity = null;
        switch (String.valueOf(jObject.get(NoticeType.JUDGE_FLAG))) {
            case NoticeType.CONFIGURATION_KEY:
                logger.info("[configurationKey] 进入回调配置");
                accessSuiteEntity = new AccessSuiteEntity(
                        String.valueOf(Optional.of(jObject.get("SuiteId")).orElse("")),
                        appCallbackPost.getSuiteSecret(),
                        String.valueOf(Optional.of(jObject.get("SuiteTicket")).orElse("")),
                        String.valueOf(Optional.of(jObject.get("InfoType")).orElse("")),
                        String.valueOf(Optional.of(jObject.get("TimeStamp")).orElse(""))
                );
                return accessSuiteEntity;
            case NoticeType.AUTH_CREATE_KEY:
                logger.info("[configurationKey] 进入应用安装 || 授权成功通知");
                accessSuiteEntity = new AccessSuiteEntity(
                        String.valueOf(Optional.of(jObject.get("SuiteId")).orElse("")),
                        String.valueOf(Optional.of(jObject.get("InfoType")).orElse("")),
                        String.valueOf(Optional.of(jObject.get("AuthCode")).orElse("")),
                        String.valueOf(Optional.of(jObject.get("TimeStamp")).orElse(""))
                );
                return accessSuiteEntity;
            case NoticeType.AUTH_CANCEL_KEY:
                logger.info("[configurationKey] 删除应用  || 取消授权通知");
                accessSuiteEntity = new AccessSuiteEntity(
                        String.valueOf(Optional.of(jObject.get("SuiteId")).orElse("")),
                        String.valueOf(Optional.of(jObject.get("InfoType")).orElse("")),
                        String.valueOf(Optional.of(jObject.get("AuthCorpId")).orElse("")),
                        String.valueOf(Optional.of(jObject.get("TimeStamp")).orElse(""))
                );
                return accessSuiteEntity;
            case NoticeType.AUTH_CHANGE_KEY:
                logger.info("[configurationKey]  变更授权通知");
                accessSuiteEntity = new AccessSuiteEntity(
                        String.valueOf(Optional.of(jObject.get("SuiteId")).orElse("")),
                        String.valueOf(Optional.of(jObject.get("InfoType")).orElse("")),
                        String.valueOf(Optional.of(jObject.get("AuthCorpId")).orElse("")),
                        String.valueOf(Optional.of(jObject.get("TimeStamp")).orElse(""))
                );
                return accessSuiteEntity;
            default:
                return new AccessSuiteEntity();
        }
    }
}
