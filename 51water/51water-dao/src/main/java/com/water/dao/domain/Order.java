package com.water.dao.domain;

/**
 * @Package: com.water.dao.domain
 * @Description: TODO
 * @date:2015年12月09日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2015; DMall All Rights Reserved.
 */
public class Order extends  BaseDomain {

    private Long usrId;//用户Id
    private Integer number;//送水数量
    private Long deliveryCfgId ;//配送配置Id
    private Long amount;//订单金额
    private Long realAmount;//订单实际金额
    private byte orderStatus;//订单状态(0:初始;2:付款;1:取消;4:送货;3:退货;5:退款;6:完成)
    private String note;//备注信息

    public Long getUsrId() {
        return usrId;
    }

    public void setUsrId(Long usrId) {
        this.usrId = usrId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getDeliveryCfgId() {
        return deliveryCfgId;
    }

    public void setDeliveryCfgId(Long deliveryCfgId) {
        this.deliveryCfgId = deliveryCfgId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(Long realAmount) {
        this.realAmount = realAmount;
    }

    public byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
