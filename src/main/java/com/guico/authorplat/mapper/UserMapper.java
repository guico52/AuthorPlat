package com.guico.authorplat.mapper;

import com.guico.authorplat.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author guico
 * @since 2023-03-16
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
