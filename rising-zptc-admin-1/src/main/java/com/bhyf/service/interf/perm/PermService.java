package com.bhyf.service.interf.perm;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bhyf.model.perm.SysPermission;
import com.bhyf.pojo.command.perm.CreatePermCommand;
import com.bhyf.pojo.command.perm.DeletePermCommand;
import com.bhyf.pojo.command.perm.UpdatePermCommand;
import com.bhyf.pojo.dto.perm.PermDto;
import com.bhyf.pojo.dto.perm.tree.AceTreeNode;
import com.bhyf.pojo.dto.perm.tree.EasyUiRolePermNode;
import com.bhyf.pojo.dto.perm.tree.EasyUiTreeNode;

/**
 * 
 * @description 权限相关Service
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午3:33:58
 *
 */
public interface PermService {

	public List<SysPermission> findAllSysPerm();

	public List<String> findEnablePermUrlMd5ByUserName(String userName);
	
	public PermDto findPermById(Integer id);
	
	public String createBootstrapMenuByUserName(HttpServletRequest request);
	
	public String createAceNestableListHtml();

	public String createEasyUiMenu();

	public List<PermDto> findAllPermForEasyUi();
	
	public  Map<String,AceTreeNode> findPermChildNodeListByParentId(Integer parentId, Integer roleId);
	
	public boolean updateBatchPermPosition(List<SysPermission> permList);
	
	public boolean updatePerm(UpdatePermCommand command);
	
	public boolean insertPerm(CreatePermCommand command);
	
	public boolean deletePerm(DeletePermCommand command);

	public List<EasyUiTreeNode> createEasyUiTreeByUser();

	public List<EasyUiRolePermNode> findAllPermForRole();

	public List<Integer> findPermIdByRoleId(Integer id);

}
