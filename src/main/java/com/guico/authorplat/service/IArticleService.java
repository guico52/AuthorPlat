package com.guico.authorplat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guico.authorplat.entity.Article;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author guico
 * @since 2023-03-16
 */
public interface IArticleService extends IService<Article> {
    List<Article> getAllArticle();

    Article getArticleById(Long id);


}
