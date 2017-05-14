package com.rising.common.page;

import java.io.Serializable;
import java.util.List;

public class Pagination extends SimplePage implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private List<?> list;
	
	private Object condition;
	
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

}
