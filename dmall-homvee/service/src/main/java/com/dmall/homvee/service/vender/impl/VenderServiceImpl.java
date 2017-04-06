package com.dmall.homvee.service.vender.impl;

import com.dmall.homvee.dao.base.BaseDao;
import com.dmall.homvee.dao.domain.Vender;
import com.dmall.homvee.dao.vender.VenderDao;
import com.dmall.homvee.service.base.impl.BaseServiceImpl;
import com.dmall.homvee.service.vender.VenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("venderService")
public class VenderServiceImpl extends BaseServiceImpl<Vender, Long> implements VenderService{
	@Autowired
	private VenderDao venderDao;
	@Override
	public BaseDao<Vender, Long> getBaseDao() {
		return venderDao;
	}
}
