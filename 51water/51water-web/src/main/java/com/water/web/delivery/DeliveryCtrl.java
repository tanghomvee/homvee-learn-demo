package com.water.web.delivery;

import com.alibaba.druid.util.StringUtils;
import com.water.dao.domain.DeliveryCfg;
import com.water.dao.domain.Msg;
import com.water.service.delivery.DeliveryServcie;
import com.water.web.base.BaseCtrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Package: com.water.web.delivery
 * @Description: TODO
 * @date:2015年12月10日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2015, DMall All Rights Reserved.
 */
@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RequestMapping(path={"/delivery"})
public class DeliveryCtrl extends BaseCtrl {
    @Autowired
    private DeliveryServcie deliveryServcie;
    public Msg addDeliveryCfg(DeliveryCfg deliveryCfg){
        Msg msg= this.verifyDeliveryCfg(deliveryCfg);
        if(Msg.success().equals(msg.getCode())){
            return msg;
        }
        if(deliveryServcie.saveEntry(deliveryCfg) == 1){
            return  Msg.success();
        }
        return Msg.error("添加配送信息失败");
    }
    public Msg verifyDeliveryCfg(DeliveryCfg deliveryCfg){
         if(deliveryCfg == null){
             return Msg.error("配送信息不存在");
         }
        if (StringUtils.isEmpty(deliveryCfg.getDeliveryAddr())){
            return Msg.error("请填写配送地址");
        }
        if(StringUtils.isEmpty(deliveryCfg.getBrand())){
            return Msg.error("请填写水的品牌");
        }
        return Msg.success();

    }


}
