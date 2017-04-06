package com.water.service.waterstation.impl;

import com.water.dao.base.BaseDao;
import com.water.dao.domain.WaterStation;
import com.water.dao.waterstation.WaterStationDao;
import com.water.service.waterstation.WaterStationService;
import com.water.service.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package: com.water.service.waterstation.impl
 * @Description: TODO
 * @date:2015年12月10日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2015, DMall All Rights Reserved.
 */
@Service("waterStationService")
public class WaterStationServiceImpl extends BaseServiceImpl<WaterStation,Long> implements WaterStationService {
    @Autowired
    private WaterStationDao waterStationDao;
    @Override
    public BaseDao<WaterStation, Long> getBaseDao() {
        return waterStationDao;
    }
}
