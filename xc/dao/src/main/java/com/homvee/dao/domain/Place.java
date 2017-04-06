package com.homvee.dao.domain;

import com.homvee.dao.domain.common.BaseDomain;

/**
 * @Package: com.homvee.dao.domain
 * @Description: 宣传点信息
 * @date:2016/11/1
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public class Place extends BaseDomain {
    private String placeName;
    private transient boolean selected;

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
