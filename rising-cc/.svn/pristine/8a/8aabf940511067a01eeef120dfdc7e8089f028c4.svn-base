package com.rising.cc.service.impl.log;

import static com.rising.cc.pojo.constants.log.LogContants.ENV_TYPE_DEVELOP;
import static com.rising.cc.pojo.constants.log.LogContants.ENV_TYPE_DEVELOP_TEST;
import static com.rising.cc.pojo.constants.log.LogContants.ENV_TYPE_FORMAL;
import static com.rising.cc.pojo.constants.log.LogContants.LOG_URL_MAP;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.rising.cc.dao.log.LogDBDao;
import com.rising.cc.model.log.LogDB;
import com.rising.cc.pojo.command.log.CreateLogDBCommand;
import com.rising.cc.pojo.command.log.RemoveLogDBCommand;
import com.rising.cc.pojo.constants.log.LogContants;
import com.rising.cc.pojo.dto.log.LogDBDto;
import com.rising.cc.service.interf.log.LogDBService;
import com.rising.cc.util.EntityConvertUtils;
import com.rising.common.model.HttpResponse;
import com.rising.common.page.Pagination;
import com.rising.common.util.HttpUtil;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/10/22 14:43
 * 修改人：caizh
 * 修改时间：2015/10/22 14:43
 * 修改备注：
 */
@Service
public class LogDBServiceImpl implements LogDBService {
    @Resource
    private LogDBDao logDBDao;


    @Override
    public String saveLogDB(CreateLogDBCommand command) {
        LogDB logDB = new LogDB();
        if(logDB.saveLogDB(command)){
            if(saveRemoteLogDB(logDB)){
                logDBDao.saveLogDB(logDB);
                return "success";
            }else{
                return "remote save logDB error";
            }
        }else{
            return "error";
        }
    }

    @Override
    public String removeLogDB(RemoveLogDBCommand command) {
        LogDB logDB = new LogDB();
        if(logDB.removeLogDB(command)){
            if(removeRemoteLogDB(logDB)){
                logDBDao.removeLogDB(logDB);
                return "success";
            }else{
                return "remove remote logDB error";
            }
        }else{
            return "error";
        }
    }

    @Override
    public Pagination findLogDBByPagination(Pagination pagination) {
        List<LogDBDto> logDBDtoList = Lists.newArrayList();
        List<LogDB> logDBList = logDBDao.findLogDBByPagination(pagination);
        Integer totalCount = logDBDao.countLogDBByPagination(pagination);
        try{
            logDBDtoList = EntityConvertUtils.convertEntityToDtoList(logDBList, LogDBDto.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        pagination.setList(logDBDtoList);
        pagination.setTotalCount(totalCount);
        return pagination;
    }

    @Override
    public String findLogDBsByEnvirId(Integer envirId) {
        List<LogDB> logDBList = logDBDao.findLogDBByEnvirId(envirId);
        StringBuffer logDBs = new StringBuffer();
        for (LogDB logDB : logDBList) {
            logDBs.append(logDB.getId()).append(":").append(logDB.getName()).append(";");
        }
        if(logDBs.length()>0){
            return logDBs.substring(0,logDBs.length()-1);
        }
        return "";
    }


    private boolean saveRemoteLogDB(LogDB logDB){
        //TODO 获取远程接口地址
        String url = "";
        Map<String,String> params = Maps.newHashMap();
        switch (logDB.getEnvirId()){
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
        url+="/addDB";
        JSONObject configObject = new JSONObject();
        configObject.put("dbName",logDB.getDbName());
        params.put("config",configObject.toJSONString());
        HttpResponse httpResponse = HttpUtil.executePostMethod(url, params, 60000);
        if("success".equals(httpResponse.getResult())){
            return true;
        }
        return false;
    }


    private boolean removeRemoteLogDB(LogDB logDB){
        String url = "";
        Map<String,String> params = Maps.newHashMap();
        switch (logDB.getEnvirId()){
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
        url+="/removeDB";
        JSONObject configObject = new JSONObject();
        configObject.put("dbName",logDB.getDbName());
        params.put("config",configObject.toJSONString());
        HttpResponse httpResponse = HttpUtil.executePostMethod(url, params, 60000);
        if("success".equals(httpResponse.getResult())){
            return true;
        }
        return false;
    }
}
