package com.rising.cc.controller.project;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.rising.common.util.Md5Util;
import com.rising.cc.common.component.BaseController;
import com.rising.cc.pojo.constants.project.EnginConfigInfoConstants;
import com.rising.cc.pojo.qo.project.ReadPropertiesInfoQo;
import com.rising.cc.service.interf.project.EnginConfigInfoService;

@Controller
public class EnginConfigInfoController extends BaseController{
	
	@Resource
	private EnginConfigInfoService enginConfigInfoService;
	
	@RequestMapping("read/prop")
	@ResponseBody
	public String readConfigInfo(@ModelAttribute ReadPropertiesInfoQo qo){
		
		if(qo != null 
				&& StringUtils.isNotBlank(qo.getProjectCode())
				&& StringUtils.isNotBlank(qo.getEnginCode())
				&& StringUtils.isNotBlank(qo.getEnvirCode())
				&& StringUtils.isNotBlank(qo.getSign())){
			
			if(this.checkSign(qo)){
				Map<String,Object> dataMap = new LinkedHashMap<String,Object>();
				
				try {
						dataMap = enginConfigInfoService.findPropertiesConfigDataMapByQo(qo);
						
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				return  JSON.toJSONString(dataMap);
			}
		}
		
		return null;
	}
	
	private boolean checkSign(ReadPropertiesInfoQo qo){
		try {
			
		    String sign = qo.getSign();
			
			StringBuffer paramSb = new StringBuffer();
			paramSb.append("projectCode=");
			paramSb.append(qo.getProjectCode());
			paramSb.append("&enginCode=");
			paramSb.append(qo.getEnginCode());
			paramSb.append("&envirCode=");
			paramSb.append(qo.getEnvirCode());
			paramSb.append("&key=");
			paramSb.append(EnginConfigInfoConstants.MD5_KEY);
			
			String mSign = Md5Util.MD5(paramSb.toString());
			if(mSign.equals(sign)){
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) {
		
	}
	
}
