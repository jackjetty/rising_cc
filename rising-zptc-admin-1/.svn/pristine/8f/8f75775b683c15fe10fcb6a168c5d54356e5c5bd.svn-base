package com.bhyf.pojo.response;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.rising.common.page.Pagination;

import java.util.List;


public class DataGridResponse{
	
	private Integer total;
	
	private List<?> rows;
	
	public DataGridResponse() {
		
	}
	
	
	public DataGridResponse(Integer total, List<?> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	
	public DataGridResponse(Pagination pagination) {
		super();
		this.total = pagination.getTotalCount();
		this.rows = pagination.getList();
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
