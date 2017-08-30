package com.bhyf.service.interf.app;

import java.util.HashMap;

import com.bhyf.pojo.command.app.CreateAppVersionCommand;
import com.bhyf.pojo.command.app.UpdateAppVersionCommand;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @description
 * @author pl
 * @createTime 2016年4月14日
 */
public interface AppVersionService {
	HashMap<String,Object> getAppVersionList(Integer pageIndex, Integer pageSize, String versionName,
			String category, String status);
	
	HashMap<String,Object> deleteAppversionsByIds(String ids);
	
	HashMap<String,Object> saveAppVersion(CreateAppVersionCommand command);


	HashMap<String, Object> updateAppVersion(UpdateAppVersionCommand command, MultipartFile app);
}
