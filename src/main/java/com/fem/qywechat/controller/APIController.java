package com.fem.qywechat.controller;

import com.fem.qywechat.constants.ThirdPartyQyWechatConstant;
import com.fem.qywechat.thirdpartyapps.api.apps.AppAPI;
import com.fem.qywechat.thirdpartyapps.api.apps.vo.AppCallback;
import com.fem.qywechat.thirdpartyapps.api.apps.vo.AppCallbackPost;
import com.fem.qywechat.thirdpartyapps.api.core.common.AccessSuiteEntity;
import com.fem.qywechat.thirdpartyapps.api.general.GeneralAPI;
import com.fem.qywechat.thirdpartyapps.api.general.vo.SystemEventCallback;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jeewx.api.mp.aes.AesException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能描述:
 * 公共调用 层
 *
 * @author : blackCat
 * @date : 2019/6/28 14:18
 */
@Slf4j
@RestController
@AllArgsConstructor
public class APIController {

    /**
     * 功能描述:
     * 配置通用开发时调用
     * 系统事件接收URL
     *
     * @author : blackCat
     * @date : 2019/6/28 15:38
     */
    @GetMapping("/receiveUrl")
    public String receiveUrl(@RequestParam("msg_signature") String msg_signature, @RequestParam("timestamp") String timestamp,
                             @RequestParam("nonce") String nonce, @RequestParam("echostr") String echostr) {
        SystemEventCallback system = new SystemEventCallback();
        system.setGeneralToken(ThirdPartyQyWechatConstant.GENERAL_TOKEN);
        system.setGeneralEncodingAeskey(ThirdPartyQyWechatConstant.GENERAL_ENCODINGAESKEY);
        system.setGeneralAppId(ThirdPartyQyWechatConstant.GENERAL_APPID);

        system.setMsgSignature(msg_signature);
        system.setNonce(nonce);
        system.setEchostr(echostr);
        system.setTimestamp(timestamp);
        String re = null;
        try {
            re = GeneralAPI.systemEventCallback(system);
        } catch (AesException e) {
            e.printStackTrace();
        }
        return re;
    }

    /**
     * 功能描述:
     * 数据回调参数设置
     *
     * @author : blackCat
     * @date : 2019/6/28 16:02
     */
    @GetMapping("/dataCallback")
    public String dataCallback(@RequestParam("msg_signature") String msg_signature, @RequestParam("timestamp") String timestamp,
                               @RequestParam("nonce") String nonce, @RequestParam("echostr") String echostr) {
        AppCallback appCallback = new AppCallback();
        appCallback.setAppToken(ThirdPartyQyWechatConstant.APP_TOKEN);
        appCallback.setAppEncodingAeskey(ThirdPartyQyWechatConstant.APP_ENCODINGAESKEY);
        appCallback.setAppId(ThirdPartyQyWechatConstant.GENERAL_APPID);

        appCallback.setMsgSignature(msg_signature);
        appCallback.setTimestamp(timestamp);
        appCallback.setNonce(nonce);
        appCallback.setEchostr(echostr);
        String re = null;
        try {
            re = AppAPI.dataCallback(appCallback);
        } catch (AesException e) {
            e.printStackTrace();
        }
        return re;
    }

    /**
     * 功能描述:
     * 业务回调参数设置
     *
     * @author : blackCat
     * @date : 2019/6/28 16:02
     */
    @RequestMapping("/serviceCallback")
    public String serviceCallback(@RequestParam("msg_signature") String msg_signature, @RequestParam("timestamp") String timestamp,
                                  @RequestParam("nonce") String nonce, @RequestParam("echostr") String echostr) {
        AppCallback appCallback = new AppCallback();
        appCallback.setAppToken(ThirdPartyQyWechatConstant.APP_TOKEN);
        appCallback.setAppEncodingAeskey(ThirdPartyQyWechatConstant.APP_ENCODINGAESKEY);
        appCallback.setAppId(ThirdPartyQyWechatConstant.GENERAL_APPID);

        appCallback.setMsgSignature(msg_signature);
        appCallback.setTimestamp(timestamp);
        appCallback.setNonce(nonce);
        appCallback.setEchostr(echostr);

        String re = null;
        try {
            re = AppAPI.serviceCallback(appCallback);
        } catch (AesException e) {
            e.printStackTrace();
        }
        return re;
    }


    /**
     * 功能描述:
     * 设置 指令回调  get
     *
     * @author : blackCat
     * @date : 2019/6/28 17:21
     */
    @GetMapping("/instructionCallback")
    public String instructionCallback(@RequestParam("msg_signature") String msg_signature, @RequestParam("timestamp") String timestamp,
                                      @RequestParam("nonce") String nonce, @RequestParam(value = "echostr", required = false) String echostr) {
        AppCallback appCallback = new AppCallback();
        appCallback.setAppToken(ThirdPartyQyWechatConstant.APP_TOKEN);
        appCallback.setAppEncodingAeskey(ThirdPartyQyWechatConstant.APP_ENCODINGAESKEY);
        appCallback.setAppId(ThirdPartyQyWechatConstant.GENERAL_APPID);

        appCallback.setMsgSignature(msg_signature);
        appCallback.setTimestamp(timestamp);
        appCallback.setNonce(nonce);
        appCallback.setEchostr(echostr);

        String re = null;
        try {
            re = AppAPI.instructionCallbackGet(appCallback);
        } catch (AesException e) {
            e.printStackTrace();
        }
        return re;
    }

    /**
     * 功能描述:
     * 主动请求 比如 刷新 suite_ticket
     *
     * @author : blackCat
     * @date : 2019/6/29 11:09
     */
    @PostMapping("/instructionCallback")
    public String instructionCallback(@RequestParam("msg_signature") String msg_signature, @RequestParam("timestamp") String timestamp,
                                      @RequestParam("nonce") String nonce, @RequestParam(value = "echostr", required = false) String echostr,
                                      HttpServletRequest request, HttpServletResponse response) {

        AppCallbackPost appCallbackPost = new AppCallbackPost();
        appCallbackPost.setAppToken(ThirdPartyQyWechatConstant.APP_TOKEN);
        appCallbackPost.setAppEncodingAeskey(ThirdPartyQyWechatConstant.APP_ENCODINGAESKEY);
        appCallbackPost.setAppId(ThirdPartyQyWechatConstant.APP_APPID);
        appCallbackPost.setMsgSignature(msg_signature);
        appCallbackPost.setTimestamp(timestamp);
        appCallbackPost.setNonce(nonce);
        appCallbackPost.setEchostr(echostr);
        appCallbackPost.setSuiteSecret("uLfdRkSCPOKqRfuKll2ZG5Uk0OfQZ8aX0t1vNb9WbUs");
        try {
            AccessSuiteEntity accessSuiteEntity = AppAPI.instructionCallbackPost(request, appCallbackPost);
            System.out.println(accessSuiteEntity);
//            AccessSuiteToken accessSuiteToken = AccessSuiteTokenAPI.getAccessSuiteToken(accessSuiteEntity);
//            System.out.println(accessSuiteToken);
            // 获取token
//            getSuiteToken(decryptMsgs,suite);
            return "success";
        } catch (AesException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
