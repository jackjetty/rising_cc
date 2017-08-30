package com.bhyf.pojo.vip;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable{
	private static final long serialVersionUID = -7721059389027100112L;
	
	private Integer id;
	private String userName;//用户名
	private String userPwd;//用户密码
	private Integer userType;//0：老师；1：学生；2：校外人员；
	private Integer userSex;//0：未知；1：男；2：女；
	private String realName;//真实姓名
	private String idNum;//身份证
	private String mobile;//手机号码
	private String jobNo;//学号/教工号
	private Date registerTime;//注册时间
	private String registerTime1;
	private Date updateTime;//修改时间
	private String updateTime1;
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
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public Integer getUserSex() {
		return userSex;
	}
	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getJobNo() {
		return jobNo;
	}
	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public String getRegisterTime1() {
		return registerTime1;
	}
	public void setRegisterTime1(String registerTime1) {
		this.registerTime1 = registerTime1;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdateTime1() {
		return updateTime1;
	}
	public void setUpdateTime1(String updateTime1) {
		this.updateTime1 = updateTime1;
	}
	
	
}
