package com.rising.cc.service.impl.api;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.rising.common.api.base.RequestBody;
import com.rising.common.page.Pagination;
import com.rising.common.util.Md5Util;
import com.rising.common.util.SysDateUtils;
import com.rising.cc.common.component.ApiRequest;
import com.rising.cc.common.component.RequestHead;
import com.rising.cc.dao.api.ApiAccountDao;
import com.rising.cc.dao.api.ApiAccountInfoDao;
import com.rising.cc.dao.api.ApiInfoDao;
import com.rising.cc.model.api.ApiAccount;
import com.rising.cc.model.api.ApiAccountInfo;
import com.rising.cc.pojo.command.api.CheckApiAccountCommand;
import com.rising.cc.pojo.command.api.CreateApiAccountCommand;
import com.rising.cc.pojo.command.api.DeleteApiAccountCommand;
import com.rising.cc.pojo.command.api.RefreshSecretKeyAccountCommand;
import com.rising.cc.pojo.command.api.UpdateApiAccountCommand;
import com.rising.cc.pojo.constants.api.ApiAccountConstants;
import com.rising.cc.pojo.constants.api.ApiInfoConstants;
import com.rising.cc.pojo.dto.api.ApiAccountDto;
import com.rising.cc.pojo.qo.api.ApiAccountInfoQo;
import com.rising.cc.pojo.qo.api.ApiAccountQo;
import com.rising.cc.pojo.response.api.CheckApiReqResponse;
import com.rising.cc.service.interf.api.ApiAccountService;


/**
 * 
 * @description api用户管理Service
 * @company 碧海银帆
 * @author caoy
 * @date 2015年9月7日 下午2:55:41
 *
 */
@Service
public class ApiAccountServiceImpl implements ApiAccountService {

	public static final Logger logger = LoggerFactory.getLogger(ApiAccountServiceImpl.class);

	
	@Resource
	private ApiAccountDao apiAccountDao;
	
	@Resource
	private ApiAccountInfoDao apiAccountInfoDao;
	
	@Resource
	private ApiInfoDao apiInfoDao;
	
	public Pagination findApiAccountListByPagination(Pagination pagination) {
		
		List<ApiAccount> apiList = apiAccountDao.findApiAccountListByPagination(pagination);
		List<ApiAccountDto> dtoList = new ArrayList<ApiAccountDto>();
		
		for (ApiAccount apiAccount : apiList) {
			ApiAccountDto dto = new ApiAccountDto();
			
			BeanUtils.copyProperties(apiAccount, dto);
			dtoList.add(dto);
		}
		
		pagination.setList(dtoList);
		pagination.setTotalCount(apiAccountDao.countApiAccountListByPagination(pagination));
		
		return pagination;
	}

	@Transactional
	public boolean saveApiAccount(CreateApiAccountCommand addCommand) {
		ApiAccount apiAccount = new ApiAccount();
		apiAccount.createApiAccount(addCommand);
		
		
		ApiAccountQo qo = new ApiAccountQo();
		qo.setAccount(apiAccount.getAccount());
		qo.setEnvirId(apiAccount.getEnvirId());
		List<ApiAccount> list = apiAccountDao.findApiAccountListByQo(qo);
		
		if(list != null && list.size() > 0){
			return false;
		}
		
		apiAccountDao.insertApiAccount(apiAccount);
		
		return true;
	}

	@Transactional
	public boolean updateApiAccount(UpdateApiAccountCommand updateCommand) {

		ApiAccount apiAccount = new ApiAccount();
		apiAccount.updateApiAccount(updateCommand);
		
		ApiAccountQo qo = new ApiAccountQo();
		qo.setAccount(apiAccount.getAccount());
		qo.setEnvirId(apiAccount.getEnvirId());
		List<ApiAccount> list = apiAccountDao.findApiAccountListByQo(qo);
		
		if(list != null){
			for(ApiAccount a : list){
				if(a.getAccount().equals(apiAccount.getAccount()) 
						&& !a.getId().equals(apiAccount.getId())){
					return false;
				}
			}
		}
		
		apiAccountDao.updateApiAccount(apiAccount);
		
		return true;
	}

