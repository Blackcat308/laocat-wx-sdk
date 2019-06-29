package com.fem.qywechat.thirdpartyapps.api.authconfig.vo;

import lombok.Data;
import lombok.ToString;

/**
 * 功能描述:
 * session_info 请求体
 *
 * @author : blackCat
 * @date : 2019/6/29 11:31
 */
@Data
@ToString
public class SessionInfo {
    /**
     * 允许进行授权的应用id，如1、2、3， 不填或者填空数组都表示允许授权套件内所有应用（仅旧的多应用套件可传此参数，新开发者可忽略）
     */
    private String[] appid;
    /**
     * 授权类型：0 正式授权， 1 测试授权。 默认值为0。注意，请确保应用在正式发布后的授权类型为“正式授权”
     */
    private String auth_type;


}
