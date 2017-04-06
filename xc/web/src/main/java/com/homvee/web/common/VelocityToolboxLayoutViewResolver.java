package com.homvee.web.common;

import org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver;

import java.util.Map;

/**
 * @Package: com.homvee.web.common
 * @Description: TODO
 * @date:2016/11/4
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public class VelocityToolboxLayoutViewResolver extends VelocityLayoutViewResolver {
    private Map<String,Object> otherConfgs =  null;

    public Map<String, Object> getOtherConfgs() {
        return otherConfgs;
    }

    public void setOtherConfgs(Map<String, Object> otherConfgs) {
        this.otherConfgs = otherConfgs;
    }
}
