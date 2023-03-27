package com.guico.authorplat.controller;

import DTO.Result;
import com.guico.authorplat.service.impl.UserServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author guico
 * @since 2023-03-16
 */
@CrossOrigin
@RequestMapping("/api/user")
@RestController
public class UserController {

    @Resource
    UserServiceImpl userService;


    @PostMapping(value = "/register" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Result register(String username, String password, String email) throws ExecutionException, InterruptedException {
        return userService.register(username, password, email);
    }

    @PostMapping("/login")
    public Result login(String username, String password) {
        return userService.login(username, password);
    }

    @RequestMapping(value = "/activate", produces = "text/html;charset=UTF-8")
    public String activate(String token) {
        return userService.activate(token);
    }

    @PostMapping("/logout")
    public Result logout() {
        return userService.logout();
    }

    @PostMapping("/resetPasswordRequest")
    public Result resetPasswordRequest(String password, String email) throws ExecutionException, InterruptedException {
        return userService.resetPasswordRequest(password, email);
    }

    @RequestMapping(value = "/resetPassword", produces = "text/html;charset=UTF-8")
    public String resetPassword(String token) {
        return userService.resetPassword(token);
    }
}
