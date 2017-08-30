package com.bhyf.service.impl.enter;

import com.bhyf.dao.enter.EnterRecordDao;
import com.bhyf.dao.enter.EnterStatisticsDao;
import com.bhyf.model.enter.EnterRecord;
import com.bhyf.model.enter.EnterStatistics;
import com.bhyf.pojo.command.enter.CreateEnterCommand;
import com.bhyf.pojo.command.enter.RemoveEnterCommand;
import com.bhyf.pojo.command.enter.UpdateEnterCommand;
import com.bhyf.pojo.command.enter.UpdateEnterStatusCommand;
import com.bhyf.pojo.qo.enter.EnterRecordQo;
import com.rising.common.page.Pagination;
import com.bhyf.dao.enter.EnterDao;
import com.bhyf.model.enter.Enter;
import com.bhyf.pojo.dto.enter.EnterDto;
import com.bhyf.service.interf.enter.EnterService;
import com.bhyf.util.EntityConvertUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2016/4/11.
 */
@Service()
public class EnterServiceImpl implements EnterService{

    @Resource
    private EnterDao enterDao;

    @Resource
    private EnterStatisticsDao enterStatisticsDao;

    @Resource
    private EnterRecordDao enterRecordDao;

    @Override
    public Pagination findEnterByPagination(Pagination pagination) {

        List<Enter> enterList = enterDao.findEnterByPagination(pagination);
        Integer totalCount = enterDao.countEnterByPagination(pagination);

        List<EnterDto>  enterDtoList = EntityConvertUtils.convertEntityToDtoList(enterList,EnterDto.class);
        pagination.setList(enterDtoList);
        pagination.setTotalCount(totalCount);
        return pagination;
    }

    @Override
    @Transactional
    public String saveEnter(CreateEnterCommand command) {


        Enter enter = new Enter();
        if(enter.create(command)){
            enterDao.saveEnter(enter);
        }
        //向报名统计添加一条记录
        EnterStatistics enterStatistics = new EnterStatistics();
        enterStatistics.setEnter(enter);
        enterStatisticsDao.saveEnterStatistics(enterStatistics);

        return "success";
    }

    @Override
    @Transactional
    public String updateEnter(UpdateEnterCommand command) {
        Enter enter = new Enter();
        if(enter.update(command)){
            enterDao.updateEnter(enter);
            return "success";
        }
        return "error";
    }

    @Override
    @Transactional
    public String updateEnterStatus(UpdateEnterStatusCommand command) {
        Enter enter = new Enter();
        if(enter.updateStatus(command)){
            enterDao.updateEnter(enter);
            return "success";
        }
        return "error";
    }

    @Override
    public String removeEnter(RemoveEnterCommand command) {
        EnterRecordQo qo = new EnterRecordQo();
        qo.setEnterId(command.getId());
        List<EnterRecord> enterRecordList = enterRecordDao.findEnterRecordByQo(qo);
        if(enterRecordList == null || enterRecordList.size() == 0){
            Enter enter = new Enter();
            enter.remove(command);
            enterDao.updateEnter(enter);
            return "删除成功";
        }
        return "该报名栏已有报名记录无法删除";
    }

    @Override
    public List<Enter> findEnterByloseTime(Date beginTime, Date endTime) {
        return enterDao.findEnterByLoseTime(beginTime,endTime);
    }


}
