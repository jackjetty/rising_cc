package com.bhyf.service.interf.enter;

import com.bhyf.pojo.command.enter.CreateEnterCommand;
import com.bhyf.pojo.command.enter.RemoveEnterCommand;
import com.bhyf.pojo.command.enter.UpdateEnterCommand;
import com.bhyf.pojo.command.enter.UpdateEnterStatusCommand;
import com.rising.common.page.Pagination;
import com.bhyf.model.enter.Enter;

import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2016/4/11.
 */
public interface EnterService {
    Pagination findEnterByPagination(Pagination pagination);

    String saveEnter(CreateEnterCommand command);

    String updateEnter(UpdateEnterCommand command);

    String updateEnterStatus(UpdateEnterStatusCommand command);

    String removeEnter(RemoveEnterCommand command);

    List<Enter> findEnterByloseTime(Date beginTime,Date endTime);

}
