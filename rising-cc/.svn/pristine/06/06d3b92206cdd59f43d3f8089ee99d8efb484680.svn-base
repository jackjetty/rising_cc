package com.rising.cc.service.impl.basicdata;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rising.common.page.Pagination;
import com.rising.cc.dao.basicdata.DubboDao;
import com.rising.cc.model.basicdata.SysDubboInfo;
import com.rising.cc.pojo.command.basicdata.dubbo.CreateDubboCommand;
import com.rising.cc.pojo.command.basicdata.dubbo.DeleteDubboCommand;
import com.rising.cc.pojo.command.basicdata.dubbo.UpdateDubboCommand;
import com.rising.cc.service.interf.basicdata.DubboService;

@Service
public class DubboServiceImpl implements DubboService {

	@Resource
	private DubboDao dubboDao;
	
	public Pagination findDubboInfoListByPagination(Pagination pagination) {
		pagination.setList(this.dubboDao.queryPagination(pagination));
		pagination.setTotalCount(this.dubboDao.countPagination(pagination));
		pagination.adjustPageNo();
		return pagination;
	}

	@Transactional
	public boolean saveDubbo(CreateDubboCommand command) {
		SysDubboInfo dubbo = new SysDubboInfo();
		dubbo.createDubbo(command);
		dubboDao.insertDubbo(dubbo);
		return true;
	}

	@Transactional
	public boolean updateDubbo(UpdateDubboCommand command) {
		SysDubboInfo dubbo = new SysDubboInfo();
		dubbo.updateDubbo(command);
		dubboDao.updateDubbo(dubbo);
		return true;
	}

	@Transactional
	public boolean deleteCommand(DeleteDubboCommand command) {
		dubboDao.updateDubboStatusByIds(command.getStatus(), command.getIds());
		return true;
	}

}
