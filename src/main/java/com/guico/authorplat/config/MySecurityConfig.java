package com.guico.authorplat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
    // 配置认证规则
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .authorizeExchange()  // 开启认证
                .pathMatchers("/login")/* 匹配路径 */.permitAll() /* 放行 */
                .anyExchange().authenticated() /* 其他路径需要认证 */
                .and() /* 与 */
                .build(); /* 构建 */
    }

    //
}
