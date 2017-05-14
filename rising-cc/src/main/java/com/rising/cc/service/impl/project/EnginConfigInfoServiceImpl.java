package com.rising.cc.service.impl.project;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.rising.cc.dao.project.EnginConfigInfoDao;
import com.rising.cc.model.project.EnginConfigInfo;
import com.rising.cc.pojo.command.project.UpdateEnginConfigInfoCommand;
import com.rising.cc.pojo.dto.project.EnginConfigInfoDto;
import com.rising.cc.pojo.dto.project.EnginConfigTypeDto;
import com.rising.cc.pojo.dto.project.EngineeringDto;
import com.rising.cc.pojo.qo.project.EnginConfigInfoQo;
import com.rising.cc.pojo.qo.project.ReadPropertiesInfoQo;
import com.rising.cc.service.interf.project.EnginConfigInfoService;


/**
 * 
 * @description 工程配置信息
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月28日 上午10:26:58
 *
 */
@Service
public class EnginConfigInfoServiceImpl implements EnginConfigInfoService {
	
	@Resource
	private EnginConfigInfoDao enginConfigInfoDao;

	public List<EnginConfigInfoDto> findEnginConfigInfoListByQo(
			EnginConfigInfoQo qo) {

		List<EnginConfigInfo> configInfoList = enginConfigInfoDao.findEnginConfigInfoListByQo(qo);
		List<EnginConfigInfoDto> dtoList = new ArrayList<EnginConfigInfoDto>();
		
		for (EnginConfigInfo config : configInfoList) {
			EnginConfigInfoDto dto = new EnginConfigInfoDto();
			EngineeringDto enginDto = new EngineeringDto();
			EnginConfigTypeDto enginConfigTypeDto = new EnginConfigTypeDto();
			
			BeanUtils.copyProperties(config, dto);
			BeanUtils.copyProperties(config.getEngin(), enginDto);
			BeanUtils.copyProperties(config.getEnginConfigType(), enginConfigTypeDto);
			dto.setEnginDto(enginDto);
			dto.setEnginConfigTypeDto(enginConfigTypeDto);
			
			dtoList.add(dto);
		}
		
		return dtoList;
	}

	@Transactional
	public boolean updateEnginConfigInfo(UpdateEnginConfigInfoCommand command) {
		
		List<EnginConfigInfo> list = command.getUpdateEnginConfigList();
		
		enginConfigInfoDao.deleteEnginConfigInfoByEnginId(command.getEnginId());
		
		enginConfigInfoDao.insertBatchEnginConfigInfo(list);
			
		return true;
	}

	public Map<String, Object> findPropertiesConfigDataMapByQo(ReadPropertiesInfoQo qo) {
		List<EnginConfigInfo> list = enginConfigInfoDao.findEnginConfigInfoListByPropQo(qo);
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		
		Properties propertiesAll = new Properties(); 
		List<Map<String, String>> fileList = new ArrayList<Map<String, String>>();
		
		
		for(EnginConfigInfo e : list){
			String data = e.getData();
			if(e.getEnginConfigType().getFileName().contains(".properties")){
				try {
					Properties properties = new Properties(); 
					InputStream inStream= new ByteArrayInputStream(data.getBytes());
					// 生成properties对象  
					properties.load(inStream);
					
					propertiesAll.putAll(properties);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			Map<String, String> fileMap = new LinkedHashMap<String, String>();
			fileMap.put("fileName", e.getEnginConfigType().getFileName());
			fileMap.put("encoding", "UTF-8");
			fileMap.put("content", data);
			
			fileList.add(fileMap);
		}
		map.put("properties", propertiesAll);
		map.put("propertyFiles", fileList);
		
		return map;
	}
	
	
}
