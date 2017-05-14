package com.rising.cc.service.impl.api;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rising.common.page.Pagination;
import com.rising.cc.dao.api.ApiInfoDao;
import com.rising.cc.model.api.ApiInfo;
import com.rising.cc.pojo.command.api.CreateApiInfoCommand;
import com.rising.cc.pojo.command.api.DeleteApiInfoCommand;
import com.rising.cc.pojo.command.api.UpdateApiInfoCommand;
import com.rising.cc.pojo.dto.api.ApiInfoDto;
import com.rising.cc.pojo.qo.api.ApiInfoQo;
import com.rising.cc.service.interf.api.ApiInfoService;


/**
 * 
 * @description api管理Service
 * @company 碧海银帆
 * @author caoy
 * @date 2015年9月7日 下午2:55:41
 *
 */
@Service
public class ApiInfoServiceImpl implements ApiInfoService {

	@Resource
	private ApiInfoDao apiInfoDao;
	
	public Pagination findApiInfoListByPagination(Pagination pagination) {
		
		List<ApiInfo> apiList = apiInfoDao.findApiInfoListByPagination(pagination);
		List<ApiInfoDto> dtoList = new ArrayList<ApiInfoDto>();
		
		for (ApiInfo apiInfo : apiList) {
			ApiInfoDto dto = new ApiInfoDto();
			BeanUtils.copyProperties(apiInfo, dto);
			dtoList.add(dto);
		}
		
		pagination.setList(dtoList);
		pagination.setTotalCount(apiInfoDao.countApiInfoListByPagination(pagination));
		
		return pagination;
	}

	@Transactional
	public boolean saveApiInfo(CreateApiInfoCommand addCommand) {
		ApiInfo apiInfo = new ApiInfo();
		apiInfo.createApiInfo(addCommand);
		
		
		ApiInfoQo qo = new ApiInfoQo();
		qo.setApiCode(apiInfo.getApiCode());
		qo.setEnvirId(apiInfo.getEnvirId());
		List<ApiInfo> list = apiInfoDao.findApiInfoListByQo(qo);
		
		if(list != null && list.size() > 0){
			return false;
		}
		
		apiInfoDao.insertApiInfo(apiInfo);
		
		return true;
	}

	@Transactional
	public boolean updateApiInfo(UpdateApiInfoCommand updateCommand) {

		ApiInfo apiInfo = new ApiInfo();
		apiInfo.updateApiInfo(updateCommand);
		
		ApiInfoQo qo = new ApiInfoQo();
		qo.setApiCode(apiInfo.getApiCode());
		qo.setEnvirId(apiInfo.getEnvirId());
		List<ApiInfo> list = apiInfoDao.findApiInfoListByQo(qo);
		
		if(list != null){
			for(ApiInfo a : list){
				if(a.getApiCode().equals(apiInfo.getApiCode()) 
						&& !a.getId().equals(apiInfo.getId())){
					return false;
				}
			}
		}
		
		apiInfoDao.updateApiInfo(apiInfo);
		
		return true;
	}

	@Transactional
	public boolean deleteApiInfo(DeleteApiInfoCommand deleteCommand) {
		if(apiInfoDao.countApiInfoAccountListByApiIds(deleteCommand.getIds()) > 0){
			return false;
		}
		apiInfoDao.deleteBatchApiInfo(deleteCommand.getIds());
		return true;
	}

	public List<ApiInfoDto> findApiInfoListByQo(ApiInfoQo qo) {

		List<ApiInfo> apiInfoList = apiInfoDao.findApiInfoListByQo(qo);
		List<ApiInfoDto> dtoList = new ArrayList<ApiInfoDto>();
		
		for (ApiInfo apiInfo : apiInfoList) {
			ApiInfoDto dto = new ApiInfoDto();
			BeanUtils.copyProperties(apiInfo, dto);
			dtoList.add(dto);
		}
		
		return dtoList;
	}

}
