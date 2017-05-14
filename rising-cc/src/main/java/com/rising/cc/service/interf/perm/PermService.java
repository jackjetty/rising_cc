package com.rising.cc.service.interf.perm;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.rising.cc.model.perm.SysPermission;
import com.rising.cc.pojo.command.perm.CreatePermCommand;
import com.rising.cc.pojo.command.perm.DeletePermCommand;
import com.rising.cc.pojo.command.perm.UpdatePermCommand;
import com.rising.cc.pojo.dto.perm.PermDto;
import com.rising.cc.pojo.dto.perm.tree.AceTreeNode;

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
	
	public  Map<String,AceTreeNode> findPermChildNodeListByParentId(Integer parentId, Integer roleId);
	
	public boolean updateBatchPermPosition(List<SysPermission> permList);
	
	public boolean updatePerm(UpdatePermCommand command);
	
	public boolean insertPerm(CreatePermCommand command);
	
	public boolean deletePerm(DeletePermCommand command);
	
}
