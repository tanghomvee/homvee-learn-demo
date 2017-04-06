package com.water.service.base;

import java.io.Serializable;
import java.util.List;

/**
 * @Package: com.water.service.base
 * @Description: TODO
 * @date:2015年12月10日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2015, DMall All Rights Reserved.
 */

public interface BaseService<T,KEY extends Serializable> {

    /**
     *
     * @Title: saveEntry
     * @Description: 添加对象
     * @param t
     * @return 影响条数
     * @date:2015年11月14日
     *
     * @author:Homvee.Tang
     * @email:Hongwei.Tang@DMall.com
     */
    int saveEntry(T...t);

    /**
     *
     * @Title: saveEntryCreateId
     * @Description: 添加对象并设置ID到对象上(需开启事务)
     * @param t
     * @return  影响条数
     * @date:2015年11月14日
     *
     * @author:Homvee.Tang
     * @email:Hongwei.Tang@DMall.com
     */
    //int saveEntryCreateId(T t);

    /**
     *
     * @Title: deleteByKey
     * @Description:  通过指定主键删除对象
     * @param keys
     * @return 影响行数
     * @date:2015年11月14日
     *
     * @author:Homvee.Tang
     * @email:Hongwei.Tang@DMall.com
     */
    int deleteByKey(KEY...keys);

    /**
     *
     * @Title: deleteByCondtion
     * @Description: 通过指定条件删除对象
     * @param condtion
     * @return 影响条数
     * @date:2015年11月14日
     *
     * @author:Homvee.Tang
     * @email:Hongwei.Tang@DMall.com
     */
    int deleteByCondition(T condtion);

    /**
     *
     * @Title: modifyByKey
     * @Description: 通过主键 更新对象
     * @param t
     * @return 影响条数
     * @date:2015年11月14日
     *
     * @author:Homvee.Tang
     * @email:Hongwei.Tang@DMall.com
     */
    int modifyByKey(T t);

    /**
     *
     * @Title: queryEntry
     * @Description: 按主键 查询对象
     * @param key
     * @return
     * @date:2015年11月14日
     *
     * @author:Homvee.Tang
     * @email:Hongwei.Tang@DMall.com
     */
    T queryEntryByKey(KEY key);

    /**
     * 查询对象,条件主键数组
     * @param key
     * @return
     */
    /**
     *
     * @Title: queryEntryList
     * @Description: 通过主键数组, 查询对象
     * @param keys
     * @return
     * @date:2015年11月14日
     *
     * @author:Homvee.Tang
     * @email:Hongwei.Tang@DMall.com
     */
    List<T> queryEntryListByKeys(KEY...keys);

    /**
     *
     * @Title: queryEntryList
     * @Description: 查询对象,只要不为NULL与空则为条件
     * @param condtion
     * @return
     * @date:2015年11月14日
     *
     * @author:Homvee.Tang
     * @email:Hongwei.Tang@DMall.com
     */
    List<T> queryEntryListByCondition(T condtion);

    /**
     *
     * @Title: queryEntryListCnt
     * @Description: 通过条件查询对象的个数
     * @param condtion
     * @return
     * @date:2015年11月14日
     *
     * @author:Homvee.Tang
     * @email:Hongwei.Tang@DMall.com
     */
    Integer queryEntryListCntByCondition(T condtion);
    /**
     *
     * @Title: logicDelByKey
     * @Description: 通过主键数组,逻辑删除数据
     * @param keys
     * @return
     * @date:2015年11月14日
     *
     * @author:Homvee.Tang
     * @email:Hongwei.Tang@DMall.com
     */
    int logicDelByKey(KEY...keys);
    /**
     *
     * @Title: logicDelByKey
     * @Description: 通过条件,逻辑删除数据
     * @param condtion
     * @return
     * @date:2015年11月14日
     *
     * @author:Homvee.Tang
     * @email:Hongwei.Tang@DMall.com
     */
    int logicDelByCondition(T condtion);
}
