package com.water.service.order.impl;

import com.water.dao.base.BaseDao;
import com.water.dao.domain.Order;
import com.water.dao.order.OrderDao;
import com.water.service.base.impl.BaseServiceImpl;
import com.water.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package: com.water.service.order.impl
 * @Description: TODO
 * @date:2015年12月10日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2015, DMall All Rights Reserved.
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<Order,Long> implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public BaseDao<Order, Long> getBaseDao() {
        return this.orderDao;
    }
}
