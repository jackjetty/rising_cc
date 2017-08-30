package com.bhyf.service.impl.vip;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhyf.dao.vip.UserInfoDao;
import com.bhyf.pojo.constants.user.LoginConstants;
import com.bhyf.pojo.vip.UserInfo;
import com.bhyf.service.interf.vip.UserInfoService;
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	Log log = LogFactory.getLog(UserInfoServiceImpl.class);
	
	@Autowired
	UserInfoDao userInfoDao;
	
	@Override
	public HashMap<String, Object> getUserInfoList(String mobile, String userName,
			String startTime, String endTime, String userType, String jobNo, Integer pageSize, Integer pageIndex) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("mobile", mobile);
		params.put("userName", userName);
		params.put("startTime", startTime);
		params.put("endTime", endTime);
		params.put("userType", userType);
		params.put("jobNo", jobNo);
		Integer listSize = userInfoDao.getUserInfoCount(params);
		Integer start = (pageIndex - 1) * pageSize ;
		params.put("start", start);
		params.put("pageSize", pageSize);
		ArrayList<UserInfo> lists = userInfoDao.getUserInfoList(params);
		resultMap.put("listSize", listSize);
		resultMap.put("rows", lists);
		return resultMap;
	}
	
	@Override
	public HashMap<String, Object> editUserInfo(UserInfo cm){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		if(cm != null){
			try {
				cm.setUpdateTime(new Date());
				userInfoDao.updateUserInfoById(cm);
				resultMap.put("respCode", 0);
				resultMap.put("respInfo", "编辑成功！");
			} catch (Exception e) {
				e.printStackTrace();
				resultMap.put("respCode", -1);
				resultMap.put("respInfo", "编辑失败！");
			}
		}else{
			resultMap.put("respCode", -1);
			resultMap.put("respInfo", "实例对象不能为空！");
		}
		return resultMap;
	}

	@Override
	public UserInfo findUserInfoById(Integer id){
		return userInfoDao.findUserInfoByUserId(id);
	}
	
	@Override
	public HashMap<String, Object> resetUserPwd(String id) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			ArrayList<UserInfo> ai = new ArrayList<UserInfo>();
			String[] ids = id.split(",");
			for (String id1 : ids) {
				try {
					UserInfo user = new UserInfo();
					user.setId(Integer.parseInt(id1));
					user.setUserPwd(LoginConstants.INITIAL_PASSWORD_MD5);
					ai.add(user);
				} catch (Exception e) {
					continue;
				}
			}
			userInfoDao.updateBatchUserPwd(ai);
			resultMap.put("respCode", 0);
			resultMap.put("respInfo", "密码初始化成功！");
		} catch (Exception e) {
			resultMap.put("respCode", -1);
			resultMap.put("respInfo", "密码初始化失败！");
		}
		return resultMap;
	}
	
	@Override
	public HashMap<String, Object> exportData(String mobile, String userName,
			String startTime, String endTime, String userType, String jobNo, HttpServletResponse response) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("mobile", mobile);
		params.put("userName", userName);
		params.put("startTime", startTime);
		params.put("endTime", endTime);
		params.put("userType", userType);
		params.put("jobNo", jobNo);
		ArrayList<UserInfo> lists = userInfoDao.getUserInfoList1(params);
		
		String filename = null;
		try {
			filename = new String("会员用户信息".getBytes("GBK"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		response.addHeader("Content-Disposition", "attachment;filename=" + filename + ".xls");
		try {
			exportDatas(response.getOutputStream(), lists);
			resultMap.put("respCode", 0);
			resultMap.put("respInfo", "Excel导出成功！");
		} catch (IOException e) {
			e.printStackTrace();
			resultMap.put("respCode", -1);
			resultMap.put("respInfo", "Excel导出失败！");
		}
		return resultMap;
	}
	
	private static void exportDatas(OutputStream os, List<UserInfo> list) {  
		  WritableWorkbook wbook=null;
		  try {  
			   wbook = Workbook.createWorkbook(os); // 建立excel文件  
			   WritableSheet wsheet = wbook.createSheet("会员用户信息", 0); // 工作表名称  
			   //设置Excel字体  
			   WritableFont wfont = new WritableFont(WritableFont.ARIAL, 12,  
					   WritableFont.BOLD, false,  
					   jxl.format.UnderlineStyle.NO_UNDERLINE,  
					   jxl.format.Colour.BLACK);  
			   WritableCellFormat titleFormat = new WritableCellFormat(wfont);  
			   titleFormat.setAlignment(jxl.format.Alignment.CENTRE);
			   
			   String[] title = { "姓名","手机号码","身份证号","用户类别","学号/教工号","注册时间"};//如果还有字段的话,以此类推  
			   // 设置Excel表头  
			   for (int i = 0; i < title.length; i++) {  
				    Label excelTitle = new Label(i, 0, title[i], titleFormat);  
				    wsheet.addCell(excelTitle);  
			   }  
			   int c = 1; // 用于循环时Excel的行号  
			   for(UserInfo pm : list){
				  	Label content0 = new Label(0, c,  pm.getRealName());  
				  	Label content1 = new Label(1, c,  pm.getMobile()); 
				  	Label content2 = new Label(2, c,  pm.getIdNum());
				  	Label content3 = new Label(3, c,  "");
				  	if(0 == pm.getUserType()){//0：老师；1：学生；2：校外人员；
				  		content3 = new Label(3, c,  "老师");
				  	}else if(1 == pm.getUserType()){//0：老师；1：学生；2：校外人员；
				  		content3 = new Label(3, c,  "学生");
				  	}else if(2 == pm.getUserType()){//0：老师；1：学生；2：校外人员；
				  		content3 = new Label(3, c,  "校外人员");
				  	}
				  	Label content4 = new Label(4, c,  pm.getJobNo());
				  	Label content5 = new Label(5, c,  pm.getRegisterTime1());
				  	
				    //如果还有的话,以此类推  
				    wsheet.addCell(content0); 
				    wsheet.addCell(content1);  
				    wsheet.addCell(content2);
				    wsheet.addCell(content3);
				    wsheet.addCell(content4);
				    wsheet.addCell(content5);
				   
				    //如果还有的话,以此类推  
				    c++;  
			  }
			   wbook.write(); // 写入文件  
			   wbook.close();  
			   os.close();  
			   //System.out.println("导入成功！");  
		  
		  } catch (Exception e) {  
			  e.printStackTrace();  
		  }  
	}  
	
}
