package com.rising.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @description: Properties文件操作工具类
 * @company: 碧海银帆
 * @author caoy
 * @date 2015年6月2日上午10:21:30
 */
public class PropertiesUtils {

	/**
	 * 获取当前path指定的properties对象
	 * @description: 
	 * @date 2015年6月2日上午10:21:01
	 * @param path
	 * @return
	 */
	public static Properties getProps(String path) {
		Properties props = new Properties();
		InputStream in = null;
		try {
			in = PropertiesUtils.class.getResourceAsStream(path);
			props.load(in);
			return props;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null){
					in.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return props;
	}
}
