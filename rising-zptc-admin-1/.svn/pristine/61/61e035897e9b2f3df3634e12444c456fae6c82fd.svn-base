package com.bhyf.dao.article;

import com.bhyf.model.article.ArticleCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by admin on 2016/4/25.
 */
public interface ArticleCategoryDao {

    public List<ArticleCategory>  findAllArticleCategory();

    public void saveArticleCategory(ArticleCategory articleCategory);

    public void updateArticleCategory(ArticleCategory articleCategory);

    public void removeArticleCategory(ArticleCategory articleCategory);

    List<ArticleCategory> findChildrenByParentId(@Param("parentId") Integer parentId);
}
