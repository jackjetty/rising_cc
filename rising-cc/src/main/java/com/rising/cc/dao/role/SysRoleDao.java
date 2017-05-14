package com.rising.cc.dao.role;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rising.common.page.Pagination;
import com.rising.cc.model.role.SysRole;
import com.rising.cc.model.role.SysRolePermission;
import com.rising.cc.pojo.qo.role.RoleQo;

/**
 * 
 * @description 系统角色接口Dao
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午4:36:33
 *
 */
public interface SysRoleDao {
	
	public List<SysRole> findAllSysRoleByUserName(String userName);
	
	/**
	 * 
	 * @description 分页查询角色列表
	 * @author caoy
	 * @date 2015年8月21日 上午9:05:17
	 * @param pagination
	 * @return
	 */
	public List<SysRole> findRoleListByPagination(Pagination pagination);
	
	/**
	 * 
	 * @description 分页统计角色
	 * @author caoy
	 * @date 2015年8月21日 上午9:05:23
	 * @param pagination
	 * @return
	 */
	public Integer countRoleListByPagination(Pagination pagination);
	
	/**
	 * 
	 * @description 根据角色ID，删除角色权限数据
	 * @author caoy
	 * @date 2015年8月25日 下午3:46:13
	 * @param roleId
	 * @return
	 */
	public Integer deleteOldRolePermByRoleId(@Param("roleId")Integer roleId);
	
	/**
	 * 
	 * @description 批量更新角色权限关系
	 * @author caoy
	 * @date 2015年8月25日 下午3:55:02
	 * @param list
	 * @return
	 */
	public Integer insertBatchRolePerm(List<SysRolePermission> list);
	
	/**
	 * 
	 * @description 根据用户ID返回用户角色
	 * @author caoy
	 * @date 2015年8月26日 下午1:43:49
	 * @param userId
	 * @return
	 */
	public List<SysRole> findUserRoleListByUserId(Integer userId) ;
	
	/**
	 * 
	 * @description 根据Qo返回想要角色List
	 * @author caoy
	 * @date 2015年9月1日 上午11:05:24
	 * @param qo
	 * @return
	 */
	public List<SysRole> findRoleListByQo(RoleQo qo);
	
	/**
	 * 
	 * @description 创建角色
	 * @author caoy
	 * @date 2015年8月26日 下午4:31:03
	 * @param role
	 * @return
	 */
	public Integer insertSysRole(SysRole role);
	
	/**
	 * 
	 * @description 修改角色
	 * @author caoy
	 * @date 2015年8月26日 下午4:31:12
	 * @param role
	 * @return
	 */
	public Integer updateSysRoleById(SysRole role);
	
	/**
	 * 
	 * @description 根据Ids修改status
	 * @author caoy
	 * @date 2015年8月26日 下午4:41:25
	 * @param status
	 * @param ids
	 * @return
	 */
	public Integer updateSysRoleStatusByIds(@Param("status") Integer status, @Param("ids")List<Integer> ids);
}
