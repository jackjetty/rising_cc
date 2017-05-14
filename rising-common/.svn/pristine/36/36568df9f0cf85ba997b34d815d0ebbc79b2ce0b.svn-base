package com.rising.common.util;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

/**
 * DWZ JSON 工具类
 * @author zhurz
 */
public class DwzJsonResultUtil {

	public final static String STATUS_CODE_200 = "200";
	public final static String STATUS_CODE_300 = "300";
	public final static String STATUS_CODE_500 = "300";

	public final static String CALL_BACK_TYPE_CLOSE_CURRENT = "closeCurrent";
	public final static String FLUSH_FORWARD = "forward";

	public static String createSimpleJsonString(String statusCode, String message){
		return createJsonString(statusCode, message, null, null, null, null, null);
	}

	public static String createJsonString(String statusCode, String message, String callbackType, String navTabId){
		return createJsonString(statusCode, message, callbackType, navTabId, null, null, null);
	}

	public static String createJsonString(String statusCode, String message, String callbackType, String navTabId, 
			String confirmMsg, String forwardUrl, String rel){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("statusCode", statusCode);
		map.put("message", message);
		if(StringUtils.isNotBlank(callbackType)){
			map.put("callbackType", callbackType);
		}
		if(StringUtils.isNotBlank(navTabId)){
			map.put("navTabId", navTabId);
		}
		if(StringUtils.isNotBlank(confirmMsg)){
			map.put("confirmMsg", confirmMsg);
		}
		if(StringUtils.isNotBlank(forwardUrl)){
			map.put("forwardUrl", forwardUrl);
		}
		if(StringUtils.isNotBlank(rel)){
			map.put("rel", rel);
		}
		return JsonUtil.parseObject(map, false);
	}
}