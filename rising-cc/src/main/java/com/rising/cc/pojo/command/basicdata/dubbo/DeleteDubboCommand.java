package com.rising.cc.pojo.command.basicdata.dubbo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.rising.cc.pojo.constants.basicdata.BasicDataConstants;

@SuppressWarnings("serial")
public class DeleteDubboCommand implements Serializable{

	private List<Integer> ids;

	private Integer status;
	
	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public void createCommand(EditDubboCommand command) {
		String idStrs = command.getId();
		if(StringUtils.isNotBlank(idStrs)){
			List<Integer> ids = new ArrayList<Integer>();
			for (String id : idStrs.split(",")) {
				ids.add(Integer.valueOf(id));
			}
			this.ids = ids;
		}
		
		this.status = BasicDataConstants.BASICDATA_REMOVE;
	}

}
