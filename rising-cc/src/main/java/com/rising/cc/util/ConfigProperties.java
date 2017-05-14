package com.rising.cc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {

	private Properties properties = null;
	private final String PROP_PATH = "/config.properties";
	private static ConfigProperties configProperties;

	public static ConfigProperties getInstance() {
		if (configProperties == null) {
			synchronized (ConfigProperties.class) {
				if (configProperties == null){
					configProperties = new ConfigProperties();					
				}
			}
		}
		return configProperties;
	}

	private ConfigProperties() {
		init();
	}

	private void init() {
		try {
			InputStream inputStream = getInputStream();
			properties = new Properties();
			properties.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}

	public Properties getProp(String path) {
		Properties props = new Properties();
		InputStream in = null;
		try {
			// 讲文件信息读取到输出流
			in = ConfigProperties.class.getResourceAsStream(path);
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

	private InputStream getInputStream() {
		return ConfigProperties.class.getResourceAsStream(PROP_PATH);
	}

	public String get(String key) {
		return properties.getProperty(key);
	}

}
