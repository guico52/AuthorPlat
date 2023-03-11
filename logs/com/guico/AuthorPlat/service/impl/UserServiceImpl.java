package com.guico.AuthorPlat.service.impl;

import com.guico.AuthorPlat.entity.User;
import com.guico.AuthorPlat.mapper.UserMapper;
import com.guico.AuthorPlat.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author guico
 * @since 2023-03-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
