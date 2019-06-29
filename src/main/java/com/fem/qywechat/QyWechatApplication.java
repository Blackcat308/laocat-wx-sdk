package com.fem.qywechat;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan("com.fem.qywechat.mapper")
public class QyWechatApplication {

    public static void main(String[] args) {
        SpringApplication.run(QyWechatApplication.class, args);
        log.info("qy_wechat start success!");
    }

}
