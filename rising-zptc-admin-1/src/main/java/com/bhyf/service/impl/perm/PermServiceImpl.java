package com.bhyf.service.impl.perm;

import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.bhyf.pojo.dto.perm.tree.EasyUiRolePermNode;
import com.bhyf.pojo.dto.perm.tree.EasyUiTreeNode;
import com.bhyf.util.EasyUiTreeUtils;
import com.rising.common.util.Md5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bhyf.dao.perm.SysPermDao;
import com.bhyf.dao.role.SysRoleDao;
import com.bhyf.model.menu.BootstrapMenuTreeNode;
import com.bhyf.model.perm.SysPermission;
import com.bhyf.model.user.SysUser;
import com.bhyf.pojo.command.perm.CreatePermCommand;
import com.bhyf.pojo.command.perm.DeletePermCommand;
import com.bhyf.pojo.command.perm.UpdatePermCommand;
import com.bhyf.pojo.constants.perm.PermConstants;
import com.bhyf.pojo.constants.user.LoginConstants;
import com.bhyf.pojo.dto.perm.PermDto;
import com.bhyf.pojo.dto.perm.tree.AceTreeNode;
import com.bhyf.pojo.dto.perm.tree.AdditionalParameters;
import com.bhyf.service.interf.perm.PermService;
import com.bhyf.util.BootStrapTreeUtils;

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

	public List<PermDto> findAllPermForEasyUi(){

		List<SysPermission> sysPermissionList = sysPermDao.findAllSysPerm();
		List<PermDto> permDtoList = new ArrayList<>();
		permDtoList = createEasyUiPerm(sysPermissionList);
		return permDtoList;
	}

	private static List<PermDto> createEasyUiPerm(List<SysPermission> sysPermissionList) {
		List<PermDto> resultList = new ArrayList<>();
		List<PermDto> permDtoList = new ArrayList<>();
		Map<Integer,List<PermDto>> map = new HashMap<>();
		for (SysPermission sysPermission:sysPermissionList){
			PermDto permDto = new PermDto(sysPermission);
			if(permDto.get_parentId() !=null){
				List<PermDto> permDtos = map.get(permDto.get_parentId());
				if(permDtos == null){
					permDtos = new ArrayList<>();
				}
				permDtos.add(permDto);
				map.put(permDto.get_parentId(),permDtos);
			}else {
				permDtoList.add(permDto);
			}
		}
		resultList = findChildPermDto(permDtoList,map);
		return resultList;
	}

	private static List<PermDto> findChildPermDto(List<PermDto> permDtoList,Map<Integer,List<PermDto>> parentMap){
		List<PermDto> returnList = new ArrayList<>();
		for (PermDto permDto:permDtoList){
			Integer parentId = permDto.getId();
			List<PermDto> permDtoList1 = parentMap.get(parentId);
			if(permDtoList1 != null){
				permDtoList1 = findChildPermDto(permDtoList1,parentMap);
			}
			permDto.setChildren(permDtoList1);
			returnList.add(permDto);
		}
		return returnList;
	}

	public List<EasyUiTreeNode> createEasyUiTreeByUser(){

		Subject currentSubject = SecurityUtils.getSubject();
		SysUser sysUser = (SysUser)currentSubject.getSession().getAttribute(LoginConstants.SESSION_USER_KEY);
		List<EasyUiTreeNode> easyUiTreeNodeList = null;
		if(sysUser != null){
			List<SysPermission> permList = sysPermDao.findEnableSysPermByUserName(sysUser.getUserName(), PermConstants.PERM_MENU);
			easyUiTreeNodeList = EasyUiTreeUtils.createEasyUiPerm(permList);
		}

		return easyUiTreeNodeList;
	}

	@Override
	public List<EasyUiRolePermNode> findAllPermForRole() {
		List<SysPermission> sysPermissionList = sysPermDao.findAllSysPerm();
		List<EasyUiRolePermNode> permDtoList = EasyUiTreeUtils.createEasyUiRolePerm(sysPermissionList);
		return permDtoList;
	}


//	public static void main(String[] args) {
	//  校验生成权限树
//		List<SysPermission> sysPermissionList = new ArrayList<>();
//
//		for (int i = 0;i<3;i++){
//			SysPermission sysPermission = new SysPermission();
//			sysPermission.setPermName("name"+i);
//			sysPermission.setId(i);
//			if(i!=0){
//				SysPermission parentPerm = new SysPermission();
//				parentPerm.setId(i-1);
//				sysPermission.setParentSysPerm(parentPerm);
//			}
//			sysPermissionList.add(sysPermission);
//		}
//		for (int i = 10;i<13;i++){
//			SysPermission sysPermission = new SysPermission();
//			sysPermission.setPermName("names"+i);
//			sysPermission.setId(i);
//			if(i!=10){
//				SysPermission parentPerm = new SysPermission();
//				parentPerm.setId(i-1);
//				sysPermission.setParentSysPerm(parentPerm);
//			}
//			sysPermissionList.add(sysPermission);
//		}
//		List<PermDto> permDtoList = createEasyUiPerm(sysPermissionList);
//		System.out.println(JSON.toJSONString(permDtoList));
//
//	}


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

	@Override
	public String createEasyUiMenu() {

		List<SysPermission> permList = sysPermDao.findPermChildNodeByParentId(null);
		List<EasyUiTreeNode> menus = new ArrayList<>();
		List<EasyUiTreeNode> childNodes ;
		for (SysPermission sysPermission:permList){
			EasyUiTreeNode	node = new EasyUiTreeNode(sysPermission);
			List<SysPermission> subPermList = sysPermDao.findPermChildNodeByParentId(node.getMenuid());
			childNodes = new ArrayList<>();
			for (SysPermission childPerm:subPermList){
				EasyUiTreeNode	childNode = new EasyUiTreeNode(childPerm);
				childNodes.add(childNode);
			}
			node.setMenus(childNodes);
			menus.add(node);
		}

		return JSON.toJSONString(menus);
	}

	public String createEasyUiMenuByUser() {
		Subject currentSubject = SecurityUtils.getSubject();
		SysUser sysUser = (SysUser)currentSubject.getSession().getAttribute(LoginConstants.SESSION_USER_KEY);
		List<EasyUiTreeNode> menus = new ArrayList<>();
		if(sysUser != null) {

			List<SysPermission> permList = sysPermDao.findEnableSysPermByUserName(sysUser.getUserName(), PermConstants.PERM_MENU);
			List<EasyUiTreeNode> childNodes;
			for (SysPermission sysPermission : permList) {
				EasyUiTreeNode node = new EasyUiTreeNode(sysPermission);
				List<SysPermission> subPermList = sysPermDao.findPermChildNodeByParentId(node.getMenuid());
				childNodes = new ArrayList<>();
				for (SysPermission childPerm : subPermList) {
					EasyUiTreeNode childNode = new EasyUiTreeNode(childPerm);
					childNodes.add(childNode);
				}
				node.setMenus(childNodes);
				menus.add(node);
			}
		}

		return JSON.toJSONString(menus);
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

	public List<Integer> findPermIdByRoleId(Integer id){
		List<Integer> permIdList = sysPermDao.findPermIdByRoleId(id);
		return permIdList;
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
