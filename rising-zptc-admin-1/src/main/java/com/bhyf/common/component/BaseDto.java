package com.bhyf.common.component;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Date createTime;
	
	private String createUser;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreateTime() {
		if(this.createTime != null){
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
				return format.format(this.createTime);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	
}
