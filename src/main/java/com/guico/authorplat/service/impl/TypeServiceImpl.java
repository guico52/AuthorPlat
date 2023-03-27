package com.guico.authorplat.service.impl;

import com.guico.authorplat.entity.Type;
import com.guico.authorplat.mapper.TypeMapper;
import com.guico.authorplat.service.ITypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author guico
 * @since 2023-03-16
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements ITypeService {

}
