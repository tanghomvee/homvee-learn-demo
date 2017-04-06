package com.water.service.wechat.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.druid.util.StringUtils;
import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.water.service.wechat.WeChatBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Package: com.water.service.wechat.impl
 * @Description: TODO
 * @date:2016年01月11日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public class WeChatBaseServiceImpl implements WeChatBaseService {
    protected Logger LOGGER = null;
    public WeChatBaseServiceImpl(){
        LOGGER = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public <T> String convertObject2JSONString(Map<String, String> map, final T obj) {
        if(obj == null){
            return null;
        }
        if(map == null || map.size() == 0){
            return JSONUtils.toJSONString(obj);
        }
        final Class cls = obj.getClass();
        final  StringBuffer methodName = new StringBuffer("get");
        Map<String,Object> data = Maps.transformValues(map, new Function<String, Object>() {
            @Override
            public Object apply(String val) {
                if(StringUtils.isEmpty(val)){
                    return val;
                }
                char[] tmpCh = val.toCharArray();
                tmpCh[0] = Character.toUpperCase(tmpCh[0]);
                methodName.append(tmpCh);
                try {
                    return cls.getMethod(methodName.toString()).invoke(obj);
                } catch (Exception e) {
                    LOGGER.error("获取对象数据异常",e);
                }finally {
                    methodName.delete(3,tmpCh.length);
                }
                return null;
            }
        });


        return JSONUtils.toJSONString(data);
    }
}
