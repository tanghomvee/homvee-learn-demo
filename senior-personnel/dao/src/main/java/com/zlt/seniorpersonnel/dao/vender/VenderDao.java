package com.zlt.seniorpersonnel.dao.vender;

import com.zlt.seniorpersonnel.dao.base.BaseDao;
import org.springframework.stereotype.Repository;

import com.zlt.seniorpersonnel.dao.domain.Vender;
@Repository("venderDao")
public interface VenderDao extends BaseDao<Vender, Long> {

}
