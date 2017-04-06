package com.homvee.dao.vender;

import com.homvee.dao.base.BaseDao;
import org.springframework.stereotype.Repository;

import com.homvee.dao.domain.Vender;
@Repository("venderDao")
public interface VenderDao extends BaseDao<Vender, Long> {

}
