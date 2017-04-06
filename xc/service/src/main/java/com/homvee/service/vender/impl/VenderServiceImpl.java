package com.homvee.service.vender.impl;

import com.homvee.dao.base.BaseDao;
import com.homvee.dao.domain.Vender;
import com.homvee.dao.vender.VenderDao;
import com.homvee.service.base.impl.BaseServiceImpl;
import com.homvee.service.vender.VenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("venderService")
public class VenderServiceImpl extends BaseServiceImpl<Vender, Long> implements VenderService {
	@Autowired
	private VenderDao venderDao;
	@Override
	public BaseDao<Vender, Long> getBaseDao() {
		return venderDao;
	}
}
