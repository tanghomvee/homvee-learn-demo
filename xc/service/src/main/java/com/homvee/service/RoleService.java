package com.homvee.service;

import com.homvee.dao.domain.Role;
import com.homvee.service.base.BaseService;

import java.util.List;
import java.util.Map;

public interface RoleService extends BaseService<Role, Long>{

    /**
     * 通过用户ID获取用户角色名称
     * @param usrIds
     * @return
     */
    List<Map<String, Object>> queryRoleNameByUsrIds(Long ... usrIds);

    /**
     * 增加用户和角色
     * @param usrId
     * @param roleIds
     * @return
     */
    int addUsrRole(Long usrId,Long[] roleIds);

    /**
     * 通过角色ID删除数据
     * @param roleIds
     * @return
     */
    int delUsrRoleByRoleIds(Long ... roleIds);

    /**
     * 通过用户ID删除数据
     * @param usrIds
     * @return
     */
    int delUsrRoleByUsrIds(Long ... usrIds);

    /**
     * 查询改角色下有那些用户
     * @param roleIds
     * @return
     */
    List<Map<String, Object>>  queryUsrRoleByRoleIds(Long ...roleIds);

    /**
     * 向用户授权
     * @param roleId
     * @param usrIds
     * @return
     */
    int auth(Long roleId,Long[] usrIds);
}
