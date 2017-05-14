package com.rising.cc.service.impl.log;

import static com.rising.cc.pojo.constants.log.LogContants.ENV_TYPE_DEVELOP;
import static com.rising.cc.pojo.constants.log.LogContants.ENV_TYPE_DEVELOP_TEST;
import static com.rising.cc.pojo.constants.log.LogContants.ENV_TYPE_FORMAL;
import static com.rising.cc.pojo.constants.log.LogContants.LOG_FIELD_MAP;
import static com.rising.cc.pojo.constants.log.LogContants.LOG_URL_MAP;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.rising.cc.dao.log.LogDBDao;
import com.rising.cc.dao.log.LogTableDao;
import com.rising.cc.model.log.LogDB;
import com.rising.cc.model.log.LogField;
import com.rising.cc.model.log.LogTable;
import com.rising.cc.pojo.command.log.CopyLogTableToEnvirCommand;
import com.rising.cc.pojo.command.log.CreateLogFieldCommand;
import com.rising.cc.pojo.command.log.CreateLogServiceTableCommand;
import com.rising.cc.pojo.command.log.CreateLogTableCommand;
import com.rising.cc.pojo.command.log.RemoveLogFieldCommand;
import com.rising.cc.pojo.command.log.RemoveLogTableCommand;
import com.rising.cc.pojo.constants.log.LogContants;
import com.rising.cc.pojo.dto.log.LogFieldDto;
import com.rising.cc.pojo.dto.log.LogTableDto;
import com.rising.cc.pojo.qo.log.LogTableQo;
import com.rising.cc.service.interf.log.LogTableService;
import com.rising.cc.util.EntityConvertUtils;
import com.rising.common.model.HttpResponse;
import com.rising.common.page.Pagination;
import com.rising.common.util.HttpUtil;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/8/3 14:24
 * 修改人：caizh
 * 修改时间：2015/8/3 14:24
 * 修改备注：
 */
@Service
public class LogTableServiceImpl implements LogTableService{

    @Resource
    private LogTableDao logTableDao;
    @Resource
    private LogDBDao logDBDao;

    @Transactional
    public String saveLogTable(CreateLogTableCommand command){
        LogTable logTable = new LogTable();
        if(!logTable.createLogTable(command)){
            return "param is error";
        }
        logTableDao.saveLogTable(logTable);
        return "success";
    }

    @Transactional
    public String removeLogTable(RemoveLogTableCommand command){
        LogTable logTable = logTableDao.findLogTableAndFieldById(command.getId());
        logTable.removeLogTable();
        if(logTable.getIsSync()){
            String result = removeLogServiceTable(command);
            if("success".equals(result)){
                 logTableDao.removeLogTable(logTable);
                return "success";
            }else{
                return result;
            }
        }else{
            logTableDao.removeLogTable(logTable);
            return "success";
        }
    }
    @Transactional
    public String saveLogField(CreateLogFieldCommand command){
        LogField logField = new LogField();
        if(!logField.createLogField(command)){
            return "param is error";
        }
         logTableDao.saveLogField(logField);
        return "success";
    }

    @Transactional
    public String removeLogField(RemoveLogFieldCommand command){
        LogField logField = new LogField();
        if(!logField.removeLogField(command)){
            return "param is error";
        }
        logTableDao.removeLogField(logField);
        return "success";
    }

    public String copyLogTableToEnvir(CopyLogTableToEnvirCommand command){
        boolean dbFlag = false;
        LogTable logTable = logTableDao.findLogTableAndFieldById(command.getId());
        if(logTable == null){
            return "logTable is inexistence";
        }
        List<LogDB> logDBList = logDBDao.findLogDBByEnvirId(command.getEnvirId());
        for (LogDB logDB : logDBList) {
            if(logDB.getDbName().equals(logTable.getLogDB().getDbName())){
                logTable.setLogDB(logDB);
                dbFlag = true;
                break;
            }
        }
        if(!dbFlag){
            return "logDB is inexistence";
        }
        if(!logTable.updateEnvir(command)){
            return "param is error";
        }
        logTableDao.saveLogTable(logTable);
        return "success";
    }


