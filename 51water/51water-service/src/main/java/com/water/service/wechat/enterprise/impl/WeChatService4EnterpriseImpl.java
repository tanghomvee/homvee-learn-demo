package com.water.service.wechat.enterprise.impl;

import com.google.common.collect.Maps;
import com.water.common.util.NetworkUtil;
import com.water.dao.domain.Msg;
import com.water.dao.domain.wechat.Depart;
import com.water.dao.domain.wechat.Department;
import com.water.service.wechat.enterprise.WeChatService4Enterprise;
import com.water.service.wechat.impl.WeChatBaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Package: com.water.service.wechat.enterprise.impl
 * @Description: TODO
 * @date:2016年01月11日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
@Service("weChatService4Enterprise")
public class WeChatService4EnterpriseImpl extends WeChatBaseServiceImpl implements WeChatService4Enterprise {
    private String url;
    @Override
    public Msg createDepartment(Department department) {
        Map<String,String> map = Maps.newHashMap();
        map.put("name","departName");
        map.put("parentid","parentId");
        map.put("order","order");
        map.put("id","id");
        NetworkUtil.sendData(url,this.convertObject2JSONString(map,department));
        return null;
    }

    @Override
    public Msg modifyDepartment(Department department) {
        return null;
    }

    @Override
    public Msg delDepartment(Long departmentId) {
        return null;
    }

    @Override
    public List<Department> queryDepartmentById(Long departmentId) {
        return null;
    }

    @Override
    public Msg createDepart(Depart depart) {
        return null;
    }

    @Override
    public Msg modifyDepart(Depart depart) {
        return null;
    }

    @Override
    public Msg delDepart(String... departIds) {
        return null;
    }

    @Override
    public Depart queryDepartById(Long departId) {
        return null;
    }

    @Override
    public List<Depart> queryDepartDetailsByDepartmentId(Long departmentId, boolean isFetchChild, byte status) {
        return null;
    }

    @Override
    public Msg inviteFollow(Long departId) {
        return null;
    }
}
