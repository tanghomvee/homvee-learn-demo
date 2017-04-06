package com.homvee.dao.domain.enums;

/**
 * @Package: com.homvee.dao.domain.enums
 * @Description: YES or NO
 * @date:2016/11/2
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public enum YN {
    YES(1,"YES"),
    NO(-1,"NO");
    private int val;
    private String descp;

    YN(int val, String descp) {
        this.val = val;
        this.descp = descp;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }
}
