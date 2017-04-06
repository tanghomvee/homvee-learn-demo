package com.dmall.homvee.web.vender;

import com.dmall.homvee.dao.domain.Vender;
import com.dmall.homvee.service.vender.VenderService;
import com.dmall.homvee.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

@Controller
public class VenderCtrl extends BaseController{
	@Autowired
	private VenderService venderService;
	@RequestMapping(path={"/init"},method={RequestMethod.GET},produces = {"text/plain;charset=utf8"})
	@ResponseBody
	public String init(){
		LOGGER.info("Hello log level info   {}", "Spring");
		LOGGER.debug("Hello log level debug {}", "Spring");
		LOGGER.error("Hello log level error {}", "Spring");
		venderService.deleteByKey(9L);
		return "spring-mvc";
	}
	//vender.xml 返回 xml;vender.json返回json
	@RequestMapping(path={"/vender"},method={RequestMethod.GET})
	@ResponseBody
	public Vender xml(){
		Vender vender = new Vender();
		vender.setVenderName("XXXXXXXXXX");
		vender.setCreateTime(new Date());
		return vender;
	}
	//parseVender
	@RequestMapping(path={"/parseVender"},method={RequestMethod.GET})
	public void parseStr2Vender(Vender vender){

		System.out.println(vender);
	}
	@RequestMapping(path={"/reqParams"},method={RequestMethod.GET})
	public void reqParams(HttpServletRequest request,String[] ids){
		System.out.println(request.getParameterValues("ids"));
		System.out.println(Arrays.toString(ids));
	}

	
}
