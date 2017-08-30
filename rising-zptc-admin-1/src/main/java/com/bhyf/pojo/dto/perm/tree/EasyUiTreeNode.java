package com.bhyf.pojo.dto.perm.tree;

import com.bhyf.model.perm.SysPermission;

import java.util.List;

/**
 * 项目名称：rising-zptc-admin
 * 类描述：
 * 创建人：caizh
 * 创建时间：2016/4/7 11:00
 * 修改人：caizh
 * 修改时间：2016/4/7 11:00
 * 修改备注：
 */
public class EasyUiTreeNode {

    private String menuname;

    private Integer menuid;

    private String icon;

    private String url;

    private Integer parentId;

    private List<EasyUiTreeNode> menus;

    public EasyUiTreeNode(SysPermission sysPermission) {
        menuid = sysPermission.getId();
        menuname = sysPermission.getPermName();
        icon = "";
        url = "/rising-zptc-admin"+sysPermission.getPermUrl();
        if(sysPermission.getParentSysPerm() != null){
            parentId = sysPermission.getParentSysPerm().getId();
        }
    }

    public EasyUiTreeNode() {
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<EasyUiTreeNode> getMenus() {
        return menus;
    }

    public void setMenus(List<EasyUiTreeNode> menus) {
        this.menus = menus;
    }
}
