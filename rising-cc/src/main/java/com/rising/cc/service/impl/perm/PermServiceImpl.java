package com.rising.cc.service.impl.perm;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rising.common.util.Md5Util;
import com.rising.cc.dao.perm.SysPermDao;
import com.rising.cc.dao.role.SysRoleDao;
import com.rising.cc.model.menu.BootstrapMenuTreeNode;
import com.rising.cc.model.perm.SysPermission;
import com.rising.cc.model.user.SysUser;
import com.rising.cc.pojo.command.perm.CreatePermCommand;
import com.rising.cc.pojo.command.perm.DeletePermCommand;
import com.rising.cc.pojo.command.perm.UpdatePermCommand;
import com.rising.cc.pojo.constants.perm.PermConstants;
import com.rising.cc.pojo.constants.user.LoginConstants;
import com.rising.cc.pojo.dto.perm.PermDto;
import com.rising.cc.pojo.dto.perm.tree.AceTreeNode;
import com.rising.cc.pojo.dto.perm.tree.AdditionalParameters;
import com.rising.cc.service.interf.perm.PermService;
import com.rising.cc.util.BootStrapTreeUtils;

/**
 * 
 * @description 权限相关Service实现
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午3:33:58
 *
 */
@Service
public class PermServiceImpl implements PermService{

	@Resource
	private SysPermDao sysPermDao;
	
	@Resource
	private SysRoleDao sysRoleDao;
	
	
	public List<SysPermission> findAllSysPerm() {
		
		return sysPermDao.findAllSysPerm();
	}

	public List<String> findEnablePermUrlMd5ByUserName(String userName) {
		
		List<SysPermission> sysPermList = sysPermDao.findEnableSysPermByUserName(userName, null);
		
		List<String> md5PermList = new ArrayList<String>();
		
		for (SysPermission perm: sysPermList) {
			md5PermList.add(Md5Util.MD5(perm.getPermUrl()));
		}
		
		return md5PermList;
	}

	public String createBootstrapMenuByUserName(HttpServletRequest request) {
		
		String menuHtml = "";
		
		Subject currentSubject = SecurityUtils.getSubject();
		SysUser sysUser = (SysUser)currentSubject.getSession().getAttribute(LoginConstants.SESSION_USER_KEY);
    	
		if(sysUser != null){
			
			List<SysPermission> permList = sysPermDao.findEnableSysPermByUserName(sysUser.getUserName(), PermConstants.PERM_MENU);
			
			
			LinkedHashMap<Integer,BootstrapMenuTreeNode> map = new LinkedHashMap<Integer, BootstrapMenuTreeNode>();
			
			for(SysPermission perm:permList){

				BootstrapMenuTreeNode mtn=new BootstrapMenuTreeNode();
				
				mtn.setId(perm.getId());
				mtn.setMenuName(perm.getPermName());
				mtn.setHref(perm.getPermUrl());
				
				if(perm.getParentSysPerm() != null && perm.getParentSysPerm().getId() != null){
					mtn.setParentId(perm.getParentSysPerm().getId());
				}

				map.put(perm.getId(), mtn);
			}
			
			menuHtml = BootStrapTreeUtils.createBootstrapMenuTreeListHtml(map, request);
			
		}
		
		return menuHtml;
	}

