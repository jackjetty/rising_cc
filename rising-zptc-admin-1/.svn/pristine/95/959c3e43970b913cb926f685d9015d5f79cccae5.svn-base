package com.bhyf.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.rising.common.model.HttpResponse;
import com.rising.common.util.SysDateUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.lang.StringUtils;


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
//			params.setParameter("Content-Type","text/html;charset=UTF-8");
			httpclient.setParams(params);
			for (Iterator iterator = paramMap.keySet().iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				method.addParameter(key, paramMap.get(key));
			}
            method.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
			method.setRequestHeader("Connection", "close");
			int respoinsCode = httpclient.executeMethod(method);
			in = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), "utf-8"));
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
	 * http post 请求
	 * @param postUrl ==>请求Url  必须参数
	 * @param paramMap ==>请求参数，请封装成Map 非必须参数
	 * @param timeOut ==>超时时间  非必须参数，如若为null，默认超时时间为5000ms
	 * @return
	 */
	public static HttpResponse executePostMethod(String postUrl, Map<String,String> paramMap,String user,String pwd,Integer timeOut){
		timeOut = timeOut == null ? defaultSoTimeOut : timeOut;
		HttpResponse res = new HttpResponse();
		Date sendTime = SysDateUtils.getCurrentDate();
		res.setSendTime(sendTime);
		HttpClient httpclient = new HttpClient();
        //需要验证
        UsernamePasswordCredentials creds = new UsernamePasswordCredentials(user,pwd);
        PostMethod method = new PostMethod(postUrl);
		BufferedReader in = null;
		try {
			HttpClientParams params = new HttpClientParams();
			params.setContentCharset("utf-8");
			params.setConnectionManagerTimeout(defaultConnTimeOut);
			params.setSoTimeout(timeOut);
//			params.setParameter("Content-Type","text/html;charset=UTF-8");
			httpclient.setParams(params);
            httpclient.getState().setCredentials(AuthScope.ANY,creds);
			for (Iterator iterator = paramMap.keySet().iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				method.addParameter(key, paramMap.get(key));
			}
            method.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
			method.setRequestHeader("Connection", "close");
			int respoinsCode = httpclient.executeMethod(method);
			in = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), "utf-8"));
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
	 * http get 请求 参数getUrl后边要调用此方法者手动拼接参数
	 * @param getUrl ==>请求Url  必须参数
	 * @param timeOut ==>超时时间  非必须参数，如若为null，默认超时时间为5000ms	 
	 * @return
	 */
	public static HttpResponse executeGetMethod(String getUrl,String user,String pwd, Integer timeOut){
		timeOut = timeOut == null ? defaultSoTimeOut : timeOut;
		HttpResponse res = new HttpResponse();
		Date sendTime = SysDateUtils.getCurrentDate();
		res.setSendTime(sendTime);
		HttpClient httpclient = new HttpClient();
		GetMethod method = new GetMethod(getUrl);
        //需要验证
        UsernamePasswordCredentials creds = new UsernamePasswordCredentials(user,pwd);
		BufferedReader in = null;
		try {
			HttpClientParams params = new HttpClientParams();
			params.setContentCharset("utf-8");
			params.setConnectionManagerTimeout(defaultConnTimeOut);
			params.setSoTimeout(timeOut);
			httpclient.setParams(params);
            httpclient.getState().setCredentials(AuthScope.ANY,creds);
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
     * 向指定URL发送GET方法的请求<br/>
     *
     * @param url 发送请求的URL<br/>
     * @param param 请求参数<br/>
     *            请求参数应该是 name1=value1&name2=value2 的形式,中文需要先URLEncoder.encode<br/>
     * @return URL 所代表远程资源的响应结果<br/>
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            // Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            // for (String key : map.keySet()) {
            // System.out.println(key + "--->" + map.get(key));
            // }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            result = e.getMessage();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求<br/>
     *
     * @param url 发送请求的 URL<br/>
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。<br/>
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        OutputStream out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(130000);

            // 获取URLConnection对象对应的输出流
            out = conn.getOutputStream();
            out.write(param.getBytes("utf-8"));
            // 发送请求参数
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            result = e.getMessage();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求<br/>
     *
     * @param url 发送请求的 URL<br/>
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。<br/>
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param,String encode) {
        OutputStream out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(130000);

            // 获取URLConnection对象对应的输出流
            out = conn.getOutputStream();
            out.write(param.getBytes(encode));
            // 发送请求参数
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(),encode));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            result = e.getMessage();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
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
		return ip;
	}

}
