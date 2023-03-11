package com.guico.authorplat.mapper;

import com.guico.authorplat.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author guico
 * @since 2023-03-11
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

}
