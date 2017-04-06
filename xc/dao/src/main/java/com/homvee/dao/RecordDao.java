package com.homvee.dao;

import com.homvee.dao.base.BaseDao;
import com.homvee.dao.domain.Record;
import org.springframework.stereotype.Repository;

@Repository("recordDao")
public interface RecordDao extends BaseDao<Record, Long> {

}
