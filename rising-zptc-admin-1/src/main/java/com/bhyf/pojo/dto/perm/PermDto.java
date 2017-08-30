package com.bhyf.pojo.dto.perm;

import org.springframework.beans.BeanUtils;

import com.bhyf.common.component.BaseDto;
import com.bhyf.model.perm.SysPermission;

import java.util.List;

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

	private Integer _parentId;

	private List<PermDto> children;

	public PermDto(SysPermission sysPermission) {
		super();
		setId(sysPermission.getId());
		this.permName = sysPermission.getPermName();
		this.permLevel = sysPermission.getPermLevel();
		this.permUrl = sysPermission.getPermUrl();
		this.isEnable = sysPermission.getIsEnable();
		if(sysPermission.getParentSysPerm() != null){
			this._parentId = sysPermission.getParentSysPerm().getId();
		}
	}

	public PermDto() {
	}

	public Integer get_parentId() {
		return _parentId;
	}

	public void set_parentId(Integer _parentId) {
		this._parentId = _parentId;
	}

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

	public List<PermDto> getChildren() {
		return children;
	}

	public void setChildren(List<PermDto> children) {
		this.children = children;
	}
}
