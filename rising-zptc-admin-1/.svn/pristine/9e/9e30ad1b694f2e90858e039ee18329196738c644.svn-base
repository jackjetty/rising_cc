package com.bhyf.util;

import com.bhyf.model.perm.SysPermission;
import com.bhyf.pojo.dto.perm.PermDto;
import com.bhyf.pojo.dto.perm.tree.EasyUiRolePermNode;
import com.bhyf.pojo.dto.perm.tree.EasyUiTreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/4/7.
 */
public class EasyUiTreeUtils {

    public static List<EasyUiTreeNode> createEasyUiPerm(List<SysPermission> sysPermissionList) {
        List<EasyUiTreeNode> resultList = new ArrayList<>();
        List<EasyUiTreeNode> easyUiTreeNodeList = new ArrayList<>();
        Map<Integer,List<EasyUiTreeNode>> map = new HashMap<>();
        for (SysPermission sysPermission:sysPermissionList){
            EasyUiTreeNode easyUiTreeNode = new EasyUiTreeNode(sysPermission);
            if(easyUiTreeNode.getParentId() !=null){
                List<EasyUiTreeNode> easyUiTreeNodeDtos = map.get(easyUiTreeNode.getParentId());
                if(easyUiTreeNodeDtos == null){
                    easyUiTreeNodeDtos = new ArrayList<>();
                }
                easyUiTreeNodeDtos.add(easyUiTreeNode);
                map.put(easyUiTreeNode.getParentId(),easyUiTreeNodeDtos);
            }else {
                easyUiTreeNodeList.add(easyUiTreeNode);
            }
        }
        resultList = findChildEasyUiTreeNode(easyUiTreeNodeList,map);
        return resultList;
    }

    private static List<EasyUiTreeNode> findChildEasyUiTreeNode(List<EasyUiTreeNode> easyUiTreeNodeList,Map<Integer,List<EasyUiTreeNode>> parentMap){
        List<EasyUiTreeNode> returnList = new ArrayList<>();
        for (EasyUiTreeNode easyUiTreeNode:easyUiTreeNodeList){
            Integer parentId = easyUiTreeNode.getMenuid();
            List<EasyUiTreeNode> easyUiTreeNodeList1 = parentMap.get(parentId);
            if(easyUiTreeNodeList1 != null){
                easyUiTreeNodeList1 = findChildEasyUiTreeNode(easyUiTreeNodeList1,parentMap);
            }
            easyUiTreeNode.setMenus(easyUiTreeNodeList1);
            returnList.add(easyUiTreeNode);
        }
        return returnList;
    }
    public static List<EasyUiRolePermNode> createEasyUiRolePerm(List<SysPermission> sysPermissionList) {
        List<EasyUiRolePermNode> resultList = new ArrayList<>();
        List<EasyUiRolePermNode> easyUiTreeNodeList = new ArrayList<>();
        Map<Integer,List<EasyUiRolePermNode>> map = new HashMap<>();
        for (SysPermission sysPermission:sysPermissionList){
            EasyUiRolePermNode easyUiTreeNode = new EasyUiRolePermNode(sysPermission);
            if(easyUiTreeNode.getParentId() !=null){
                List<EasyUiRolePermNode> easyUiTreeNodeDtos = map.get(easyUiTreeNode.getParentId());
                if(easyUiTreeNodeDtos == null){
                    easyUiTreeNodeDtos = new ArrayList<>();
                }
                easyUiTreeNodeDtos.add(easyUiTreeNode);
                map.put(easyUiTreeNode.getParentId(),easyUiTreeNodeDtos);
            }else {
                easyUiTreeNodeList.add(easyUiTreeNode);
            }
        }
        resultList = findChildEasyUiRoleTreeNode(easyUiTreeNodeList,map);
        return resultList;
    }

    private static List<EasyUiRolePermNode> findChildEasyUiRoleTreeNode(List<EasyUiRolePermNode> easyUiTreeNodeList,Map<Integer,List<EasyUiRolePermNode>> parentMap){
        List<EasyUiRolePermNode> returnList = new ArrayList<>();
        for (EasyUiRolePermNode easyUiTreeNode:easyUiTreeNodeList){
            Integer parentId = easyUiTreeNode.getId();
            List<EasyUiRolePermNode> easyUiTreeNodeList1 = parentMap.get(parentId);
            if(easyUiTreeNodeList1 != null){
                easyUiTreeNodeList1 = findChildEasyUiRoleTreeNode(easyUiTreeNodeList1,parentMap);
            }
            easyUiTreeNode.setChildren(easyUiTreeNodeList1);
            returnList.add(easyUiTreeNode);
        }
        return returnList;
    }
}
