package com.dmall.homvee.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dmall.homvee.service.rpc.DubboService;


@Controller
public class DubboCtrl {
	@Autowired
	@Qualifier("dubboServiceClient")
	private DubboService dubboService;
	@RequestMapping(path={"/sayDubbo"},method={RequestMethod.GET})
	@ResponseBody
	public String sayDubbo(){
		return dubboService.sayDubbo("Homvee");
	}
}
