package com.rising.cc.model.perm;

import org.springframework.beans.BeanUtils;

import com.rising.common.component.BaseModel;
import com.rising.cc.pojo.command.perm.CreatePermCommand;
import com.rising.cc.pojo.command.perm.DeletePermCommand;
import com.rising.cc.pojo.command.perm.UpdatePermCommand;

/**
 * 
 * @description 
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午1:56:35
 *
 */
@SuppressWarnings("serial")
public class SysPermission extends BaseModel{

	private String permName;
	
	private Integer permLevel;
	
	private String permUrl;
	
	private String permRel;
	
	private Integer permType;
	
	private Integer sortNum;
	
	private SysPermission parentSysPerm;
	
	private Integer isEnable;

	public String getPermName() {
		return permName;
	}

	public void setPermName(String permName) {
		this.permName = permName;
	}

	public Integer getPermLevel() {
		return permLevel;
	}

	public void setPermLevel(Integer permLevel) {
		this.permLevel = permLevel;
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

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

	public SysPermission getParentSysPerm() {
		return parentSysPerm;
	}

	public void setParentSysPerm(SysPermission parentSysPerm) {
		this.parentSysPerm = parentSysPerm;
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

	public void updateSysPermission(UpdatePermCommand command){
		BeanUtils.copyProperties(command, this);
	}
	
	
	public void deleteSysPermission(DeletePermCommand command){
		BeanUtils.copyProperties(command, this);
	}
	
	public void createSysPermission(CreatePermCommand command, Integer sortNum, SysPermission parentSysPerm){
		this.setCreateTime(command.getCreateTime());
		this.setCreateUser(command.getCreateUser());
		this.permName =command.getPermName() ;
		this.permLevel = parentSysPerm == null ? 1 : parentSysPerm.getPermLevel()+1;
		this.permUrl = command.getPermUrl();
		this.permRel = command.getPermRel();
		this.permType = command.getPermType();
		this.sortNum = sortNum == null ? 0 : sortNum+1;
		this.parentSysPerm = parentSysPerm;
		this.isEnable = command.getIsEnable();
	}
}
