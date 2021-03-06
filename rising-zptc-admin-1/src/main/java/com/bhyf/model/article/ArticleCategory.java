package com.bhyf.model.article;

import com.bhyf.pojo.command.article.CreateArticleCategoryCommand;
import com.bhyf.pojo.command.article.RemoveArticleCategoryCommand;
import com.bhyf.pojo.command.article.UpdateArticleCategoryCommand;
import com.rising.common.component.BaseModel;

/**
 * Created by admin on 2016/4/25.
 */
public class ArticleCategory extends BaseModel{

    /**
     * 栏目名称
     */
    private String name;
    /**
     * 父菜单
     */
    private Integer parentId;
    /**
     * 级别
     */
    private Integer level;
    /**
     * 状态 1:启用;0:未启用;80:删除
     */
    private Integer status;
    /**
     * 是否有子分类 0:无；1:有
     */
    private Integer hasChildren;
    /**
     * 是否有文章 0:无；1:有
     */
    private Integer hasArticle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(Integer hasChildren) {
        this.hasChildren = hasChildren;
    }

    public Integer getHasArticle() {
        return hasArticle;
    }

    public void setHasArticle(Integer hasArticle) {
        this.hasArticle = hasArticle;
    }

    public boolean create(CreateArticleCategoryCommand command) {
        setName(command.getName());
        setStatus(command.getStatus());
        setLevel(command.getLevel());
        setParentId(command.getParentId());
        setHasArticle(command.getHasArticle());
        setHasChildren(command.getHasChildren());
        return true;
    }

    public boolean update(UpdateArticleCategoryCommand command) {
        setId(command.getId());
        setName(command.getName());
        setStatus(command.getStatus());
        setLevel(command.getLevel());
        setParentId(command.getParentId());
        setHasArticle(command.getHasArticle());
        setHasChildren(command.getHasChildren());
        return true;
    }

    public boolean remove(RemoveArticleCategoryCommand command) {
        setId(command.getId());
        return true;
    }
}
