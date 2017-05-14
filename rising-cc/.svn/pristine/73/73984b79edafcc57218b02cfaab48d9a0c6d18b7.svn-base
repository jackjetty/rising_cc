package com.rising.cc.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
