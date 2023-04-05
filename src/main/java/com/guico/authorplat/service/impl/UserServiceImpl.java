package com.guico.authorplat.service.impl;

import DTO.Result;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guico.authorplat.entity.User;
import com.guico.authorplat.mapper.UserMapper;
import com.guico.authorplat.redis.RedisTool;
import com.guico.authorplat.service.IUserService;
import com.guico.authorplat.tool.JwtTool;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author guico
 * @since 2023-03-16
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private static final String RESET_PASSWORD_SUCCESS_HTML = """
            <p>您已经成功重置密码!</p>      \s
                    """;

    // 设置注册时的sessionName

    @Resource
    private JavaMailSenderImpl javaMailSender;

    @Resource
    private JwtTool jwtTool;

    @Value("${spring.mail.username}")
    private String from;


    @Resource
    RedisTool redisTool;

    @Resource
    HttpServletRequest request;

    @Resource
    private CollectionServiceImpl collectionService;

    private static final String ENVIRONMENT = "http://localhost:8081";

    private static final String REGISTER_EMAIL_HTML = """
             <h1>欢迎您使用Author-plat</h1>
             <p>尊敬的用户%s，我们已经收到了您的注册请求，请您<a href="%s/api/user/activate?token=%s">点击链接</a>激活您的账户，链接的有效时间为3小时，请您尽快处理。</p>
            """;
    private static final String ACTIVATE_SUCCESS_HTML = """
                <p>您已经成功完成注册!</p>      \s
            """;
    private static final String ACTIVATE_FAIL_HTML = """
                <p>注册失败，原因可能为：%s，请您稍后重试。</p>        \s
            """;
    private static final String RESET_PASSWORD_EMAIL_HTML = """
                <h1>欢迎您使用Author-plat</h1>
                <p>尊敬的用户%s，我们已经收到了您的重置密码请求，请您<a href="%s/api/user/resetPassword?token=%s">点击链接</a>重置您的密码，链接的有效时间为3小时，请您尽快处理。</p>
            """;

    private static final String RESET_PASSWORD_FAIL_HTML = """        
                <p>重置密码失败，原因可能为：%s，请您稍后重试。</p>        \s
            """;

    @Override
    public Result register(String username, String password, String email) throws ExecutionException, InterruptedException {
        log.info("用户注册：username={}, password={}, email={}", username, password, email);
        // 校验写入信息，不可过长，不可为空
        if (username.length() > 30 || password.length() > 30 || email.length() > 50) {
            return Result.fail("注册信息过长");
        }
        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            return Result.fail("注册信息不能为空");
        }
        // 1. 首先对password进行md5加密
        password = new String(DigestUtil.md5(password));
        // 2. 生成User对象，包装信息
        User user = new User();
        user.setUsername(username);
        user.setPwd(password);
        user.setEmail(email);
        user.setRole(User.ROLE_NORMAL);
        user.setRegisterTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        // 3. 检查是否用户输入合法,并将User对象存入Session
        boolean success = !query().eq("username", username).or().eq("email", email).exists();
        // 4. 查看是否成功
        // 4.1 如果成功，生成token，向用户发送激活邮箱
        if (success) {
//            设置Session中的参数
            redisTool.insertRegisterObject(user);
//            生成jwttoken
            String token = jwtTool.createRegisterToken(username);
            String content = generateRegisterMail(username, token);
            CompletableFuture<Boolean> sendSuccess = sendMail(email, content);
            if (!sendSuccess.get()) {
                return Result.fail("邮件发送失败，请重试");
            }
            log.info("用户注册成功，已向用户发送激活邮件");
            return Result.success();
        }
        // 4.2 如果失败，查找错误原因
        if (query().eq("username", username).exists()) {
            return Result.fail("用户名已存在");
        }
        if (query().eq("email", email).exists()) {
            return Result.fail("邮箱已被注册");
        }
        return Result.fail("未知错误，请重试");
    }

    @Override
    public Result login(String username, String password) {
//        md5加密，查询数据库
        password = new String(DigestUtil.md5(password));
//        查询用户信息并验证
        User user = query().eq("username", username).eq("pwd", password).one();
        if (user != null) {
//            生成token
            String token = jwtTool.createLoginToken(username, user.getRole());
//            更新用户登录时间
            user.setLastLoginTime(LocalDateTime.now());
            updateById(user);
            return Result.success(token);
        }
        return Result.fail("用户名或密码错误");
    }

    //    退出登录业务需要前端删除token，后端删除用户相关信息
    @Override
    public Result logout() {
        String token = request.getHeader("token");
//        从token中获取Payload
        JWT jwt = JWTUtil.parseToken(token);
        String username = (String) jwt.getPayload("username");
        redisTool.logout(username);
        return Result.success();
    }

    @Override
    public String activate(String token) {
//        认证token，此方法仅能验证token是否合法或过期
        boolean success = jwtTool.verifyToken(token);
//        解析并获取payload
        JWT jwt = JWTUtil.parseToken(token);
        String username = (String) jwt.getPayload("username");
//        获取session中的user
        User user = redisTool.getRegisterObject(username);
        if (user == null) {
            return ACTIVATE_FAIL_HTML.formatted("服务器未检测到" + username + "的信息");
        }
//        比对信息，验证payload和token合法性
        if (user.getUsername().equals(username) && success) {
//            保存用户信息
            save(user);
//            清除redis中的user
            redisTool.clearRegisterObject(username);
//            创建默认收藏夹
            collectionService.createDefaultCollection(user.getId());
            return ACTIVATE_SUCCESS_HTML;
        }
        return ACTIVATE_FAIL_HTML.formatted("网络异常");
    }

    @Override
    public Result resetPasswordRequest(String password, String email) throws ExecutionException, InterruptedException {
//        检查用户提交的信息
        log.info("重置密码请求：password={}, email={}", password, email);
        User user = query().eq("email", email).one();
        if (user == null) {
            return Result.fail("邮箱未注册");
        }
//        信息无误，生成token，发送邮件，将用户信息存入redis
        String username = user.getUsername();
        password = new String(DigestUtil.md5(password));
        user.setPwd(password);
        redisTool.insertResetPasswordObject(user);
        String token = jwtTool.createResetPasswordToken(username);
        String content = generateResetPasswordMail(username, token);
        boolean success = sendMail(email, content).get();
//        发送成功，返回成功信息
        if (success) {
            log.info("用户重置密码成功，已向用户发送重置密码邮件");
            return Result.success();
        }
//        发送失败，返回失败信息
        return Result.fail("邮件发送失败，请重试");
    }

    @Override
    public String resetPassword(String token) {
//        验证token
        boolean success = jwtTool.verifyToken(token);
//        解析token
        JWT jwt = JWTUtil.parseToken(token);
        String username = (String) jwt.getPayload("username");
//        获取用户信息
        User user = redisTool.getResetPasswordObject(username);
        if (user == null) {
            return RESET_PASSWORD_FAIL_HTML.formatted("服务器未检测到" + username + "的信息");
        }
//        比对信息，验证payload和token合法性
        if (user.getUsername().equals(username) && success) {
//            保存用户信息
            update().set("pwd", user.getPwd()).eq("username", username).update();
//            清除redis中的user
            redisTool.clearResetPasswordObject(username);
            return RESET_PASSWORD_SUCCESS_HTML;
        }
        return RESET_PASSWORD_FAIL_HTML.formatted("网络异常");
    }


    //生成注册邮件
    private String generateRegisterMail(String username, String token) {
        return REGISTER_EMAIL_HTML.formatted(username, ENVIRONMENT, token);
    }

    //生成重置密码邮件
    private String generateResetPasswordMail(String username, String token) {
        return RESET_PASSWORD_EMAIL_HTML.formatted(username, ENVIRONMENT, token);
    }

    // 异步发送邮件
    @Async
    CompletableFuture<Boolean> sendMail(String to, String content) {
        try {
            MimeMessageHelper helper = new MimeMessageHelper(javaMailSender.createMimeMessage());
            helper.setFrom(Objects.requireNonNull(javaMailSender.getUsername()));
            helper.setTo(to);
            helper.setSubject("Author-plat");
            helper.setText(content, true);
            javaMailSender.send(helper.getMimeMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return CompletableFuture.completedFuture(false);
        }
        return CompletableFuture.completedFuture(true);
    }
}
