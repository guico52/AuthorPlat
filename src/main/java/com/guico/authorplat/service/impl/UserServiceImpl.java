package com.guico.authorplat.service.impl;

import com.guico.authorplat.entity.User;
import com.guico.authorplat.mapper.UserMapper;
import com.guico.authorplat.service.IUserService;
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
