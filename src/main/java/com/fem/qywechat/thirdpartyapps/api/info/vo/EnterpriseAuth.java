package com.fem.qywechat.thirdpartyapps.api.info.vo;

import lombok.Data;
import lombok.ToString;

/**
 * 功能描述:
 *  获取企业授权信息 请求体
 * @author : blackCat
 * @date : 2019/6/29 15:50
 */
@Data
@ToString
public class EnterpriseAuth {

    private String auth_corpid;

    private String permanent_code;

}
