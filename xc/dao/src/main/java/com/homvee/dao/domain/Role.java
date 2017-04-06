package com.homvee.dao.domain;

import com.homvee.dao.domain.common.BaseDomain;

/**
 * @Package: com.homvee.dao.domain
 * @Description: 角色
 * @date:2016/11/1
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public class Role extends BaseDomain {
    private String roleName;
    private transient boolean selected;
    private String funUrl;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getFunUrl() {
        return funUrl;
    }

    public void setFunUrl(String funUrl) {
        this.funUrl = funUrl;
    }
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
