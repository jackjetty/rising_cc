package com.bhyf.pojo.dto.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.bhyf.model.role.SysRole;
import com.bhyf.model.user.SysUserBasicInfo;
import com.bhyf.pojo.dto.role.SysRoleDto;

/**
 * 
 * @description 用户基础信息
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午1:46:01
 *
 */
@SuppressWarnings("serial")
public class SysUserBasicInfoDto implements Serializable{
	
	
	/**
	 * 用户ID
	 */
	private Integer id;
	
	/***
	 * 账号信息
	 * */
	private String userName;
	
	/***
	 * 真是姓名
	 * */
	private String realName;
	
	/***
	 * 邮箱
	 * */
	private String email;
	
	/***
	 * 手机号码
	 * */
	private String telephone;
	
	/***
	 * 备注
	 * */
	private String note;
	
	/**
	 * 状态
	 */
	private Integer status;
	
	private String rolesStr;
	
	private List<SysRoleDto> sysRoleDtoList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getRolesStr() {
		return rolesStr;
	}

	public void setRolesStr(String rolesStr) {
		this.rolesStr = rolesStr;
	}

	public List<SysRoleDto> getSysRoleDtoList() {
		return sysRoleDtoList;
	}

	public void setSysRoleDtoList(List<SysRoleDto> sysRoleDtoList) {
		this.sysRoleDtoList = sysRoleDtoList;
	}

	public void createSysUserBasicInfoDto(SysUserBasicInfo sysUserBasicInfo, List<SysRole> sysRoleList){
		
		if(sysUserBasicInfo != null){
			if(sysUserBasicInfo.getSysUser() != null ){
				this.userName = sysUserBasicInfo.getSysUser().getUserName();
				this.note = sysUserBasicInfo.getSysUser().getNote();
				this.status = sysUserBasicInfo.getSysUser().getStatus();
				this.id = sysUserBasicInfo.getSysUser().getId();
			}
			this.realName = sysUserBasicInfo.getRealName();
			this.telephone = sysUserBasicInfo.getTelephone();
			this.email = sysUserBasicInfo.getEmail();
		}
		if(sysRoleList != null){
			String roles = "";
			List<SysRoleDto> roleDtoList = new ArrayList<SysRoleDto>();
			for (int i = 0; i < sysRoleList.size(); i++) {
				SysRole sysRole = sysRoleList.get(i);
				roles = roles + sysRole.getRoleName();
				if(i + 1 != sysRoleList.size()){
					roles+="、";
				}
				
				SysRoleDto dto = new SysRoleDto();
				BeanUtils.copyProperties(sysRole, dto);
				roleDtoList.add(dto);
				
			}
			this.sysRoleDtoList = roleDtoList;
			this.rolesStr = roles;
			
		}
		
	}
	
}
