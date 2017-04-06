package com.homvee.dao;

import com.homvee.dao.base.BaseDao;
import com.homvee.dao.domain.Place;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("placeDao")
public interface PlaceDao extends BaseDao<Place, Long> {

    /**
     * 通过用户ID获取用户负责的站点名称
     * @param usrIds
     * @return
     */
    List<Map<String, Object>> queryPlaceNameByUsrIds(Long ...usrIds);

    /**
     * 增加用户和宣传点
     * @param uarPlaceIds
     * @return
     */
    int addUsrPlace(Map<String,Long> uarPlaceIds);

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
