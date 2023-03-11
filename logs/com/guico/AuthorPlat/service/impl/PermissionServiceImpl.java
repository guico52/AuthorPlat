package com.guico.AuthorPlat.service.impl;

import com.guico.AuthorPlat.entity.Permission;
import com.guico.AuthorPlat.mapper.PermissionMapper;
import com.guico.AuthorPlat.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author guico
 * @since 2023-03-11
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
