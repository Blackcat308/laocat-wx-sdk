package com.fem.qywechat.thirdpartyapps.api.base.vo;

import lombok.Data;
import lombok.ToString;

/**
 * 功能描述:
 * base返回体
 *
 * @author : blackCat
 * @date : 2019/6/29 11:40
 */
@Data
@ToString
public class BaseResponse {
    private Integer errcode;

    private String errmsg;
}
