package com.bhyf.controller.article;

import com.bhyf.pojo.command.article.CreateArticleCategoryCommand;
import com.bhyf.pojo.command.article.RemoveArticleCategoryCommand;
import com.bhyf.pojo.command.article.UpdateArticleCategoryCommand;
import com.bhyf.pojo.dto.article.ArticleCategoryDto;
import com.bhyf.pojo.dto.perm.PermDto;
import com.bhyf.pojo.response.DataGridResponse;
import com.bhyf.service.interf.article.ArticleCategoryService;
import com.rising.common.component.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by admin on 2016/4/25.
 */
@Controller
@RequestMapping("/article_category")
public class ArticleCategoryController extends BaseController{

    @Resource
    private ArticleCategoryService articleCategoryService;


    @RequestMapping("to_article_category_list")
    public String toUserList(HttpServletRequest request,
                             Model model){

        return "/article/article_category.html";
    }


    @RequestMapping("article_category_list")
    @ResponseBody
    public DataGridResponse findAllPermForEasyUi(HttpServletRequest request,
                                                 Model model){
        List<ArticleCategoryDto> articleCategoryDtoList = articleCategoryService.findAllArticleCategoryForEasyUi();
        return new DataGridResponse(articleCategoryDtoList.size(),articleCategoryDtoList);
    }

    @RequestMapping("save_article_category")
    @ResponseBody
    public String saveEnter(HttpServletRequest request,
                            @ModelAttribute CreateArticleCategoryCommand command,
                            Model model){
        String str =  articleCategoryService.saveArticleCategory(command);
        return str;
    }
    @RequestMapping("remove_article_category")
    @ResponseBody
    public String removeEnter(HttpServletRequest request,
                              @ModelAttribute RemoveArticleCategoryCommand command,
                              Model model){


        String str =  articleCategoryService.removeArticleCategory(command);
        return str;
    }
    @RequestMapping("update_article_category")
    @ResponseBody
    public String updateEnter(HttpServletRequest request,
                              @ModelAttribute UpdateArticleCategoryCommand command,
                              Model model){


        String str =  articleCategoryService.updateArticleCategory(command);
        return str;
    }
}
