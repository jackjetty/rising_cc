package com.bhyf.pojo.dto.article;

import java.io.Serializable;
import java.util.Date;

public class ArticleDto implements Serializable{
	private static final long serialVersionUID = -7721059389027100112L;
	
	private Integer id;
	private String title;//标题
	private Integer category;//分类，1：公告；2：新闻；3：招生；4：就业；
	private String content;//内容
	private Integer status;//状态：0：失效；1：激活；80：删除；
	private Date issueTime;//发布时间
	private String issueUser;//发布人
	private Integer top;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
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
	public Date getIssueTime() {
		return issueTime;
	}
	public void setIssueTime(Date issueTime) {
		this.issueTime = issueTime;
	}
	public Integer getTop() {
		return top;
	}
	public void setTop(Integer top) {
		this.top = top;
	}

	public String getIssueUser() {
		return issueUser;
	}

	public void setIssueUser(String issueUser) {
		this.issueUser = issueUser;
	}
}
