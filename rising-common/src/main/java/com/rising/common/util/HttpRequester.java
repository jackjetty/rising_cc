package com.rising.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.rising.common.model.HttpRespons;

public class HttpRequester {
    private static String defaultContentEncoding;   
    private static Date sendTime ;
    private static Date handOverTime;
    
    public HttpRequester() {   
        defaultContentEncoding = Charset.defaultCharset().name();   
    }   
    
    /**  
     * 发送GET请求  
     *   
     * @param urlString  
     *            URL地址  
     * @return 响应对象  
     * @throws IOException  
     */  
    public static HttpRespons sendGet(String urlString,int timeOut) throws IOException {   
        return send(urlString, "GET", null, null,timeOut);   
    }   
    
    /**  
     * 发送GET请求  
     *   
     * @param urlString  
     *            URL地址  
     * @param params  
     *            参数集合  
     * @return 响应对象  
     * @throws IOException  
     */  
    public static HttpRespons sendGet(String urlString, Map<String, String> params,int timeOut)   
            throws IOException {   
        return send(urlString, "GET", params, null,timeOut);   
    }   
    
    /**  
     * 发送GET请求  
     *   
     * @param urlString  
     *            URL地址  
     * @param params  
     *            参数集合  
     * @param propertys  
     *            请求属性  
     * @return 响应对象  
     * @throws IOException  
     */  
    public static HttpRespons sendGet(String urlString, Map<String, String> params,   
            Map<String, String> propertys,int timeOut) throws IOException {   
        return send(urlString, "GET", params, propertys,timeOut);   
    }   
    
    /**  
     * 发送POST请求  
     *   
     * @param urlString  
     *            URL地址  
     * @return 响应对象  
     * @throws IOException  
     */  
    public static HttpRespons sendPost(String urlString ,int timeOut) throws IOException {   
        return send(urlString, "POST", null, null,timeOut);   
    }   
    
    /**  
     * 发送POST请求  
     *   
     * @param urlString  
     *            URL地址  
     * @param params  
     *            参数集合  
     * @return 响应对象  
     * @throws IOException  
     */  
    public static HttpRespons sendPost(String urlString, Map<String, String> params,int timeOut)   
            throws IOException {   
        return send(urlString, "POST", params, null,timeOut);   
    }   
    
    /**  
     * 发送POST请求  
     *   
     * @param urlString  
     *            URL地址  
     * @param params  
     *            参数集合  
     * @param propertys  
     *            请求属性  
     * @return 响应对象  
     * @throws IOException  
     */  
    public static HttpRespons sendPost(String urlString, Map<String, String> params,   
            Map<String, String> propertys,int timeOut) throws IOException {   
        return send(urlString, "POST", params, propertys,timeOut);   
    }   
    
	 /**
	  * 发送post请求
	  * 
	  * 		URL地址
	  * @param urlString
	  * 		URL参数
	  * param params
	  * 	例如 ddd=888&dd=asdas
	  *  
	  * @return 相应请求
	  * @throws IOException
	  * 
	  */
    public static HttpRespons sendPost(String urlString,String params,int timeOut){
    	Map<String ,String> parameters = new HashMap<String,String>();
    	String[] paramsTemp  = params.split("&");
    	try{
	    	for(String str : paramsTemp){
	    		String[] maptemp = str.split("=");
	    		parameters.put(maptemp[0], maptemp[1]);    		
	    	}   
	    	return send(urlString,"POST",parameters,null,timeOut);
    	}catch(Exception e){
    		sendTime =new Date();
    		handOverTime = new Date();
    		HttpRespons httpRespons = new HttpRespons();
    		httpRespons.setMessage("输入参数有误！");
    		httpRespons.setUrlTimeOut(0L);
    		httpRespons.setCode(400);
    		httpRespons.setSendTime(sendTime);
    		httpRespons.setHandOverTime(handOverTime);
    		return httpRespons;
    	}
    	
    }
    
