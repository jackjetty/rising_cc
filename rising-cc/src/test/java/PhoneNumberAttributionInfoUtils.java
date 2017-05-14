

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.swing.JEditorPane;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @description:号码归属地信息工具类
 * @company: 碧海银帆
 * @author caoy
 * @date 2015年7月6日上午10:35:18
 */
public class PhoneNumberAttributionInfoUtils {
	
    
	/**
	 * 
	 * @description: 根据财付通获取号码归属地信息
	 * @author caoy
	 * @date 2015年7月6日上午11:27:32
	 * @param cache
	 * @return
	 */
    public static Map<String,String> getPhoneNumberAttributionInfoByTenpay(String mobile) {
		if(StringUtils.isNotBlank(mobile)){
			mobile = mobile.trim();
			
			String getUrl = "http://life.tenpay.com/cgi-bin/mobile/MobileQueryAttribution.cgi?chgmobile="+mobile;
			/*<?xml version="1.0" encoding="gb2312" ?>
			<root>
			<ENV_CgiName>/cgi-bin/mobile/MobileQueryAttribution.cgi</ENV_CgiName>
			<ENV_ClientAgent>Jakarta Commons-HttpClient/3.1</ENV_ClientAgent>
			<ENV_ClientIp>125.119.240.148</ENV_ClientIp>
			<ENV_QueryString>chgmobile=18608672404</ENV_QueryString>
			<ENV_RequestMethod>GET</ENV_RequestMethod>
			<ENV_referer></ENV_referer>
			<chgmobile>18608672404</chgmobile>
			<city>襄樊 </city>
			<province>湖北 </province>
			<retcode>0</retcode>
			<retmsg>OK</retmsg>
			<supplier>联通 </supplier>
			<tid></tid>
			</root>*/
			Integer timeOut = 5000;
			
			HttpClient httpclient = new HttpClient();
			GetMethod method = new GetMethod(getUrl);
			try {
				
				
				HttpClientParams params = new HttpClientParams();
				params.setContentCharset("gb2312");
				params.setConnectionManagerTimeout(timeOut);
				params.setSoTimeout(timeOut);
				httpclient.setParams(params);
				method.setRequestHeader("Connection", "close");
				
				httpclient.executeMethod(method);
				
				String xmlText = method.getResponseBodyAsString();
				
				Document doc = DocumentHelper.parseText(xmlText);
				
				Element rootElement = doc.getRootElement();
				
				String resultCode = rootElement.element("retmsg").getTextTrim();
				
				if(resultCode.equals("OK")){
					Map<String, String> map = new HashMap<>();
					map.put("mobile", mobile);
					map.put("province", rootElement.element("province").getTextTrim());
					map.put("city", rootElement.element("city").getTextTrim());
					map.put("supplier", supplierStringConverter(rootElement.element("supplier").getTextTrim()));
					
					return map;
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				method.releaseConnection();
			}
		}
    	return null;
    }
    
    
    /**
     * 
     * @description 根据百度Api获取号码归属地信息
     * @author caoy
     * @date 2015年11月4日 下午3:21:41
     * @param mobile
     * @return
     */
    public static Map<String,String> getPhoneNumberAttributionInfoByBaidu(String mobile) {
    	if(StringUtils.isNotBlank(mobile)){
    		mobile = mobile.trim();
    		
    		String getUrl = "http://apis.baidu.com/apistore/mobilephoneservice/mobilephone?tel="+mobile;
			//{"errNum":0,"retData":{"city":"襄樊","phone":"18608672404","prefix":"1860867","province":"湖北","suit":"186卡","supplier":"联通"},"retMsg":"success"}

    		Integer timeOut = 5000;
    		
    		HttpClient httpclient = new HttpClient();
    		GetMethod method = new GetMethod(getUrl);
    		try {
    			
    			
    			HttpClientParams params = new HttpClientParams();
    			params.setContentCharset("utf-8");
    			params.setConnectionManagerTimeout(timeOut);
    			params.setSoTimeout(timeOut);
    			httpclient.setParams(params);
    			method.setRequestHeader("Connection", "close");
    			method.setRequestHeader("Content-Type", "text/html;charset=utf-8");
    			method.setRequestHeader("apikey","3d8f7364e699da7e5b75a7b73a0260cb");// 百度ApiStore cybestyou   的  apiKey
    			
    			httpclient.executeMethod(method);
    			
    			String jsonText = method.getResponseBodyAsString();
    			
    			JSONObject jsonObject = JSON.parseObject(jsonText);
    			JSONObject dataObject = jsonObject.getJSONObject("retData");
    			
    			String resultCode = jsonObject.getString("errNum");
    			
//    			System.out.println(jsonObject.toJSONString());
    			if(resultCode.equals("0")){
    				Map<String, String> map = new HashMap<>();
    				map.put("mobile", mobile);
    				map.put("province", dataObject.getString("province"));
    				map.put("city", dataObject.getString("city"));
    				map.put("supplier", supplierStringConverter(dataObject.getString("supplier")));
    				
    				return map;
    			}
    			
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} finally{
    			method.releaseConnection();
    		}
    	}
    	return null;
    }
    
    
    /**
     * 
     * @description 根据淘宝Api获取号码归属地信息
     * @author caoy
     * @date 2015年11月4日 下午3:21:41
     * @param mobile
     * @return
     * 
     */
    public static Map<String,String> getPhoneNumberAttributionInfoByTaobao(String mobile) {
    	if(StringUtils.isNotBlank(mobile)){
    		mobile = mobile.trim();
    		
    		String getUrl = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel="+mobile;
    		/*	
			__GetZoneResult_ = {
			    mts:'1860867',
			    province:'湖北',
			    catName:'中国联通',
			    telString:'18608672404',
				areaVid:'30513',
				ispVid:'137815084',
				carrier:'湖北联通'
			}
    		 * 
    		 * */
    		
    		Integer timeOut = 5000;
    		
    		HttpClient httpclient = new HttpClient();
    		GetMethod method = new GetMethod(getUrl);
    		try {
    			
    			
    			HttpClientParams params = new HttpClientParams();
    			params.setContentCharset("utf-8");
    			params.setConnectionManagerTimeout(timeOut);
    			params.setSoTimeout(timeOut);
    			httpclient.setParams(params);
    			method.setRequestHeader("Connection", "close");
    			method.setRequestHeader("Content-Type", "text/html;charset=utf-8");
    			
    			httpclient.executeMethod(method);
    			
    			String jsonText = method.getResponseBodyAsString();
    			
    			JSONObject dataObject = JSON.parseObject(jsonText.split("=")[1]);
    			
    			if(dataObject != null){
    				Map<String, String> map = new HashMap<>();
    				map.put("mobile", mobile);
    				map.put("province", dataObject.getString("province"));
//    				map.put("city", dataObject.getString("city"));
    				map.put("supplier", supplierStringConverter(dataObject.getString("carrier")));
    				
    				return map;
    			}
    			
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} finally{
    			method.releaseConnection();
    		}
    	}
    	return null;
    }
    
    
    /**
     * 
     * @description 根据拍拍Api获取号码归属地信息
     * @author caoy
     * @date 2015年11月4日 下午3:21:41
     * @param mobile
     * @return
     * 
     */
    public static Map<String,String> getPhoneNumberAttributionInfoByPaipai(String mobile) {
    	if(StringUtils.isNotBlank(mobile)){
    		mobile = mobile.trim();
    		
    		String getUrl = "http://virtual.paipai.com/extinfo/GetMobileProductInfo?amount=10000&mobile="+mobile;
    		/*
    		 * ({mobile:'18608672404',province:'湖北',isp:'中国联通',stock:'1',amount:'10000',maxprice:'0',minprice:'0',cityname:'襄樊'});
    		 * * */
    		
    		Integer timeOut = 5000;
    		
    		HttpClient httpclient = new HttpClient();
    		GetMethod method = new GetMethod(getUrl);
    		try {
    			
    			
    			HttpClientParams params = new HttpClientParams();
    			params.setContentCharset("utf-8");
    			params.setConnectionManagerTimeout(timeOut);
    			params.setSoTimeout(timeOut);
    			httpclient.setParams(params);
    			method.setRequestHeader("Connection", "close");
    			method.setRequestHeader("Content-Type", "text/html;charset=utf-8");
    			
    			httpclient.executeMethod(method);
    			
    			String jsonText = method.getResponseBodyAsString();
    			
    			jsonText = jsonText.substring(1, jsonText.length());
    			jsonText = jsonText.substring(0, jsonText.indexOf(");"));
    			JSONObject dataObject = JSON.parseObject(jsonText);
    			
    			if(dataObject != null){
    				Map<String, String> map = new HashMap<>();
    				map.put("mobile", mobile);
    				map.put("province", dataObject.getString("province"));
    				map.put("city", dataObject.getString("cityname"));
    				map.put("supplier", supplierStringConverter(dataObject.getString("isp")));
    				
    				return map;
    			}
    			
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} finally{
    			method.releaseConnection();
    		}
    	}
    	return null;
    }
    
    private static String supplierStringConverter(String supplier){
    	if(StringUtils.isNotBlank(supplier)){
    		supplier = supplier.contains("联通")?"联通":supplier;
    		supplier = supplier.contains("移动")?"移动":supplier;
    		supplier = supplier.contains("电信")?"电信":supplier;
    		
    		return supplier;
    		
    	}
    	return null;
    }
    
    public static void test1(){
    	
    	File file = new File("D://11.xls");
		HSSFWorkbook hssfWorkbook = null;
		
		try {
			OutputStream os = new FileOutputStream("D://22.xls");
			InputStream is = new FileInputStream(file);
			hssfWorkbook = new HSSFWorkbook(is);
			// 循环工作表Sheet
			for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
				HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
				if (hssfSheet == null) {
					continue;
				}
				// 循环行Row
				for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
					HSSFRow hssfRow = hssfSheet.getRow(rowNum);
					// 循环列Cell
					// 0省 1市 2姓名 3号码
					HSSFCell mobile = hssfRow.getCell(1);
					HSSFCell gsd = hssfRow.getCell(2);
					String mobiless = getCellValue(mobile).trim();
					
					Map<String,String> map = null;
					map = PhoneNumberAttributionInfoUtils.getPhoneNumberAttributionInfoByBaidu(mobiless);
					if(map == null || StringUtils.isBlank(map.get("province")) || StringUtils.isBlank(map.get("supplier"))){
						map = PhoneNumberAttributionInfoUtils.getPhoneNumberAttributionInfoByPaipai(mobiless);
					}
					if(map == null || StringUtils.isBlank(map.get("province")) || StringUtils.isBlank(map.get("supplier"))){
						map = PhoneNumberAttributionInfoUtils.getPhoneNumberAttributionInfoByTaobao(mobiless);
					}
					if(map == null || StringUtils.isBlank(map.get("province")) || StringUtils.isBlank(map.get("supplier"))){
						map = PhoneNumberAttributionInfoUtils.getPhoneNumberAttributionInfoByTenpay(mobiless);
					}
					gsd.setCellValue(map.get("province") +" "+map.get("city") );
					
					
				}
				
			
				
				hssfWorkbook.write(os);
				os.flush();
				os.close();
				is.close();
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally {}
    	
    	
    	
    }
    
	 /**
     * 得到Excel表中的值
     * 
     * @param hssfCell
     *            Excel中的每一个格子
     * @return Excel中每一个格子中的值
     */
	 /**
     * 得到Excel表中的值
     * 
     * @param hssfCell
     *            Excel中的每一个格子
     * @return Excel中每一个格子中的值
     */
    private static String getCellValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
	        DecimalFormat df = new DecimalFormat("#");
            return String.valueOf(df.format(hssfCell.getNumericCellValue()));
        } else {
            // 返回字符串类型的值
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
    
    public static void test2(){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			File file = new File("D://1.txt");
			byte [] b = new byte[(int)file.length()];
			
			fis = new FileInputStream(file);
			fis.read(b);
			
			String str = new String(b);
			
			int i = 0;
			StringBuffer sb = new StringBuffer();
			HashSet<String> set = new HashSet<>();
			String strs [] = str.split("\\|");
			for (String s : strs) {
				set.add(s);
			}
			
			for (String st : set) {
				sb.append(st);
				sb.append("|");
			}
			
			System.out.println(set.size());
			File file1 = new File("D://2.txt");
			
			fos = new FileOutputStream(file1);
			fos.write(sb.toString().getBytes());
			System.out.println("======================================================================");
			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
    }
    
    public static void test3(){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			File file = new File("D://2.txt");
			byte [] b = new byte[(int)file.length()];
			
			fis = new FileInputStream(file);
			fis.read(b);
			
			String str = new String(b);
			
			int i = 0;
			StringBuffer sb = new StringBuffer();
			String strs [] = str.split("\\|");
			for (String s : strs) {
				
				Map<String,String> map = null;
				map = PhoneNumberAttributionInfoUtils.getPhoneNumberAttributionInfoByBaidu(s);
				if(map == null || StringUtils.isBlank(map.get("province")) || StringUtils.isBlank(map.get("supplier"))){
					map = PhoneNumberAttributionInfoUtils.getPhoneNumberAttributionInfoByPaipai(s);
				}
				if(map == null || StringUtils.isBlank(map.get("province")) || StringUtils.isBlank(map.get("supplier"))){
					map = PhoneNumberAttributionInfoUtils.getPhoneNumberAttributionInfoByTaobao(s);
				}
				if(map == null || StringUtils.isBlank(map.get("province")) || StringUtils.isBlank(map.get("supplier"))){
					map = PhoneNumberAttributionInfoUtils.getPhoneNumberAttributionInfoByTenpay(s);
				}
			
				
				
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
    }
    
    public static void main(String[] args) {
    	test1();
    }
    
}
