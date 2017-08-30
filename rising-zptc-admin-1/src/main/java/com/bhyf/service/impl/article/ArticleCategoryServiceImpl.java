package com.bhyf.service.impl.article;

import com.bhyf.dao.article.ArticleCategoryDao;
import com.bhyf.dao.article.ArticleDao;
import com.bhyf.model.article.Article;
import com.bhyf.model.article.ArticleCategory;
import com.bhyf.model.perm.SysPermission;
import com.bhyf.pojo.command.article.CreateArticleCategoryCommand;
import com.bhyf.pojo.command.article.RemoveArticleCategoryCommand;
import com.bhyf.pojo.command.article.UpdateArticleCategoryCommand;
import com.bhyf.pojo.dto.article.ArticleCategoryDto;
import com.bhyf.pojo.dto.perm.PermDto;
import com.bhyf.service.interf.article.ArticleCategoryService;
import com.bhyf.util.EntityConvertUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/4/25.
 */
@Service
public class ArticleCategoryServiceImpl implements ArticleCategoryService {

    @Resource
    private ArticleCategoryDao articleCategoryDao;
    @Resource
    private ArticleDao articleDao;



    @Override
    public List<ArticleCategoryDto> findAllArticleCategoryForEasyUi() {
        List<ArticleCategory> articleCategoryList = articleCategoryDao.findAllArticleCategory();
        return createEasyUiArticleCategory(articleCategoryList);
    }

    @Override
    public String saveArticleCategory(CreateArticleCategoryCommand command) {
        ArticleCategory articleCategory = new ArticleCategory();

        if(articleCategory.create(command)){
            articleCategoryDao.saveArticleCategory(articleCategory);
            return "添加成功";
        }
        return "参数错误";
    }

    @Override
    public String updateArticleCategory(UpdateArticleCategoryCommand command) {
        ArticleCategory articleCategory = new ArticleCategory();
        if(articleCategory.update(command)){
            articleCategoryDao.updateArticleCategory(articleCategory);
            return "修改成功";
        }
        return "参数错误";
    }

    @Override
    public String removeArticleCategory(RemoveArticleCategoryCommand command) {
        ArticleCategory articleCategory = new ArticleCategory();
        if(articleCategory.remove(command)){
            articleDao.removeArticleByCategory(articleCategory.getId());
            articleCategoryDao.removeArticleCategory(articleCategory);
            return "删除成功";
        }
        return "参数错误";
    }

    @Override
    public List<ArticleCategoryDto> findChildrenByParentId(Integer parentId) {
        List<ArticleCategory> articleCategoryList =
                articleCategoryDao.findChildrenByParentId(parentId);
        List<ArticleCategoryDto> articleCategoryDtoList = EntityConvertUtils.convertEntityToDtoList(articleCategoryList,ArticleCategoryDto.class);
        return articleCategoryDtoList;
    }


    private static List<ArticleCategoryDto> createEasyUiArticleCategory(List<ArticleCategory> articleCategoryList) {
        List<ArticleCategoryDto> articleCategoryDtoList = new ArrayList<>();
        Map<Integer,List<ArticleCategoryDto>> map = new HashMap<>();
        for (ArticleCategory articleCategory:articleCategoryList){
            ArticleCategoryDto dto = new ArticleCategoryDto(articleCategory);
            if(dto.getParentId() !=null){
                List<ArticleCategoryDto> articleCategoryDtos = map.get(dto.getParentId());
                if(articleCategoryDtos == null){
                    articleCategoryDtos = new ArrayList<>();
                }
                articleCategoryDtos.add(dto);
                map.put(dto.getParentId(),articleCategoryDtos);
            }else {
                articleCategoryDtoList.add(dto);
            }
        }
        return findChildArticleCategoryDto(articleCategoryDtoList,map);
    }

    private static List<ArticleCategoryDto> findChildArticleCategoryDto(List<ArticleCategoryDto> articleCategoryDtoList,Map<Integer,List<ArticleCategoryDto>> parentMap){
        List<ArticleCategoryDto> returnList = new ArrayList<>();
        for (ArticleCategoryDto articleCategoryDto:articleCategoryDtoList){
            Integer parentId = articleCategoryDto.getId();
            List<ArticleCategoryDto> articleCategoryDtoList1 = parentMap.get(parentId);
            if(articleCategoryDtoList1 != null){
                articleCategoryDtoList1 = findChildArticleCategoryDto(articleCategoryDtoList1,parentMap);
            }
            articleCategoryDto.setChildren(articleCategoryDtoList1);
            returnList.add(articleCategoryDto);
        }
        return returnList;
    }
}
