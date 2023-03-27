package com.guico.authorplat.redis;

import cn.hutool.json.JSONUtil;
import com.guico.authorplat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

import static com.guico.authorplat.redis.RedisConstants.*;


@Component
public class RedisTool {

    @Autowired
    StringRedisTemplate template;

    public RedisTool(StringRedisTemplate redisTemplate){
        this.template = redisTemplate;
    }

    public void insertObject(String key, Object obj){
        insertObject(key, obj, DEFAULT_TIME_OUT, DEFAULT_TIME_UNIT);
    }

    public void insertObject(String key, Object obj, Long timeout, TimeUnit unit){
        String json = JSONUtil.toJsonStr(obj);
        template.opsForValue().set(key,json,timeout,unit);
    }

    public void insertLoginObject(User user){
        insertObject(USER_LOGIN+user.getUsername(),user,LOGIN_TIME_OUT,LOGIN_TIME_UNIT);
    }

    public void insertRegisterObject(User user){
        insertObject(USER_REGISTER+user.getUsername(),user);
    }

    public void insertResetPasswordObject(User user){insertObject(USER_RESET_PASSWORD+user.getUsername(),user);}

    public <T> T getObject (String key, Class<T> clazz){
        String json = template.opsForValue().get(key);
        return JSONUtil.toBean(json, clazz);
    }

    public User getRegisterObject(String username){
        return getObject(USER_REGISTER+username, User.class);
    }

    public User getResetPasswordObject(String username){
        return getObject(USER_RESET_PASSWORD+username, User.class);
    }

    public User getLoginObject(String username){
        return getObject(USER_LOGIN+username, User.class);
    }

    public void deleteObject(String key){
        template.delete(key);
    }

    public void clearRegisterObject(String username){
        deleteObject(USER_REGISTER+username);
    }

    public void clearResetPasswordObject(String username){
        deleteObject(USER_RESET_PASSWORD+username);
    }

    public void logout(String username){
        deleteObject(USER_LOGIN+username);
    }

}
