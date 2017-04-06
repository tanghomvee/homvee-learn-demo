package com.homvee.dao.domain.enums;

/**
 * @Package: com.homvee.dao.domain.enums
 * @Description: TODO
 * @date:2016/11/2
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public enum OrderType {
    ASC("ASC","升序"),
    DESC("DESC","降序");

    private  String type;
    private String descp;

    OrderType(String type, String descp) {
        this.type = type;
        this.descp = descp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }
}
