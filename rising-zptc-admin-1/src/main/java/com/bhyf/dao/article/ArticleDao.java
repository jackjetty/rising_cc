package com.bhyf.dao.article;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bhyf.model.article.Article;
import com.rising.common.page.Pagination;
import org.apache.ibatis.annotations.Param;

public interface ArticleDao {

	List<Article> findArticleByPagination(Pagination pagination);
	
	void addArticle(Article rm);
	
	void editArticle(Article rm);
	
	void removeArticle(@Param("id") Integer id);
	
	void changeStatus(HashMap<String, Object> map);
	
	void changeTop(HashMap<String, Object> map);
	
	Integer countArticleByPagination(Pagination pagination);

	List<Article> getClassifies();

	List<Article> getArticleById(HashMap<String, Object> map);

	void removeArticleByCategory(@Param("category")Integer category);
	
}
