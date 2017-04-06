package com.homvee.web.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public  class BaseController {
	protected   Logger LOGGER = null;
	public BaseController(){
		LOGGER = LoggerFactory.getLogger(this.getClass());
	}
	
}
