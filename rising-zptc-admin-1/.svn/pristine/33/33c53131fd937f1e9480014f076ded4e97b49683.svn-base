package com.bhyf.controller.ad;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rising.common.util.PropertiesUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("fileUploadAction")
@Scope("prototype")
@RequestMapping("/imgManager")
public class FileUploadAction{ 
	Log log = LogFactory.getLog(FileUploadAction.class);
	


	
	@RequestMapping("/viewImages")
	public void viewImages(String picPath,HttpServletResponse response,HttpServletRequest request) throws Exception {
		// pic为读取到图片的存储路径(数据库中存储的字段值)
/*		String pic = new String(
				(request.getParameter("picPath")).getBytes("ISO-8859-1"),
				"utf-8");*/
		File picFile = new File(picPath);
		FileInputStream is = new FileInputStream(picFile.getAbsolutePath());
		int i = is.available(); // 得到文件大小
		byte data[] = new byte[i];
		is.read(data); // 读数据
		is.close();
		//response.setContentType("jpg/*"); // 设置返回的文件类型
		response.setContentType("jpg");  
		response.setContentType("application/octet-stream; charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + new String(picFile.getName().getBytes("gb2312"), "ISO8859-1"));
		response.setHeader("Content_Length",new Integer(i).toString());
		OutputStream toClient = response.getOutputStream(); // 得到向客户端输出二进制数据的对象
		toClient.write(data); // 输出数据
		toClient.close();
	}
	


}