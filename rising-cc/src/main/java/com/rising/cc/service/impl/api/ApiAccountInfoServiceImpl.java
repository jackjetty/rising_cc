package com.rising.cc.service.impl.api;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rising.common.page.Pagination;
import com.rising.cc.dao.api.ApiAccountInfoDao;
import com.rising.cc.model.api.ApiAccountInfo;
import com.rising.cc.pojo.command.api.SetAccountApiInfoCommand;
import com.rising.cc.pojo.command.api.UpdateApiAccountInfoCommand;
import com.rising.cc.pojo.dto.api.ApiAccountDto;
import com.rising.cc.pojo.dto.api.ApiAccountInfoDto;
import com.rising.cc.pojo.dto.api.ApiInfoDto;
import com.rising.cc.pojo.qo.api.ApiAccountInfoQo;
import com.rising.cc.service.interf.api.ApiAccountInfoService;


/**
 * 
 * @description api用户管理Service
 * @company 碧海银帆
 * @author caoy
 * @date 2015年9月7日 下午2:55:41
 *
 */
@Service
public class ApiAccountInfoServiceImpl implements ApiAccountInfoService {

//	private static final Logger logger = LoggerFactory.getLogger(ApiAccountInfoServiceImpl.class);

	@Resource
	private ApiAccountInfoDao apiAccountInfoDao;
	

	@Transactional
	public boolean updateApiAccountInfo(SetAccountApiInfoCommand command) {
		
//		apiAccountInfoDao.deleteApiAccountInfoByAccountId(command.getAccountId());
		
		List<ApiAccountInfo> list = new ArrayList<ApiAccountInfo>();
		if(command.getAddIds() != null && command.getAddIds().size() > 0){
			for (Integer apiId : command.getAddIds()) {
				ApiAccountInfo accountApiInfo = new ApiAccountInfo();
				accountApiInfo.createAccountApiInfo(command, apiId);
				
				list.add(accountApiInfo);
			}
			apiAccountInfoDao.insertBatchApiAccountInfo(list);
			
		}
		if(command.getDelIds() != null && command.getDelIds().size() > 0){
			apiAccountInfoDao.deleteApiAccountInfoByAccountIdApiId(command.getAccountId(), command.getDelIds());
		}
		return true;
	}


	@Override
	public List<ApiAccountInfoDto> findApiAccountInfoListByQo(
			ApiAccountInfoQo qo) {

		List<ApiAccountInfo> apiInfoList = apiAccountInfoDao.findApiAccountInfoListByQo(qo);
		List<ApiAccountInfoDto> dtoList = new ArrayList<ApiAccountInfoDto>();
		
		for (ApiAccountInfo apiAccountInfo : apiInfoList) {
			ApiAccountInfoDto dto = new ApiAccountInfoDto();
			ApiInfoDto apiInfoDto = new ApiInfoDto();
			ApiAccountDto accountDto = new ApiAccountDto();
			
			BeanUtils.copyProperties(apiAccountInfo, dto);
			BeanUtils.copyProperties(apiAccountInfo.getApiInfo(), apiInfoDto);
			BeanUtils.copyProperties(apiAccountInfo.getAccount(), accountDto);
			
			dto.setAccountDto(accountDto);
			dto.setApiInfoDto(apiInfoDto);
			
			dtoList.add(dto);
		}
		
		return dtoList;
	}


	@Override
	public boolean updateUnitTimeCallNumber(
			UpdateApiAccountInfoCommand command) {

		ApiAccountInfo apiAccountInfo = new ApiAccountInfo();
		apiAccountInfo.updateUnitTimeCallNumber(command);
		
		apiAccountInfoDao.updateApiAccountInfoById(apiAccountInfo);
		
		return true;
	}


	@Override
	public Pagination findApiAccountInfoListByPagination(Pagination pagination) {
		List<ApiAccountInfo> apiInfoList = apiAccountInfoDao.findApiAccountInfoListByPagination(pagination);
		List<ApiAccountInfoDto> dtoList = new ArrayList<ApiAccountInfoDto>();
		
		for (ApiAccountInfo apiAccountInfo : apiInfoList) {
			ApiAccountInfoDto dto = new ApiAccountInfoDto();
			ApiInfoDto apiInfoDto = new ApiInfoDto();
			ApiAccountDto accountDto = new ApiAccountDto();
			
			BeanUtils.copyProperties(apiAccountInfo, dto);
			BeanUtils.copyProperties(apiAccountInfo.getApiInfo(), apiInfoDto);
			BeanUtils.copyProperties(apiAccountInfo.getAccount(), accountDto);
			
			dto.setAccountDto(accountDto);
			dto.setApiInfoDto(apiInfoDto);
			
			dtoList.add(dto);
		}
		
		pagination.setList(dtoList);
		pagination.setTotalCount(apiAccountInfoDao.countApiAccountInfoListByPagination(pagination));
		
		return pagination;
	}

}
