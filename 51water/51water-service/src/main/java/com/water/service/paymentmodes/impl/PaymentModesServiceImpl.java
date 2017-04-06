package com.water.service.paymentmodes.impl;

import com.water.dao.base.BaseDao;
import com.water.dao.domain.PaymentModes;
import com.water.dao.paymentmodes.PaymentModesDao;
import com.water.service.base.impl.BaseServiceImpl;
import com.water.service.paymentmodes.PaymentModesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package: com.water.service.paymentmodes.impl
 * @Description: TODO
 * @date:2015年12月10日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2015, DMall All Rights Reserved.
 */
@Service
public class PaymentModesServiceImpl extends BaseServiceImpl<PaymentModes,Long> implements PaymentModesService {
    @Autowired
    private PaymentModesDao paymentModesDao;
    @Override
    public BaseDao<PaymentModes, Long> getBaseDao() {
        return paymentModesDao;
    }

}
