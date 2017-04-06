package com.water.web.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Package: com.water.web.base
 * @Description: TODO
 * @date:2015年12月10日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2015, DMall All Rights Reserved.
 */
public class BaseCtrl {
    protected Logger LOGGER = null;
    public BaseCtrl(){
        LOGGER = LoggerFactory.getLogger(this.getClass());
    }

}
