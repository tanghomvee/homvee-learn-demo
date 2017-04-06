package com.dmall.homvee.service.rpc.impl;

import org.springframework.stereotype.Service;

import com.dmall.homvee.service.base.impl.BaseService4RpcImpl;
import com.dmall.homvee.service.rpc.HessianService;
@Service("hessianService")
public class HessianServiceImpl extends BaseService4RpcImpl implements HessianService {

	public String sayHessian(String usrName){
		System.out.println("=====================>"+usrName);
		return "Hessian Hello "+usrName;
	}
}
