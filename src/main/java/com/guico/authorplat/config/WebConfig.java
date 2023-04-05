package com.guico.authorplat.config;

import com.guico.authorplat.interceptor.AdminAccessInterceptor;
import com.guico.authorplat.interceptor.UserAccessInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Bean
    public AdminAccessInterceptor adminAccessInterceptor() {
        return new AdminAccessInterceptor();
    }

    @Bean
    public UserAccessInterceptor userAccessInterceptor() {
        return new UserAccessInterceptor();
    }

    private final String[] excludePathPatterns = {
            "/user/register",
            "/user/login",
            "/user/activate",
            "/user/resetPasswordRequest",
            "/user/resetPassword"
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminAccessInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns(excludePathPatterns);
        registry.addInterceptor(userAccessInterceptor())
                .addPathPatterns("/user/**")
                .excludePathPatterns(excludePathPatterns);
    }
}
