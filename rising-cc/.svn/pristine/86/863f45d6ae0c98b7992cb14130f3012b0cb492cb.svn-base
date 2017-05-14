package com.rising.cc.service.impl.project;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rising.common.page.Pagination;
import com.rising.cc.dao.project.EnginConfigInfoDao;
import com.rising.cc.dao.project.EnginConfigTypeDao;
import com.rising.cc.dao.project.EngineeringDao;
import com.rising.cc.dao.project.ProjectDao;
import com.rising.cc.model.project.Project;
import com.rising.cc.pojo.command.project.CreateProjectCommand;
import com.rising.cc.pojo.command.project.DeleteProjectCommand;
import com.rising.cc.pojo.command.project.UpdateProjectCommand;
import com.rising.cc.pojo.dto.project.ProjectDto;
import com.rising.cc.pojo.qo.project.ProjectQo;
import com.rising.cc.service.interf.project.ProjectService;


/**
 * 
 * @description 工程配置信息
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月28日 上午10:26:58
 *
 */
@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Resource
	private ProjectDao projectDao;
	
	@Resource
	private EngineeringDao engineeringDao;
	
	@Resource
	private EnginConfigInfoDao enginConfigInfoDao;
	
	@Resource
	private EnginConfigTypeDao enginConfigTypeDao;

	public Pagination findProjectListByPagination(Pagination pagination) {
		
		List<Project> projectList = projectDao.findProjectListByPagination(pagination);
		List<ProjectDto> dtoList = new ArrayList<ProjectDto>();
		
		for (Project project : projectList) {
			ProjectDto dto = new ProjectDto();
			BeanUtils.copyProperties(project, dto);
			dtoList.add(dto);
		}
		
		pagination.setList(dtoList);
		pagination.setTotalCount(projectDao.countProjectListByPagination(pagination));
		
		return pagination;
	}

	@Transactional
	public boolean saveProject(CreateProjectCommand command) {
		Project project = new Project();
		project.createProject(command);
		
		
		ProjectQo qo = new ProjectQo();
		qo.setProjectCode(project.getProjectCode());
		List<Project> list = projectDao.findProjectListByQo(qo);
		
		if(list != null && list.size() > 0){
			return false;
		}
		
		projectDao.insertProject(project);
		
		return true;
	}

	@Transactional
	public boolean updateProject(UpdateProjectCommand command) {

		Project project = new Project();
		project.updateProject(command);
		
		ProjectQo qo = new ProjectQo();
		qo.setProjectCode(project.getProjectCode());
		List<Project> list = projectDao.findProjectListByQo(qo);
		
		if(list != null){
			for(Project p : list){
				if(p.getProjectCode().equals(project.getProjectCode()) 
						&& !p.getId().equals(project.getId())){
					return false;
				}
			}
		}
		
		projectDao.updateProject(project);
		
		return true;
	}

	@Transactional
	public boolean deleteProject(DeleteProjectCommand command) {
		
		enginConfigTypeDao.deleteEnginConfigTypeByProjectIds(command.getIds());
		enginConfigInfoDao.deleteEnginConfigInfoByProjectIds(command.getIds());
		engineeringDao.deleteEngineeringByProjectIds(command.getIds());
		projectDao.deleteBatchProject(command.getIds());
		
		return true;
	}

	public List<ProjectDto> findProjectListByQo(ProjectQo qo) {

		List<Project> projectList = projectDao.findProjectListByQo(qo);
		List<ProjectDto> dtoList = new ArrayList<ProjectDto>();
		
		for (Project project : projectList) {
			ProjectDto dto = new ProjectDto();
			BeanUtils.copyProperties(project, dto);
			dtoList.add(dto);
		}
		
		return dtoList;
	}

	
}
