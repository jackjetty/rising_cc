package com.rising.cc.service.interf.api;

import java.util.List;

import com.rising.common.page.Pagination;
import com.rising.cc.common.component.ApiRequest;
import com.rising.cc.pojo.command.api.CheckApiAccountCommand;
import com.rising.cc.pojo.command.api.CreateApiAccountCommand;
import com.rising.cc.pojo.command.api.DeleteApiAccountCommand;
import com.rising.cc.pojo.command.api.RefreshSecretKeyAccountCommand;
import com.rising.cc.pojo.command.api.SetAccountApiInfoCommand;
import com.rising.cc.pojo.command.api.UpdateApiAccountCommand;
import com.rising.cc.pojo.dto.api.ApiAccountDto;
import com.rising.cc.pojo.dto.api.ApiInfoDto;
import com.rising.cc.pojo.qo.api.ApiAccountInfoQo;
import com.rising.cc.pojo.qo.api.ApiAccountQo;


/**
 * 
 * @description api用户管理Service
 * @company 碧海银帆
 * @author caoy
 * @date 2015年9月7日 下午2:55:41
 *
 */
public interface ApiAccountService {

	/**
	 * 
	 * @description 分页查询Api用户列表
	 * @author caoy
	 * @date 2015年9月11日 下午1:48:19
	 * @param pagination
	 * @return
	 */
	public Pagination findApiAccountListByPagination(Pagination pagination);
	
	/**
	 * 
	 * @description 新增Api用户
	 * @author caoy
	 * @date 2015年9月11日 下午1:47:52
	 * @param addCommand
	 * @return
	 */
	public boolean saveApiAccount(CreateApiAccountCommand addCommand);
	
	/**
	 * 
	 * @description 修改Api用户
	 * @author caoy
	 * @date 2015年9月11日 下午1:47:52
	 * @param updateCommand
	 * @return
	 */
	public boolean updateApiAccount(UpdateApiAccountCommand updateCommand);
	
	/**
	 * 
	 * @description 删除Api用户
	 * @author caoy
	 * @date 2015年9月11日 下午1:47:13
	 * @param deleteCommand
	 * @return
	 */
	public boolean deleteApiAccount(DeleteApiAccountCommand deleteCommand);
	
	/**
	 * 
	 * @description 根据 Api用户查询模型 返回相应 Api用户列表
	 * @author caoy
	 * @date 2015年9月11日 下午1:46:46
	 * @param qo
	 * @return
	 */
	public List<ApiAccountDto> findApiAccountListByQo(ApiAccountQo qo);
	
	/**
	 * 
	 * @description 刷新账号的私钥
	 * @author caoy
	 * @date 2015年9月11日 下午1:46:33
	 * @param command
	 * @return
	 */
	public boolean RefreshSecretKeyAccount(RefreshSecretKeyAccountCommand command);
	
	/**
	 * 
	 * @description 鉴权Api请求
	 * @author caoy
	 * @date 2015年9月11日 下午1:46:15
	 * @param command
	 * @return
	 */
	public String checkApiAccountIsAuth(CheckApiAccountCommand command);
	
}
