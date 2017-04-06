package com.zlt.seniorpersonnel.dao.domain;

import java.io.Serializable;
import java.util.Date;


public class Vender implements Serializable{
	private long id;
	private String venderName;
	private int yn;
	private Date createTime;
	private Date modifyTime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getVenderName() {
		return venderName;
	}
	public void setVenderName(String venderName) {
		this.venderName = venderName;
	}
	public int getYn() {
		return yn;
	}
	public void setYn(int yn) {
		this.yn = yn;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	@Override
	public String toString() {
		return "Vender{" +
				"id=" + id +
				", venderName='" + venderName + '\'' +
				", yn=" + yn +
				", createTime=" + createTime +
				", modifyTime=" + modifyTime +
				'}';
	}
}
