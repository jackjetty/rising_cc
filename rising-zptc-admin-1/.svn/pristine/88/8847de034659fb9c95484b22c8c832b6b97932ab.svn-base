package com.bhyf.service.interf.vip;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import com.bhyf.pojo.vip.UserInfo;

/**
 * 
 * @description 用户管理Service
 * @author ruanmh
 * @date 2016年4月13日
 *
 */
public interface UserInfoService {
	
	/**
	 * 
	 * @description 查询列表
	 * @author ruanmh
	 * @date 2016年4月13日
	 * @param userInfo
	 * @return
	 */
	public HashMap<String, Object> getUserInfoList(String mobile, String userName,
			String startTime, String endTime, String userType, String jobNo, Integer pageSize, Integer pageIndex);
	
	/**
	 * 
	 * @description 更新User
	 * @author ruanmh
	 * @date 2016年4月13日
	 * @param userInfo
	 * @return
	 */
	public HashMap<String, Object> editUserInfo(UserInfo userInfo);
	
	/**
	 * 
	 * @description 查询User
	 * @author ruanmh
	 * @date 2016年4月13日
	 * @param userInfo
	 * @return
	 */
	public UserInfo findUserInfoById(Integer id);
	
	/**
	 * 
	 * @description 重置User密码
	 * @author ruanmh
	 * @date 2016年4月13日
	 * @param userInfo
	 * @return
	 */
	public HashMap<String, Object> resetUserPwd(String id);
	
	/**
	 * 
	 * @description 导出数据
	 * @author ruanmh
	 * @date 2016年4月13日
	 * @param userInfo
	 * @return
	 */
	public HashMap<String, Object> exportData(String mobile, String userName,
			String startTime, String endTime, String userType, String jobNo, HttpServletResponse response);
	

}
