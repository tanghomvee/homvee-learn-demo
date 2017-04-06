package com.homvee.dao.domain;

import com.homvee.dao.domain.common.BaseDomain;

import java.io.Serializable;
import java.util.Date;


public class Vender extends BaseDomain{

	private String venderName;

	public String getVenderName() {
		return venderName;
	}
	public void setVenderName(String venderName) {
		this.venderName = venderName;
	}

}
