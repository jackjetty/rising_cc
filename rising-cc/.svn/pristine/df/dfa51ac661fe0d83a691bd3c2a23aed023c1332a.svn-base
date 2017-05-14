package com.rising.cc.service.impl.role;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rising.common.page.Pagination;
import com.rising.common.util.SysDateUtils;
import com.rising.cc.dao.perm.SysPermDao;
import com.rising.cc.dao.role.SysRoleDao;
import com.rising.cc.model.perm.SysPermission;
import com.rising.cc.model.role.SysRole;
import com.rising.cc.model.role.SysRolePermission;
import com.rising.cc.model.user.SysUser;
import com.rising.cc.pojo.command.role.CreateRoleCommand;
import com.rising.cc.pojo.command.role.RemoveRoleCommand;
import com.rising.cc.pojo.command.role.UpdateRoleCommand;
import com.rising.cc.pojo.constants.user.LoginConstants;
import com.rising.cc.pojo.dto.role.SysRoleDto;
import com.rising.cc.pojo.qo.role.RoleQo;
import com.rising.cc.service.interf.role.RoleService;

/**
 * 
 * @description 角色相关Service实现
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月4日 上午9:40:01
 *
 */
@Service
public class RoleServiceImpl implements RoleService{

	@Resource
	private SysRoleDao sysRoleDao;
	
	@Resource
	private SysPermDao sysPermDao;
	
	public List<String> findAllRolesByUserName(String userName) {
		
		List<SysRole> sysRoleList = sysRoleDao.findAllSysRoleByUserName(userName);
		List<String> roleList = new ArrayList<String>();
		
		for (SysRole sysRole : sysRoleList) {
			roleList.add(sysRole.getRoleName());
		}
		
		return roleList;
	}

	public Pagination findRoleListByPagination(Pagination pagination) {
		
		List<SysRole> sysRoleList = sysRoleDao.findRoleListByPagination(pagination);
		Integer totalCount = sysRoleDao.countRoleListByPagination(pagination);
		
		List<SysRoleDto> dtoList = new ArrayList<SysRoleDto>();

		
		for (SysRole role : sysRoleList) {
			
			SysRoleDto dto = new SysRoleDto();
			
			BeanUtils.copyProperties(role, dto);
			dtoList.add(dto);
			
		}
		
		pagination.setList(dtoList);
		pagination.setTotalCount(totalCount);
		
		return pagination;
	}

	@Transactional
	public boolean updateRolePerm(Integer roleId, List<Integer> permIdList) {
		
		if(roleId != null && permIdList != null && permIdList.size() >0 ){
			List<SysRolePermission> rolePermList = new ArrayList<SysRolePermission>();
			
			Subject currentSubject = SecurityUtils.getSubject();
			SysUser sysUser = (SysUser)currentSubject.getSession().getAttribute(LoginConstants.SESSION_USER_KEY);
			
			
			Set<Integer> permSet = new HashSet<Integer>();

			for (Integer permId : permIdList) {
				permSet.add(permId);
				List<SysPermission> parentPermList = sysPermDao.findAllParentPermByChildId(permId);
				for (SysPermission parentPerm : parentPermList) {
					permSet.add(parentPerm.getId());
				}
			}
			
			for (Integer permId : permSet) {
				SysRolePermission srp = new SysRolePermission();
				srp.createSysRolePermission(roleId, permId, sysUser);
				
				rolePermList.add(srp);
			}
			
			
			sysRoleDao.deleteOldRolePermByRoleId(roleId);
			sysRoleDao.insertBatchRolePerm(rolePermList);
		}
		
		return true;
	}

	public List<SysRoleDto> findUserRoleListByUserId(Integer userId) {
		List<SysRole> sysRoleList = sysRoleDao.findUserRoleListByUserId(userId);
		List<SysRoleDto> dtoList = new ArrayList<SysRoleDto>();
		for (SysRole role : sysRoleList) {
			SysRoleDto dto = new SysRoleDto();
			BeanUtils.copyProperties(role, dto);
			dtoList.add(dto);
		}
		return dtoList;
	}

	public List<SysRoleDto> findRoleListByQo(RoleQo qo) {
		List<SysRole> sysRoleList = sysRoleDao.findRoleListByQo(qo);
		List<SysRoleDto> dtoList = new ArrayList<SysRoleDto>();
		for (SysRole role : sysRoleList) {
			SysRoleDto dto = new SysRoleDto();
			BeanUtils.copyProperties(role, dto);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Transactional
	public boolean saveRole(CreateRoleCommand command) {
		
		SysRole role = new SysRole();
		role.createRole(command);
		
		sysRoleDao.insertSysRole(role);
		
		return true;
	}

	@Transactional
	public boolean updateRole(UpdateRoleCommand command) {

		SysRole role = new SysRole();
		role.updateRole(command);
		
		sysRoleDao.updateSysRoleById(role);
		
		return true;
	}

	@Transactional
	public boolean removeRole(RemoveRoleCommand command) {
		
		sysRoleDao.updateSysRoleStatusByIds(command.getStatus(), command.getIds());
		
		return true;
	}


}
