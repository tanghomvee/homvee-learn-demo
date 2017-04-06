package com.dmall.homvee.web.velocity;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dmall.homvee.dao.domain.Vender;
import com.dmall.homvee.web.BaseController;
@Controller
public class VelocityCtrl extends BaseController{

	@RequestMapping(path={"/helloVelocity"},method={RequestMethod.GET})
	public String helloVelocity(){
		return "velocity/velocity";
	}
	@RequestMapping(path={"/layout"},method={RequestMethod.GET})
	public String layout(Model view,HttpServletRequest request) throws MalformedURLException{
		URL path = request.getServletContext().getResource("/");
		LOGGER.info("ContextPath:{}",path);
		InputStream in = request.getServletContext().getResourceAsStream("classpath:velocity-toolbox.xml");
		if(in== null){
			LOGGER.error("====================");
		}
		view.addAttribute("viewData", "viewData");
		request.setAttribute("reqData", "reqData");
		return "layout/default";
	}
	//访问~/write.xml返回XML格式数据,访问~/write.json返回json格式数据
	@RequestMapping(path={"/write"},method={RequestMethod.GET})
	public @ResponseBody Vender writeData(){
		Vender vender = new Vender();
		vender.setCreateTime(new Date());
		vender.setModifyTime(new Date());
		vender.setVenderName("JSON中国");
		return vender;
	}
}
