package com.bhyf.pojo.command.perm;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DeletePermCommand implements Serializable{
	
	private Integer id;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	
	

}
