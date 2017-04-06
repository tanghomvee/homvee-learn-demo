package com.water.service.wechat.enterprise;

import com.water.dao.domain.Msg;
import com.water.dao.domain.wechat.Depart;
import com.water.dao.domain.wechat.Department;
import com.water.service.wechat.WeChatBaseService;

import java.util.List;

/**
 * @Package: com.water.service.wechat
 * @Description: 微信企业号接口
 * @date:2016年01月11日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public interface WeChatService4Enterprise extends WeChatBaseService {
    /**
     * 创建部门
     * @param department
     * @return
     */
    public Msg createDepartment(Department department);

    /**
     * 修改部门
     * @param department
     * @return
     */
    public Msg modifyDepartment(Department department);

    /**
     * 删除部门
     * @param departmentId
     * @return
     */
    public Msg delDepartment(Long departmentId);

    /**
     * 获取指定部门及其下的子部门
     * @param departmentId
     * @return
     */
    public List<Department> queryDepartmentById(Long departmentId);

    /**
     * 创建成员
     * @param depart
     * @return
     */
    public Msg createDepart(Depart depart);

    /**
     * 修改成员
     * @param depart
     * @return
     */
    public Msg modifyDepart(Depart depart);

    /**
     * 删除成员
     * @param departIds
     * @return
     */
    public Msg delDepart(String ...departIds);

    /**
     * 通过成员ID获取成员信息
     * @param departId
     * @return
     */
    public Depart queryDepartById(Long departId);

    /**
     * 通过部门ID获取成员信息
     * @param departmentId 部门ID
     * @param isFetchChild true/false：是否递归获取子部门下面的成员
     * @param status //0获取全部成员，1获取已关注成员列表，2获取禁用成员列表，4获取未关注成员列表。status可叠加,未填写则默认为4
     * @return
     */
    public List<Depart> queryDepartDetailsByDepartmentId(Long departmentId, boolean isFetchChild, byte status);

    /**
     * 邀请成员关注
     * @param departId
     * @return
     */
    public Msg inviteFollow(Long departId);
}