	public Map<String,AceTreeNode> findPermChildNodeListByParentId(Integer parentId, Integer roleId) {
		
		List<SysPermission> selectedList = sysPermDao.findAllSysPermByRoleId(roleId);
		
		List<SysPermission> allPermList = sysPermDao.findAllSysPerm();
		List<SysPermission> permList = sysPermDao.findPermChildNodeByParentId(parentId);
		
		
		List<BootstrapMenuTreeNode> menuTreeList = new ArrayList<BootstrapMenuTreeNode>();

		for (SysPermission perm : allPermList) {
			BootstrapMenuTreeNode mtn=new BootstrapMenuTreeNode();
			mtn.setId(perm.getId());
			mtn.setMenuName(perm.getPermName());
			mtn.setHref(perm.getPermUrl());
			if(perm.getParentSysPerm() != null && perm.getParentSysPerm().getId() != null){
				mtn.setParentId(perm.getParentSysPerm().getId());
			}
			menuTreeList.add(mtn);
		}
		
		Map<Integer, List<BootstrapMenuTreeNode>> map = BootStrapTreeUtils.createAceTreeMap(menuTreeList);
		

/*		{
			'children' : {
				'哈哈' : {text: '哈哈', type: 'item',data:'123'},
				'sports-fitness' : {text: 'Sports & Fitness', type: 'item'}
			}
		};*/
		
		 Map<String, AceTreeNode> treeMap =  new LinkedHashMap<String, AceTreeNode>();
		
		for (SysPermission perm : permList) {
			String type = "item";
			if(map.get(perm.getId()) != null && map.get(perm.getId()).size() > 0){
				type = "folder";
			}
			
			boolean itemSelected = false;
			for (SysPermission selectedPerm : selectedList) {
				if(selectedPerm.getId().equals(perm.getId())){
					itemSelected = true;
				}
			}
			
			AdditionalParameters additionalParameters = new AdditionalParameters(itemSelected);
			
			treeMap.put(perm.getPermName(),new AceTreeNode(perm.getPermName(), type, perm.getId(), additionalParameters));
		}
		
		return treeMap;
	}

	public String createAceNestableListHtml() {
		
		String menuHtml = "";
			
		List<SysPermission> permList = sysPermDao.findAllSysPerm();
		
		List<BootstrapMenuTreeNode> menuTreeList = new ArrayList<BootstrapMenuTreeNode>();
		
		for(SysPermission perm:permList){

			BootstrapMenuTreeNode mtn=new BootstrapMenuTreeNode();
			
			mtn.setId(perm.getId());
			mtn.setMenuName(perm.getPermName());
			mtn.setHref(perm.getPermUrl());
			
			if(perm.getParentSysPerm() != null && perm.getParentSysPerm().getId() != null){
				mtn.setParentId(perm.getParentSysPerm().getId());
			}

			menuTreeList.add(mtn);
		}
		
		menuHtml = BootStrapTreeUtils.createAceNestableListHtml(menuTreeList);
			
		
		return menuHtml;
	}

	@Transactional
	public boolean updateBatchPermPosition(List<SysPermission> permList) {

		sysPermDao.updateBatchPermPosition(permList);
		
		
		return false;
	}

	@Transactional
	public boolean updatePerm(UpdatePermCommand command) {
		
		SysPermission perm = new SysPermission();
		perm.updateSysPermission(command);
		
		sysPermDao.updatePerm(perm);

		return false;
	}

	public PermDto findPermById(Integer id) {

		SysPermission perm = sysPermDao.findPermById(id);
		
		PermDto dto = new PermDto();
		dto.createPermDto(perm);
		
		return dto;
	}

	@Transactional
	public boolean deletePerm(DeletePermCommand command) {
		SysPermission perm = new SysPermission();
		perm.deleteSysPermission(command);
		
		List<SysPermission> list = sysPermDao.findPermChildNodeByParentId(command.getId());
		if(list != null && list.size() > 0){
			return false;
		}
		
		sysPermDao.deletePerm(perm);
		
		return true;
	}

	@Transactional
	public boolean insertPerm(CreatePermCommand command) {
		
		SysPermission perm = new SysPermission();
		
		Integer sortNum = sysPermDao.findChildPermMaxSortNumByParentId(command.getParentId());
		
		SysPermission parentPerm = null;
		if(command.getParentId() != null){
			parentPerm = sysPermDao.findPermById(command.getParentId());
			
		}
		
		perm.createSysPermission(command, sortNum, parentPerm);
		
		sysPermDao.insertPerm(perm);
		
		return false;
	}
	
	
}
