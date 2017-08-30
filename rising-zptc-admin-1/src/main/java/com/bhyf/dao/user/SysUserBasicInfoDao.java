package com.bhyf.dao.user;

import java.util.List;

import com.bhyf.model.user.SysUserBasicInfo;
import com.bhyf.pojo.dto.user.SysUserBasicInfoDto;
import com.bhyf.pojo.qo.user.UserQo;
import com.rising.common.page.Pagination;

import org.springframework.stereotype.Service;

/**
 * 
 * @description 用户基础信息接口Dao
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午3:59:40
 *
 */
@Service
public interface SysUserBasicInfoDao {

	/**
	 * 
	 * @description 新增用户基本信息
	 * @author caoy
	 * @date 2015年8月3日 下午4:00:05
	 * @param userBasicInfo
	 * @return
	 */
	public Integer saveSysUserBasicInfo(SysUserBasicInfo userBasicInfo);
	
	/**
	 * 
	 * @description 更新用户基本信息
	 * @author caoy
	 * @date 2015年8月3日 下午4:00:05
	 * @param userBasicInfo
	 * @return
	 */
	public Integer updateSysUserBasicInfoByUserId(SysUserBasicInfo userBasicInfo);
	
	/**
	 * 
	 * @description 分页查询用户列表
	 * @author caoy
	 * @date 2015年8月11日 上午10:55:05
	 * @param pagination
	 * @return
	 */
	public List<SysUserBasicInfo> findUserInfoListByPagination(Pagination pagination);
	
	/**
	 * 
	 * @description 分页统计用户
	 * @author caoy
	 * @date 2015年8月11日 上午10:55:05
	 * @param pagination
	 * @return
	 */
	public Integer countUserInfoListByPagination(Pagination pagination);
	
	/**
	 * 
	 * @description 根据用户登录名，返回用户所有信息
	 * @author caoy
	 * @date 2015年9月11日 下午5:11:36
	 * @param userName
	 * @return
	 */
	public SysUserBasicInfo findSysUserBasicInfoByUserQo(UserQo qo);
	
}
