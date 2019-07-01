package com.leqiang222.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * @Author LeQiang Li
 * @Date Created in 16:45 2019/7/1
 * @Description: 认证服务器配置，这里采用内存方式获取，其他方式获取在这里定制即可
 * @Modified By:
 */
@Configuration
@EnableAuthorizationServer
public class OAuthServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("LLQ_ClientId") // clientId, 可以类比为用户名
                .secret(passwordEncoder.encode("666666")) // secret， 可以类比为密码
                .authorizedGrantTypes("authorization_code")    // 授权类型，这里选择授权码
                .scopes("user_info") // 授权范围
                .autoApprove(true) // 自动认证
                .redirectUris("http://localhost:10052/login","http://localhost:10053/login")    // 认证成功重定向URL
                .accessTokenValiditySeconds(10); // 超时时间，10s
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        super.configure(endpoints);
    }
}
