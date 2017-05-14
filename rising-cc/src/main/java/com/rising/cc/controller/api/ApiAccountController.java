package com.rising.cc.controller.api;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.rising.common.api.base.ApiResponse;
import com.rising.common.model.HttpResponse;
import com.rising.common.page.Pagination;
import com.rising.common.util.HttpUtil;
import com.rising.common.util.Md5Util;
import com.rising.cc.common.component.BaseController;
import com.rising.cc.common.component.PaginQo;
import com.rising.cc.pojo.command.api.CheckApiAccountCommand;
import com.rising.cc.pojo.command.api.CreateApiAccountCommand;
import com.rising.cc.pojo.command.api.DeleteApiAccountCommand;
import com.rising.cc.pojo.command.api.EditApiAccountCommand;
import com.rising.cc.pojo.command.api.RefreshSecretKeyAccountCommand;
import com.rising.cc.pojo.command.api.SetAccountApiInfoCommand;
import com.rising.cc.pojo.command.api.UpdateApiAccountCommand;
import com.rising.cc.pojo.command.api.UpdateApiAccountInfoCommand;
import com.rising.cc.pojo.constants.api.ApiAccountConstants;
import com.rising.cc.pojo.constants.api.ApiInfoConstants;
import com.rising.cc.pojo.dto.api.ApiAccountDto;
import com.rising.cc.pojo.dto.api.ApiAccountInfoDto;
import com.rising.cc.pojo.dto.api.ApiInfoDto;
import com.rising.cc.pojo.dto.envir.EnvirTypeDto;
import com.rising.cc.pojo.qo.api.ApiAccountInfoQo;
import com.rising.cc.pojo.qo.api.ApiAccountQo;
import com.rising.cc.pojo.qo.api.ApiInfoQo;
import com.rising.cc.pojo.response.api.CheckApiReqResponse;
import com.rising.cc.service.interf.api.ApiAccountInfoService;
import com.rising.cc.service.interf.api.ApiAccountService;
import com.rising.cc.service.interf.api.ApiInfoService;
import com.rising.cc.service.interf.envir.EnvirTypeService;

/**
 * 
 * @description Api用户管理控制器
 * @company 碧海银帆
 * @author caoy
 * @date 2015年9月7日 下午3:20:21
 *
 */
@Controller
@RequestMapping("api")
public class ApiAccountController extends BaseController{
	
	public static final Logger logger = LoggerFactory.getLogger(ApiAccountController.class);
	
	@Resource
	private ApiAccountService apiAccountService;
	
	@Resource
	private ApiInfoService apiInfoService;
	
	@Resource
	private ApiAccountInfoService apiAccountInfoService;
	
	@Resource
	private EnvirTypeService envirTypeService;
	
	
	/**
	 * 
	 * @description 跳转至api用户列表
	 * @author caoy
	 * @date 2015年9月7日 下午3:16:36
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("to_account_list")
	public String toApiAccountList(HttpServletRequest request,
			Model model){
		
		List<EnvirTypeDto> envirTypeList = envirTypeService.findEnvirTypeListByUserId(this.getCurrentUser().getId());
		
		model.addAttribute("envirTypeList", envirTypeList);
		return "/api/account/account_list.html";
	}
	
	/**
	 * 
	 * @description 加载Api用户列表
	 * @author caoy
	 * @date 2015年9月7日 下午3:16:59
	 * @param request
	 * @param pageNo
	 * @param pageSize
	 * @param qo
	 * @param model
	 * @return
	 */
	@RequestMapping("account_list")
	@ResponseBody
	public Pagination findApiAccountList(HttpServletRequest request,
			@RequestParam(value="page",required=true) Integer pageNo,
			@RequestParam(value="rows",required=true) Integer pageSize,
			@ModelAttribute ApiAccountQo qo,
			Model model){
	
		PaginQo paginQo = new PaginQo();
		paginQo.setPageNo(pageNo);
		paginQo.setPageSize(pageSize);
		
		Pagination pagination = this.createPagination(paginQo, qo);
		
		pagination = apiAccountService.findApiAccountListByPagination(pagination);
		
		return pagination;
	}
	
	/**
	 * 
	 * @description 保存Api用户信息
	 * @author caoy
	 * @date 2015年9月7日 下午3:18:29
	 * @param request
	 * @param command
	 * @param model
	 * @param oper
	 * @return
	 */
	@RequestMapping("save_account")
	@ResponseBody
	public String saveApiAccount(HttpServletRequest request,
			@ModelAttribute EditApiAccountCommand command,Model model,
			@RequestParam String oper){
		
		if(oper.equals("add")){
			CreateApiAccountCommand addCommand = new CreateApiAccountCommand();
			addCommand.createCommand(command);
			if(!apiAccountService.saveApiAccount(addCommand)){
				return "code_existing";
			}
		}else if(oper.equals("edit")){
			UpdateApiAccountCommand updateCommand = new UpdateApiAccountCommand();
			updateCommand.createCommand(command);
			if(!apiAccountService.updateApiAccount(updateCommand)){
				return "code_existing";
			}
		}else if(oper.equals("del")){
			DeleteApiAccountCommand deleteCommand = new DeleteApiAccountCommand();
			deleteCommand.createCommand(command);
			apiAccountService.deleteApiAccount(deleteCommand);
		}
		
		return "true";
	}
	
	@RequestMapping("find_account_list_by_qo")
	@ResponseBody
	public List<ApiAccountDto> findProjectList(@ModelAttribute ApiAccountQo qo){
		
		List<ApiAccountDto> dtoList = apiAccountService.findApiAccountListByQo(qo);
		
		return dtoList;
	}
	
