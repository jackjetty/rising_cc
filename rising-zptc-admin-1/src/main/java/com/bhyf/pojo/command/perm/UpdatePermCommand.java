package com.bhyf.pojo.command.perm;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UpdatePermCommand implements Serializable{
	
	private Integer id;
	
	private String permName;
	
	//private Integer permLevel;
	
	private String permUrl;
	
	private String permRel;
	
	private Integer permType;
	//private Integer sortNum;
	
	//private SysPermission parentSysPerm;
	
	private Integer isEnable;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPermName() {
		return permName;
	}

	public void setPermName(String permName) {
		this.permName = permName;
	}

	public String getPermUrl() {
		return permUrl;
	}

	public void setPermUrl(String permUrl) {
		this.permUrl = permUrl;
	}

	public String getPermRel() {
		return permRel;
	}

	public void setPermRel(String permRel) {
		this.permRel = permRel;
	}

	public Integer getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}

	public Integer getPermType() {
		return permType;
	}

	public void setPermType(Integer permType) {
		this.permType = permType;
	}


}
