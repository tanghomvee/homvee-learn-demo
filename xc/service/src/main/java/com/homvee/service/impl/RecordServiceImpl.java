package com.homvee.service.impl;

import com.homvee.dao.RecordDao;
import com.homvee.dao.base.BaseDao;
import com.homvee.dao.domain.Record;
import com.homvee.service.RecordService;
import com.homvee.service.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package: com.homvee.service.impl
 * @Description:
 * @date:2016/11/2
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
@Service("recordService")
public class RecordServiceImpl extends BaseServiceImpl<Record,Long> implements RecordService {
    @Autowired
    private RecordDao recordDao;
    @Override
    public BaseDao<Record, Long> getBaseDao() {
        return recordDao;
    }
}
