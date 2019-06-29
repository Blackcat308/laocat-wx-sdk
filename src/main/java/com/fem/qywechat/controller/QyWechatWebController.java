package com.fem.qywechat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述:
 *
 * @author Jeazer
 * @create 2019-06-28 15:42
 */
@Slf4j
@Controller
@RequestMapping("test")
public class QyWechatWebController {

    @RequestMapping("/index")
    public String index() {
        log.info("访问index");
        return "test/index";
    }


}
