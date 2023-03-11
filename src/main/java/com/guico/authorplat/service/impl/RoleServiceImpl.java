package com.guico.authorplat.service.impl;

import com.guico.authorplat.entity.Role;
import com.guico.authorplat.mapper.RoleMapper;
import com.guico.authorplat.service.IRoleService;
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
