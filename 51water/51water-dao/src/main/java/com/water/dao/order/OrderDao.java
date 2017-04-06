package com.water.dao.order;

import com.water.dao.base.BaseDao;
import com.water.dao.domain.Order;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.water.dao.order
 * @Description: TODO
 * @date:2015年12月09日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2015, DMall All Rights Reserved.
 */
@Repository
public interface OrderDao extends BaseDao<Order,Long> {
}
