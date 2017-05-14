package com.rising.common.util;

import java.util.ArrayList;
import java.util.List;

/*
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Log日志包转
 * 
 */
public class LogFlow {

	private static Logger logger = LoggerFactory.getLogger(LogFlow.class);

	private int logLevel;

	private Logger customLog;
	
	private long timestamp;
	
	private String name;

	private List<String> profileList;
	
	private int timeUnit;
	
	private boolean immediateOutput = false;
	
	/** 日志级别 */
	public final static int LOG_LEVEL_DEBUG = 1;
	public final static int LOG_LEVEL_INFO = 2;
	public final static int LOG_LEVEL_WARN = 3;
	public final static int LOG_LEVEL_ERROR = 4;

	/** 时间单位 */
	public final static int TIME_UNIT_MS = 1;
	public final static int TIME_UNIT_NS = 2;
	
	public LogFlow(String name) {
		this.name = name;
		profileList = new ArrayList<String>();
		timestamp = currentTime();
	}

	public LogFlow(String name, int timeUnit) {
		this.name = name;
		profileList = new ArrayList<String>();
		this.timeUnit = timeUnit;
		timestamp = currentTime();
	}
	
	public LogFlow(String name, Class<?> logClass, int logLevel) {
		this.logLevel = logLevel;
		if (logClass != null) {
			customLog = LoggerFactory.getLogger(logClass);
		}
		this.name = name;
		profileList = new ArrayList<String>();
		timestamp = currentTime();
	}

	public void record(String prompt) {
		StringBuilder sb = new StringBuilder();
		long timestampcurrent = currentTime();
		long timestamptmp = (timestampcurrent - timestamp);
		
		String info = sb.append(name).append("--> ").append(prompt)
				.append(" used time: ")
				.append(timestamptmp).append(currentTimeUnit())
				.toString();
		profileList.add(info);
		timestamp = timestampcurrent;
		if (immediateOutput) {
			output(info);
		}
	}

	public void record(String prompt, Class<Object> logClass) {
		StringBuilder sb = new StringBuilder();
		long timestampcurrent = currentTime();
		long timestamptmp = (timestampcurrent - timestamp);
		
		String info = sb.append(name).append("--> ").append(prompt)
				.append(" used time: ")
				.append(timestamptmp).append(currentTimeUnit())
				.toString();
		
		profileList.add(info);
		
		timestamp = timestampcurrent;
		if (immediateOutput) {
			output(info);
		}
	}

	public void record(String prompt, String remark) {
		StringBuilder sb = new StringBuilder();
		long timestampcurrent = currentTime();
		long timestamptmp = (timestampcurrent - timestamp);
		
		String info = sb.append(name).append("--> ").append(prompt)
				.append(" used time: ")
				.append(timestamptmp)
				.append(currentTimeUnit()).append("  remark:").append(remark).toString();
		
		profileList.add(info);
		timestamp = timestampcurrent;
		if (immediateOutput) {
			output(info);
		}
	}
	
	public void output(String info) {
		switch (logLevel) {
		case LOG_LEVEL_DEBUG:
			logger.debug(info);
			break;
		case LOG_LEVEL_INFO:
			logger.info(info);
			break;
		case LOG_LEVEL_WARN:
			logger.warn(info);
			break;
		case LOG_LEVEL_ERROR:
			logger.error(info);
			break;
		default:
			logger.info(info);
			break;
		}
	}
	
	public void print() {
		Logger logger;
		if (customLog != null) {
			logger = customLog;
		} else {
			logger = LogFlow.logger;
		}
		for (String profile : profileList) {
			switch (logLevel) {
			case LOG_LEVEL_DEBUG:
				logger.debug(profile);
				break;
			case LOG_LEVEL_INFO:
				logger.info(profile);
				break;
			case LOG_LEVEL_WARN:
				logger.warn(profile);
				break;
			case LOG_LEVEL_ERROR:
				logger.error(profile);
				break;
			default:
				logger.info(profile);
				break;
			}
		}
	}
	
	private long currentTime() {
		if (timeUnit == TIME_UNIT_NS) {
			return System.nanoTime();
		} else {
			return System.currentTimeMillis();
		}
	}
	
	private String currentTimeUnit() {
		if (timeUnit == TIME_UNIT_NS) {
			return "ns";
		} else {
			return "ms";
		}
	}

	public boolean isImmediateOutput() {
		return immediateOutput;
	}
	public void setImmediateOutput(boolean immediateOutput) {
		this.immediateOutput = immediateOutput;
	}
}