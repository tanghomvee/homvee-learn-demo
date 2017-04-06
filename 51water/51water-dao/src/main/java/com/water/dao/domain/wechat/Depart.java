package com.water.dao.domain.wechat;

import com.water.dao.domain.BaseDomain;

import java.util.Arrays;

/**
 * @Package: com.water.dao.domain.wechat
 * @Description: 成员实体
 * @date:2016年01月11日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public class Depart extends BaseDomain {
    private String  departId;//必须	成员UserID。对应管理端的帐号，企业内;//必须唯一。长度为1~64个字节
    private String departName;//必须	成员名称。长度为1~64个字节
    private Long[] departments;//可选	成员所属部门id列表
    private String position;//可选	职位信息。长度为0~64个字节
    private String mobile;//可选	手机号码。企业内;//必须唯一，mobile/weixinid/email三者不能同时为空
    private byte gender;//可选	性别。1表示男性，2表示女性
    private String email;//可选	邮箱。长度为0~64个字节。企业内;//必须唯一
    private String weixinid;//可选	微信号。企业内;//必须唯一。（注意：是微信号，不是微信的名字）
    private String avatarMediaid;//可选	成员头像的mediaid，通过多媒体接口上传图片获得的mediaid
    private String avatar;//头像URL
    private String extattr;//可选	扩展属性。扩展属性需要在WEB管理端创建后才生效，否则忽略未知属性的赋值
    private byte enable = 1;//	可选	启用/禁用成员。1表示启用成员，0表示禁用成员
    private byte status;//	关注状态: 1=已关注，2=已冻结，4=未关注
    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public Long[] getDepartments() {
        return departments;
    }

    public void setDepartments(Long[] departments) {
        this.departments = departments;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeixinid() {
        return weixinid;
    }

    public void setWeixinid(String weixinid) {
        this.weixinid = weixinid;
    }

    public String getAvatarMediaid() {
        return avatarMediaid;
    }

    public void setAvatarMediaid(String avatarMediaid) {
        this.avatarMediaid = avatarMediaid;
    }

    public String getExtattr() {
        return extattr;
    }

    public void setExtattr(String extattr) {
        this.extattr = extattr;
    }

    public Depart(String departId, String departName) {
        this.departId = departId;
        this.departName = departName;
    }

    public byte getEnable() {
        return enable;
    }

    public void setEnable(byte enable) {
        this.enable = enable;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Depart{" +
                "departId='" + departId + '\'' +
                ", departName='" + departName + '\'' +
                ", departments=" + Arrays.toString(departments) +
                ", position='" + position + '\'' +
                ", mobile='" + mobile + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", weixinid='" + weixinid + '\'' +
                ", avatarMediaid='" + avatarMediaid + '\'' +
                ", avatar='" + avatar + '\'' +
                ", extattr='" + extattr + '\'' +
                ", enable=" + enable +
                ", status=" + status +
                '}';
    }
}
