package com.bhyf.service.impl.app;

import com.bhyf.dao.app.HelpDao;
import com.bhyf.model.app.Help;
import com.bhyf.pojo.command.app.CreateHelpCommand;
import com.bhyf.pojo.command.app.UpdateHelpCommand;
import com.bhyf.service.interf.app.HelpService;
import com.rising.common.page.Pagination;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2016/4/18.
 */
@Service
public class HelpServiceImpl implements HelpService {

    @Resource
    private HelpDao helpDao;
    @Override
    public Pagination findHelpByPagination(Pagination pagination) {
        List<Help> helpList = helpDao.findHelpByPagination(pagination);
        Integer total = helpDao.countHelpByPagination(pagination);
        pagination.setList(helpList);
        pagination.setTotalCount(total);
        return pagination;
    }

    @Override
    public String saveHelp(CreateHelpCommand command) {
        Help help = new Help();
        if(help.create(command)){
            helpDao.saveHelp(help);
            return "success";
        }

        return "参数错误";
    }

    @Override
    public String updateHelp(UpdateHelpCommand command) {
        Help help = new Help();
        if(help.update(command)){
            helpDao.updateHelp(help);
            return "success";
        }

        return "参数错误";
    }
}
