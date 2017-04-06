package com.homvee.dao;

import com.homvee.dao.base.BaseDao;
import com.homvee.dao.domain.Usr;
import org.springframework.stereotype.Repository;

@Repository("usrDao")
public interface UsrDao extends BaseDao<Usr, Long> {

}
