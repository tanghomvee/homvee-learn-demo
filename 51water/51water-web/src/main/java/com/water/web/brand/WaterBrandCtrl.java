package com.water.web.brand;

import com.alibaba.druid.util.StringUtils;
import com.water.dao.domain.Msg;
import com.water.dao.domain.WaterBrand;
import com.water.service.waterbrand.WaterBrandService;
import com.water.web.base.BaseCtrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Package: com.water.web.brand
 * @Description: TODO
 * @date:2016年01月15日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RequestMapping(path={"brand"})
public class WaterBrandCtrl extends BaseCtrl {
    @Autowired
    private WaterBrandService waterBrandService;
    public Msg addWaterBrand(WaterBrand waterBrand){
        Msg msg = this.verifyWaterBrand(waterBrand);
        if(!Msg.success().getCode().equals(msg.getCode())){
            return msg;
        }
        if(waterBrandService.saveEntry(waterBrand) > 0){
            return Msg.success();
        }
        return Msg.error("添加品牌信息失败");
    }
    public Msg verifyWaterBrand(WaterBrand waterBrand){
        if(waterBrand == null){
            return Msg.error("错误的品牌信息");
        }
        if(StringUtils.isEmpty(waterBrand.getBrandName())){
            return Msg.error("请输入品牌名称");
        }
        if(waterBrand.getPrice() < 1){
            return Msg.error("请输入价格");
        }
        if(waterBrand.getStationId() < 1){
            return  Msg.error("请选择品牌所属的水站");
        }

        return Msg.success();
    }
}
