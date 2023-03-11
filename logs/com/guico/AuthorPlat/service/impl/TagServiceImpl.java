package com.guico.AuthorPlat.service.impl;

import com.guico.AuthorPlat.entity.Tag;
import com.guico.AuthorPlat.mapper.TagMapper;
import com.guico.AuthorPlat.service.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签表 服务实现类
 * </p>
 *
 * @author guico
 * @since 2023-03-11
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

}
