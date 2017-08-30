package com.bhyf.pojo.app;

import com.bhyf.model.user.SysUser;
import com.bhyf.pojo.command.app.CreateAppVersionCommand;
import com.bhyf.pojo.command.app.UpdateAppVersionCommand;
import com.bhyf.pojo.constants.user.LoginConstants;
import com.rising.common.component.BaseModel;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.util.Date;
/**
 * 
 * @description
 * @author pl
 * @createTime 2016年4月14日
 */
public class AppVersion extends BaseModel{
	private Integer id;	//自增Id
	private String versionName; //app名称
	private Integer category;	//分类：1：android；2：ios；
	private Integer versionNo;	//版本号
	private String downUrl;	//下载地址
	private Integer isUpgrade;	//升级：0：不强制升级；1：强制升级；
	private String content;	//更新内容
	private Integer status;	//状态：0：禁用；1：启用；80：删除；
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVersionName() {
		return versionName;
	}
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public Integer getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}
	public String getDownUrl() {
		return downUrl;
	}
	public void setDownUrl(String downUrl) {
		this.downUrl = downUrl;
	}
	public Integer getIsUpgrade() {
		return isUpgrade;
	}
	public void setIsUpgrade(Integer isUpgrade) {
		this.isUpgrade = isUpgrade;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public boolean create(CreateAppVersionCommand command,  String appAddress) {
		setStatus(command.getStatus());
		setVersionName(command.getVersionName());
		setDownUrl(appAddress);
		setContent(command.getContent());
		setCategory(command.getCategory());
		setIsUpgrade(command.getIsUpgrade());
		setVersionNo(command.getVersionNo());
		setCreateTime(new Date());
		Subject currentSubject = SecurityUtils.getSubject();
		SysUser sysUser =(SysUser) currentSubject.getSession().getAttribute(LoginConstants.SESSION_USER_KEY);
		setCreateUser(sysUser.getUserName());
		return true;
	}

	public boolean update(UpdateAppVersionCommand command, String appAddress) {
		setId(command.getId());
		setStatus(command.getStatus());
		setVersionName(command.getVersionName());
		setDownUrl(appAddress);
		setContent(command.getContent());
		setCategory(command.getCategory());
		setIsUpgrade(command.getIsUpgrade());
		setVersionNo(command.getVersionNo());
		return true;
	}

	public boolean update(UpdateAppVersionCommand command) {
		setId(command.getId());
		setStatus(command.getStatus());
		setVersionName(command.getVersionName());
		setContent(command.getContent());
		setCategory(command.getCategory());
		setIsUpgrade(command.getIsUpgrade());
		setVersionNo(command.getVersionNo());
		return true;
	}
}