    public String createLogServiceTable(CreateLogServiceTableCommand command){
        String url = "";
        LogTable logTable = logTableDao.findLogTableAndFieldById(command.getId());
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
        url+=LogContants.ADD_TABLE;
        JSONObject configObject = new JSONObject();
        configObject.put("dbName",logTable.getLogDB().getDbName());
        configObject.put("tableName",logTable.getTableName());
        JSONArray array = new JSONArray();
        JSONObject object;
        for(LogField logField:logTable.getFieldList()){
            object = new JSONObject();
            object.put("tableName",logTable.getTableName());
            object.put("type", LOG_FIELD_MAP.get(logField.getType()));
            object.put("fieldName",logField.getFieldName());
            array.add(object);
        }
        Map<String,String> params = Maps.newHashMap();
        params.put("config",configObject.toJSONString());
        params.put("tables",array.toJSONString());
        HttpResponse httpResponse = HttpUtil.executePostMethod(url, params, 60000);
        if("success".equals(httpResponse.getResult())){
            logTable.setIsSync(true);
            logTableDao.syncLogTable(logTable);
        }
        return httpResponse.getResult();
    }
    private String removeLogServiceTable(RemoveLogTableCommand command){
        String url = "";
        LogTable logTable = logTableDao.findLogTableAndFieldById(command.getId());
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
        url+=LogContants.REMOVE_TABLE;
        JSONObject configObject = new JSONObject();
        configObject.put("dbName",logTable.getLogDB().getDbName());
        configObject.put("tableName",logTable.getTableName());
        Map<String,String> params = Maps.newHashMap();
        params.put("config",configObject.toJSONString());
        HttpResponse httpResponse = HttpUtil.executePostMethod(url, params, 60000);
        return httpResponse.getResult();
    }

    
    @Override
    public Pagination findLogTableByPagination(Pagination pagination) {
        List<LogTableDto> logTableDtoList = Lists.newArrayList();
        List<LogTable> logTableList = logTableDao.findLogTableByPagination(pagination);
        Integer totalCount = logTableDao.countLogTableByPagination(pagination);
        try{
            logTableDtoList = EntityConvertUtils.convertEntityToDtoList(logTableList,LogTableDto.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        for (int i=0;i<logTableList.size();i++) {
            LogTableDto logTableDto = logTableDtoList.get(i);
            LogTable logTable = logTableList.get(i);
            logTableDto.setLogDBId(logTable.getLogDB().getId());
        }
        pagination.setList(logTableDtoList);
        pagination.setTotalCount(totalCount);
        return pagination;
    }

    @Override
    public List<LogTableDto> findLogTableByQo(LogTableQo qo) {
        List<LogTableDto> logTableDtoList = Lists.newArrayList();
        List<LogTable> logTableList = logTableDao.findlogTableByQo(qo);
        try{
            logTableDtoList = EntityConvertUtils.convertEntityToDtoList(logTableList,LogTableDto.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return logTableDtoList;
    }

    @Override
    public LogTableDto findLogTableAndFieldById(Integer id) {
        LogTable logTable = logTableDao.findLogTableAndFieldById(id);
        LogTableDto logTableDto = new LogTableDto();
        logTableDto.createLogTableAndField(logTable);
        return logTableDto;
    }

    @Override
    public Pagination findLogTableFieldByPagination(Pagination pagination) {
        List<LogFieldDto> logFieldDtoList = Lists.newArrayList();
        List<LogField> logFieldList = logTableDao.findLogTableFieldByPagination(pagination);
        Integer totalCount = logTableDao.countLogTableFieldByPagination(pagination);
        try{
            logFieldDtoList = EntityConvertUtils.convertEntityToDtoList(logFieldList,LogFieldDto.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        pagination.setList(logFieldDtoList);
        pagination.setTotalCount(totalCount);
        return pagination;
    }

}
