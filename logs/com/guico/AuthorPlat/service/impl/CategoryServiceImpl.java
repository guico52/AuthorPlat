package com.guico.AuthorPlat.service.impl;

import com.guico.AuthorPlat.entity.Category;
import com.guico.AuthorPlat.mapper.CategoryMapper;
import com.guico.AuthorPlat.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 分类表 服务实现类
 * </p>
 *
 * @author guico
 * @since 2023-03-11
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
