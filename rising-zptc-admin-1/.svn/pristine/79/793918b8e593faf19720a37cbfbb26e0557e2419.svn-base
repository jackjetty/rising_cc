package com.bhyf.service.impl.article;

import com.bhyf.dao.article.ArticleDao;
import com.bhyf.model.article.Article;
import com.bhyf.pojo.dto.article.ArticleDto;
import com.bhyf.service.interf.article.ArticleService;
import com.bhyf.util.EntityConvertUtils;
import com.rising.common.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleDao articleDao;
	
	@Override
	public Pagination findArticleByPagination(Pagination pagination) {
		List<Article> lists = articleDao.findArticleByPagination(pagination);
		Integer total = articleDao.countArticleByPagination(pagination);
		List<ArticleDto> articleDtoList = EntityConvertUtils.convertEntityToDtoList(lists,ArticleDto.class);
		pagination.setList(articleDtoList);
		pagination.setTotalCount(total);
		return pagination;
	}
	@Override
	public String saveArticle(Article cm){
		if(cm != null){
			try {
				articleDao.addArticle(cm);
				return  "添加成功！";
			} catch (Exception e) {
				return "添加失败！";
			}
		}else{
			return "实例对象不能为空！";
		}
	}
	
	@Override
	public String updateArticle(Article cm){
		if(cm != null){
			try {
				articleDao.editArticle(cm);
				return  "编辑成功！";
			} catch (Exception e) {
				return  "编辑失败！";
			}
		}else{
			return  "实例对象不能为空！";
		}
	}
	@Override
	public String removeArticle(Integer id){
		if(id != null){
				articleDao.removeArticle(id);
			return "删除成功";
		}else{
			return  "ID不能为空！";
		}
	}
	

	@Override
	public List<Article> getClassifies() {
		List<Article> lists = articleDao.getClassifies();
		return lists;
	}
	@Override
	public Article getArticleById(String id) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		List<Article> lists = articleDao.getArticleById(param);
		return lists.get(0);
	}
	
	@Override
	public String changeStatus(String id,String status) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		try {
			if("1".equals(status)){
				param.put("status", "0");
			}else if("0".equals(status)){
				param.put("status", "1");
			}
			articleDao.changeStatus(param);
			return  "修改状态成功！";
		} catch (Exception e) {
			return "修改状态失败！";
		}
	}
	@Override
	public String changeTop(String id,String top) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		try {
			if("1".equals(top)){
				param.put("top", "0");
			}else if("0".equals(top)){
				param.put("top", "1");
			}else{
				param.put("top", "1");
			}
			articleDao.changeTop(param);
			return  "置顶成功！";
		} catch (Exception e) {
			return "置顶失败！";
		}
	}
}