    /**  
     * 发送HTTP请求  
     *   
     * @param urlString  
     * @return 响映对象  
     * @throws IOException  
     */  
    private static HttpRespons send(String urlString, String method,   
            Map<String, String> parameters, Map<String, String> propertys,int timeOut) {
    	try{
        HttpURLConnection urlConnection = null;   
        //记录发送当前时间
        sendTime = new  Date();
        if (method.equalsIgnoreCase("GET") && parameters != null) {   
            StringBuffer param = new StringBuffer();   
            int i = 0;   
            for (String key : parameters.keySet()) {   
                if (i == 0)   
                    param.append("?");   
                else  
                    param.append("&");   
                param.append(key).append("=").append(parameters.get(key));   
                i++;   
            }   
            urlString += param;   
        }   
        URL url = new URL(urlString);   
        urlConnection = (HttpURLConnection) url.openConnection();   
    
        urlConnection.setRequestMethod(method);   
        urlConnection.setDoOutput(true);   
        urlConnection.setDoInput(true);   
        urlConnection.setUseCaches(false);   
        urlConnection.setConnectTimeout(timeOut);
        if (propertys != null)   
            for (String key : propertys.keySet()) {   
                urlConnection.addRequestProperty(key, propertys.get(key));   
            }   
    
        if (method.equalsIgnoreCase("POST") && parameters != null) {   
            StringBuffer param = new StringBuffer();   
            for (String key : parameters.keySet()) {   
                param.append("&");   
                param.append(key).append("=").append(parameters.get(key));   
            }   
            urlConnection.getOutputStream().write(param.toString().getBytes());   
            urlConnection.getOutputStream().flush();   
            urlConnection.getOutputStream().close();   
        }   
        return makeContent(urlString, urlConnection);   
    	}catch(Exception e){
    		sendTime =new Date();
    		handOverTime = new Date();
    		HttpRespons httpRespons = new HttpRespons();    		
    		httpRespons.setMessage("连接超时");
    		httpRespons.setUrlTimeOut(0L);
    		httpRespons.setSendTime(sendTime);
    		httpRespons.setHandOverTime(handOverTime);
    		httpRespons.setCode(400);
    		return httpRespons;
    	}
    }   
    
    /**  
     * 得到响应对象  
     *   
     * @param urlConnection  
     * @return 响应对象  
     * @throws IOException  
     */  
    private static HttpRespons makeContent(String urlString,   
            HttpURLConnection urlConnection) throws IOException {   
        HttpRespons httpResponser = new HttpRespons();            
        try {   
            InputStream in = urlConnection.getInputStream();   
            BufferedReader bufferedReader = new BufferedReader(   
                    new InputStreamReader(in));   
            Vector<String> contentCollection = new Vector<String>();   
            StringBuffer temp = new StringBuffer();   
            String line = bufferedReader.readLine();   
            while (line != null) {   
               contentCollection.add(line);   
                temp.append(line).append("\r\n");   
                line = bufferedReader.readLine();   
            }  
            httpResponser.setContentCollection(contentCollection);
            bufferedReader.close();   
    
            String ecod = urlConnection.getContentEncoding();   
            if (ecod == null){
                ecod = Charset.defaultCharset().name(); 
            }
            httpResponser.setCode(urlConnection.getResponseCode());   
            httpResponser.setMessage(urlConnection.getResponseMessage());
            //记录成功接受请求的当前时间
            handOverTime = new Date();
            httpResponser.setSendTime(sendTime);
            httpResponser.setHandOverTime(handOverTime);
            httpResponser.setUrlTimeOut(handOverTime.getTime()-sendTime.getTime());
            return httpResponser;   
        } catch (IOException e) {
        	httpResponser.setConnectTimeout(urlConnection.getConnectTimeout());
        	httpResponser.setMessage("连接超时");
        	httpResponser.setUrlTimeOut(0L);
            httpResponser.setSendTime(sendTime);
            httpResponser.setHandOverTime(handOverTime);
        	httpResponser.setCode(400);
    		return httpResponser;   
        } finally {   
            if (urlConnection != null)   
                urlConnection.disconnect();   
        }   
    }   
    
    /**  
     * 默认的响应字符集  
     */  
    public String getDefaultContentEncoding() {   
        return defaultContentEncoding;   
    }   
    
    /**  
     * 设置默认的响应字符集  
     */  
    public void setDefaultContentEncoding(String dce) {   
        defaultContentEncoding = dce;   
    }   
} 
