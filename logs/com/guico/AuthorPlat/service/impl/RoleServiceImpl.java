package com.guico.AuthorPlat.service.impl;

import com.guico.AuthorPlat.entity.Role;
import com.guico.AuthorPlat.mapper.RoleMapper;
import com.guico.AuthorPlat.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author guico
 * @since 2023-03-11
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
