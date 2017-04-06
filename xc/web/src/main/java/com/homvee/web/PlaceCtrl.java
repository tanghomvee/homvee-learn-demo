package com.homvee.web;

import com.homvee.dao.domain.Place;
import com.homvee.dao.domain.enums.OrderType;
import com.homvee.service.PlaceService;
import com.homvee.web.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Package: com.homvee.web
 * @Description:
 * @date:2016/11/2
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
@Controller
@RequestMapping(value = "/place")
public class PlaceCtrl extends BaseController {
    @Resource(name = "placeService")
    private PlaceService placeService;

    @RequestMapping(value = "/init", method = { RequestMethod.GET, RequestMethod.POST })
    public String init(){

        int k =1 /0;
        Place place = new Place();
        place.setPlaceName("中国四川乐山");
        int pk = placeService.saveEntry(place);
        System.out.println(pk);
        place.addOrderFieldAndType("place_name", OrderType.DESC);
        place.addOrderFieldAndType("id", OrderType.DESC);
        List<Place> places = placeService.queryEntryListByCondition(place);
        return "info";
    }
}
