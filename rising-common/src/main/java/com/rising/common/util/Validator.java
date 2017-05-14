package com.rising.common.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;



/**
 * 过滤URL请求参数的特殊字符
 *
 */
public class Validator {
	/**
	 * 过滤参数里面的特殊字符
	 * @param value
	 * @return
	 */
	public static String filter(String value) {
		if (value == null) {
			return null;
		}
		
		if(value.indexOf("http://") >= 0){
			return value.replaceAll("http://", "");
		}
		
		StringBuffer result = new StringBuffer(value.length());
		for (int i = 0; i < value.length(); ++i) {
			switch (value.charAt(i)) {
			case '<':
				result.append("&lt;");
				break;
			case '>':
				result.append("&gt;");
				break;
			case '"':
				result.append("&quot;");
				break;
			case '\'':
				result.append("&#39;");
				break;			
			case ';':
				result.append("&#59;");
				break;
			case '(':
				result.append("&#40;");
				break;
			case ')':
				result.append("&#41;");
				break;
			case '&':
				result.append("&amp;");
				break;
			case '+':
				result.append("&#43;");
				break;
			default:
				result.append(value.charAt(i));
				break;
			}
		}
		return result.toString();
	}
	
	public static String filterRemove(String value) {
		if (value == null) {
			return null;
		}
		
//		value = value.toLowerCase();
		
		value = value.replaceAll("[~|$|￥|\"|'|:|(|)|^|&|<|>|\\||\\+|=]*", "");
		value = value.replaceAll("(?i)script", "");
		return value;
	}
	
	public static boolean isSafe(String value) {
		if (value == null) {
			return true;
		}
		

		for (int i = 0; i < value.length(); ++i) {
			switch (value.charAt(i)) {
			case '%':
				return false;
			default:
				break;
			}
		}
		
		value  = EscapeUtil.unescape(value);
		value = value.toLowerCase();
		
		for (int i = 0; i < value.length(); ++i) {
			switch (value.charAt(i)) {
			case '<':
				return false;
			case '>':
				return false;
			case ';':
				return false;
			case '{':
				return false;
			case '}':
				return false;
			case '|':
				return false;
			case '(':
				return false;
			case ')':
				return false;
			default:
				break;
			}
		}
		
		if (value.indexOf("script") != -1) {
			return false;
		}
		
		return true;
	}
	
	public static boolean isCsair(HttpServletRequest request) {
		String value = request.getHeader("REFERER");
		
		if (StringUtils.isBlank(value)) {
			return true;
		}
		value = EscapeUtil.unescape(value).toLowerCase();
		int begin = value.indexOf("//");
		if (begin != -1) {
			value = value.substring(begin + 2);
		}
		
		int index = value.indexOf("/");
		String checkStr;
 		if (index == -1) {
			checkStr = value;
		} else {
			checkStr = value.substring(0, index);
		}
		if (checkStr.indexOf("csair.com") == -1
				|| checkStr.indexOf("csair.com.") != -1) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean isCsairTest(String value) {
		
		if (StringUtils.isBlank(value)) {
			return true;
		}
		value = EscapeUtil.unescape(value).toLowerCase();
		int begin = value.indexOf("//");
		if (begin != -1) {
			value = value.substring(begin + 2);
		}
		
		int index = value.indexOf("/");
		String checkStr;
 		if (index == -1) {
			checkStr = value;
		} else {
			checkStr = value.substring(0, index);
		}
		if (checkStr.indexOf("csair.com") == -1
				|| checkStr.indexOf("csair.com.") != -1) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void main(String[] args) {
		Validator validator = new Validator();
		System.out.println(validator.isCsairTest("csair.com.:7101"));
	}
}
