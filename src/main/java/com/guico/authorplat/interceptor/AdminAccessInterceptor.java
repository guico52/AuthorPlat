package com.guico.authorplat.interceptor;

import com.guico.authorplat.tool.JwtTool;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminAccessInterceptor implements HandlerInterceptor {

    @Resource
    JwtTool jwtTool;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
//        获取Authorization
        String authorization = request.getHeader("Authorization");
//        获取token
        String token = authorization.substring(7);
//        获取用户信息
        Integer Role = jwtTool.getRole(token);
//        判断是否为管理员
        if(Role >= 1){
            response.setStatus(403);
            return false;
        }
//
        return true;
    }
}
