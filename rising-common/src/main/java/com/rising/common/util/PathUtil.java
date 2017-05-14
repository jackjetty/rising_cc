package com.rising.common.util;


/**
 * java类获取web应用的根目录
 */
public class PathUtil {
	private  static PathUtil pathUtil;
	
	public static PathUtil getInstancePath() {
		if (pathUtil == null) {
			pathUtil = new PathUtil();
        }
		return pathUtil;
	}
	
	/**
	 * 获取当前类的绝对路径
	 * @return
	 */
	public static String getClassPath(){
		String path = "";
		try {
			path =  getInstancePath().getWebClassesPath();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	
	public static String getwebPath(){
		String path = "";
		try {
			path =  getInstancePath().getWebInfPath();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	
	/**
	 * 获取当前工程绝对路径
	 * @return
	 */
	public static String getRootPath(){
		String path = "";
		try {
			path =  getInstancePath().getWebRoot();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	
	public final String getWebClassesPath() {
		String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
		if (path.endsWith(".class")) {
			String cp = this.getClass().getName();
			cp = cp.replace(".", "/") + ".class";
			int lidx = path.lastIndexOf(cp);
			if (lidx >= 0) {
				path = path.substring(0, lidx);
			}
		} else if (path.endsWith(".jar")) {
			int lidx = path.lastIndexOf("/WEB-INF/lib/");
			if (lidx >= 0) {
				path = path.substring(0, lidx);
				path += "/WEB-INF/classes/";
			}
		}
		return path;
	}

	public final String getWebInfPath() throws IllegalAccessException {
		String path = getWebClassesPath();
		if (path.indexOf("WEB-INF") > 0) {
			path = path.substring(0, path.indexOf("WEB-INF") + 8);
		} else {
			throw new IllegalAccessException("路径获取错误");
		}
		return path;
	}

	public final String getWebRoot() throws IllegalAccessException {
		String path = getWebClassesPath();
		if (path.indexOf("WEB-INF") > 0) {
			path = path.substring(0, path.indexOf("WEB-INF/classes"));
		} else {
			throw new IllegalAccessException("路径获取错误");
		}
		return path;
	}
}