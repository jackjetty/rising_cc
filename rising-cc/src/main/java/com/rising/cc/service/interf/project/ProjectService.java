package com.rising.cc.service.interf.project;

import java.util.List;

import com.rising.common.page.Pagination;
import com.rising.cc.pojo.command.project.CreateProjectCommand;
import com.rising.cc.pojo.command.project.DeleteProjectCommand;
import com.rising.cc.pojo.command.project.UpdateProjectCommand;
import com.rising.cc.pojo.dto.project.ProjectDto;
import com.rising.cc.pojo.qo.project.ProjectQo;


/**
 * 
 * @description 工程配置信息
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月28日 上午10:26:58
 *
 */
public interface ProjectService {

	public Pagination findProjectListByPagination(Pagination pagination);
	
	public boolean saveProject(CreateProjectCommand addCommand);
	
	public boolean updateProject(UpdateProjectCommand updateCommand);
	
	public boolean deleteProject(DeleteProjectCommand deleteCommand);
	
	public List<ProjectDto> findProjectListByQo(ProjectQo qo);
	
}
