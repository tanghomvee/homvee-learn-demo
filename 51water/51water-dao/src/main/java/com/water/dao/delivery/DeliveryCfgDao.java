package com.water.dao.delivery;

import com.water.dao.base.BaseDao;
import com.water.dao.domain.DeliveryCfg;
import org.springframework.stereotype.Repository;

/**
 * @Package: com.water.dao.delivery
 * @Description: TODO
 * @date:2015年12月09日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2015, DMall All Rights Reserved.
 */
@Repository("deliveryCfgDao")
public interface DeliveryCfgDao extends BaseDao<DeliveryCfg,Long> {
}
