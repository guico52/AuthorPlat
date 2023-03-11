package com.guico.authorplat.mapper;

import com.guico.authorplat.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 文章表 Mapper 接口
 * </p>
 *
 * @author guico
 * @since 2023-03-11
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}
