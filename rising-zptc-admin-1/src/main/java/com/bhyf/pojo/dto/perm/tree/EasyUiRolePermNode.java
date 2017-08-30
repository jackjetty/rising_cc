package com.bhyf.pojo.dto.perm.tree;

import com.bhyf.model.perm.SysPermission;
import com.bhyf.pojo.dto.perm.PermDto;

import java.util.List;

/**
 * Created by admin on 2016/4/7.
 */
public class EasyUiRolePermNode {

    private Integer id;
    private String text;
    private Integer parentId;
    private List<EasyUiRolePermNode> children;

    public EasyUiRolePermNode(SysPermission permission) {
        this.id = permission.getId();
        this.text = permission.getPermName();
        if(permission.getParentSysPerm() != null){
            this.parentId = permission.getParentSysPerm().getId();
        }
    }

    public EasyUiRolePermNode() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<EasyUiRolePermNode> getChildren() {
        return children;
    }

    public void setChildren(List<EasyUiRolePermNode> children) {
        this.children = children;
    }
}
