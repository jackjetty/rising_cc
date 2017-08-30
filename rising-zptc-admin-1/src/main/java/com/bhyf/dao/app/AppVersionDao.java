package com.bhyf.dao.app;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.bhyf.pojo.app.AppVersion;

/**
 * 
 * @description
 * @author pl
 * @createTime 2016年4月14日
 */
@Service
public interface AppVersionDao {
	
	/**
	 * 
	 * @description 获取版本列表
	 * @param paramMap
	 * @return
	 */
	public ArrayList<AppVersion> getAppVersionList(HashMap<String,Object> paramMap);
	
	/**
	 * @description 获取版本列表总数
	 * @param paramMap
	 * @return
	 */
	public Integer getAppVersionListSize(HashMap<String,Object> paramMap);
	
	/**
	 * @description 添加版本信息
	 * @param app
	 * @return
	 */
	public Integer addAppVersion(AppVersion app);
	
	/**
	 * @description 检查版本是否重复
	 * @param paramMap
	 * @return
	 */
	public AppVersion findAppVersionCheck(HashMap<String,Object> paramMap);
	
	/**
	 * @description 更新版本
	 * @param app
	 */
	public Integer updateAppVersion(AppVersion app);
	
	/**
	 * @description 根据Id查询版本
	 * @param id
	 * @return
	 */
	public AppVersion findAppVersionById(Integer id);
	
	/**
	 * @description 根据Ids删除版本
	 * @param ids
	 * @return
	 */
	public Integer deleteAppVersionByIds(ArrayList<Integer> ids);
	
}
