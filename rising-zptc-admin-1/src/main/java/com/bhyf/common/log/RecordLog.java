package com.bhyf.common.log;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.alibaba.fastjson.JSON;
import com.rising.common.util.HttpUtil;
import com.rising.common.util.PropertiesUtils;

/**
 * 
 * @description: 记录日志工具类
 * @company: 碧海银帆
 * @author caoy
 * @date 2015年6月2日上午9:57:38
 */
public class RecordLog {
	private static final Properties properties = PropertiesUtils.getProps("/config.properties");
	private static final String postUriReserve = properties.getProperty("log_record_url");
	private static final Integer timeOutReserve = Integer.parseInt(properties.getProperty("log_record_timeout"));
	private static BaseLogDb db = new BaseLogDb("rising","exceptionLog");
	
	
	
	public static BaseLogDb getDb() {
		return db;
	}
	/**
	 * 
	 * @description: 
	 * @date 2015年6月2日上午9:57:51
	 * @param config 必需
	 * @param data 必需
	 * @param postUri 非必需
	 * @param timeOut 非必需
	 */
	public static void record(Object config, Object data, String postUri, Integer timeOut){
		try {
			
			timeOut = timeOut==null ? timeOutReserve : timeOut;
			postUri = postUri==null ? postUriReserve : postUri;
			
			Map<String,String> paramMap = new HashMap<String, String>();
			
			paramMap.put("config", JSON.toJSONString(config));
			paramMap.put("data", JSON.toJSONString(data));
			HttpUtil.executePostMethod(postUri, paramMap, timeOut);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 * @Title record 
	 * @Description TODO
	 * @param config 必需
	 * @param data 必需
	 * @throws
	 * @author caizh
	 * @creatTime 2015年6月11日 上午10:23:52
	 * @modifyTime 2015年6月11日 上午10:23:52
	 */
	public static void record(Object config, Object data){
		record(config,data,postUriReserve,timeOutReserve);
	}
	
	
}
