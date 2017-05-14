package com.rising.cc.service.interf.api;

import java.util.List;

import com.rising.common.page.Pagination;
import com.rising.cc.common.component.ApiRequest;
import com.rising.cc.pojo.command.api.CreateApiAccountCommand;
import com.rising.cc.pojo.command.api.DeleteApiAccountCommand;
import com.rising.cc.pojo.command.api.RefreshSecretKeyAccountCommand;
import com.rising.cc.pojo.command.api.SetAccountApiInfoCommand;
import com.rising.cc.pojo.command.api.UpdateApiAccountCommand;
import com.rising.cc.pojo.command.api.UpdateApiAccountInfoCommand;
import com.rising.cc.pojo.dto.api.ApiAccountDto;
import com.rising.cc.pojo.dto.api.ApiAccountInfoDto;
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
public interface ApiAccountInfoService {

	public boolean updateApiAccountInfo(SetAccountApiInfoCommand command);
	
	public boolean updateUnitTimeCallNumber(UpdateApiAccountInfoCommand command);
	
	public List<ApiAccountInfoDto> findApiAccountInfoListByQo(ApiAccountInfoQo qo);
	
	public Pagination findApiAccountInfoListByPagination(Pagination pagination);
	
}