	@RequestMapping("api_account_info_list")
	@ResponseBody
	public Pagination findApiInfoAccountList(	
			@RequestParam(value="page",required=true) Integer pageNo,
			@RequestParam(value="rows",required=true) Integer pageSize,
			@ModelAttribute ApiAccountInfoQo qo){
		PaginQo paginQo = new PaginQo();
		paginQo.setPageNo(pageNo);
		paginQo.setPageSize(pageSize);
		
		Pagination pagination = this.createPagination(paginQo, qo);
		
		pagination = apiAccountInfoService.findApiAccountInfoListByPagination(pagination);
		
		return pagination;
	}
	
	@RequestMapping("to_set_account_api_info")
	public String toSetApi(@ModelAttribute ApiAccountInfoQo qo, 
			@ModelAttribute ApiInfoQo aQo,Model model){
		
		if(qo != null && qo.getAccountId() != null 
				&& qo.getEnvirId() != null 
				&& aQo != null 
				&& aQo.getEnvirId() != null){
			
			qo.setApiStatus(ApiInfoConstants.API_ENABLE);
			List<ApiAccountInfoDto> dtoList = apiAccountInfoService.findApiAccountInfoListByQo(qo);
			
			aQo.setStatus(ApiInfoConstants.API_ENABLE);
			List<ApiInfoDto> allDtoList = apiInfoService.findApiInfoListByQo(aQo);
			
			model.addAttribute("accountId", qo.getAccountId());
			model.addAttribute("dtoList", dtoList);
			model.addAttribute("allDtoList", allDtoList);
			
		}
		
		
		return "/api/account/update_account_api.html";
	}
	
	@RequestMapping("set_account_api_info")
	@ResponseBody
	public String updateAccountApiInfo(@ModelAttribute SetAccountApiInfoCommand command){
		
		try {
			apiAccountInfoService.updateApiAccountInfo(command);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		
		return "success";
	}
	
	@RequestMapping("update_unittime_callnumber")
	@ResponseBody
	public boolean updateUnitTimeCallNumber(@ModelAttribute UpdateApiAccountInfoCommand command){
		
		try {
			apiAccountInfoService.updateUnitTimeCallNumber(command);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	@RequestMapping("refresh_secretkey")
	@ResponseBody
	public boolean refreshSecretKey(@ModelAttribute RefreshSecretKeyAccountCommand command){
		
		try {
			apiAccountService.RefreshSecretKeyAccount(command);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	@RequestMapping("check_request")
	@ResponseBody
	public ApiResponse checkApiAccountRequest(@ModelAttribute CheckApiAccountCommand command, HttpServletRequest request){
		
		logger.info("校验api请求command，参数如下：{}",JSON.toJSONString(command));
		
		CheckApiReqResponse response = new CheckApiReqResponse();
		String resultCode = CheckApiReqResponse.RESULT_CODE_SUCCESS;
		
		if(command == null){
			resultCode = CheckApiReqResponse.RESULT_CODE_ILLEGAL;

		}else if(StringUtils.isBlank(command.getEnvirCode())){
			
			resultCode = CheckApiReqResponse.ENVIR_CODE_MISSING;
		}else if(StringUtils.isBlank(command.getRealityIp())){
			
			resultCode = CheckApiReqResponse.REALITY_IP_MISSING;
		}else if(StringUtils.isBlank(command.getRequest())){
			
			resultCode = CheckApiReqResponse.REQUEST_MISSING;
		}else if(StringUtils.isBlank(command.getSign())){
			
			resultCode = CheckApiReqResponse.C_SIGN_MISSING;
		}else{
			
			StringBuffer sb = new StringBuffer();
			sb.append(command.getEnvirCode());
			sb.append("&");
			sb.append(command.getRealityIp());
			sb.append("&");
			sb.append(command.getRequest());
			sb.append("&");
			sb.append(ApiAccountConstants.CHECK_API_REQUEST_MD5_KEY);
			
			if(!command.getSign().equals(Md5Util.MD5(sb.toString()))){//校验Command签名
				resultCode = CheckApiReqResponse.C_SIGN_ILLEGAL;
				
			}else{
				try {
					
					resultCode = apiAccountService.checkApiAccountIsAuth(command);
					
				} catch (Exception e) {
					e.printStackTrace();
					resultCode = CheckApiReqResponse.SYSTEM_ERROR;
				}
				
			}
			
		}
		
		response.setResult(resultCode);
		response.setMessage(CheckApiReqResponse.RESULT_CODE_MAP.get(resultCode));
		
		logger.info("校验api请求command，响应如下：{}",JSON.toJSONString(response));

		return response;
	}
	
	@RequestMapping("/check_request/test")
	@ResponseBody
	public String checkApi(@RequestParam(value="param",required=true) String param, HttpServletRequest request){
		
		return this.checkRequest(param, request);
	}
	
	private String checkRequest(String param, HttpServletRequest request){
		String ip = HttpUtil.getIpAddress(request);
		
		Map<String, String> paramMap = new HashMap<String, String>();
		String envirCode = "ENV_TYPE_DEVELOP";
		paramMap.put("request", param);
		
		paramMap.put("envirCode", envirCode);
		paramMap.put("realityIp", ip);
		paramMap.put("sign", Md5Util.MD5(envirCode+"&"+ip+"&"+param+"&"+ApiAccountConstants.CHECK_API_REQUEST_MD5_KEY));
		HttpResponse response = HttpUtil.executePostMethod("http://localhost:9999/bhyf-cc/api/check_request", paramMap, 50000);
		return  response.getResult();
	}
	public static void main(String[] args) {
		System.out.println(new Date().getTime());
	}
}
