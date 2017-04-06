package com.homvee.dao.domain.common;

import com.homvee.dao.domain.enums.OrderType;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Package: com.homvee.dao.domain.common
 * @Description: TODO
 * @date:2016/11/2
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public class BaseQuery implements Serializable {

    private transient Integer startIndex;// 开始索引

    private transient Integer endIndex;// 结束索引

    /**
     * KEY:排序字段
     * Value:排序类型
     */
    private transient Map<String,String> orderFields = new LinkedHashMap<>();


    public Integer getStartIndex() {
        return startIndex;
    }
    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getEndIndex() {
        return endIndex;
    }
    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
    }

    //每页显示条数
    public Integer getPageSize() {
        if(endIndex != null && startIndex != null) {
            return endIndex - startIndex;
        }
        return null;
    }

    public Map<String, String> getOrderFields() {
        return orderFields;
    }

    public void addOrderFieldAndType(String orderField,OrderType orderType) {
       this.orderFields.put(orderField,orderType.getType());
    }
}
