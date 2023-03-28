package com.guico.authorplat.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author guico
 * @since 2023-03-16
 */
@TableName("t_user")
public class User implements Serializable {

    public static final int ROLE_ROOT = 0;
    public static final int ROLE_ADMIN = 1;
    public static final int ROLE_NORMAL = 2;

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 用户昵称
     */
      private String username;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 0-根用户；1-管理员；2-普通用户
     */
    private Integer role;

    /**
     * 用户注册时间
     */
    private LocalDateTime registerTime;

    /**
     * 用户信息上次更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 用户上次认证登录时间
     */
    private LocalDateTime lastLoginTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public LocalDateTime getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(LocalDateTime registerTime) {
        this.registerTime = registerTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id = " + id +
        "username = " + username +
        ", pwd = " + pwd +
        ", email = " + email +
        ", role = " + role +
        ", registerTime = " + registerTime +
        ", updateTime = " + updateTime +
        ", lastLoginTime = " + lastLoginTime +
        "}";
    }
}
