package com.fem.qywechat.thirdpartyapps.api.apps;

import cn.hutool.json.JSONObject;
import cn.hutool.json.XML;
import com.fem.qywechat.thirdpartyapps.api.apps.vo.AppCallback;
import com.fem.qywechat.thirdpartyapps.api.apps.vo.AppCallbackPost;
import com.fem.qywechat.thirdpartyapps.api.base.BaseAPI;
import com.fem.qywechat.thirdpartyapps.api.core.common.AccessSuiteEntity;
import org.jeewx.api.mp.aes.AesException;
import org.jeewx.api.mp.aes.WXBizMsgCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;

/**
 * 功能描述:
 * app设置参数api
 *
 * @author : blackCat
 * @date : 2019/6/28 16:22
 */
public class AppAPI extends BaseAPI {

    private static final Logger logger = LoggerFactory.getLogger(AppAPI.class);

    /**
     * 功能描述:
     * app 设置业务回调
     *
     * @author : blackCat
     * @date : 2019/6/28 16:51
     */
    public static String serviceCallback(AppCallback appCallback) throws AesException {
        logger.info("[serviceCallback] 接收参数:{}", appCallback);
        WXBizMsgCrypt wxBizMsgCrypt =
                wxBizMsgCryptConfig(appCallback.getAppToken(),
                        appCallback.getAppEncodingAeskey(), appCallback.getAppId());

        return wxBizMsgCrypt.verifyUrl(appCallback.getMsgSignature(),
                appCallback.getTimestamp(), appCallback.getNonce(), appCallback.getEchostr());
    }

    /**
     * 功能描述:
     * app 设置数据回调
     *
     * @author : blackCat
     * @date : 2019/6/28 16:51
     */
    public static String dataCallback(AppCallback appCallback) throws AesException {
        logger.info("[dataCallback] 接收参数:{}", appCallback);
        WXBizMsgCrypt wxBizMsgCrypt =
                wxBizMsgCryptConfig(appCallback.getAppToken(),
                        appCallback.getAppEncodingAeskey(), appCallback.getAppId());

        return wxBizMsgCrypt.verifyUrl(appCallback.getMsgSignature(),
                appCallback.getTimestamp(), appCallback.getNonce(), appCallback.getEchostr());
    }

    /**
     * 功能描述:
     * app 设置 指令回调
     *
     * @author : blackCat
     * @date : 2019/6/28 17:13
     */
    public static String instructionCallbackGet(AppCallback appCallback) throws AesException {
        logger.info("[instructionCallbackGet] 接收参数:{}", appCallback);
        WXBizMsgCrypt wxBizMsgCrypt =
                wxBizMsgCryptConfig(appCallback.getAppToken(),
                        appCallback.getAppEncodingAeskey(), appCallback.getAppId());

        return wxBizMsgCrypt.verifyUrl(appCallback.getMsgSignature(),
                appCallback.getTimestamp(), appCallback.getNonce(), appCallback.getEchostr());
    }

    /**
     * 功能描述:
     * app 设置 指令回调 接收
     *
     * @author : blackCat
     * @date : 2019/6/28 17:13
     */
    public static AccessSuiteEntity instructionCallbackPost(HttpServletRequest request, AppCallbackPost appCallbackPost) throws AesException, IOException {
        logger.info("[instructionCallbackPost] 接收参数:{}", appCallbackPost);
        AccessSuiteEntity accessSuiteEntity = null;
        WXBizMsgCrypt wxBizMsgCrypt =
                wxBizMsgCryptConfig(appCallbackPost.getAppToken(),
                        appCallbackPost.getAppEncodingAeskey(), appCallbackPost.getAppId());

        String postData = getPostData(request);

        String decryptMsg =
                wxBizMsgCrypt.decryptMsg(appCallbackPost.getMsgSignature(),
                        appCallbackPost.getTimestamp(), appCallbackPost.getNonce(), postData);

        JSONObject jObject =
                XML.toJSONObject(decryptMsg.replace("<xml>", "").replace("</xml>", ""));

        if (null != jObject) {
            accessSuiteEntity = AuthNotice
                    .getAccessSuiteEntityByAuthNoticeType(jObject, appCallbackPost);
        }
        logger.info("[instructionCallbackPost] 得到的请求包体为:{}", accessSuiteEntity);
        return accessSuiteEntity;
    }



    /**
     * 功能描述:
     * 获取 postData
     *
     * @author : blackCat
     * @date : 2019/6/28 18:41
     */
    private static String getPostData(HttpServletRequest request) throws IOException {
        String line = " ";

        BufferedReader reader = request.getReader();
        StringBuffer buffer = new StringBuffer();
        while (null != (line = reader.readLine())) {
            buffer.append(line);
        }

        String postData = Optional.of(buffer.toString()).orElse("");
        logger.info("[getPostData] postData:{}", postData);

        return postData;
    }


}
