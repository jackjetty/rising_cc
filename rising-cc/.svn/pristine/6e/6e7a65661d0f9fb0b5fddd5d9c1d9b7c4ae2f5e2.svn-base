package com.rising.cc.pojo.dto.perm;

import org.springframework.beans.BeanUtils;

import com.rising.cc.common.component.BaseDto;
import com.rising.cc.model.perm.SysPermission;

/**
 * 
 * @description 
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午1:56:35
 *
 */
@SuppressWarnings("serial")
public class PermDto extends BaseDto{

	private String permName;
	
	private Integer permLevel;
	
	private String permUrl;
	
	private String permRel;

	private Integer permType;
	
	private Integer sortNum;
	
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

	public void createPermDto(SysPermission perm){
		BeanUtils.copyProperties(perm, this);
	}
	
}
