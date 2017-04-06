package com.zlt.seniorpersonnel.service.rpc.impl;

import com.zlt.seniorpersonnel.service.base.impl.BaseService4RpcImpl;
import org.springframework.stereotype.Service;

import com.zlt.seniorpersonnel.service.rpc.DubboService;
@Service("dubboService")
public class DubboServiceImpl extends BaseService4RpcImpl implements DubboService {

	@Override
	public String sayDubbo(String usrName) {
		return "Dubbo Say Hi to "+usrName;
	}

}
