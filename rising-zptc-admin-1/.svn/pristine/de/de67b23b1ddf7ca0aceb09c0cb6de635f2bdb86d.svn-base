package com.bhyf.controller.app;

import java.util.HashMap;
import java.util.List;

import com.bhyf.pojo.command.app.CreateAppVersionCommand;
import com.bhyf.pojo.command.app.UpdateAppVersionCommand;
import org.apache.ibatis.annotations.Update;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.bhyf.model.user.SysUser;
import com.bhyf.pojo.constants.user.LoginConstants;
import com.bhyf.service.interf.app.AppVersionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @description
 * @author pl
 * @createTime 2016年4月14日
 */
@Controller("appVersionAction")
@RequestMapping("/appVersion")
public class AppVersionAction {

	@Autowired
	AppVersionService appVersionService;
	
	@RequestMapping("/doAppVersion")
	public ModelAndView doAppVersion(){
		return new ModelAndView("/app/app_version.html");
	}
	
	@RequestMapping("/getAppVersionList")
	public @ResponseBody
	HashMap<String,Object> getAppVersionList(Integer pageIndex, Integer pageSize, String versionName,
			String category, String status){
		return appVersionService.getAppVersionList(pageIndex,pageSize,versionName,category,status);
	}
	
	@RequestMapping("/addAppVersion")
	public @ResponseBody
	HashMap<String,Object> addAppVersion(
			@ModelAttribute CreateAppVersionCommand command
			){

		return appVersionService.saveAppVersion(command);
	}
	
	@RequestMapping("/updateAppVersion")
	public @ResponseBody
	HashMap<String,Object> updateAppVersion(HttpServletRequest request,
											HttpServletResponse response,
			@ModelAttribute UpdateAppVersionCommand command
			){
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest) request;
		// 上传文件 name默认 uploadFile
		List<MultipartFile> uploadFiles = multi.getFiles("app");
		if(uploadFiles != null && uploadFiles.size()>0){
			return appVersionService.updateAppVersion(command,uploadFiles.get(0));
		}else{
			return appVersionService.updateAppVersion(command,null);
		}
	}

	@RequestMapping("/deleteAppversionsByIds")
	public @ResponseBody
	HashMap<String,Object> deleteAppversionsByIds(String ids){
		return appVersionService.deleteAppversionsByIds(ids);
	}
	
}
