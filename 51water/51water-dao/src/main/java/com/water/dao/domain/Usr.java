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
public class Usr extends BaseDomain {
    private String usrName;
    private String usrCode;
    private String usrStationCode;
    private String usrOpenid;
    private Date followTime;

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getUsrCode() {
        return usrCode;
    }

    public void setUsrCode(String usrCode) {
        this.usrCode = usrCode;
    }

    public String getUsrOpenid() {
        return usrOpenid;
    }

    public void setUsrOpenid(String usrOpenid) {
        this.usrOpenid = usrOpenid;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }

    public String getUsrStationCode() {
        return usrStationCode;
    }

    public void setUsrStationCode(String usrStationCode) {
        this.usrStationCode = usrStationCode;
    }
}
