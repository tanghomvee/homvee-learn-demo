package com.water.dao.domain;

import java.util.Date;

/**
 * @Package: com.water.dao.domain
 * @Description: TODO
 * @date:2015年12月09日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2015, DMall All Rights Reserved.
 */
public class DeliveryCfg extends BaseDomain {
   private Long usrStationId;
   private String deliveryAddr;//配送地址
   private int number;//订水数量
   private String brand;//品牌
   private Long modesId;//支付方式ID
   private Date deliveryTime;
   private byte defaultCfg;//默认配送地址(0:非默认配送地址;1:默认配送地址)

    public Long getUsrStationId() {
        return usrStationId;
    }

    public void setUsrStationId(Long usrStationId) {
        this.usrStationId = usrStationId;
    }

    public String getDeliveryAddr() {
        return deliveryAddr;
    }

    public void setDeliveryAddr(String deliveryAddr) {
        this.deliveryAddr = deliveryAddr;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getModesId() {
        return modesId;
    }

    public void setModesId(Long modesId) {
        this.modesId = modesId;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public byte getDefaultCfg() {
        return defaultCfg;
    }

    public void setDefaultCfg(byte defaultCfg) {
        this.defaultCfg = defaultCfg;
    }
}
