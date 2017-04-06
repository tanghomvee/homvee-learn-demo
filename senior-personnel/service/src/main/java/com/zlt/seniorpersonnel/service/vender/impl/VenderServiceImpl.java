package com.zlt.seniorpersonnel.service.vender.impl;

import com.zlt.seniorpersonnel.dao.base.BaseDao;
import com.zlt.seniorpersonnel.dao.domain.Vender;
import com.zlt.seniorpersonnel.dao.vender.VenderDao;
import com.zlt.seniorpersonnel.service.base.impl.BaseServiceImpl;
import com.zlt.seniorpersonnel.service.vender.VenderService;
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
