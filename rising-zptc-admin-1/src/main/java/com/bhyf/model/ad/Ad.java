package com.bhyf.model.ad;

import java.io.Serializable;
import java.util.Date;

public class Ad implements Serializable{
	private static final long serialVersionUID = -7721059389027100112L;
	private String id;
	private String origImageLinkUrl;//图片链接
	private String targImageLinkUrl;//目标链接
	private String adName;//广告名称
	private Integer posiId;//广告位置
	private Integer sortNum;//排序
	private Date createTime;//创建时间
	private String createTime1;
	private String createUser;//创建人
	private String status;//状态：0：禁用；1：启用；80：删除；
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrigImageLinkUrl() {
		return origImageLinkUrl;
	}
	public void setOrigImageLinkUrl(String origImageLinkUrl) {
		this.origImageLinkUrl = origImageLinkUrl;
	}
	public String getTargImageLinkUrl() {
		return targImageLinkUrl;
	}
	public void setTargImageLinkUrl(String targImageLinkUrl) {
		this.targImageLinkUrl = targImageLinkUrl;
	}
	public String getAdName() {
		return adName;
	}
	public void setAdName(String adName) {
		this.adName = adName;
	}
	public Integer getPosiId() {
		return posiId;
	}
	public void setPosiId(Integer posiId) {
		this.posiId = posiId;
	}
	public Integer getSortNum() {
		return sortNum;
	}
	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreateTime1() {
		return createTime1;
	}
	public void setCreateTime1(String createTime1) {
		this.createTime1 = createTime1;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
