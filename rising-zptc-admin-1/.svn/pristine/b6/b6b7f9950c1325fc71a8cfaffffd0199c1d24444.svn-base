package com.bhyf.service.impl.recharge;

import com.bhyf.dao.recharge.RechargeMoneyDao;
import com.bhyf.model.recharge.RechargeMoney;
import com.bhyf.pojo.command.recharge.CreateRechargeMoneyCommand;
import com.bhyf.pojo.command.recharge.UpdateRechargeMoneyStatusCommand;
import com.bhyf.pojo.dto.recharge.RechargeMoneyDto;
import com.bhyf.service.interf.recharge.RechargeMoneyService;
import com.bhyf.util.EntityConvertUtils;
import com.rising.common.page.Pagination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2016/4/13.
 */
@Service
public class RechargeMoneyServiceImpl implements RechargeMoneyService {

    @Resource
    private RechargeMoneyDao rechargeMoneyDao;

    @Override
    public List<RechargeMoneyDto> findRechargeMoney(){
        List<RechargeMoney> rechargeMoneyList = rechargeMoneyDao.findAllRechargeMoney();
        List<RechargeMoneyDto> rechargeMoneyDtoList = EntityConvertUtils.convertEntityToDtoList(rechargeMoneyList,RechargeMoneyDto.class);
        return rechargeMoneyDtoList;
    }

    @Override
    @Transactional
    public String saveRechargeMoney(CreateRechargeMoneyCommand command) {
        RechargeMoney rechargeMoney = new RechargeMoney();
        if(rechargeMoney.create(command)){
            rechargeMoneyDao.saveRechargeMoney(rechargeMoney);
            return "success";
        }
        return "error";
    }

    @Override
    @Transactional
    public String updateRechargeMoneyStatus(UpdateRechargeMoneyStatusCommand command) {
        RechargeMoney rechargeMoney = new RechargeMoney();
        if(rechargeMoney.updateStatus(command)){
            rechargeMoneyDao.updateRechargeMoneyStatus(rechargeMoney);
            return "success";
        }
        return "error";
    }
}
