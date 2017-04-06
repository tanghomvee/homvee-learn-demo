package com.homvee.service.impl;

import com.google.common.collect.Maps;
import com.homvee.dao.RoleDao;
import com.homvee.dao.base.BaseDao;
import com.homvee.dao.domain.Role;
import com.homvee.service.RoleService;
import com.homvee.service.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Package: com.homvee.service.impl
 * @Description:
 * @date:2016/11/2
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role,Long> implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public BaseDao<Role, Long> getBaseDao() {
        return roleDao;
    }

    @Override
    public List<Map<String, Object>> queryRoleNameByUsrIds(Long... usrIds) {
        return roleDao.queryRoleNameByUsrIds(usrIds);
    }

    @Transactional(rollbackFor = {Exception.class})
    public int addUsrRole(Long usrId, Long[] roleIds) {
        int rs = 0;
        Map<String,Long> params = Maps.newHashMap();
        params.put("usrId",usrId);
        for (Long roleId : roleIds){
            params.put("roleId",roleId);
            rs = roleDao.addUsrRole(params);
            if(rs < 1){
                LOGGER.error("用户[{}]授权角色[{}]失败",usrId,roleId);
            }
        }
        return rs;
    }

    @Override
    public int delUsrRoleByRoleIds(Long... roleIds) {
        return roleDao.delUsrRoleByRoleIds(roleIds);
    }

    @Override
    public int delUsrRoleByUsrIds(Long... usrIds) {
        return roleDao.delUsrRoleByUsrIds(usrIds);
    }

    @Override
    public List<Map<String, Object>> queryUsrRoleByRoleIds(Long... roleIds) {
        return roleDao.queryUsrRoleByRoleIds(roleIds);
    }

    @Transactional(rollbackFor = {Exception.class})
    public int auth(Long roleId,Long[] usrIds){
        int rs = delUsrRoleByRoleIds(roleId);
        if(rs >= 0){
            if(usrIds == null || usrIds.length < 1){
                return rs;
            }
            for (Long usrId : usrIds){
                rs = addUsrRole(usrId,new Long[]{roleId});
                if(rs < 1){
                    return rs;
                }
            }
        }
        return rs;
    }
}
