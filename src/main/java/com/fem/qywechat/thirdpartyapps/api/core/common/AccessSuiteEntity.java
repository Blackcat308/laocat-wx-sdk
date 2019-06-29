package com.fem.qywechat.thirdpartyapps.api.core.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Optional;

/**
 * 功能描述:
 * 封装 请求 suite token 的请求包体
 *
 * @author : blackCat
 * @date : 2019/6/28 18:14
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AccessSuiteEntity {

    private String suite_id;

    private String suite_secret;

    private String suite_ticket;

    private String infoType;

    private String authCode;

    private String authCorpId;

    private String timeStamp;

    public AccessSuiteEntity(String suite_id, String suite_secret, String suite_ticket, String infoType, String timeStamp) {
        this.suite_id = suite_id;
        this.suite_secret = suite_secret;
        this.suite_ticket = suite_ticket;
        this.infoType = infoType;
        this.timeStamp = timeStamp;
    }

    public AccessSuiteEntity(String suite_id, String infoType, String authCode, String timeStamp) {
        this.suite_id = suite_id;
        this.infoType = infoType;
        if ("create_auth".equals(infoType)) {
            this.authCode = authCode;
        }
        this.authCorpId = authCode;
        this.timeStamp = timeStamp;
    }

}
