package com.water.service.delivery.impl;

import com.water.dao.base.BaseDao;
import com.water.dao.delivery.DeliveryCfgDao;
import com.water.dao.domain.DeliveryCfg;
import com.water.service.base.impl.BaseServiceImpl;
import com.water.service.delivery.DeliveryServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package: com.water.service.delivery.impl
 * @Description: TODO
 * @date:2015年12月10日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2015, DMall All Rights Reserved.
 */
@Service("deliveryServcie")
public class DeliveryServiceImpl extends BaseServiceImpl<DeliveryCfg,Long> implements DeliveryServcie {
    @Autowired
    private DeliveryCfgDao deliveryCfgDao;
    @Override
    public BaseDao<DeliveryCfg, Long> getBaseDao() {
        return this.deliveryCfgDao;
    }
}
