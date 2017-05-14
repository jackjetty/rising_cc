package com.rising.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.rising.common.model.DwzTreeNode;

/**
 * dwz树形HTML生成工具
 * 
 * @author zhurz
 */
public class DwzTreeUtil {

	/**
	 * 将dwzTreeList转换成dwz树HTML代码 
	 * dwzTree节点parentId为null视为顶级节点
	 * 
	 * @param dwzTreeList
	 * @param cssClass
	 * @return
	 */
	public static String createDwzTreeListHtml(List<DwzTreeNode> dwzTreeList, String cssClass) {
		try {
			return createDwzTreeHtml(createDwzTree(dwzTreeList), cssClass);
		} catch (Exception e) { }
		return "";
	}

	/**
	 * 通过无关联的dwzTreeList转换为有关联的 
	 * dwzTree节点parentId为null视为顶级节点
	 * 
	 * @param dwzTreeList
	 * @return
	 */
	public static List<DwzTreeNode> createDwzTree(List<DwzTreeNode> dwzTreeList) {
		Map<String, List<DwzTreeNode>> map = new HashMap<String, List<DwzTreeNode>>();
		for (DwzTreeNode dwzTree : dwzTreeList) {
			String parentId = dwzTree.getParentId();
			if (!map.containsKey(parentId)) {
				map.put(parentId, new ArrayList<DwzTreeNode>());
			}
			map.get(parentId).add(dwzTree);
		}
		for (DwzTreeNode dwzTree : dwzTreeList) {
			dwzTree.setChildrenList(map.get(dwzTree.getId()));
		}
		return map.containsKey(null) ? map.get(null) : new ArrayList<DwzTreeNode>();
	}

	private static String createDwzTreeHtml(List<DwzTreeNode> dwzTreeList, String cssClass) {
		StringBuffer htmlBuf = new StringBuffer();
		htmlBuf.append("<ul class=\"");
		if (StringUtils.isNotBlank(cssClass)) {
			htmlBuf.append(cssClass);
		} else {
			htmlBuf.append("tree treeFolder");
		}
		htmlBuf.append("\">");
		createChildrenListhtml(dwzTreeList, htmlBuf);
		htmlBuf.append("</ul>");
		return htmlBuf.toString();
	}

	private static void createChildrenListhtml(List<DwzTreeNode> dwzTreeList, StringBuffer sb) {
		if (sb != null && dwzTreeList != null && dwzTreeList.size() > 0) {
			for (DwzTreeNode dwzTree : dwzTreeList) {
				sb.append("<li><a");

				Map<String, String> attrMap = dwzTree.getAttrMap();
				for (String attrKey : attrMap.keySet()) {
					String attrValue = attrMap.get(attrKey);
					if (StringUtils.isNotBlank(attrValue)) {
						sb.append(" ").append(attrKey).append("=\"").append(attrValue).append("\"");
					}
				}

				sb.append(">");
				sb.append(dwzTree.getDisplayName());
				sb.append("</a>");
				if (dwzTree.hasChildren()) {
					sb.append("<ul>");
					createChildrenListhtml(dwzTree.getChildrenList(), sb);
					sb.append("</ul>");
				}
				sb.append("</li>");
			}
		}
	}

	public static void main(String[] args) {
		List<DwzTreeNode> list = new ArrayList<DwzTreeNode>();
		DwzTreeNode n1 = new DwzTreeNode();
		n1.setId("1");
		n1.setDisplayName("test");
		n1.setHref("javascript:;");

		DwzTreeNode n2 = new DwzTreeNode();
		n2.setId("2");
		n2.setParentId("1");
		n2.setDisplayName("test2");
		n2.setHref("javascript:;");

		DwzTreeNode n3 = new DwzTreeNode();
		n3.setId("3");
		n3.setParentId("1");
		n3.setDisplayName("test3");
		n3.setHref("http://www.baidu.com");
		n3.setTarget("navTab");

		DwzTreeNode n4 = new DwzTreeNode();
		n4.setId("4");
		n4.setParentId("3");
		n4.setDisplayName("test4");
//		n4.setHref("http://www.baidu.com");
		n4.addAttr("href", "http://www.qq.com");
		n4.addAttr("test", "dddddddddddd");
		n4.setTarget("navTab");

		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);

		System.out.println(createDwzTreeListHtml(list, null));
	}
}
