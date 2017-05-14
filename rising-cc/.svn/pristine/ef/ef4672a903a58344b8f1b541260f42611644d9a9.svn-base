package com.rising.cc.service.interf.project;

import java.util.List;
import java.util.Map;

import com.rising.cc.pojo.command.project.UpdateEnginConfigInfoCommand;
import com.rising.cc.pojo.dto.project.EnginConfigInfoDto;
import com.rising.cc.pojo.qo.project.EnginConfigInfoQo;
import com.rising.cc.pojo.qo.project.ReadPropertiesInfoQo;


/**
 * 
 * @description 工程配置信息Service
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月28日 上午10:26:58
 *
 */
public interface EnginConfigInfoService {

	/**
	 * 
	 * @description 根据EnginConfigInfoQo返回环境配置信息列表
	 * @author caoy
	 * @date 2015年9月2日 上午9:56:03
	 * @param qo
	 * @return
	 */
	public List<EnginConfigInfoDto> findEnginConfigInfoListByQo(EnginConfigInfoQo qo);
	
	/**
	 * 
	 * @description 读取环境配置信息
	 * @author caoy
	 * @date 2015年9月2日 上午9:56:28
	 * @param qo
	 * @return 返回key，value
	 */
	public Map<String, Object> findPropertiesConfigDataMapByQo(ReadPropertiesInfoQo qo) ;

	/**
	 * 
	 * @description 修改环境配置信息
	 * @author caoy
	 * @date 2015年9月2日 上午9:56:50
	 * @param command
	 * @return
	 */
	public boolean updateEnginConfigInfo(UpdateEnginConfigInfoCommand command);
	
}
