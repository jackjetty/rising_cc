package com.rising.cc.service.interf.api;

import java.util.List;

import com.rising.common.page.Pagination;
import com.rising.cc.pojo.command.api.CreateApiInfoCommand;
import com.rising.cc.pojo.command.api.DeleteApiInfoCommand;
import com.rising.cc.pojo.command.api.UpdateApiInfoCommand;
import com.rising.cc.pojo.dto.api.ApiInfoDto;
import com.rising.cc.pojo.qo.api.ApiInfoQo;


/**
 * 
 * @description api管理Service
 * @company 碧海银帆
 * @author caoy
 * @date 2015年9月7日 下午2:55:41
 *
 */
public interface ApiInfoService {

	/**
	 * 
	 * @description 分页查询Api信息
	 * @author caoy
	 * @date 2015年9月10日 上午9:43:41
	 * @param pagination
	 * @return
	 */
	public Pagination findApiInfoListByPagination(Pagination pagination);
	
	/**
	 * 
	 * @description 新增Api
	 * @author caoy
	 * @date 2015年9月10日 上午9:43:55
	 * @param addCommand
	 * @return
	 */
	public boolean saveApiInfo(CreateApiInfoCommand addCommand);
	
	/**
	 * 
	 * @description 修改Api
	 * @author caoy
	 * @date 2015年9月10日 上午9:43:55
	 * @param updateCommand
	 * @return
	 */
	public boolean updateApiInfo(UpdateApiInfoCommand updateCommand);
	
	/**
	 * 
	 * @description 删除Api
	 * @author caoy
	 * @date 2015年9月10日 上午9:43:55
	 * @param deleteCommand
	 * @return
	 */
	public boolean deleteApiInfo(DeleteApiInfoCommand deleteCommand);
	
	/**
	 * 
	 * @description 根据ApiInfoQo 查询Api信息列表
	 * @author caoy
	 * @date 2015年9月10日 上午9:43:55
	 * @param qo
	 * @return
	 */
	public List<ApiInfoDto> findApiInfoListByQo(ApiInfoQo qo);
	
}
