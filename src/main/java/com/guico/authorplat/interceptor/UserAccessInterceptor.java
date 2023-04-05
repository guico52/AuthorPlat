package com.guico.authorplat.interceptor;

import com.guico.authorplat.tool.JwtTool;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class UserAccessInterceptor implements HandlerInterceptor {

    @Resource
    JwtTool jwtTool;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        String authorization = request.getHeader("Authorization");
        String token = authorization.substring(7);
        Integer Role = jwtTool.getRole(token);
        if(Role > 1){
            response.setStatus(403);
            return false;
        }
        return true;
    }
}
