package com.guico.authorplat.service;

import com.guico.authorplat.entity.Collection;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author guico
 * @since 2023-03-16
 */
public interface ICollectionService extends IService<Collection> {

    boolean createDefaultCollection(Integer userId);
}
