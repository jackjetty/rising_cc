package com.bhyf.dao.vip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bhyf.pojo.vip.UserInfo;

public interface UserInfoDao {

	/**
	 * 
	 * @description 查询列表
	 * @author ruanmh
	 * @date 2016年4月13日
	 * @param user
	 * @return
	 */
	public ArrayList<UserInfo> getUserInfoList(HashMap<String, Object> map);
	
	/**
	 * 
	 * @description 查询列表
	 * @author ruanmh
	 * @date 2016年4月13日
	 * @param user
	 * @return
	 */
	public ArrayList<UserInfo> getUserInfoList1(HashMap<String, Object> map);
	
	/**
	 * 
	 * @description 查询数目
	 * @author ruanmh
	 * @date 2016年4月13日
	 * @param user
	 * @return
	 */
	public Integer getUserInfoCount(HashMap<String, Object> params);
	
	/**
	 * 
	 * @description 更新用户账号
	 * @author ruanmh
	 * @date 2016年4月13日
	 * @param user
	 * @return
	 */
	public Integer updateUserInfoById(UserInfo user);
	
	/**
	 * 
	 * @description 根据用户用户ID返回用户账号信息
	 * @author ruanmh
	 * @date 2016年4月13日
	 * @param user
	 * @return
	 */
	public UserInfo findUserInfoByUserId(Integer userId);
	
	/**
	 * 
	 * @description 批量修改用户密码
	 * @author ruanmh
	 * @date 2016年4月13日
	 * @param list
	 * @return
	 */
	public Integer updateBatchUserPwd(List<UserInfo> list);
}
