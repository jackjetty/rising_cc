package com.bhyf.service.interf.app;

import com.bhyf.pojo.command.app.CreateHelpCommand;
import com.bhyf.pojo.command.app.UpdateHelpCommand;
import com.rising.common.page.Pagination;

/**
 * Created by admin on 2016/4/18.
 */
public interface HelpService {
    Pagination findHelpByPagination(Pagination pagination);

    String saveHelp(CreateHelpCommand command);

    String updateHelp(UpdateHelpCommand command);
}
