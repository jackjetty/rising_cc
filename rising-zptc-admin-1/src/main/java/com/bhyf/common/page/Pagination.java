package com.bhyf.common.page;

import java.io.Serializable;
import java.util.List;

public class Pagination extends SimplePage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public final static String PAGE_CONDITION_CACHE = "PageCondition";
	public final static String PAGE_CURRENT_NO_CACHE = "PageCurrentNo";
	public final static String PAGE_SIZE_CACHE = "PageSize";
	public final static String PAGE_TOTAL_COUNT_CACHE = "PageTotalCount";
	public final static String PAGE_ALL_CONDITION_CACHE = "PageAllCondition";
	
	private String id;
	
	/**
	 * 检查页码是否超过最后一页
	 */
	private boolean checkPassLastPageNo = true;
	
	/**
	 * 是否查询总条目数
	 */
	private boolean selectTotalCount = true;
	
	public Pagination() {
		
	}
	
	public Pagination(int pageNo, int pageSize, int totalCount) {
		super(pageNo, pageSize, totalCount);
	}
	
	public Pagination(int pageNo, int pageSize, int totalCount, List<?> list) {
		super(pageNo, pageSize, totalCount);
		this.list = list;
	}
	
	public int getFirstResult() {
		return (pageNo - 1) * pageSize;
	}
	
	private List<?> list;
	
	private Object condition;
	
	private Integer sort;

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public Object getCondition() {
		return condition;
	}

	public void setCondition(Object condition) {
		this.condition = condition;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public boolean isCheckPassLastPageNo() {
		return checkPassLastPageNo;
	}

	public void setCheckPassLastPageNo(boolean checkPassLastPageNo) {
		this.checkPassLastPageNo = checkPassLastPageNo;
	}

	public boolean isSelectTotalCount() {
		return selectTotalCount;
	}

	public void setSelectTotalCount(boolean selectTotalCount) {
		this.selectTotalCount = selectTotalCount;
	}

}
