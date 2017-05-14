package com.rising.cc.service.interf.basicdata;

import com.rising.common.page.Pagination;
import com.rising.cc.pojo.command.basicdata.dubbo.CreateDubboCommand;
import com.rising.cc.pojo.command.basicdata.dubbo.DeleteDubboCommand;
import com.rising.cc.pojo.command.basicdata.dubbo.UpdateDubboCommand;

public interface DubboService {

	public Pagination findDubboInfoListByPagination(Pagination pagination);

	public boolean saveDubbo(CreateDubboCommand addCommand);

	public boolean updateDubbo(UpdateDubboCommand updateCommand);

	public boolean deleteCommand(DeleteDubboCommand deleteCommand);

}
