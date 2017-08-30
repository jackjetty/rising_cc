package com.bhyf.service.impl.user;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rising.common.page.Pagination;
import com.bhyf.dao.role.SysRoleDao;
import com.bhyf.dao.user.SysUserBasicInfoDao;
import com.bhyf.dao.user.SysUserDao;
import com.bhyf.model.role.SysRole;
import com.bhyf.model.user.SysUser;
import com.bhyf.model.user.SysUserBasicInfo;
import com.bhyf.model.user.SysUserRole;
import com.bhyf.pojo.command.user.CreateUserCommand;
import com.bhyf.pojo.command.user.RemoveUserCommand;
import com.bhyf.pojo.command.user.ResetUserPwdCommand;
import com.bhyf.pojo.command.user.SetRoleUserCommand;
import com.bhyf.pojo.command.user.UpdateUserCommand;
import com.bhyf.pojo.command.user.UpdateUserPwdCommand;
import com.bhyf.pojo.dto.user.SysUserBasicInfoDto;
import com.bhyf.pojo.qo.user.UserQo;
import com.bhyf.service.interf.user.UserService;

/**
 * 
 * @description 用户相关Service实现
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月4日 上午9:40:01
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	private SysUserDao sysUserDao;
	
	@Resource
	private SysUserBasicInfoDao sysUserBasicInfoDao;
	
	@Resource
	private SysRoleDao sysRoleDao;

	@Transactional
	public Integer saveUser(CreateUserCommand command) {
		SysUser oldSysUser = sysUserDao.findSysUserByUserName(command.getUserName());
		if(oldSysUser != null){
			return 0;
		}

		SysUser user = new SysUser();
		
		user.createUser(command);
		sysUserDao.saveSysUser(user);
		
		SysUserBasicInfo userBasicInfo = new SysUserBasicInfo();
		userBasicInfo.createUserBasicInfo(command, user);
		
		sysUserBasicInfoDao.saveSysUserBasicInfo(userBasicInfo);
		
		return user.getId();
	}
	
	@Transactional
	public boolean updateUser(UpdateUserCommand command) {
		
		SysUser oldSysUser = sysUserDao.findSysUserByUserName(command.getUserName());
		if(oldSysUser != null && !oldSysUser.getId().equals(command.getUserId())){
			return false;
		}
		
		SysUser user = new SysUser();
		
		user.updateUser(command);
		sysUserDao.updateSysUserById(user);
		
		SysUserBasicInfo userBasicInfo = new SysUserBasicInfo();
		userBasicInfo.updateUserBasicInfo(command, user);
		
		sysUserBasicInfoDao.updateSysUserBasicInfoByUserId(userBasicInfo);
		
		
		return true;
	}
	
	@Transactional
	public boolean removeUser(RemoveUserCommand command) {
		
		if(command != null && command.getIds() != null && command.getIds().size() > 0){
			sysUserDao.updateSysUserStatusByIds(command.getStatus(),command.getIds());
		}
		
		return true;
	}

	public SysUser findSysUserByUserName(String userName) {
		return sysUserDao.findSysUserByUserName(userName);
	}

	public Pagination findUserInfoListByPagination(Pagination pagination) {
		
		List<SysUserBasicInfo> userInfoList = sysUserBasicInfoDao.findUserInfoListByPagination(pagination);
		
		List<SysUserBasicInfoDto> userInfoDtoList = new ArrayList<SysUserBasicInfoDto>();
		
		for (SysUserBasicInfo sysUserBasicInfo : userInfoList) {
			SysUserBasicInfoDto dto = new SysUserBasicInfoDto();
			
			List<SysRole> sysRoleList = sysRoleDao.findAllSysRoleByUserName(sysUserBasicInfo.getSysUser().getUserName());
			
			dto.createSysUserBasicInfoDto(sysUserBasicInfo, sysRoleList);
			userInfoDtoList.add(dto);
		}
		
		pagination.setList(userInfoDtoList);
		pagination.setTotalCount(sysUserBasicInfoDao.countUserInfoListByPagination(pagination));
		
		return pagination;
	}

	@Transactional
	public boolean setRoleUser(SetRoleUserCommand command) {
		
		List<SysUserRole> userRoleList = new ArrayList<SysUserRole>();

		for (int roleId : command.getRoleIds()) {
			SysUserRole sur = new SysUserRole();
			sur.createSysUserRole(command, roleId);
			
			userRoleList.add(sur);
			
		}
		
		sysUserDao.deleteOldUserRoleByUserId(command.getUserId());
		sysUserDao.insertBatchUserRole(userRoleList);
		
		return true;
	}

	@Override
	public SysUserBasicInfoDto findSysUserBasicInfoByUserQo(UserQo qo) {
		
		SysUserBasicInfo sysUserBasicInfo = sysUserBasicInfoDao.findSysUserBasicInfoByUserQo(qo);
		
		SysUserBasicInfoDto dto = new SysUserBasicInfoDto();
		
		List<SysRole> sysRoleList = sysRoleDao.findAllSysRoleByUserName(sysUserBasicInfo.getSysUser().getUserName());
		
		dto.createSysUserBasicInfoDto(sysUserBasicInfo, sysRoleList);
		
		return dto;
	}

	@Override
	@Transactional
	public boolean updateUserPwd(UpdateUserPwdCommand command) {

		SysUser sysUser = sysUserDao.findSysUserByUserId(command.getUserId());
		
		if(sysUser != null && command.getOldPwd().equals(sysUser.getUserPwd())){
			SysUser user = new SysUser();
			
			user.updateUserPwd(command);
			sysUserDao.updateSysUserById(user);
			
			return true;
		}
		
		return false;
	}


	@Override
	public boolean resetUserPwd(ResetUserPwdCommand command) {
		
		List<SysUser> userList = new ArrayList<SysUser>();
		
			SysUser user = new SysUser();
			user.resetUserPwd(command);
			
			userList.add(user);
		sysUserDao.updateBatchUserPwd(userList);
		
		return true;
	}

}
