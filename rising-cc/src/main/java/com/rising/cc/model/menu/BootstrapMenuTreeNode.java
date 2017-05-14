package com.rising.cc.model.menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @description 左侧菜单树节点
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月10日 下午4:32:37
 *
 */
public class BootstrapMenuTreeNode {

	private Integer id;
	private Integer parentId;

	private String menuName;

	private String aid;
	private String href;
	private String target;
	private String rel;

	private String tname;
	private String tvalue;
	private boolean checked;

	private Map<String, String> attrMap;

	private List<BootstrapMenuTreeNode> childrenList;

	/**
	 * 获取A标签内的所有属性（只读）
	 * 
	 * @return
	 */
	public Map<String, String> getAttrMap() {
		if (attrMap == null) {
			attrMap = new HashMap<String, String>();
		}
		attrMap.put("id", aid);
		attrMap.put("href", href);
		attrMap.put("target", target);
		attrMap.put("rel", rel);
		attrMap.put("tname", tname);
		attrMap.put("tvalue", tvalue);
		if (checked) {
			attrMap.put("checked", "true");
		} else {
			attrMap.remove("checked");
		}
		return Collections.unmodifiableMap(attrMap);
	}

	/**
	 * 添加A标签内的属性
	 * 
	 * @param key
	 * @param value
	 */
	public void addAttr(String key, String value) {
		if(attrMap == null){
			attrMap = new HashMap<String, String>();
		}
		if (key != null) {
			attrMap.put(key, value);
			if ("id".equals(key)) {
				aid = value;
			} else if ("href".equals(key)) {
				href = value;
			} else if ("target".equals(key)) {
				target = value;
			} else if ("rel".equals(key)) {
				rel = value;
			} else if ("tname".equals(key)) {
				tname = value;
			} else if ("tvalue".equals(key)) {
				tvalue = value;
			} else if ("checked".equals(key)) {
				if (value != null && ("true".equals(value.toLowerCase()) || "checked".equals(value.toLowerCase()))) {
					checked = true;
				} else {
					checked = false;
				}
			}
		}
	}

	/**
	 * 删除A标签内的属性
	 * 
	 * @param key
	 */
	public void removeAttr(String key) {
		if(attrMap == null){
			attrMap = new HashMap<String, String>();
		}
		attrMap.remove(key);
		if (key != null) {
			if ("id".equals(key)) {
				aid = null;
			} else if ("href".equals(key)) {
				href = null;
			} else if ("target".equals(key)) {
				target = null;
			} else if ("rel".equals(key)) {
				rel = null;
			} else if ("tname".equals(key)) {
				tname = null;
			} else if ("tvalue".equals(key)) {
				tvalue = null;
			} else if ("checked".equals(key)) {
				checked = false;
			}
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}


	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public List<BootstrapMenuTreeNode> getChildrenList() {
		if (childrenList == null) {
			childrenList = new ArrayList<BootstrapMenuTreeNode>();
		}
		return childrenList;
	}

	public void setChildrenList(List<BootstrapMenuTreeNode> childrenList) {
		this.childrenList = childrenList;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public boolean hasChildren() {
		return getChildrenList().size() > 0 ? true : false;
	}

	public String getTvalue() {
		return tvalue;
	}

	public void setTvalue(String tvalue) {
		this.tvalue = tvalue;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

}
