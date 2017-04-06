package com.water.dao.domain;

/**
 * @author Tang.Homvee
 * @email Tanghomvee@QQ.COM
 * @PackageName:com.water.dao.domain
 * @Description:TODO
 * @Copyright:Homvee.Tang(c)2015
 * @date:2015年12月19日
 * @version:0.1
 */
public class Employee extends BaseDomain {
    private String empName;
    private String empMp;
    private Long stationId;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpMp() {
        return empMp;
    }

    public void setEmpMp(String empMp) {
        this.empMp = empMp;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }
}
