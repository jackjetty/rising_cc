package com.rising.common.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.lang.StringUtils;

import com.rising.common.model.HttpResponse;

/**
 * Http工具类
 * @author caoy
 *
 */
public class HttpUtil {
	
	/**
	 * 默认读取结果超时时间
	 */
	private static final int defaultSoTimeOut = 6000;
	/**
	 * 默认请求超时时间
	 */
	private static final int defaultConnTimeOut = 10000;
	
	/**
	 * http post 请求
	 * @param postUrl ==>请求Url  必须参数
	 * @param paramMap ==>请求参数，请封装成Map 非必须参数
	 * @param timeOut ==>超时时间  非必须参数，如若为null，默认超时时间为5000ms
	 * @return
	 */
	public static HttpResponse executePostMethod(String postUrl, Map<String,String> paramMap, Integer timeOut){
		timeOut = timeOut == null ? defaultSoTimeOut : timeOut;
		HttpResponse res = new HttpResponse();
		Date sendTime = SysDateUtils.getCurrentDate();
		res.setSendTime(sendTime);
		HttpClient httpclient = new HttpClient();
		PostMethod method = new PostMethod(postUrl);
		BufferedReader in = null;
		try {
			HttpClientParams params = new HttpClientParams();
			params.setContentCharset("utf-8");
			params.setConnectionManagerTimeout(defaultConnTimeOut);
			params.setSoTimeout(timeOut);
			httpclient.setParams(params);
			for (Iterator iterator = paramMap.keySet().iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				method.addParameter(key, paramMap.get(key));
			}
			method.setRequestHeader("Connection", "close");
			int respoinsCode = httpclient.executeMethod(method);
			in = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), "UTF-8"));
			String line;
			StringBuffer sb = new StringBuffer();
			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
			in.close();	
			Date handOverTime = SysDateUtils.getCurrentDate();
			res.setRespoinsCode(respoinsCode);
			res.setHandOverTime(handOverTime);
			if (sb.length() <= 0) {
				res.setResult(method.getResponseBodyAsString());
			} else {
				res.setResult(sb.toString());
			}
			res.setResponseTime(handOverTime.getTime()-sendTime.getTime());
			res.setResponseState(1);	
		} catch (Exception e) {
			e.printStackTrace();
			res.setHandOverTime(SysDateUtils.getCurrentDate());
			res.setResponseTime(0L);
			res.setResponseState(3);
			res.setResult("响应超时!");
			res.setRespoinsCode(500);
		} finally {
			try {
				method.releaseConnection();
				if(in != null){
					in.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	
	/**
	 * http get 请求 参数getUrl
	 * @param getUrl ==>请求Url  必须参数
	 * @param param ==>请求Url  必须参数
	 * @param timeOut ==>超时时间  非必须参数，如若为null，默认超时时间为5000ms	 
	 * @return
	 */
	public static HttpResponse executeGetMethod(String getUrl, String param, Integer timeOut){
		if(StringUtils.isNotBlank(param)){
			getUrl+="?"+param;
		}
		return executeGetMethod(getUrl, timeOut);
	}
	
	/**
	 * http get 请求 参数getUrl后边要调用此方法者手动拼接参数
	 * @param getUrl ==>请求Url  必须参数
	 * @param timeOut ==>超时时间  非必须参数，如若为null，默认超时时间为5000ms	 
	 * @return
	 */
	public static HttpResponse executeGetMethod(String getUrl, Integer timeOut){
		timeOut = timeOut == null ? defaultSoTimeOut : timeOut;
		HttpResponse res = new HttpResponse();
		Date sendTime = SysDateUtils.getCurrentDate();
		res.setSendTime(sendTime);
		HttpClient httpclient = new HttpClient();
		GetMethod method = new GetMethod(getUrl);
		BufferedReader in = null;
		try {
			HttpClientParams params = new HttpClientParams();
			params.setContentCharset("utf-8");
			params.setConnectionManagerTimeout(defaultConnTimeOut);
			params.setSoTimeout(timeOut);
			httpclient.setParams(params);
			method.setRequestHeader("Connection", "close");
			int respoinsCode = httpclient.executeMethod(method);
			in = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), "UTF-8"));
			String line;
			StringBuffer sb = new StringBuffer();
			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
			in.close();	
			Date handOverTime = SysDateUtils.getCurrentDate();
			Long responseTime = handOverTime.getTime()-sendTime.getTime();
			res.setRespoinsCode(respoinsCode);
			if(responseTime>timeOut){
				res.setHandOverTime(SysDateUtils.getCurrentDate());
				res.setResult("请求连接超时！");
				res.setResponseTime(0L);
				res.setResponseState(3);	
			}else{			
				res.setHandOverTime(handOverTime);
				if (sb.length() <= 0) {
					res.setResult(method.getResponseBodyAsString());
				} else {
					res.setResult(sb.toString());
				}
				res.setResponseTime(handOverTime.getTime()-sendTime.getTime());
				res.setResponseState(1);	
			}			
		} catch (Exception e) {
			e.printStackTrace();
			res.setHandOverTime(SysDateUtils.getCurrentDate());
			res.setResponseTime(0L);
			res.setResponseState(3);
			res.setResult("响应超时!");
			res.setRespoinsCode(500);
		} finally {
			try {
				method.releaseConnection();
				if(in != null){
					in.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	
	/**
	 * 获取cokie信息
	 * @param request
	 * @param key
	 * @param domain
	 * @return
	 */
	public static String getCookie(HttpServletRequest request, String key, String domain) {
		if (StringUtils.isNotBlank(key)) {
			// 获取cookie[]组
			Cookie[] cookies = request.getCookies();
			// 遍历cookie[]组，获取匹配cookie
			if (cookies != null) {
				for (Cookie cookie:cookies) {
					if (key.equals(cookie.getName())) {
						return cookie.getValue();
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * 设置cokie信息
	 * @param request
	 * @param key
	 * @param domain
	 * @return
	 */
	public static void setCookie(HttpServletResponse response, String key, String value, String domain, Integer maxAge) {
		Cookie c = new Cookie(key, value);
		if (StringUtils.isNotEmpty(domain)) {
			c.setDomain(domain);
		}
		if (maxAge != null) {
			c.setMaxAge(maxAge);
		}
		c.setPath("/");
		response.addCookie(c);
	}
	
	/**
	 * 获取用户IP地址
	 * @param request
	 * @return
	 */
	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip==null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip=request.getHeader("Proxy-Client-IP");
		}
		if (ip==null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip=request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip==null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip=request.getRemoteAddr();
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("http_client_ip");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip != null && ip.indexOf(",") != -1) {// 如果是多级代理，那么取第一个ip为客户ip
			ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
		}
		return ip;
	}
}
