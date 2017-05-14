package com.rising.cc.dao.project;

import java.util.List;

import com.rising.common.page.Pagination;
import com.rising.cc.model.project.Project;
import com.rising.cc.pojo.qo.project.ProjectQo;

public interface ProjectDao {
	
	public List<Project> findProjectListByPagination(Pagination pagination);
	
	public Integer countProjectListByPagination(Pagination pagination);
	
	public Integer updateProject(Project project);
	
	public Integer deleteBatchProject(List<Integer> list);
	
	public Integer insertProject(Project project);

	public List<Project> findProjectListByQo(ProjectQo qo);
	
}
