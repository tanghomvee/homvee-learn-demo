package com.water.dao.domain.wechat;

import com.water.dao.domain.BaseDomain;

/**
 * @Package: com.water.dao.domain.wechat
 * @Description:  部门实体
 * @date:2016年01月11日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public class Department extends BaseDomain {
    private String departName;//部门名称。长度限制为1~64个字节，字符不能包括\:*?"<>｜
    private Long parentId;//父亲部门id。根部门id为1
    private Long order;//在父部门中的次序值。order值小的排序靠前

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departName='" + departName + '\'' +
                ", parentId=" + parentId +
                ", order=" + order +
                '}';
    }
}
