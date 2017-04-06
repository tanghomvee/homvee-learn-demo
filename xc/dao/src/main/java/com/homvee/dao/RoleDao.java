package com.homvee.dao;

import com.homvee.dao.base.BaseDao;
import com.homvee.dao.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("roleDao")
public interface RoleDao extends BaseDao<Role, Long> {

    /**
     * 通过用户ID获取用户角色名称
     * @param usrIds
     * @return
     */
    List<Map<String, Object>> queryRoleNameByUsrIds(Long ... usrIds);

    /**
     * 增加用户和角色
     * @param uarRoleIds
     * @return
     */
    int addUsrRole(Map<String,Long> uarRoleIds);

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

    List<Map<String, Object>>  queryUsrRoleByRoleIds(Long ...roleIds);

}
