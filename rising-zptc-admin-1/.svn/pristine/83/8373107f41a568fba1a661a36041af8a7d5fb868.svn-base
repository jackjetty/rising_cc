package com.bhyf.service.interf.vip;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import com.bhyf.pojo.vip.Suggest;

/**
 * 
 * @description 用户管理Service
 * @author ruanmh
 * @date 2016年4月13日
 *
 */
public interface SuggestService {
	
	/**
	 * 
	 * @description 查询列表
	 * @author ruanmh
	 * @date 2016年4月13日
	 * @param userInfo
	 * @return
	 */
	public HashMap<String, Object> getSuggestList(String contactWay, String userName,
			String startTime, String endTime, Integer pageSize, Integer pageIndex);
	
	/**
	 * 
	 * @description 查询数据
	 * @author ruanmh
	 * @date 2016年4月13日
	 * @param userInfo
	 * @return
	 */
	public Suggest findSuggestById(Integer id);
	
	
	/**
	 * 
	 * @description 导出数据
	 * @author ruanmh
	 * @date 2016年4月13日
	 * @param userInfo
	 * @return
	 */
	public HashMap<String, Object> exportData(String contactWay, String userName,
			String startTime, String endTime, HttpServletResponse response);
	

}
