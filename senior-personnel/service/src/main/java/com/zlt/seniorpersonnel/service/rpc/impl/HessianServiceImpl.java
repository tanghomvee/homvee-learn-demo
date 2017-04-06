package com.zlt.seniorpersonnel.service.rpc.impl;

import com.zlt.seniorpersonnel.service.base.impl.BaseService4RpcImpl;
import org.springframework.stereotype.Service;

import com.zlt.seniorpersonnel.service.rpc.HessianService;
@Service("hessianService")
public class HessianServiceImpl extends BaseService4RpcImpl implements HessianService {

	public String sayHessian(String usrName){
		System.out.println("=====================>"+usrName);
		return "Hessian Hello "+usrName;
	}
}
