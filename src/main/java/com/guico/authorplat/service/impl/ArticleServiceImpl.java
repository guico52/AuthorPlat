package com.guico.authorplat.service.impl;

import com.guico.authorplat.entity.Article;
import com.guico.authorplat.mapper.ArticleMapper;
import com.guico.authorplat.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author guico
 * @since 2023-03-16
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    @Override
    public List<Article> getAllArticle() {
        return query().list();
    }

    @Override
    public Article getArticleById(Long id) {
        return query().eq("id", id).one();
    }

}
