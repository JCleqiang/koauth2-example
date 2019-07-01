package com.leqiang222.oauth.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author LeQiang Li
 * @Date Created in 17:24 2019/7/1
 * @Description: 添加安全配置类
 * @Modified By:
 */
// 添加 @EnableOAuth2Sso 注解支持单点登录。单点登录拦截器会读取授权服务器的配置，发起形如： http://localhost:8881/auth/oauth/authorize?client_id=SampleClientId&redirect_uri=http://localhost:8882/ui/login&response_type=code&state=xtDCY2 的授权请求获取授权码。
@EnableOAuth2Sso
@Configuration
public class OAuthClientSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }
}
