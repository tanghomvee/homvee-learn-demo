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
public class WaterStation extends BaseDomain{
    private String waterStationName;
    private String waterStationCode;
    private String  waterStationAddr;
    private String waterStationMp;
    private byte isFollow;
    private Date followTime;
    private Date openTime;
    private Date closeTime;

    public String getWaterStationName() {
        return waterStationName;
    }

    public void setWaterStationName(String waterStationName) {
        this.waterStationName = waterStationName;
    }

    public String getWaterStationCode() {
        return waterStationCode;
    }

    public void setWaterStationCode(String waterStationCode) {
        this.waterStationCode = waterStationCode;
    }

    public String getWaterStationAddr() {
        return waterStationAddr;
    }

    public void setWaterStationAddr(String waterStationAddr) {
        this.waterStationAddr = waterStationAddr;
    }

    public String getWaterStationMp() {
        return waterStationMp;
    }

    public void setWaterStationMp(String waterStationMp) {
        this.waterStationMp = waterStationMp;
    }

    public byte getIsFollow() {
        return isFollow;
    }

    public void setIsFollow(byte isFollow) {
        this.isFollow = isFollow;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }
}
