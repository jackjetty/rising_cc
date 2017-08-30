package com.bhyf.service.interf.role;

import java.util.List;

import com.bhyf.pojo.command.role.CreateRoleCommand;
import com.bhyf.pojo.command.role.RemoveRoleCommand;
import com.bhyf.pojo.command.role.UpdateRoleCommand;
import com.bhyf.pojo.dto.role.SysRoleDto;
import com.bhyf.pojo.qo.role.RoleQo;
import com.rising.common.page.Pagination;

/**
 * 
 * @description 角色相关Service
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午4:38:47
 *
 */
public interface RoleService {

	/**
	 * 
	 * @description 根据用户名返回当前用户所有角色名称列表
	 * @author caoy
	 * @date 2015年8月3日 下午4:39:04
	 * @param userName
	 * @return
	 */
	public List<String> findAllRolesByUserName(String userName);

	
	/**
	 * 
	 * @description 分页查询角色列表
	 * @author caoy
	 * @date 2015年8月21日 上午8:54:33
	 * @param pagination
	 * @return
	 */
	public Pagination findRoleListByPagination(Pagination pagination);
	
	/**
	 * 
	 * @description 更新角色权限
	 * @author caoy
	 * @date 2015年8月25日 下午3:41:49
	 * @param roleId
	 * @param permIdList
	 * @return
	 */
	public boolean updateRolePerm(Integer roleId, Integer[] permIdList);
	
	/**
	 * 
	 * @description 根据用户ID返回用户角色
	 * @author caoy
	 * @date 2015年8月26日 下午1:43:49
	 * @param userId
	 * @return
	 */
	public List<SysRoleDto> findUserRoleListByUserId(Integer userId);
	
	/**
	 * 
	 * @description 根据Qo返回想要角色List
	 * @author caoy
	 * @date 2015年9月1日 上午11:05:24
	 * @param qo
	 * @return
	 */
	public List<SysRoleDto> findRoleListByQo(RoleQo qo);
	
	/**
	 * 
	 * @description 新增角色
	 * @author caoy
	 * @date 2015年8月26日 下午4:20:45
	 * @param command
	 * @return
	 */
	public Integer saveRole(CreateRoleCommand command);
	
	/**
	 * 
	 * @description 修改角色
	 * @author caoy
	 * @date 2015年8月26日 下午4:20:45
	 * @param command
	 * @return
	 */
	public boolean updateRole(UpdateRoleCommand command);
	
	/**
	 * 
	 * @description 删除角色
	 * @author caoy
	 * @date 2015年8月26日 下午4:20:45
	 * @param command
	 * @return
	 */
	public boolean removeRole(RemoveRoleCommand command);
}
