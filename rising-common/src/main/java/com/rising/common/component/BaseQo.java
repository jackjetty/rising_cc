package com.rising.common.component;

import java.io.Serializable;
import java.util.List;

/**
 * 基础查询类 名词解释：query object 简称 qo
 */
public class BaseQo implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 实体ID
	 */
	private Integer id;
	
	/**
	 * 实体ID集合
	 */
	private List<String> ids;

	// 分页条件
	private Integer pageNo;

	private Integer pageSize;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}