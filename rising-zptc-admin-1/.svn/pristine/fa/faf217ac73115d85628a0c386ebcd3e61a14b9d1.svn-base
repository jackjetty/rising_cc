package com.bhyf.controller.vip;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bhyf.pojo.vip.UserInfo;
import com.bhyf.service.interf.vip.UserInfoService;

@Controller("userInfoAction")
@RequestMapping("/userInfo")
public class UserInfoAction {

	@Autowired
	UserInfoService userInfoService;
	
	@RequestMapping("/doUserInfo")
	public ModelAndView doUserInfo(){
		ModelAndView view = new ModelAndView("/vip/doUserInfo.html");
		return view;
	}
	
	
	@RequestMapping("/editUserInfo")
	public @ResponseBody
	HashMap<String, Object> editUserInfo(UserInfo userInfo) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try{
			resultMap = userInfoService.editUserInfo(userInfo);
		}catch(Exception e){
			e.printStackTrace();
			resultMap.put("respCode", -1);
			resultMap.put("respInfo", "编辑失败！");
		}
		return resultMap;
	}
	
	@RequestMapping("/findUserInfoById")
	public @ResponseBody
	UserInfo findUserInfoById(Integer id) {
		return userInfoService.findUserInfoById(id);
	}
	
	@RequestMapping("/resetPwd")
	public @ResponseBody
	HashMap<String, Object> resetPwd(String id) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try{
			resultMap = userInfoService.resetUserPwd(id);
		}catch(Exception e){
			e.printStackTrace();
			resultMap.put("respCode", -1);
			resultMap.put("respInfo", "密码初始化失败！");
		}
		return resultMap;
	}
	
	@RequestMapping("/getUserInfoList")
	public @ResponseBody
	HashMap<String, Object> getUserInfoList(String mobile, String userName, String startTime, String endTime, String userType, String jobNo,
			Integer pageSize, Integer pageIndex) {
		HashMap<String, Object> resultMap = userInfoService.getUserInfoList(mobile, userName, startTime, endTime, userType, jobNo, pageSize, pageIndex);
		return resultMap;
	}
	
	@RequestMapping("/exportDaInfo")
	public void exportDaInfo(String mobile, String userName, String startTime, String endTime, String userType, String jobNo, HttpServletResponse response){
		userInfoService.exportData(mobile, userName, startTime, endTime, userType, jobNo, response);
    }
}
