package com.bhyf.common.wsclient.onecard.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bhyf.common.wsclient.onecard.SecurityHeader;
import com.bhyf.common.wsclient.onecard.SignInResponse;
import com.bhyf.common.wsclient.onecard.ThirdWebservice;
import com.bhyf.common.wsclient.onecard.ThirdWebserviceSoap;
import com.rising.common.util.CalcUtil;
import com.rising.common.util.DateUtil;
import com.rising.common.util.SysDateUtils;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;

import javax.xml.ws.Holder;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <p>Title : ClientWebService</p>
 * <p>Description : 一卡通接口客户端 </p>
 * <p>Company : 杭州冉思科技有限公司</p>
 * @author : caoyang
 * @date : 2016年4月15日 下午1:32:15
 */
public class ClientWebService {
	public static ThirdWebserviceSoap soap = null;
	
	public static SignInResponse signInResponse = null;
	
	public static final int NOPT_NUM = 1003;//操作员号 1003
	public static final int NID_TYPE = 4;//1帐号、2卡号、3卡内编号、4个人编号、5第三方对接号
	public static final int NEWALLET_NUM = 1;//主钱包为1，共8个钱包
	
	public ClientWebService() {
		
	}
	
	public static synchronized ThirdWebserviceSoap getSoapInstance() {
		if (soap == null) {
			ThirdWebservice webService = new ThirdWebservice();
			soap = webService.getThirdWebserviceSoap();
			signIn();
		}
		return soap;
	}
	
	
	//签入
	public static void signIn(){
		Holder<String> signInResult = new Holder<>();//签到结果，，1为成功，，其它为失败
		Holder<Integer> stanum = new Holder<>();//认证站点编号
		Holder<Integer> thirdType = new Holder<>();//第三方类型
		Holder<Integer> secret1 = new Holder<>();//加密因子1
		Holder<String> secret2 = new Holder<>();//加密因子2
		ClientWebService.getSoapInstance().signIn(signInResult, stanum, thirdType, secret1, secret2);
		
		SecurityHeader securityHeader = new SecurityHeader();
		securityHeader.setThirdType(thirdType.value);
		securityHeader.setSecret1(secret1.value);
		securityHeader.setSecret2(secret2.value);

		SoapSecurityHeader soapHeader = new SoapSecurityHeader();
		soapHeader.setSecurityHeader(securityHeader);
		
		Client client = ClientProxy.getClient(soap);
		client.getOutInterceptors().add(soapHeader);
		
		signInResponse = new SignInResponse();
		signInResponse.setStanum(stanum.value);
		
	}
	

	/**
	 * 获取一卡通交易流水
	 * @param cardNo 卡号
	 * @param start 起始时间 yyyyMMdd
	 * @param end	结束时间 yyyyMMdd
     * @return
     */
	public static String getPaymentBooks(String cardNo,String start,String end){
		int nIDType = 4;//1帐号、2卡号、3卡内编号、4个人编号、5第三方对接号


		Holder<String> getPaymentBooksResult = new Holder<>();//充值结果
		Holder<String> data = new Holder<>();//一卡通站点流水号
		ClientWebService.getSoapInstance().getPaymentBooks(cardNo, nIDType, start, end, signInResponse.getStanum(), 0, 0, getPaymentBooksResult, data);

		if("00000003".equals(getPaymentBooksResult.value)){//未通过加密因子校验
			ClientWebService.signIn();//重新签入一次
			ClientWebService.getSoapInstance().getPaymentBooks(cardNo, nIDType, start, end, signInResponse.getStanum(), 0, 0, getPaymentBooksResult, data);
		}
		return data.value;
	}
	

}
