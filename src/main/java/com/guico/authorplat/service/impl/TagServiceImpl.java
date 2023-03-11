package com.guico.authorplat.service.impl;

import com.guico.authorplat.entity.Tag;
import com.guico.authorplat.mapper.TagMapper;
import com.guico.authorplat.service.ITagService;
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
