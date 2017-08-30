package com.bhyf.pojo.exception;

import java.util.List;

@SuppressWarnings("serial")
public class BusinessException extends Exception{
	
	/*** 返回异常码 */
	private String errCode;
	
	/*** 返回异常信息 */
	private String errMsg;
	
	/*** 返回对象 */
	private Object obj;
	
	/*** 返回对象List */
	private List<Object> objectList;
	
	
	public BusinessException() {
		
	}
	
	public BusinessException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
	
	public BusinessException(String errCode, String errMsg, 
			Object obj) {
		super();
		this.obj = obj;
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
	
	public BusinessException(String errCode, String errMsg, 
			Object obj, List<Object> objectList) {
		super();
		this.objectList = objectList;
		this.obj = obj;
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
	
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public List<Object> getObjectList() {
		return objectList;
	}
	public void setObjectList(List<Object> objectList) {
		this.objectList = objectList;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
}
