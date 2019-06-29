package com.fem.qywechat.thirdpartyapps.api.admin.vo;

import lombok.Data;
import lombok.ToString;

/**
 * 功能描述:
 *  获取应用的管理员列表 请求包体
 * @author : blackCat
 * @date : 2019/6/29 16:02
 */
@Data
@ToString
public class AdminEntity {

    private String auth_corpid;

    private Long agentid;
}
