package com.water.service.wechat;

import java.util.Map;

/**
 * @Package: com.water.service.wechat
 * @Description: TODO
 * @date:2016年01月11日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public interface WeChatBaseService {
    /**
     * 将 obj对象按照map中指定的数据格式转为 json 字符串
     * @param map
     * @param obj
     * @param <T>
     * @return
     */
    public <T> String convertObject2JSONString(Map<String,String> map ,T obj);
}
