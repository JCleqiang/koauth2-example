package com.leqiang222.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @Author LeQiang Li
 * @Date Created in 16:44 2019/7/1
 * @Description:
 * @Modified By:
 */
@SpringBootApplication
// 表示作为资源服务器
@EnableResourceServer
public class OAuthServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OAuthServerApplication.class, args);
    }
}
