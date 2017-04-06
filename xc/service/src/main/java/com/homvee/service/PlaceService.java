package com.homvee.service;

import com.homvee.dao.domain.Place;
import com.homvee.service.base.BaseService;

import java.util.List;
import java.util.Map;

public interface PlaceService extends BaseService<Place, Long>{
    /**
     * 通过用户ID获取用户负责的站点名称
     * @param usrIds
     * @return
     */
    List<Map<String, Object>> queryPlaceNameByUsrIds(Long ...usrIds);

    /**
     * 增加用户和宣传点
     * @param usrId
     * @param placeIds
     * @return
     */
    int addUsrPlace(Long usrId,Long[] placeIds);

    /**
     * 通过宣传点ID删除数据
     * @param placeIds
     * @return
     */
    int delUsrPlaceByPlaceIds(Long ... placeIds);

    /**
     * 通过用户ID删除数据
     * @param usrIds
     * @return
     */
    int delUsrPlaceByUsrIds(Long ... usrIds);
}
