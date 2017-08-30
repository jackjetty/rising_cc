package com.bhyf.dao.enter;

import com.rising.common.page.Pagination;
import com.bhyf.model.enter.Enter;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 *
 */
public interface EnterDao {

    public List<Enter> findEnterByPagination(Pagination pagination);
    public Integer countEnterByPagination(Pagination pagination);

    public Integer saveEnter(Enter enter);

    public Integer updateEnter(Enter enter);

    List<Enter> findEnterByLoseTime(@Param("beginTime") Date beginTime,@Param("endTime")  Date endTime);
}
