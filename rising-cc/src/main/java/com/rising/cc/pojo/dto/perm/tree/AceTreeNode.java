package com.rising.cc.pojo.dto.perm.tree;

import java.io.Serializable;



@SuppressWarnings("serial")
public class AceTreeNode implements Serializable{
	
	private String text;
	
	private String type;//item  ，， folder
	
	private Integer data;
	
	private AdditionalParameters additionalParameters;

	
	public AceTreeNode() {
		// TODO Auto-generated constructor stub
	}
	
	
	public AceTreeNode(String text, String type, Integer data) {
		super();
		this.text = text;
		this.type = type;
		this.data = data;
	}


	
	public AceTreeNode(String text, String type, Integer data,
			AdditionalParameters additionalParameters) {
		super();
		this.text = text;
		this.type = type;
		this.data = data;
		this.additionalParameters = additionalParameters;
	}


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}


	public AdditionalParameters getAdditionalParameters() {
		return additionalParameters;
	}


	public void setAdditionalParameters(AdditionalParameters additionalParameters) {
		this.additionalParameters = additionalParameters;
	}
	

}
