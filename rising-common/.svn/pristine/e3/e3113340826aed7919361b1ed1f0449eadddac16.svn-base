package com.rising.common.util;

public class ClassPathTool {
	private static String path;

	private ClassPathTool() {
		path = this.getClass().getResource("").getPath();
		path = path.substring(0, path.indexOf("/WEB-INF"));
	}

	private static ClassPathTool classPathTool;

	public static ClassPathTool getInstance() {
		if (classPathTool == null) {
			classPathTool = new ClassPathTool();
		}
		return classPathTool;
	}

	/**
	 * WebRoot路径
	 * 
	 * @return
	 */
	public static String getWebRootPath() {
		return path;
	}
}