package com.rising.cc.dao.perm;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rising.cc.model.perm.SysPermission;

/**
 * 
 * @description 权限接口Dao
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午4:09:04
 *
 */
public interface SysPermDao {

	
	/**
	 * 
	 * @description 返回所有权限信息
	 * @author caoy
	 * @date 2015年8月3日 下午4:00:05
	 * @param userBasicInfo
	 * @return
	 */
	public List<SysPermission> findAllSysPerm();
	
	/**
	 * 
	 * @description 根据用户名返回所有当前用户权限对象
	 * @author caoy
	 * @date 2015年8月27日 下午2:52:11
	 * @param userName
	 * @param permType
	 * @return
	 */
	public List<SysPermission> findEnableSysPermByUserName(@Param("userName")String userName,@Param("permType")Integer permType);
	
	/**
	 * 
	 * @description 根据角色ID返回所有当前角色所有权限
	 * @author caoy
	 * @date 2015年8月25日 下午4:33:03
	 * @param roleId
	 * @return
	 */
	public List<SysPermission> findAllSysPermByRoleId(@Param("roleId")Integer roleId);
	
	/**
	 * 
	 * @description 根据父节点ID查询子节点
	 * @author caoy
	 * @date 2015年8月25日 上午8:52:35
	 * @param parentId
	 * @return
	 */
	public List<SysPermission> findPermChildNodeByParentId(@Param("parentId")Integer parentId);
	
	/**
	 * 
	 * @description 批量修改权限位置信息
	 * @author caoy
	 * @date 2015年8月25日 上午8:52:23
	 * @param permList
	 * @return
	 */
	public boolean updateBatchPermPosition(List<SysPermission> permList);
	

	/**
	 * 
	 * @description 修改权限
	 * @author caoy
	 * @date 2015年8月25日 上午8:52:14
	 * @param perm
	 * @return
	 */
	public boolean updatePerm(SysPermission perm);
	
	/**
	 * 
	 * @description 删除权限
	 * @author caoy
	 * @date 2015年8月25日 上午8:52:14
	 * @param perm
	 * @return
	 */
	public boolean deletePerm(SysPermission perm);
	
	/**
	 * 
	 * @description 创建权限
	 * @author caoy
	 * @date 2015年8月25日 下午1:29:13
	 * @param perm
	 * @return
	 */
		public boolean insertPerm(SysPermission perm);
	
	/**
	 * 
	 * @description 根据ID查询对象
	 * @author caoy
	 * @date 2015年8月25日 上午9:38:19
	 * @param id
	 * @return
	 */
	public SysPermission findPermById(@Param("id")Integer id);
	
	/**
	 * 
	 * @description 获取当前父节点下的子节点最大排序号
	 * @author caoy
	 * @date 2015年8月25日 下午1:45:54
	 * @param parentId
	 * @return
	 */
	public Integer findChildPermMaxSortNumByParentId(@Param("parentId")Integer parentId);
	
	/**
	 * 
	 * @description 通过子节点获取所有父节点
	 * @author caoy
	 * @date 2015年8月26日 上午11:00:18
	 * @param id
	 * @return
	 */
	public List<SysPermission> findAllParentPermByChildId(Integer id);
}
