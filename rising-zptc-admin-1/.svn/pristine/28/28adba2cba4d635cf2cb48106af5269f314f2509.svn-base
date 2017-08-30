package com.bhyf.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bhyf.model.user.SysUser;
import com.bhyf.model.user.SysUserRole;

/**
 * 
 * @description 用户账号接口Dao
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午3:59:20
 *
 */
public interface SysUserDao {
	
	/**
	 * 
	 * @description 新增用户账号
	 * @author caoy
	 * @date 2015年8月3日 下午4:00:27
	 * @param user
	 * @return
	 */
	public Integer saveSysUser(SysUser user);
	
	/**
	 * 
	 * @description 更新用户账号
	 * @author caoy
	 * @date 2015年8月3日 下午4:00:27
	 * @param user
	 * @return
	 */
	public Integer updateSysUserById(SysUser user);
	
	/**
	 * 
	 * @description 批量更新账户状态
	 * @author caoy
	 * @date 2015年8月13日 上午11:13:45
	 * @param status
	 * @param ids
	 * @return
	 */
	public Integer updateSysUserStatusByIds(@Param("status")Integer status,@Param("ids")List<Integer> ids);
	
	/**
	 * 
	 * @description 根据用户登录名返回用户账号信息
	 * @author caoy
	 * @date 2015年8月3日 下午4:2:27
	 * @param user
	 * @return
	 */
	public SysUser findSysUserByUserName(String userName);
	
	/**
	 * 
	 * @description 根据用户用户ID返回用户账号信息
	 * @author caoy
	 * @date 2015年8月3日 下午4:2:27
	 * @param user
	 * @return
	 */
	public SysUser findSysUserByUserId(Integer userId);
	
	/**
	 * 
	 * @description 根据用户ID，删除用户角色数据
	 * @author caoy
	 * @date 2015年8月25日 下午3:46:13
	 * @param roleId
	 * @return
	 */
	public Integer deleteOldUserRoleByUserId(@Param("userId")Integer userId);
	
	/**
	 * 
	 * @description 批量更新用户角色关系
	 * @author caoy
	 * @date 2015年8月25日 下午3:55:02
	 * @param list
	 * @return
	 */
	public Integer insertBatchUserRole(List<SysUserRole> list);
	
	/**
	 * 
	 * @description 批量修改用户密码
	 * @author caoy
	 * @date 2015年9月29日 下午2:07:05
	 * @param list
	 * @return
	 */
	public Integer updateBatchUserPwd(List<SysUser> list);
	
}
