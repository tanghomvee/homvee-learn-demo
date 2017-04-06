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
public class WaterBrand extends BaseDomain {
    private  String brandName;
    private Integer price;
    private Long stationId;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }
}
