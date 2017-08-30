package com.bhyf.controller.article;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.bhyf.model.article.Article;
import com.bhyf.pojo.dto.article.ArticleCategoryDto;
import com.bhyf.pojo.qo.article.ArticleQo;
import com.bhyf.pojo.response.DataGridResponse;
import com.bhyf.service.interf.article.ArticleCategoryService;
import com.rising.common.component.BaseController;
import com.rising.common.component.PaginQo;
import com.rising.common.page.Pagination;
import com.rising.common.util.PropertiesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bhyf.service.interf.article.ArticleService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller()
@RequestMapping("")
public class ArticleController extends BaseController{
	private static Properties properties = PropertiesUtils.getProps("/properties/other.properties");
	@Resource
	ArticleService articleService;
	@Resource
	private ArticleCategoryService articleCategoryService;

	
	@RequestMapping("/to_article")
	public String toEmployment(HttpServletRequest request,
							   @RequestParam(value="category",required=false) Integer category,
							   Model model){

		List<ArticleCategoryDto> articleCategoryDtoList = articleCategoryService.findChildrenByParentId(category);
		String article_path = properties.getProperty("article_path");
		String article_link = properties.getProperty("article_link");
		model.addAttribute("article_path",article_path);
		model.addAttribute("article_link",article_link);
		model.addAttribute("articleCategoryDtoList",articleCategoryDtoList);
		String totalCategory = "";
		for (ArticleCategoryDto articleCategoryDto : articleCategoryDtoList) {
			totalCategory += ","+articleCategoryDto.getId();
		}
		if(articleCategoryDtoList.size()>0){
			totalCategory= totalCategory.substring(1);
		}else{
			totalCategory = category+"";
		}
		model.addAttribute("totalCategory",totalCategory);
		return "/article/article.html";
	}
	
	@RequestMapping("/article_list")
	@ResponseBody
	public DataGridResponse getClassifyList(HttpServletRequest request,
											@RequestParam(value="page",required=false) Integer pageNo,
											@RequestParam(value="rows",required=false) Integer pageSize,
											@ModelAttribute ArticleQo qo,
											Model model){

		PaginQo paginQo = new PaginQo();
		paginQo.setPageNo(pageNo);
		paginQo.setPageSize(pageSize);

		Pagination pagination = this.createPagination(paginQo, qo);

		pagination= articleService.findArticleByPagination(pagination);
		return new DataGridResponse(pagination);
	}
	

	@RequestMapping("/find_article_by_id")
	public @ResponseBody
	Article getClassifyById(String id) {
		return articleService.getArticleById(id);
	}
	
	@RequestMapping("/add_article")
	public @ResponseBody
	String addClassify(String title,String content,String createUser,String status,String category) {
		Article rm = new Article();
		Date c = new Date();
		rm.setTitle(title);
		rm.setContent(content);
		rm.setCreateTime(c);
		rm.setCreateUser(createUser);
		rm.setIssueTime(c);
		rm.setCategory(Integer.parseInt(category));
		rm.setIssueUser(createUser);
		rm.setTop(0);
		rm.setStatus(Integer.parseInt(status));
		return articleService.saveArticle(rm);
	}
	
	
	@RequestMapping("/edit_article")
	public @ResponseBody
	String editClassify(
			@ModelAttribute Article rm
	) throws ParseException {
		return articleService.updateArticle(rm);
	}
	
	@RequestMapping("/delete_article")
	public @ResponseBody
	String deleteClassify(Integer id) {
		return articleService.removeArticle(id);
	}
	
	@RequestMapping("/changeStatus")
	public @ResponseBody String changeStatus(String id,String status) {
		return articleService.changeStatus(id,status);
	}
	@RequestMapping("/changeTop")
	public @ResponseBody String changeTop(String id,String top) {
		return articleService.changeTop(id,top);
	}
}
