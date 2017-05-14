package com.rising.common.component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.helpers.Loader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.alibaba.fastjson.JSON;
import com.rising.common.model.HttpResponse;
import com.rising.common.util.HttpUtil;
import com.rising.common.util.Md5Util;
import com.rising.common.util.PathUtil;

/**
 * 
 * @description 
 * @company 碧海银帆
 * @date 2015年9月2日 上午8:57:14
 *
 */
public class RemotePropertyConfigurer extends PropertyPlaceholderConfigurer {

	public static final Logger log = LoggerFactory.getLogger(RemotePropertyConfigurer.class);

	public static final String CACHE_PATH_DEFAULT = "remote-config.json";
	public static final String CACHE_PROPERTIES_DEFAULT = "remote-config.properties";
	public static final String CACHE_TEXT_ENCODING = "UTF-8";
	
	private static final String REMOTE_MD5_KEY ="0685b2c1df4f7cbef39d74e473cce6e5";
	
	/**
	 * 远程配置URL
	 */
	private String remoteUrl;
	/**
	 * 项目Code
	 */
	private String projectCode;
	/**
	 * 工程Code
	 */
	private String enginCode;
	/**
	 * 环境名称
	 */
	private String envirCode;
	
	/**
	 * 缓存配置的文件路径
	 * 默认使用classpath:remote-config.json
	 */
	private String cachePath;
	
	/**
	 * 缓存属性的文件路径
	 * 默认使用classpath:remote-config.properties
	 */
	private String cachePropertiesPath;
	
	/**
	 * 远程配置读取超时事件(毫秒)
	 */
	private int loadConfigTimeOut = 30 * 1000;
	
	private ConfigurerListener listener;

	

	/**
	 * 获得缓存文件
	 * 
	 * @return
	 */
	public File getCacheFile() {
		File file = null;
		if (StringUtils.isNotBlank(cachePath))
			file = getFile(cachePath, false);
		else
			file = getFile(CACHE_PATH_DEFAULT, false);
		cachePath = file.getPath();
		return file;
	}
	
	/**
	 * 获得属性文件
	 * 
	 * @return
	 */
	public File getPropertiesFile() {
		File file = null;
		if (StringUtils.isNotBlank(cachePropertiesPath))
			file = getFile(cachePropertiesPath, false);
		else
			file = getFile(CACHE_PROPERTIES_DEFAULT, false);
		cachePropertiesPath = file.getPath();
		return file;
	}
	
