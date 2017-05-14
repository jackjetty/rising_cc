package com.rising.cc.pojo.command.queue;

import com.rising.cc.common.component.BaseCommand;
/**
 * 
 * 项目名称：bhyf-cc  
 * 类名称：CreateHandlerCommand  
 * 类描述：  
 * 创建人：caizh 
 * 创建时间：2015年9月9日 下午4:32:28  
 * 修改人：caizh 
 * 修改时间：2015年9月9日 下午4:32:28  
 * 修改备注：  
 * @version：v1.0.0
 */
public class CreateHandlerCommand extends BaseCommand{
	private String name;
    private String url;
    private String failUrl;
    private Integer rate;
    private Integer type;
    private Integer envirId;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFailUrl() {
		return failUrl;
	}
	public void setFailUrl(String failUrl) {
		this.failUrl = failUrl;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

    public Integer getEnvirId() {
        return envirId;
    }

    public void setEnvirId(Integer envirId) {
        this.envirId = envirId;
    }

    public void createCommand(EditHandlerCommand command) {
		setFailUrl(command.getFailUrl());
		setUrl(command.getUrl());
		setName(command.getName());
		setRate(command.getRate());
		setType(command.getType());
        setEnvirId(command.getEnvirId());
	}
    
}
