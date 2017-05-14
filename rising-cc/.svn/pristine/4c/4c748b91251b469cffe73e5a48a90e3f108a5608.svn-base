package com.rising.cc.pojo.constants.log;

import com.rising.cc.util.PropertiesUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/10/29 16:14
 * 修改人：caizh
 * 修改时间：2015/10/29 16:14
 * 修改备注：
 */
public class LogContants {
    private static Properties intf = PropertiesUtil.getProp("/interface.properties");

    private static final String PROJECT = intf.getProperty("log.project");
    private static final String NAMESPACE = intf.getProperty("log.namespace");
    private static final String FIND_LOG = intf.getProperty("log.method.searchLog");
    private static final String COUNT_LOG = intf.getProperty("log.method.countLog");
    public static final String SEARCH_LOG = "/"+PROJECT+"/"+NAMESPACE+"/"+FIND_LOG;
    public static final String COUNT = "/"+PROJECT+"/"+NAMESPACE+"/"+COUNT_LOG;

    public static final String CREATE_LOG_TABLE = intf.getProperty("logTable.method.addTable");
    public static final String  ADD_TABLE = "/"+PROJECT+"/"+CREATE_LOG_TABLE;
    public static final String REMOVE_LOG_TABLE = intf.getProperty("logTable.method.removeTable");
    public static final String  REMOVE_TABLE = "/"+PROJECT+"/"+REMOVE_LOG_TABLE;

    public final static int ENV_TYPE_DEVELOP = 1;
    public final static int ENV_TYPE_DEVELOP_TEST = 2;
    public final static int ENV_TYPE_FORMAL = 5;
    public final static Map<String,String> LOG_FIELD_MAP = new HashMap<String, String>();



    public final static Map<Integer,String> LOG_URL_MAP = new HashMap<Integer,String>();
    static{
        LOG_URL_MAP.put(ENV_TYPE_DEVELOP,"http://localhost:8082");
        LOG_URL_MAP.put(ENV_TYPE_FORMAL,"http://121.41.93.171:58086");
        LOG_URL_MAP.put(ENV_TYPE_DEVELOP_TEST,"http://192.168.1.211:8888");


        LOG_FIELD_MAP.put("0","String");
        LOG_FIELD_MAP.put("1","Date");
        LOG_FIELD_MAP.put("2","int");
    }
}
