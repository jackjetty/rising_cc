package com.bhyf.service.impl.app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import javax.annotation.Resource;

import com.bhyf.pojo.command.app.CreateAppVersionCommand;
import com.bhyf.pojo.command.app.UpdateAppVersionCommand;
import com.rising.common.util.PathUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.bhyf.dao.app.AppVersionDao;
import com.bhyf.pojo.app.AppVersion;
import com.bhyf.service.interf.app.AppVersionService;
import com.bhyf.util.PropertiesUtil;
/**
 * 
 * @description
 * @author pl
 * @createTime 2016年4月14日
 */
@Service("appVersionService")
public class AppVersionServiceImpl implements AppVersionService {
	Log log = LogFactory.getLog(AppVersionServiceImpl.class);
	
	private Properties properties = null;
	

	@Resource
	AppVersionDao appVersionDao;
	
	@Override
	@Transactional
	public HashMap<String, Object> getAppVersionList(Integer pageIndex,
			Integer pageSize, String versionName, String category,
			String status) {
		HashMap<String, Object> resultMap = new HashMap<String,Object>();
		HashMap<String, Object> paramMap = new HashMap<String,Object>();
		if(versionName.equals("")){
			versionName = null;
		}
		if(category.equals("")){
			category = null;
		}
		if(status.equals("")){
			status = null;
		}
		paramMap.put("versionName", versionName);
		paramMap.put("category", category);
		paramMap.put("status", status);
		Integer listSize = appVersionDao.getAppVersionListSize(paramMap);
		Integer start = (pageIndex - 1) * pageSize ;
		paramMap.put("start", start);
		paramMap.put("pageSize", pageSize);
		ArrayList<AppVersion> apps = appVersionDao.getAppVersionList(paramMap);
		resultMap.put("listSize", listSize);
		resultMap.put("rows", apps);
		return resultMap;
	}

	@Override
	@Transactional
	public HashMap<String, Object> deleteAppversionsByIds(String ids) {
		HashMap<String, Object> resultMap = new HashMap<String,Object>();
		String[] id = ids.split(",");
		ArrayList<Integer> appIds = new ArrayList<Integer>();
		for(int i = 0 ;i<id.length; i++){
			appIds.add(Integer.parseInt(id[i]));
		}
		try{
			Integer count = appVersionDao.deleteAppVersionByIds(appIds);
			resultMap.put("backCode", true);
			resultMap.put("success", "删除成功"+count+"条数据");
		}catch(Exception e){
			resultMap.put("backCode", false);
			resultMap.put("error", "删除失败");
		}
		return resultMap;
	}

	@Override
	@Transactional
	public HashMap<String, Object> saveAppVersion(CreateAppVersionCommand command) {
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		HashMap<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("versionNo", command.getVersionNo());
		paramMap.put("category", command.getCategory());
		AppVersion oldApp = appVersionDao.findAppVersionCheck(paramMap);
		if(oldApp == null){
			properties = PropertiesUtil.getProp("/properties/other.properties");
			String path = properties.getProperty("app_file_path");
			MultipartFile app = command.getApp();
			String versionName = app.getOriginalFilename();
			String name = versionName.substring(0,versionName.indexOf("."));
			String appName =name+ versionName.replace(name,String.valueOf(System.currentTimeMillis()));
			String appAddress = PathUtil.getRootPath() + "resources/app/";
			File appFile = new File(appAddress+appName);
			File appFoldFile = new File(appAddress);
			if(!appFoldFile.exists()){
				appFoldFile.mkdirs();
			}
			if(appFile.exists()){
				appName = versionName+String.valueOf(System.currentTimeMillis());
				appAddress = appAddress + "/" +appName;
				appFile = new File(appAddress);
			}
			try {
				app.transferTo(appFile);
			} catch (IllegalStateException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			AppVersion curApp = new AppVersion();
			curApp.create(command,path+appName);
			try{
				appVersionDao.addAppVersion(curApp);
				resultMap.put("backCode", true);
				resultMap.put("success", "添加成功");
			}catch(Exception e){
				resultMap.put("backCode", false);
				resultMap.put("error", "添加失败");
			}
		}else{
			resultMap.put("backCode", false);
			resultMap.put("error", "版本号重复");
		}
		return resultMap;
	}

	@Override
	public HashMap<String, Object> updateAppVersion(UpdateAppVersionCommand command, MultipartFile app) {
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		AppVersion curApp = new AppVersion();
		if(app != null){
			properties = PropertiesUtil.getProp("/properties/other.properties");
			String path = properties.getProperty("app_file_path");
			String versionName = app.getOriginalFilename();
			String name = versionName.substring(0,versionName.indexOf("."));
			String appName =name+ versionName.replace(name,String.valueOf(System.currentTimeMillis()));
			String appAddress = PathUtil.getRootPath() + "resources/app/";
			File appFile = new File(appAddress+appName);
			File appFoldFile = new File(appAddress);
			if(!appFoldFile.exists()){
				appFoldFile.mkdirs();
			}
			if(appFile.exists()){
				appName = versionName+String.valueOf(System.currentTimeMillis());
				appAddress = appAddress + File.separator +appName;
				appFile = new File(appAddress);
			}
			try {
				app.transferTo(appFile);
			} catch (IllegalStateException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			curApp.update(command,path+appName);
			try{
				appVersionDao.updateAppVersion(curApp);
				resultMap.put("backCode", true);
				resultMap.put("success", "添加成功");
			}catch(Exception e){
				resultMap.put("backCode", false);
				resultMap.put("error", "添加失败");
			}
		}else{
			curApp.update(command);
			try{
				appVersionDao.updateAppVersion(curApp);
				resultMap.put("backCode", true);
				resultMap.put("success", "添加成功");
			}catch(Exception e){
				resultMap.put("backCode", false);
				resultMap.put("error", "添加失败");
			}
		}
		return resultMap;
	}

}
