package com.rising.common.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 项目名称：bhyf-common  
 * 类名称：WebUtil  
 * 类描述：  
 * 创建人：dingzl  
 * 创建时间：2015-5-28 下午3:43:02  
 * 修改人：dingzl 
 * 修改时间：2015-5-28 下午3:43:02  
 * 修改备注：  
 * @version：v1.0.0
 */
@SuppressWarnings("unchecked")
public class WebUtil {
	
	public static String getBasePath(HttpServletRequest request) {
		int port = request.getServerPort();
		return request.getScheme() + "://" + request.getServerName()
					+ ((port == 80) ? "" : (":" + port)) + request.getContextPath() + "/";
	}
	
	public static void write(HttpServletResponse response, Object outObj, String outEncoding) throws IOException {
		if (response.getContentType() == null) response.setContentType("text/html");
		response.setCharacterEncoding(outEncoding);
		PrintWriter out = null;
		out = response.getWriter();
		out.print(outObj);
		out.flush();
		out.close();
	}
}
