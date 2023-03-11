package com.guico.AuthorPlat.service.impl;

import com.guico.AuthorPlat.entity.Article;
import com.guico.AuthorPlat.mapper.ArticleMapper;
import com.guico.AuthorPlat.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author guico
 * @since 2023-03-11
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