	@Transactional
	public boolean deleteApiAccount(DeleteApiAccountCommand deleteCommand) {
		apiAccountDao.deleteBatchApiAccount(deleteCommand.getIds());
		return true;
	}

	public List<ApiAccountDto> findApiAccountListByQo(ApiAccountQo qo) {

		List<ApiAccount> apiAccountList = apiAccountDao.findApiAccountListByQo(qo);
		List<ApiAccountDto> dtoList = new ArrayList<ApiAccountDto>();
		
		for (ApiAccount apiAccount : apiAccountList) {
			ApiAccountDto dto = new ApiAccountDto();
			BeanUtils.copyProperties(apiAccount, dto);
			dtoList.add(dto);
		}
		
		return dtoList;
	}

	@Transactional
	public boolean RefreshSecretKeyAccount(
			RefreshSecretKeyAccountCommand command) {

		ApiAccount apiAccount = new ApiAccount();
		apiAccount.refreshSecretKey(command);
		
		apiAccountDao.updateApiAccount(apiAccount);
		
		return true;
	}

	/**
	 * 
	 * @description 校验ApiRequest 是否为空
	 * @author caoy
	 * @date 2015年9月11日 上午11:03:30
	 * @param apiRequest
	 * @return
	 */
	private String checkApiAccountRequestIsBlank(ApiRequest apiRequest){
		if(apiRequest == null 
				|| apiRequest.getHead() == null 
				|| apiRequest.getBody() == null){
			
			return CheckApiReqResponse.RESULT_CODE_ILLEGAL;
		}else if(StringUtils.isBlank(apiRequest.getHead().getUserName())){
			
			return CheckApiReqResponse.ACCOUNT_MISSING;
		}else if(StringUtils.isBlank(apiRequest.getHead().getApiName())){
			
			return CheckApiReqResponse.API_NAME_MISSING;
		}else if(StringUtils.isBlank(apiRequest.getHead().getSeqNo())){
			
			return CheckApiReqResponse.SEQ_NO_MISSING;
		}else if(StringUtils.isBlank(apiRequest.getHead().getSign())){
			
			return CheckApiReqResponse.SIGN_MISSING;
		}else if(apiRequest.getHead().getSendTime() == null){
			
			return CheckApiReqResponse.SEND_TIME_MISSING;
		}
		return "success";
	}
	
	/**
	 * 
	 * @description 校验请求是否合法授权
	 * @author caoy
	 * @date 2015年9月11日 下午1:40:19
	 * @param apiRequest
	 * @param envirCode
	 * @return
	 */
	private String checkApiAccountRequest(ApiRequest apiRequest, CheckApiAccountCommand command){
		
		RequestHead head = apiRequest.getHead();
		RequestBody body = apiRequest.getBody();
		
		ApiAccountQo qo = new ApiAccountQo();
		qo.setAccount(head.getUserName());
		qo.setStatus(ApiAccountConstants.API_ACCOUNT_ENABLE);
		qo.setEnvirCode(command.getEnvirCode());
		List<ApiAccount> accList = apiAccountDao.findApiAccountListByQo(qo);
		
		if(accList != null && accList.size() > 0){
			ApiAccount account = accList.get(0);
			
			//校验签名和IP，参数是否被篡改，IP是否非法
			String resultCode = this.checkApiAccountRequestIsSignAndIp(account, head, body, command.getRealityIp());
			if(!"success".equals(resultCode)){
				return resultCode;
			}
			
			//校验是否有Api权限和是否超时
			return this.checkApiAccountIsPremAndTimeOut(account, head);
			
		}
			
		return CheckApiReqResponse.ACCOUNT_NOT_FOUND_OR_DISABLE;

		
	}
	
