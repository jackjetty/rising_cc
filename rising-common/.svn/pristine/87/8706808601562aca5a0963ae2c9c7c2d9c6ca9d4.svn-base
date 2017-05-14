package com.rising.common.api.base;

import java.io.Serializable;
import java.util.HashMap;

@SuppressWarnings("serial")
public class ApiResponse implements Serializable {

	/**
	 * 返回结果代码
	 */
	private String result = RESULT_CODE_SUCCESS;
	/**
	 * 返回结果文字提示
	 */
	private String message;

	public final static String RESULT_CODE_SUCCESS= "1"; // 成功
	public final static String RESULT_CODE_FAILE="0";//失败
	public final static String RESULT_CODE_ILLEGAL="-1";//非法参数
	public final static String RESULT_CODE_SIGN_ILLEGAL="-2";//签名非法
	public final static String SYSTEM_ERROR="-9999";
	
	public final static HashMap<String,String> RESULT_CODE_MAP = new HashMap<String,String>();
	static {
		RESULT_CODE_MAP.put(RESULT_CODE_SUCCESS, "成功");
		RESULT_CODE_MAP.put(RESULT_CODE_FAILE, "失败"); 
		RESULT_CODE_MAP.put(RESULT_CODE_ILLEGAL, "非法参数"); 
		RESULT_CODE_MAP.put(RESULT_CODE_SIGN_ILLEGAL, "签名非法"); 
		RESULT_CODE_MAP.put(SYSTEM_ERROR, "系统错误"); 
	}
			
	public ApiResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public ApiResponse(String result, String message) {
		super();
		this.result = result;
		this.message = message;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
