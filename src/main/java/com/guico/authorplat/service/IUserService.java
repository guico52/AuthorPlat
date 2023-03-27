package com.guico.authorplat.service;

import DTO.Result;
import com.guico.authorplat.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.concurrent.ExecutionException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author guico
 * @since 2023-03-16
 */
public interface IUserService extends IService<User> {

    Result register(String username, String password, String email) throws Exception;

    Result login(String username, String password);

    Result logout();

    String activate(String token);

    Result resetPasswordRequest(String username, String email) throws ExecutionException, InterruptedException;

    String resetPassword(String token);

}
