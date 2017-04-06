package com.dmall.homvee.web.common.utils;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @Package: com.water.web.common.utils
 * @Description: TODO
 * @date:2016年01月08日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public class DateConverter implements Converter<String, Date> {
    private static final List<String> formarts = Lists.newArrayList();
    private Logger LOGGER = LoggerFactory.getLogger(DateConverter.class);
    static{
        formarts.add("hh:mm");
        formarts.add("yyyy-MM");
        formarts.add("yyyy年MM月");
        formarts.add("yyyy-MM-dd");
        formarts.add("yyyy年MM月dd日");
        formarts.add("yyyy-MM-dd hh:mm");
        formarts.add("yyyy-MM-dd hh:mm:ss");
    }
    @Override
    public Date convert(String source) {
        if(StringUtils.isEmpty(source) || StringUtils.isEmpty(source.trim())){
            LOGGER.info("非法数据[{}]转为日期数据",source);
            return null;
        }
        String[]  patters = new String[1];
        if(source.matches("\\d{1,2}:\\d{1,2}$")){
            patters[0] = formarts.get(0);
        }else if(source.matches("^\\d{4}-\\d{1,2}$")){
            patters[0] = formarts.get(1);
        }else if(source.matches("^\\d{4}年\\d{1,2}月$")){
            patters[0] = formarts.get(2);
        }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")){
            patters[0] = formarts.get(3);
        }else if(source.matches("^\\d{4}年\\d{1,2}月\\d{1,2}日$")){
            patters[0] = formarts.get(4);
        }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")){
            patters[0] = formarts.get(5);
        }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")){
            patters[0] = formarts.get(6);
        }else {
            throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
        }

        try {
            return DateUtils.parseDate(source.trim(),patters);
        } catch (ParseException e) {
            LOGGER.info("将数据[{}]转为日期对象异常[{}]",source,e);
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            System.out.println(DateUtils.parseDate("09:30",new String[]{"hh:mm","hh:mm"}));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
