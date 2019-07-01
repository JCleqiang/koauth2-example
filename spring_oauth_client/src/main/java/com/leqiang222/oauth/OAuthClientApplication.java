package com.leqiang222.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

/**
 * @Author LeQiang Li
 * @Date Created in 17:24 2019/7/1
 * @Description:
 * @Modified By:
 */
@SpringBootApplication
public class OAuthClientApplication extends SpringBootServletInitializer {
    // 启动类需要添加 RequestContextListener，用于监听HTTP请求事件。
    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    public static void main(String[] args) {
        SpringApplication.run(OAuthClientApplication.class, args);
    }
}
