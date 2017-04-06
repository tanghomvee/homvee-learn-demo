package com.dmall.homvee.service.rpc.impl;

import org.springframework.stereotype.Service;

import com.dmall.homvee.service.base.impl.BaseService4RpcImpl;
import com.dmall.homvee.service.rpc.DubboService;
@Service("dubboService")
public class DubboServiceImpl extends BaseService4RpcImpl implements DubboService {

	@Override
	public String sayDubbo(String usrName) {
		return "Dubbo Say Hi to "+usrName;
	}

}
