package com.rising.cc.service.impl.log;

import static com.rising.cc.pojo.constants.log.LogContants.ENV_TYPE_DEVELOP;
import static com.rising.cc.pojo.constants.log.LogContants.ENV_TYPE_DEVELOP_TEST;
import static com.rising.cc.pojo.constants.log.LogContants.ENV_TYPE_FORMAL;
import static com.rising.cc.pojo.constants.log.LogContants.LOG_URL_MAP;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.rising.cc.dao.log.LogTableDao;
import com.rising.cc.model.log.LogTable;
import com.rising.cc.pojo.constants.log.LogContants;
import com.rising.cc.pojo.dto.log.LogFieldDto;
import com.rising.cc.pojo.qo.log.LogQo;
import com.rising.cc.service.interf.log.LogService;
import com.rising.common.component.PaginQo;
import com.rising.common.model.HttpResponse;
import com.rising.common.page.Pagination;
import com.rising.common.util.HttpUtil;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/8/4 9:06
 * 修改人：caizh
 * 修改时间：2015/8/4 9:06
 * 修改备注：
 */
@Service("LogService")
public class LogServiceImpl implements LogService{



    @Resource
    private LogTableDao logTableDao;

    public Pagination findLog(JSONObject qo,PaginQo paginQo,Integer tableId) {
        Pagination pagination = new Pagination();
        //TODO 从基础服务获取日志服务器url及config
        String url = "";
        Map<String,String> params = Maps.newHashMap();
        LogTable logTable = logTableDao.findLogTableAndFieldById(tableId);
        if(logTable == null){
             return null;
        }
        switch (logTable.getEnvirId()){
            case LogContants.ENV_TYPE_DEVELOP:
                url = LOG_URL_MAP.get(ENV_TYPE_DEVELOP);
                break;
            case LogContants.ENV_TYPE_FORMAL:
                url = LOG_URL_MAP.get(ENV_TYPE_FORMAL);
                break;
            case LogContants.ENV_TYPE_DEVELOP_TEST:
                url = LOG_URL_MAP.get(ENV_TYPE_DEVELOP_TEST);
                break;
        }
        url+=LogContants.SEARCH_LOG;
        JSONObject configObject = new JSONObject();
        configObject.put("dbName",logTable.getLogDB().getDbName());
        configObject.put("tableName",logTable.getTableName());
        params.put("config",configObject.toJSONString());
        JSONObject page = new JSONObject();
        page.put("skip",(paginQo.getPageNo()-1)*paginQo.getPageSize());
        page.put("limit",paginQo.getPageSize());
        params.put("page",page.toJSONString());
        params.put("qo",qo.toJSONString());
        HttpResponse httpResponse = HttpUtil.executePostMethod(url, params, 60000);
        JSONObject returnData;
        try{
            returnData = JSON.parseObject(httpResponse.getResult());
        }catch (Exception e){
            returnData = new JSONObject();
            returnData.put("totalCount","0");
        }
        List list = (List) returnData.get("list");
        pagination.setList(list);
        pagination.setPageNo(paginQo.getPageNo());
        pagination.setPageSize(paginQo.getPageSize());
        pagination.setTotalCount(Integer.parseInt(returnData.get("totalCount").toString()));
        return pagination;
    }

    @Override
    public Integer countLog(JSONObject qo, Integer tableId) {
        //TODO 从基础服务获取日志服务器url及config
        String url = "";
        Map<String,String> params = Maps.newHashMap();
        LogTable logTable = logTableDao.findLogTableAndFieldById(tableId);
        if(logTable == null){
            return 0;
        }
        switch (logTable.getEnvirId()){
            case LogContants.ENV_TYPE_DEVELOP:
                url = LOG_URL_MAP.get(ENV_TYPE_DEVELOP);
                break;
            case LogContants.ENV_TYPE_FORMAL:
                url = LOG_URL_MAP.get(ENV_TYPE_FORMAL);
                break;
            case LogContants.ENV_TYPE_DEVELOP_TEST:
                url = LOG_URL_MAP.get(ENV_TYPE_DEVELOP_TEST);
                break;
        }
        url+=LogContants.COUNT;
        JSONObject configObject = new JSONObject();
        configObject.put("dbName",logTable.getLogDB().getDbName());
        configObject.put("tableName",logTable.getTableName());
        params.put("config",configObject.toJSONString());
        params.put("qo",qo.toJSONString());
        HttpResponse httpResponse = HttpUtil.executePostMethod(url, params, 60000);
        String result = httpResponse.getResult();
        if(StringUtils.isNotBlank(result)){
            return Integer.valueOf(result);
        }else{
            return 0;
        }
    }

    public JSONObject analyseLogQo(LogQo qo, List<LogFieldDto> logFieldDtoList) {
        JSONObject object = new JSONObject();
        JSONArray array = JSON.parseArray(qo.getQos());
        for(int i = 0;i < array.size();i++){
            LogFieldDto logFieldDto = logFieldDtoList.get(i);
            if(StringUtils.isNotBlank(array.get(i).toString())){
                object.put(logFieldDto.getFieldName(),array.get(i).toString());
            }
        }
        return object;
    }

    public static void main(String[] args) {

        //http://localhost:8082/log?config={%22dbName%22:%22test%22,%22tableName%22:%22test%22}&data={%22testString%22:%22%E6%B5%8B%E8%AF%95%E6%95%B0%E6%8D%AE03%22,%22testDate%22:%222015-11-03%2000:00:00%22,%22testInt%22:%2222%22}

        //TODO 从基础服务获取日志服务器url及config
        String url = "http://localhost:8082/search/count_log";
        Map<String,String> params = Maps.newHashMap();
        String config = "{dbName:\"test\",tableName:\"test\"}";
        String page = "{skip:0,limit:1}";
        params.put("config",config);
        JSONObject object = new JSONObject();
        object.put("testString","测试数据04");
        object.put("testInt","04");
        object.put("testDate","2015-11-01 00:00:00");
        params.put("data",object.toJSONString());
        HttpResponse httpResponse = HttpUtil.executePostMethod(url, params, 60000);
        System.out.println(httpResponse.getResult());
    }
}
