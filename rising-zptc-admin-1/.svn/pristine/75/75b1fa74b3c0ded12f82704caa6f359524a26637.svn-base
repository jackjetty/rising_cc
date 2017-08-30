package com.bhyf.service.interf.user;

import com.rising.common.page.Pagination;
import com.bhyf.model.user.SysUser;
import com.bhyf.pojo.command.user.CreateUserCommand;
import com.bhyf.pojo.command.user.RemoveUserCommand;
import com.bhyf.pojo.command.user.ResetUserPwdCommand;
import com.bhyf.pojo.command.user.SetRoleUserCommand;
import com.bhyf.pojo.command.user.UpdateUserCommand;
import com.bhyf.pojo.command.user.UpdateUserPwdCommand;
import com.bhyf.pojo.dto.user.SysUserBasicInfoDto;
import com.bhyf.pojo.qo.user.UserQo;

/**
 * 
 * @description 用户管理Service
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午2:47:12
 *
 */
public interface UserService {
	
	/**
	 * 
	 * @description 新增User
	 * @author caoy
	 * @date 2015年8月3日 下午2:27:14
	 * @param command
	 * @return
	 */
	public Integer saveUser(CreateUserCommand command);
	
	/**
	 * 
	 * @description 更新User
	 * @author caoy
	 * @date 2015年8月12日 下午1:26:51
	 * @param command
	 * @return
	 */
	public boolean updateUser(UpdateUserCommand command);
	
	/**
	 * 
	 * @description 更新User密码
	 * @author caoy
	 * @date 2015年9月14日 下午1:26:51
	 * @param command
	 * @return
	 */
	public boolean updateUserPwd(UpdateUserPwdCommand command);
	
	/**
	 * 
	 * @description 重置User密码
	 * @author caoy
	 * @date 2015年9月14日 下午1:26:51
	 * @param command
	 * @return
	 */
	public boolean resetUserPwd(ResetUserPwdCommand command);
	
	/**
	 * 
	 * @description 
	 * @author caoy
	 * @date 2015年8月13日 上午10:30:25
	 * @param command
	 * @return
	 */
	public boolean removeUser(RemoveUserCommand command);
	
	/**
	 * 
	 * @description 根据登录用户名返回登录对象
	 * @author caoy
	 * @date 2015年8月3日 下午3:42:32
	 * @param userName
	 * @return
	 */
	public SysUser findSysUserByUserName(String userName);
	
	/**
	 * 
	 * @description 根据登录用户名返回用户全部信息
	 * @author caoy
	 * @date 2015年9月11日 下午5:10:35
	 * @param qo
	 * @return
	 */
	public SysUserBasicInfoDto findSysUserBasicInfoByUserQo(UserQo qo);
	
	/**
	 * 
	 * @description 分页查询用户列表信息
	 * @author caoy
	 * @date 2015年8月11日 上午10:52:33
	 * @param pagination
	 * @return
	 */
	public Pagination findUserInfoListByPagination(Pagination pagination);
	
	/**
	 * 
	 * @description 保存用户角色关系
	 * @author caoy
	 * @date 2015年8月26日 下午2:48:02
	 * @param command
	 * @return
	 */
	public boolean setRoleUser(SetRoleUserCommand command);

}
