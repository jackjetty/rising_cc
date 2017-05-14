package com.rising.cc.common.component;

import com.rising.common.page.Pagination;

/**
 * 基础查询类
 * 
 * @author caoy
 */
public class PaginQo {
	protected final int DEFAULT_PAGE_SIZE = getPagination().getPageSize();

	/**
	 * 页码
	 */
	protected Integer pageNo = 1;
	
	/**
	 * 分页大小
	 */
	protected Integer pageSize = DEFAULT_PAGE_SIZE;
	
	protected Pagination pagination;

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


	public Pagination getPagination() {
		if (pagination == null) {
			pagination = new Pagination();
		}
		pagination.setPageNo(pageNo);
		pagination.setPageSize(pageSize);
		return pagination;
	}
}