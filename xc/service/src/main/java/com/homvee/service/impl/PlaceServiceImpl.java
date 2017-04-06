package com.homvee.service.impl;

import com.google.common.collect.Maps;
import com.homvee.dao.PlaceDao;
import com.homvee.dao.base.BaseDao;
import com.homvee.dao.domain.Place;
import com.homvee.service.base.impl.BaseServiceImpl;
import com.homvee.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Package: com.homvee.service.impl
 * @Description:
 * @date:2016/11/2
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
@Service("placeService")
public class PlaceServiceImpl extends BaseServiceImpl<Place,Long> implements PlaceService {
    @Autowired
    private PlaceDao placeDao;
    @Override
    public BaseDao<Place, Long> getBaseDao() {
        return placeDao;
    }

    @Override
    public List<Map<String, Object>> queryPlaceNameByUsrIds(Long... usrIds) {
        return placeDao.queryPlaceNameByUsrIds(usrIds);
    }

    @Transactional(rollbackFor = {Exception.class})
    public int addUsrPlace(Long usrId, Long[] placeIds) {
        int rs = 0;
        Map<String,Long> params = Maps.newHashMap();
        params.put("usrId",usrId);
        for (Long placeId : placeIds){
            params.put("placeId",placeId);
            rs = placeDao.addUsrPlace(params);
            if(rs < 1){
                LOGGER.error("用户[{}]增加宣传点[{}]失败",usrId,placeId);
            }
        }
        return rs;
    }

    @Override
    public int delUsrPlaceByPlaceIds(Long... placeIds) {
        return placeDao.delUsrPlaceByPlaceIds(placeIds);
    }

    @Override
    public int delUsrPlaceByUsrIds(Long... usrIds) {
        return placeDao.delUsrPlaceByUsrIds(usrIds);
    }
}
