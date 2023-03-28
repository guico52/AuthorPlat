package com.guico.authorplat;

import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JwtTool {

    @Value("${sa-token.jwt-secret-key}")
    String jwtKey;


    // 设置注册token过期时间（小时）
    private static final int REGISTER_TOKEN_EXPIRE_HOURS = 3;
    // 设置登录token过期时间（天）
    private static final int LOGIN_TOKEN_EXPIRE_DAYS = 7;
    // 设置注册token过期时间（毫秒）
    private static final int TOKEN_EXPIRE = REGISTER_TOKEN_EXPIRE_HOURS * 60 * 60 * 1000;
    // 设置登录token过期时间（毫秒）
    private static final int LOGIN_TOKEN_EXPIRE = LOGIN_TOKEN_EXPIRE_DAYS * 24 * 60 * 60 * 1000;

    public String createToken(int expire, Map<String, String> payload) {
        JWT jwt = JWT.create().setKey(jwtKey.getBytes()).setNotBefore(DateUtil.date()).setIssuedAt(DateUtil.date()).setExpiresAt(DateUtil.offsetMillisecond(DateUtil.date(), expire));
        for (Map.Entry<String, String> entry : payload.entrySet()) {
            jwt.setPayload(entry.getKey(), entry.getValue());
        }
        return jwt.sign();
    }

    public String createLoginToken(String username){
        return createToken(LOGIN_TOKEN_EXPIRE, Map.of("username", username));
    }

    public String createRegisterToken(String username){
        return createToken(TOKEN_EXPIRE, Map.of("username", username));
    }

    public String createResetPasswordToken(String username){
        return createToken(TOKEN_EXPIRE, Map.of("username", username));
    }

    public boolean verifyToken(String token){
        return JWTUtil.verify(token, jwtKey.getBytes());
    }
}
