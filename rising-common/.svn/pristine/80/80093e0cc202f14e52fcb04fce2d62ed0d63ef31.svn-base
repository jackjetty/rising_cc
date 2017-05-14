package com.rising.common.page;

import java.io.Serializable;

public class SimplePage implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public static final int DEF_COUNT = 20;
	
	protected int totalCount = 0;
	protected int pageSize = 20;
	protected int pageNo = 1;
	protected int startIndex = 0;
	protected int totalPage = 0;
	
	public static int checkPageNo(Integer pageNo) {
		return (pageNo == null || pageNo < 1) ? 1 : pageNo;
	}
	
	public SimplePage() {
		
	}
	
	public SimplePage(int pageNo, int pageSize, int totalCount) {
		setTotalCount(totalCount);
		setPageSize(pageSize);
		setPageNo(pageNo);
		adjustPageNo();
	}
	
	/**
	 * 调整页码，使其不超过最大页数
	 */
	public void adjustPageNo() {
		if (pageNo == 1) {
			return;
		}
		int totalPage = getTotalPage();
		if (pageNo > totalPage) {
			pageNo = totalPage;
		}
		startIndex = this.pageSize * (this.pageNo - 1);
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}
	
	public int getStartIndex() {
		return startIndex;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	
	/**
	 * 是否第一页
	 * @return
	 */
	public boolean isFirstPage() {
		return pageNo <= 1;
	}
	
	/**
	 * 是否最后一页
	 * @return
	 */
	public boolean isLastPage() {
		return pageNo >= getTotalPage();
	}
	
	/**
	 * 下一页页码
	 * @return
	 */
	public int getNextPage() {
		if (isLastPage()) {
			return pageNo;
		} else {
			return pageNo + 1;
		}
	}
	
	public int getPretPage() {
		if (isFirstPage()) {
			return pageNo;
		} else {
			return pageNo - 1;
		}
	}
	
	public void setTotalCount(int totalCount) {
		
		//设置总条数
		if (totalCount < 0) {
			this.totalCount = 0;
		} else {
			this.totalCount = totalCount;
		}
		
		//设置总页数
		int totalPage = totalCount / pageSize;
		if (totalPage == 0 || totalCount % pageSize != 0) {
			totalPage++;
		}
		this.totalPage = totalPage;
	}
	
	public void setPageSize(Integer pageSize) {
		if (pageSize == null || pageSize < 1) {
			this.pageSize = DEF_COUNT;
		} else {
			this.pageSize = pageSize;
		}
		startIndex = this.pageSize * (this.pageNo - 1);
	}
	
	public void setPageNo(Integer pageNo) {
		if (pageNo == null || pageNo < 1) {
			this.pageNo = 1;
		} else {
			this.pageNo = pageNo;
		}
		startIndex = this.pageSize * (this.pageNo - 1);
	}
}