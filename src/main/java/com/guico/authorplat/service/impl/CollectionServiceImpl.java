package com.guico.authorplat.service.impl;

import com.guico.authorplat.entity.Collection;
import com.guico.authorplat.mapper.CollectionMapper;
import com.guico.authorplat.service.ICollectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author guico
 * @since 2023-03-16
 */
@Service
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, Collection> implements ICollectionService {

    @Override
    public boolean createDefaultCollection(String username) {
        Collection collection = new Collection();
        collection.setCreateTime(LocalDateTime.now());
        collection.setDefault(true);
        collection.setName("Default");
        collection.setOwnerId(username);
        return save(collection);
    }
}