	/**
	 * 获得缓存文件
	 * 
	 * @param path			路径
	 * @param abs			是否绝对路径
	 * @return
	 */
	public File getFile(String path, boolean abs) {
		String filePath = null;
		if (abs)
			filePath = path;
		else
			filePath = PathUtil.getClassPath() + path;
		File file = new File(filePath);
		if (file.getParentFile() != null && !file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		return file;
	}
	
	/**
	 * 将文本覆盖写入到cache文件中
	 * 
	 * @param text
	 * @return
	 * @throws IOException 
	 */
	public File writeCacheFile(String text) throws IOException {
		File file = getCacheFile();
		FileOutputStream fos = new FileOutputStream(file);
		try {
			IOUtils.write(text == null ? "" : text, fos, CACHE_TEXT_ENCODING);
			log.info("{}已缓存到->\"{}\"。", text, cachePath);
		} finally {
			fos.close();
		}
		return file;
	}

	/**
	 * 将文本覆盖写入到cache文件中
	 * 
	 * @param text
	 * @return
	 * @throws IOException 
	 */
	public File writeCacheProperties(Map<String, String> configMap)
			throws IOException {
		File file = getPropertiesFile();
		Properties properties = new Properties();
		FileOutputStream fos = new FileOutputStream(file);
		try {
			for (Entry<String, String> entry : configMap.entrySet())
				properties.setProperty(entry.getKey(), entry.getValue());
			properties.store(fos, "缓存属性");
			log.info("属性文件已缓存到->\"{}\"。", cachePropertiesPath);
		} finally {
			fos.close();
		}
		return file;
	}
	
	
	/**
	 * 获取缓存配置的文本
	 * 
	 * @return
	 */
	public String getCacheFileText() {
		log.info("从\"{}\"读取缓存配置。", cachePath);
		String text = null;
		try {
			FileInputStream fis = new FileInputStream(getCacheFile());
			try {
				text = IOUtils.toString(fis, CACHE_TEXT_ENCODING);
			} finally {
				fis.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return text;
	}
	
	/**
	 * 获取远程配置JSON
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	protected String getRemoteConfigJson() throws UnsupportedEncodingException {
		StringBuffer paramSb = new StringBuffer();
		paramSb.append("projectCode=");
		paramSb.append(URLEncoder.encode(projectCode, "UTF-8"));
		paramSb.append("&enginCode=");
		paramSb.append(URLEncoder.encode(enginCode, "UTF-8"));
		paramSb.append("&envirCode=");
		paramSb.append(URLEncoder.encode(envirCode, "UTF-8"));
		paramSb.append("&key=");
		paramSb.append(REMOTE_MD5_KEY);
		String sign = Md5Util.MD5(paramSb.toString());
		
		paramSb.append("&sign=");
		paramSb.append(URLEncoder.encode(sign, "UTF-8"));
		
		
		
		log.info("开始从{}加载远程配置，参数：{}。", remoteUrl, paramSb);
		
		HttpResponse response = HttpUtil.executeGetMethod(remoteUrl, paramSb.toString(),loadConfigTimeOut);
		
		return response.getResult();
	}
	
	/**
	 * 加载缓存配置
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Map<String, Object> loadCacheConfig() {
		String json = getCacheFileText();
		log.info("读取本地缓存JSON：{}。", json);
		return JSON.parseObject(json, Map.class);
	}
	
	/**
	 * 加载远程配置
	 * 
	 * @return
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	protected Map<String, Object> loadRemoteConfig() throws IOException {
		String json = getRemoteConfigJson();
		log.info("返回JSON：{}。", json);
		Map<String, Object> configMap = JSON.parseObject(json, Map.class);
		log.info("将返回的JSON写入缓存。");
		try {
			writeCacheFile(json);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("配置缓存写入异常，消息{}。", e.getMessage());
		}
		return configMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) 
			throws BeansException {
		Map<String, Object> map = null;
		try {
			map = loadRemoteConfig();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("远程配置加载失败，消息：{}。", e.getMessage());
			log.info("开始尝试从本地读取缓存配置。");
			try {
				map = loadCacheConfig();
			} catch (Exception e2) {
				log.error("缓存配置加载失败，消息：{}。", e2.getMessage());
			}
		}
		if (map != null) {
			// 属性
			Map<String, String> configMap = (Map<String, String>) map.get("properties");
			for (Entry<String, String> entry : configMap.entrySet()) {
				log.debug("set {} = {}", entry.getKey(), entry.getValue());
				props.setProperty(entry.getKey(), entry.getValue());
			}
			// 缓存属性文件
			try {
				writeCacheProperties(configMap);
			} catch (Exception e) {
				e.printStackTrace();
				log.error("缓存属性文件失败");
			}
			// 属性文件
			List<Map<String, String>> configList = (List<Map<String, String>>) map.get("propertyFiles");
			String logFileName = "";
			for (Map<String, String> cmap : configList) {
				if(cmap != null){
					String fileName = cmap.get("fileName");
					
					if (fileName.endsWith("log4j.properties")) {
						logFileName = fileName;
					}
					
					fileName = PathUtil.getClassPath() + fileName;
					String encoding = cmap.get("encoding");
					String content = cmap.get("content");
					File file = new File(fileName);
					if (!file.getParentFile().exists()) {
						file.getParentFile().mkdirs();
					}
					try {
						IOUtils.write(content, new FileOutputStream(file), encoding);
						log.debug("写入配置文件成功->{}", file.getPath());
					} catch (Exception e) {
						e.printStackTrace();
						log.error("写入配置文件遇到错误");
					}
					
				}
			}
			// 常用属性
			try {
				props.setProperty("local_ip", InetAddress.getLocalHost().getHostAddress());
			} catch (UnknownHostException e) {
				props.setProperty("local_ip", "0.0.0.0");
				e.printStackTrace();
				log.error("获取本地IP失败");
			}
			
			if (StringUtils.isNotBlank(logFileName)) {// 配置加载完毕，重新加载log4j配置
				URL url = Loader.getResource(logFileName);
				log.info("覆盖并重新加载log4j配置：{}",url);
				if (url != null) {
					PropertyConfigurator.configure(url);
				}
			}
			if (listener != null) {// 配置加载完毕，触发监听接口
				listener.configLoadOver();
			}
		} else {
			log.warn("未读取到任何配置！");
		}
		super.processProperties(beanFactoryToProcess, props);
	}


	public String getCachePath() {
		return cachePath;
	}

	public void setCachePath(String cachePath) {
		this.cachePath = cachePath;
	}

	public int getLoadConfigTimeOut() {
		return loadConfigTimeOut;
	}

	public void setLoadConfigTimeOut(int loadConfigTimeOut) {
		this.loadConfigTimeOut = loadConfigTimeOut;
	}


	public String getRemoteUrl() {
		return remoteUrl;
	}

	public void setRemoteUrl(String remoteUrl) {
		this.remoteUrl = remoteUrl;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getEnginCode() {
		return enginCode;
	}

	public void setEnginCode(String enginCode) {
		this.enginCode = enginCode;
	}

	public String getEnvirCode() {
		return envirCode;
	}

	public void setEnvirCode(String envirCode) {
		this.envirCode = envirCode;
	}

	public ConfigurerListener getListener() {
		return listener;
	}

	public void setListener(ConfigurerListener listener) {
		this.listener = listener;
	}

	public String getCachePropertiesPath() {
		return cachePropertiesPath;
	}

	public void setCachePropertiesPath(String cachePropertiesPath) {
		this.cachePropertiesPath = cachePropertiesPath;
	}

	
}