	/**
	 * 
	 * @description 校验签名和IP，参数是否被篡改，IP是否非法
	 * @author caoy
	 * @date 2015年9月11日 下午2:11:55
	 * @param account
	 * @param head
	 * @param body
	 * @param realityIp
	 * @return
	 */
	private String checkApiAccountRequestIsSignAndIp(ApiAccount account, 
			RequestHead head, RequestBody body , String realityIp){
		
		String secretKey = account.getSecretKey();
		
		//////////////////////校验签名///////////////////////
		StringBuffer sb = new StringBuffer();
		sb.append(head.getSeqNo());
		sb.append("&");
		sb.append(head.getUserName());
		sb.append("&");
		sb.append(head.getApiName());
		sb.append("&");
		sb.append(head.getSendLogo() == null ? "" : head.getSendLogo() == null);
		sb.append("&");
		sb.append(head.getReceiveLogo() == null ? "" : head.getReceiveLogo());
		sb.append("&");
		sb.append(head.getSendTime());
		sb.append("&");
		sb.append(body.getBusinessParam());
		sb.append("&");
		sb.append(secretKey);
		String sign = Md5Util.MD5(sb.toString());
		
		logger.info("校验api请求，验签字符串：{}，签名结果：{}", sb.toString(), sign);

		
		if(!sign.equals(head.getSign())){//校验签名
			return CheckApiReqResponse.RESULT_CODE_SIGN_ILLEGAL;
		}
		
		//////////////////////校验IP///////////////////////
		String ips = account.getSendIp();
		boolean ipCheck = true;
		if(StringUtils.isNotBlank(ips)){
			String [] ipArr = ips.split(",");
			for (String ip : ipArr) {
				if(ip.equals(realityIp)){
					ipCheck = false;
					break;
				}
			}
			
		}
		if(ipCheck){
			return CheckApiReqResponse.IP_ILLEGAL;
		}
		
		return "success";
		
	}
		
	
	/**
	 * 
	 * @description 校验请求是否有Api权限，如果有权限判断请求是否已经超时失效
	 * @author caoy
	 * @date 2015年9月11日 下午4:50:29
	 * @param account
	 * @param head
	 * @return
	 */
	private String checkApiAccountIsPremAndTimeOut(ApiAccount account, 
			RequestHead head){
		//////////////////////校验API权限//////////////////////
		ApiAccountInfoQo aiQo = new ApiAccountInfoQo();
		aiQo.setApiCode(head.getApiName());
		aiQo.setAccountId(account.getId());
		aiQo.setApiStatus(ApiInfoConstants.API_ENABLE);
		
		List<ApiAccountInfo> apiAccountInfoList = apiAccountInfoDao.findApiAccountInfoListByQo(aiQo);
		if(apiAccountInfoList == null || apiAccountInfoList.size() < 1){
			return CheckApiReqResponse.API_NO_EXIST_OR_PERM_OR_DISABLE;
		}else{
			
			ApiAccountInfo apiAccountInfo = apiAccountInfoList.get(0);
			//////////////////////校验API调用是否已经超时//////////////////////
			
			int timeOut = apiAccountInfo.getTimeOut() == null ? (apiAccountInfo.getApiInfo().getTimeOut() == null ? 0 : apiAccountInfo.getApiInfo().getTimeOut()) : apiAccountInfo.getTimeOut();
//			int timeOut = apiAccountInfo.getApiInfo().getTimeOut() == null ? 0 : apiAccountInfo.getApiInfo().getTimeOut();
			if(timeOut > 0 &&  (SysDateUtils.getCurrentDate().getTime() - head.getSendTime()) > timeOut ){
				return CheckApiReqResponse.CALL_TIME_OUT;
			}
			
		}
		
		return CheckApiReqResponse.RESULT_CODE_SUCCESS;
	}
	

	public String checkApiAccountIsAuth(CheckApiAccountCommand command) {
		String resultCode = "success";
		
		String param = command.getRequest();
		 ApiRequest apiRequest = JSON.parseObject(param, ApiRequest.class);
		
		resultCode = this.checkApiAccountRequestIsBlank(apiRequest);//校验apiRequest是否为空
		if(!"success".equals(resultCode)){
			return resultCode;
		}
		
		//校验请求是否合法授权
		return this.checkApiAccountRequest(apiRequest, command);
	}

}
