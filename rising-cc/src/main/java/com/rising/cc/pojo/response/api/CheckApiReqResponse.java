package com.rising.cc.pojo.response.api;

import com.rising.common.api.base.ApiResponse;

@SuppressWarnings("serial")
public class CheckApiReqResponse extends ApiResponse{
	public final static String ACCOUNT_NOT_FOUND_OR_DISABLE = "-9001001"; //账号不存在或被禁用
	public final static String IP_ILLEGAL = "-9001002"; //IP非法
	public final static String API_NO_EXIST_OR_PERM_OR_DISABLE = "-9001003"; //API不存在，或没有API权限，或者API被禁用
	public final static String CALL_TIME_OUT = "-9001004"; //调用超时

	public final static String ACCOUNT_MISSING = "-9002001"; //账号缺失
	public final static String API_NAME_MISSING = "-9002002"; //apiName缺失
	public final static String SEND_TIME_MISSING = "-9002003"; //发送时间缺失
	public final static String SIGN_MISSING = "-9002004"; //签名缺失
	public final static String SEQ_NO_MISSING = "-9002005"; //请求唯一序列缺失
	public final static String SEND_IP_MISSING = "-9002006"; //发送IP缺失
	
	public final static String ENVIR_CODE_MISSING = "-9003001"; //环境编码缺失
	public final static String REALITY_IP_MISSING = "-9003002"; //调用方IP缺失
	public final static String REQUEST_MISSING = "-9003003"; //报文缺失
	public final static String C_SIGN_MISSING = "-9003004"; //签名缺失
	public final static String C_SIGN_ILLEGAL = "-9003005"; //签名非法
	
	
	
	static{
		
		RESULT_CODE_MAP.put(ACCOUNT_NOT_FOUND_OR_DISABLE, "账号不存在或被禁用");
		RESULT_CODE_MAP.put(IP_ILLEGAL, "IP非法");
		RESULT_CODE_MAP.put(API_NO_EXIST_OR_PERM_OR_DISABLE, "API不存在，或没有API权限，或API被禁用");
		RESULT_CODE_MAP.put(CALL_TIME_OUT, "请求已经失效");
		RESULT_CODE_MAP.put(ACCOUNT_MISSING, "账号缺失");
		RESULT_CODE_MAP.put(API_NAME_MISSING, "apiName缺失");
		RESULT_CODE_MAP.put(SEND_TIME_MISSING, "发送时间缺失");
		RESULT_CODE_MAP.put(SIGN_MISSING, "签名缺失");
		RESULT_CODE_MAP.put(SEQ_NO_MISSING, "请求唯一序列缺失");
		RESULT_CODE_MAP.put(SEND_IP_MISSING, "发送IP缺失");
		
		RESULT_CODE_MAP.put(ENVIR_CODE_MISSING, "COMMAND_环境编码缺失");
		RESULT_CODE_MAP.put(REALITY_IP_MISSING, "COMMAND_实际IP缺失");
		RESULT_CODE_MAP.put(REQUEST_MISSING, "COMMAND_请求参数缺失");
		RESULT_CODE_MAP.put(C_SIGN_MISSING, "COMMAND_鉴权签名缺失");
		RESULT_CODE_MAP.put(C_SIGN_ILLEGAL, "COMMAND_鉴权签名非法");
		
	}
	
}
