package com.water.web.waterstation;

import com.water.dao.domain.Msg;
import com.water.dao.domain.WaterStation;
import com.water.service.waterstation.WaterStationService;
import com.water.web.base.BaseCtrl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Package: com.water.web.waterstation
 * @Description: TODO
 * @date:2015年12月10日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2015, DMall All Rights Reserved.
 */
@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RequestMapping(value={"/station"})
public class WaterStationCtrl extends BaseCtrl {
    @Autowired
    private WaterStationService waterStationService;
    @RequestMapping(value = {"/init"})
    public String init(){
        return "station/edit";
    }

    @RequestMapping(path={"/add"},method = {RequestMethod.POST})
    @ResponseBody
    public Msg addWaterStationInfo(WaterStation waterStation){
        Msg  msg = this.verifyWaterStation(waterStation);
        if(Msg.DEFAULT_CODE_ERROR.equals(msg.getCode())){
            return msg;
        }
        int flag = waterStationService.saveEntry(waterStation);
        if(flag != 1){
            return Msg.error("保存水站信息失败");
        }
        return Msg.success();
    }

    @RequestMapping(path={"/list"},method = {RequestMethod.POST})
    public Msg queryWaterStationInfoById(Long id){
        if(id == null || id < 0){
            return Msg.error("参数错误");
        }
        WaterStation ws = waterStationService.queryEntryByKey(id);
        if(ws == null){
            return Msg.error("该水站信息不存在");
        }
        return Msg.success(ws);
    }
    @RequestMapping(path={"/modify"},method = {RequestMethod.POST})
    @ResponseBody
    public Msg modfiyWaterStationInfoById(WaterStation waterStation){
        Msg  msg = this.verifyWaterStation(waterStation);
        if(Msg.DEFAULT_CODE_ERROR.equals(msg.getCode())){
            return msg;
        }
        int flag = waterStationService.modifyByKey(waterStation);
        if(flag != 1){
            return Msg.error("修改水站信息失败");
        }
        return Msg.success();
    }

    private Msg verifyWaterStation(WaterStation waterStation){
        if(waterStation == null){
            return Msg.error("数据传送对象不存在");
        }

        if(StringUtils.isEmpty(waterStation.getWaterStationName())){
            return Msg.error("水站名称错误");
        }
        if(StringUtils.isEmpty(waterStation.getWaterStationAddr())){
            return Msg.error("水站地址错误");
        }
        if(StringUtils.isEmpty(waterStation.getWaterStationMp()) || waterStation.getWaterStationMp().length() !=11){
            return Msg.error("水站手机号码错误");
        }
        return Msg.success();
    }
}
