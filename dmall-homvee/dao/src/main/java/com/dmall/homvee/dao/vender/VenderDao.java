package com.dmall.homvee.dao.vender;

import org.springframework.stereotype.Repository;

import com.dmall.homvee.dao.base.BaseDao;
import com.dmall.homvee.dao.domain.Vender;
@Repository("venderDao")
public interface VenderDao extends BaseDao<Vender, Long> {

}
