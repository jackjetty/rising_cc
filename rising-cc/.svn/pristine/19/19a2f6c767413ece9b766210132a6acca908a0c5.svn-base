package com.rising.cc.pojo.dto.project;

import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rising.cc.common.component.BaseModel;

/**
 * 
 * @description 工程配置信息
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月28日 上午10:12:59
 *
 */
@SuppressWarnings("serial")
public class EnginConfigInfoDto extends BaseModel{
	
	private EngineeringDto enginDto;
	
	private EnginConfigTypeDto enginConfigTypeDto;

	private String envType;
	
	private String data;

	public EngineeringDto getEnginDto() {
		return enginDto;
	}

	public void setEnginDto(EngineeringDto enginDto) {
		this.enginDto = enginDto;
	}

	public EnginConfigTypeDto getEnginConfigTypeDto() {
		return enginConfigTypeDto;
	}

	public void setEnginConfigTypeDto(EnginConfigTypeDto enginConfigTypeDto) {
		this.enginConfigTypeDto = enginConfigTypeDto;
	}

	public String getEnvType() {
		return envType;
	}

	public void setEnvType(String envType) {
		this.envType = envType;
	}

	public String getData() {
		/*if(StringUtils.isNotBlank(this.data) && this.enginConfigTypeDto != null){
			
			if(this.enginConfigTypeDto.getFileName().contains(".properties")){
				StringBuffer sbData = new StringBuffer();
				try {
					JSONObject obj = JSON.parseObject(this.data);
					for (Iterator<String> iterator = obj.keySet().iterator(); iterator.hasNext();) {
						String key = iterator.next();
						sbData.append(key);
						sbData.append("=");
						sbData.append(obj.get(key));
						sbData.append("\r\n");
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return sbData.toString();
			}else{
				return data;
			}
			
			
			
		}*/
		
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	
}
