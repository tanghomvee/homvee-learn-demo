package com.dmall.homvee.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caucho.hessian.client.HessianProxyFactory;
import com.dmall.homvee.service.rpc.HessianService;


@Controller
public class HessianCtrl {
	@Autowired
	@Qualifier("hessianServiceClient")
	private HessianService hessianService;
	@RequestMapping(path={"/sayHessian"},method={RequestMethod.GET})
	@ResponseBody
	public String sayHessian(){
		return hessianService.sayHessian("Homvee");
	}
	public static void main(String[] args) {
		String url = "http://192.168.8.2/hessianService";  
        HessianProxyFactory factory = new HessianProxyFactory();  
        try{  
        	HessianService hello = (HessianService) factory.create(HessianService.class,url);  
            hello.sayHessian("hessian");  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
	}
}
