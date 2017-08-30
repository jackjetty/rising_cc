package com.bhyf.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bhyf.model.menu.BootstrapMenuTreeNode;

/**
 * 
 * @description 树HTML生成
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月10日 下午4:47:32
 *
 */
public class BootStrapTreeUtils {

	/**
	 * 
	 * @description 菜单树创建入口
	 * @author caoy
	 * @date 2015年8月24日 下午3:00:24
	 * @param map
	 * @param checkedId
	 * @return
	 */
	public static String createBootstrapMenuTreeListHtml(LinkedHashMap<Integer,BootstrapMenuTreeNode> map, HttpServletRequest request) {
		try {
			
			/*if(checkedId != null && map != null){
				setBootstrapMenuTreeNoteChecked(map, checkedId);
			}*/
			
			List<BootstrapMenuTreeNode> menuTreeList = new ArrayList<BootstrapMenuTreeNode>();
			
			for (Iterator<BootstrapMenuTreeNode> iterator = map.values().iterator(); iterator.hasNext();) {
				BootstrapMenuTreeNode treeNode = iterator.next();
				menuTreeList.add(treeNode);
			}
			
			return createBootstrapMenuTreeHtml(createBootstrapTree(menuTreeList), request);
			
			
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return "";
	}
	
	
	/**
	 * 
	 * @description 可拖动权限树创建入口
	 * @author caoy
	 * @date 2015年8月24日 下午3:00:24
	 * @param map
	 * @param checkedId
	 * @return
	 */
	public static String createAceNestableListHtml(List<BootstrapMenuTreeNode> menuTreeList) {
		try {
			
			return createAceNestableMainListHtml(createBootstrapTree(menuTreeList));
			
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 
	 * @description 把选中节点以及父节点设置为true
	 * @author caoy
	 * @date 2015年8月10日 下午6:49:12
	 * @param map
	 * @param checkedId
	 */
	private static void setBootstrapMenuTreeNoteChecked(Map<Integer,BootstrapMenuTreeNode> map, Integer checkedId){
		BootstrapMenuTreeNode checkNode = map.get(checkedId);
		
		if(checkNode != null){
			checkNode.setChecked(true);
			setBootstrapMenuTreeNoteChecked(map, checkNode.getParentId());
		}
	}
	
	
	/**
	 * 
	 * @description 通过无关联的treeList转换为有关联的 ，menuTree节点parentId为null视为顶级节点
	 * @author caoy
	 * @date 2015年8月10日 下午4:52:24
	 * @param menuTreeList
	 * @return
	 */
	public static List<BootstrapMenuTreeNode> createBootstrapTree(List<BootstrapMenuTreeNode> menuTreeList) {
		Map<Integer, List<BootstrapMenuTreeNode>> map = new HashMap<Integer, List<BootstrapMenuTreeNode>>();
		for (BootstrapMenuTreeNode menuTree : menuTreeList) {
			Integer parentId = menuTree.getParentId();
			if (!map.containsKey(parentId)) {
				map.put(parentId, new ArrayList<BootstrapMenuTreeNode>());
			}
			map.get(parentId).add(menuTree);
		}
		for (BootstrapMenuTreeNode menuTree : menuTreeList) {
			menuTree.setChildrenList(map.get(menuTree.getId()));
		}
		
		return map.containsKey(null) ? map.get(null) : new ArrayList<BootstrapMenuTreeNode>();
	}
	
	/**
	 * 
	 * @description 组装菜单树HTML
	 * @author caoy
	 * @date 2015年8月24日 下午3:02:14
	 * @param menuTreeList
	 * @return
	 */
	private static String createBootstrapMenuTreeHtml(List<BootstrapMenuTreeNode> menuTreeList, HttpServletRequest request) {
		StringBuffer htmlSb = new StringBuffer();
		//htmlSb.append("<a class=\"menu-toggler\" id=\"menu-toggler\" href=\"#\"><span class=\"menu-text\"></span></a>");
		//htmlSb.append("<div class=\"sidebar\" id=\"sidebar  responsive\">");
		//htmlSb.append("<script type=\"text/javascript\"> try {ace.settings.check('sidebar', 'fixed')} catch (e) {}</script>");
		htmlSb.append("<ul class=\"nav nav-list\">");
		//htmlSb.append("<li class=\"active\"><a href=\"#\"><i class=\"icon-dashboard\"></i><span class=\"menu-text\"> 控制台 </span></a></li>");
		
		createChildrenListhtml(menuTreeList, htmlSb, request);
		
		htmlSb.append("</ul>");
		//htmlSb.append("<div class=\"sidebar-toggle sidebar-collapse\" id=\"sidebar-collapse\"><i class=\"ace-icon fa fa-angle-double-left\" data-icon1=\"ace-icon fa fa-angle-double-left\" data-icon2=\"ace-icon fa fa-angle-double-right\"></i> </div>");
		//htmlSb.append("<script type=\"text/javascript\"> try {ace.settings.check('sidebar', 'collapsed')} catch (e) {}</script>");
		//htmlSb.append("</div>");
		return htmlSb.toString();
	}

	/**
	 * 
	 * @description 组装菜单树HTML
	 * @author caoy
	 * @date 2015年8月24日 下午3:02:14
	 * @param menuTreeList
	 * @return
	 */
	private static void createChildrenListhtml(List<BootstrapMenuTreeNode> menuTreeList, StringBuffer sb, HttpServletRequest request) {
		if (sb != null && menuTreeList != null && menuTreeList.size() > 0) {
			
			for (BootstrapMenuTreeNode menuTree : menuTreeList) {
				
				if(menuTree.hasChildren()){
					sb.append("<li class=\"menu-tag-parent\">");
				}else if(!menuTree.hasChildren()){
					sb.append("<li class=\"menu-tag-children\">");
				}
				
				
				if(menuTree.hasChildren()){//如果有子节点，，需要下拉class属性
					sb.append("<a href=\"javascript:void(0);\" class=\"dropdown-toggle\">");
				}else{//如果无子节点，，则不需要下拉class属性
					sb.append("<a href=\"javascript:void(0);\" onclick=\"clickMenu('");
					sb.append(WebUtil.getBasePath(request));
					sb.append(menuTree.getHref());
					sb.append("');\">");
				}
				
				if(menuTree.getParentId() == null){//一级菜单
					sb.append("<i class=\"menu-icon fa fa-list\"></i>");
					sb.append("<span class=\"menu-text\">");
					sb.append(menuTree.getMenuName());
					sb.append("</span>");
				}else{//子菜单
					sb.append("<i class=\"menu-icon fa fa-caret-right\"></i>");
					sb.append(menuTree.getMenuName());
				}
				
				if(menuTree.hasChildren()){
					sb.append("<b class=\"arrow fa fa-angle-down\"></b>");
				}
				
				sb.append("</a>");
				if (menuTree.hasChildren()) {
					sb.append("<ul class=\"submenu\">");
					createChildrenListhtml(menuTree.getChildrenList(), sb, request);
					sb.append("</ul>");
				}
				sb.append("</li>");
			}
		}
	}
	
	
	/**
	 * 
	 * @description 组装可推动权限树HTML
	 * @author caoy
	 * @date 2015年8月24日 下午3:02:14
	 * @param menuTreeList
	 * @return
	 */
	private static String createAceNestableMainListHtml(List<BootstrapMenuTreeNode> menuTreeList) {
		StringBuffer htmlSb = new StringBuffer();
		htmlSb.append("<ol class=\"dd-list\">");
		
		createAceNestableChildrenListhtml(menuTreeList, htmlSb);
		
		htmlSb.append("</ol>");
		return htmlSb.toString();
	}
	
	/**
	 * 
	 * @description 组装可推动权限树HTML
	 * @author caoy
	 * @date 2015年8月24日 下午3:02:14
	 * @param menuTreeList
	 * @return
	 */
	private static void createAceNestableChildrenListhtml(List<BootstrapMenuTreeNode> menuTreeList, StringBuffer sb) {
		if (sb != null && menuTreeList != null && menuTreeList.size() > 0) {
			
			for (BootstrapMenuTreeNode menuTree : menuTreeList) {
				sb.append("<li class=\"dd-item item-blue2\" data-id=\""+menuTree.getId()+"\">");
				sb.append("<div class=\"dd-handle\" id=\"dd-handle-id-"+menuTree.getId()+"\">");
				sb.append("<b>");
				sb.append(menuTree.getMenuName());
				sb.append("</b>");
				
				sb.append("<div class=\"pull-right action-buttons\">");
				sb.append("<a class=\"purple\" href=\"#modal-form\" onclick=\"addNode("+menuTree.getId()+");\" title=\"新增子节点\" data-toggle=\"modal\" data-target=\"#modal-form\"><i class=\"ace-icon fa fa-plus-circle bigger-130\" ></i></a>");
				sb.append("<a class=\"blue\" href=\"#modal-form\" onclick=\"loadNodeData("+menuTree.getId()+");\" title=\"编辑当前节点\" data-toggle=\"modal\" data-target=\"#modal-form\"><i class=\"ace-icon fa fa-pencil bigger-130\"></i></a>");
				sb.append("<a class=\"red\" href=\"javascript:deleteNode("+menuTree.getId()+");\" title=\"删除当前节点\"><i class=\"ace-icon fa fa-trash-o bigger-130\"></i></a>");
				sb.append("</div>");
				
				sb.append("</div>");
				
				if (menuTree.hasChildren()) {
					sb.append("<ol class=\"dd-list\">");
					createAceNestableChildrenListhtml(menuTree.getChildrenList(), sb);
					sb.append("</ol>");
				}
				sb.append("</li>");
			}
		}
	}
	
	
	public static Map<Integer, List<BootstrapMenuTreeNode>> createAceTreeMap(List<BootstrapMenuTreeNode> menuTreeList) {
		Map<Integer, List<BootstrapMenuTreeNode>> map = new LinkedHashMap<Integer, List<BootstrapMenuTreeNode>>();
		for (BootstrapMenuTreeNode menuTree : menuTreeList) {
			Integer parentId = menuTree.getParentId();
			if (!map.containsKey(parentId)) {
				map.put(parentId, new ArrayList<BootstrapMenuTreeNode>());
			}
			map.get(parentId).add(menuTree);
		}
/*		for (BootstrapMenuTreeNode menuTree : menuTreeList) {
			menuTree.setChildrenList(map.get(menuTree.getId()));
		}*/
		
		return map;
	}
	

	public static void main(String[] args) {
		
		LinkedHashMap<Integer,BootstrapMenuTreeNode> map = new LinkedHashMap<Integer, BootstrapMenuTreeNode>();
		
		BootstrapMenuTreeNode n1 = new BootstrapMenuTreeNode();
		n1.setId(1);
		n1.setMenuName("test1");
		n1.setHref("javascript:;");

		BootstrapMenuTreeNode n2 = new BootstrapMenuTreeNode();
		n2.setId(2);
		n2.setParentId(1);
		n2.setMenuName("test2");
		n2.setHref("javascript:;");

		BootstrapMenuTreeNode n3 = new BootstrapMenuTreeNode();
		n3.setId(3);
		n3.setParentId(1);
		n3.setMenuName("test3");
		n3.setHref("http://www.baidu.com");

		BootstrapMenuTreeNode n4 = new BootstrapMenuTreeNode();
		n4.setId(4);
		n4.setParentId(3);
		n4.setMenuName("test4");
		n4.setHref("http://www.baidu.com");

		map.put(1, n1);
		map.put(2, n2);
		map.put(3, n3);
		map.put(4, n4);

//		System.out.println(createBootstrapMenuTreeListHtml(map, 2));
	}
}
