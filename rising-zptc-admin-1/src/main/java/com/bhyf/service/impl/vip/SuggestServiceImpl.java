package com.bhyf.service.impl.vip;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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

import com.bhyf.dao.vip.SuggestDao;
import com.bhyf.pojo.vip.Suggest;
import com.bhyf.service.interf.vip.SuggestService;
@Service("suggestService")
public class SuggestServiceImpl implements SuggestService {
	Log log = LogFactory.getLog(SuggestServiceImpl.class);
	
	@Autowired
	SuggestDao suggestDao;
	
	@Override
	public HashMap<String, Object> getSuggestList(String contactWay, String userName,
			String startTime, String endTime, Integer pageSize, Integer pageIndex) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("contactWay", contactWay);
		params.put("userName", userName);
		params.put("startTime", startTime);
		params.put("endTime", endTime);
		Integer listSize = suggestDao.getSuggestCount(params);
		Integer start = (pageIndex - 1) * pageSize ;
		params.put("start", start);
		params.put("pageSize", pageSize);
		ArrayList<Suggest> lists = suggestDao.getSuggestList(params);
		resultMap.put("listSize", listSize);
		resultMap.put("rows", lists);
		return resultMap;
	}
	
	@Override
	public Suggest findSuggestById(Integer id) {
		return suggestDao.findSuggestBySuggestId(id);
	}
	
	@Override
	public HashMap<String, Object> exportData(String contactWay, String userName,
			String startTime, String endTime, HttpServletResponse response) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("contactWay", contactWay);
		params.put("userName", userName);
		params.put("startTime", startTime);
		params.put("endTime", endTime);
		ArrayList<Suggest> lists = suggestDao.getSuggestList1(params);
		
		String filename = null;
		try {
			filename = new String("意见建议信息".getBytes("GBK"), "ISO-8859-1");
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
	
	private static void exportDatas(OutputStream os, List<Suggest> list) {  
		  WritableWorkbook wbook=null;
		  try {  
			   wbook = Workbook.createWorkbook(os); // 建立excel文件  
			   WritableSheet wsheet = wbook.createSheet("意见建议信息", 0); // 工作表名称  
			   //设置Excel字体  
			   WritableFont wfont = new WritableFont(WritableFont.ARIAL, 12,  
					   WritableFont.BOLD, false,  
					   jxl.format.UnderlineStyle.NO_UNDERLINE,  
					   jxl.format.Colour.BLACK);  
			   WritableCellFormat titleFormat = new WritableCellFormat(wfont);  
			   titleFormat.setAlignment(jxl.format.Alignment.CENTRE);
			   
			   String[] title = { "姓名","手机号码","意见简介","上报时间"};//如果还有字段的话,以此类推  
			   // 设置Excel表头  
			   for (int i = 0; i < title.length; i++) {  
				    Label excelTitle = new Label(i, 0, title[i], titleFormat);  
				    wsheet.addCell(excelTitle);  
			   }  
			   int c = 1; // 用于循环时Excel的行号  
			   for(Suggest pm : list){
				  	Label content0 = new Label(0, c,  pm.getUserName());  
				  	Label content1 = new Label(1, c,  pm.getContactWay()); 
				  	Label content2 = new Label(2, c,  pm.getContent());
				  	Label content3 = new Label(3, c,  pm.getCreateTime1());
				  	
				    //如果还有的话,以此类推  
				    wsheet.addCell(content0); 
				    wsheet.addCell(content1);  
				    wsheet.addCell(content2);
				    wsheet.addCell(content3);
				   
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
