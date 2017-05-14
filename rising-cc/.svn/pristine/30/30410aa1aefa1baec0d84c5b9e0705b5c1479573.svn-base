package com.rising.cc.pojo.command.project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rising.common.util.SysDateUtils;
import com.rising.cc.model.project.EnginConfigInfo;
import com.rising.cc.model.user.SysUser;
import com.rising.cc.pojo.constants.user.LoginConstants;

/**
 * 
 * @description 工程配置信息
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月28日 上午10:12:59
 *
 */
@SuppressWarnings("serial")
public class UpdateEnginConfigInfoCommand implements Serializable{
	
	private Integer enginId;

	private String dataArr;
	
	private Date createTime;
	
	private String createUser;
	
	public UpdateEnginConfigInfoCommand() {
		Subject currentSubject = SecurityUtils.getSubject();
		SysUser sysUser = (SysUser)currentSubject.getSession().getAttribute(LoginConstants.SESSION_USER_KEY);
		
		this.createUser = sysUser.getUserName();
		this.createTime = SysDateUtils.getCurrentDate();
	}
	
	public String getDataArr() {
		return dataArr;
	}

	public void setDataArr(String dataArr) {
		this.dataArr = dataArr;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Integer getEnginId() {
		return enginId;
	}

	public void setEnginId(Integer enginId) {
		this.enginId = enginId;
	}

	public List<EnginConfigInfo> getUpdateEnginConfigList(){
		if(StringUtils.isNotBlank(this.dataArr)){
			JSONArray  jsonArray= JSON.parseArray(this.dataArr);
			List<EnginConfigInfo> list = new ArrayList<EnginConfigInfo>();
			for (Iterator iterator = jsonArray.iterator(); iterator.hasNext();) {
				JSONObject object = (JSONObject) iterator.next();
				if(object != null){
					EnginConfigInfo config = JSON.toJavaObject(object, EnginConfigInfo.class);
					
					config.setCreateTime(this.createTime);
					config.setCreateUser(this.createUser);
					
					/*if(config.getEnginConfigType().getFileName().contains(".properties")){
						String [] dataSs = config.getData().split("\n");
						LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
						for (String dataStr : dataSs) {
							String key = dataStr.substring(0,dataStr.indexOf("="));
							String value = dataStr.substring(dataStr.indexOf("=")+1,dataStr.length());
							dataMap.put(key, value);
						}
						config.setData(JSON.toJSONString(dataMap));
						
					}*/
					
					list.add(config);
					
				}
			}
			
			return list;
		}
		
		return null;
	}
	
}
