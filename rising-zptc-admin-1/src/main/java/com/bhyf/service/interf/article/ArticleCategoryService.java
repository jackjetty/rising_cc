package com.bhyf.service.interf.article;

import com.bhyf.model.article.ArticleCategory;
import com.bhyf.pojo.command.article.CreateArticleCategoryCommand;
import com.bhyf.pojo.command.article.RemoveArticleCategoryCommand;
import com.bhyf.pojo.command.article.UpdateArticleCategoryCommand;
import com.bhyf.pojo.dto.article.ArticleCategoryDto;

import java.util.List;

/**
 * Created by admin on 2016/4/25.
 */
public interface ArticleCategoryService {

    List<ArticleCategoryDto> findAllArticleCategoryForEasyUi();


    String saveArticleCategory(CreateArticleCategoryCommand command);

    String updateArticleCategory(UpdateArticleCategoryCommand command);

    String removeArticleCategory(RemoveArticleCategoryCommand command);

    List<ArticleCategoryDto> findChildrenByParentId(Integer parentId);

}
