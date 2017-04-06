package com.homvee.web;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.homvee.dao.domain.Role;
import com.homvee.dao.domain.Usr;
import com.homvee.dao.domain.common.Message;
import com.homvee.dao.domain.common.Page;
import com.homvee.dao.domain.enums.YN;
import com.homvee.service.RoleService;
import com.homvee.service.UsrService;
import com.homvee.web.common.BaseController;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * @Package: com.homvee.web
 * @Description:
 * @date:2016/11/2
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
@Controller
@RequestMapping(path = {"/role"})
public class RoleCtrl extends BaseController {

    @Resource(name = "roleService")
    private RoleService roleService;
    @Resource(name = "usrService")
    private UsrService usrService;

    @RequestMapping(path = {"/list"},method = {RequestMethod.GET,RequestMethod.POST})
    public String list(Model view, Page<Role> page,Role role) throws Exception {
        page = roleService.queryPageByCondition(role,page);
        view.addAttribute("page",page);
        view.addAttribute("role",role);
        return "role/list";
    }
    @RequestMapping(path = {"/authInit"},method = {RequestMethod.GET,RequestMethod.POST})
    public String authInit(Model view,Long roleId){
        Usr usr = new Usr();
        usr.setYn(YN.YES.getVal());
        List<Usr> usrs = usrService.queryEntryListByCondition(usr);
        if(CollectionUtils.isNotEmpty(usrs)){
            Map<Long,Usr> usrMap = Maps.uniqueIndex(usrs, new Function<Usr, Long>() {
                @Override
                public Long apply(Usr usr) {
                    return usr.getId();
                }
            });
            List<Map<String, Object>>  usrRoles = roleService.queryUsrRoleByRoleIds(roleId);
            if(CollectionUtils.isNotEmpty(usrRoles)){
                for (Map<String,Object> tmpMap : usrRoles){
                    Long usrId = (Long) tmpMap.get("usrId");
                    Usr usrTmp = usrMap.get(usrId);
                    if(usrTmp == null){
                        continue;
                    }
                    usrTmp.setSelected(true);
                }
            }
        }
        view.addAttribute("usrs",usrs);
        view.addAttribute("roleId",roleId);
        return "role/auth";
    }

    @RequestMapping(path = {"/initEdit"},method = {RequestMethod.GET,RequestMethod.POST})
    public String editInit(Model view,Long roleId){
        Role role = roleService.queryEntryByKey(roleId);
        view.addAttribute("role",role);
        return "role/edit";
    }
    @RequestMapping(path = {"/initAdd"},method = {RequestMethod.GET,RequestMethod.POST})
    public String addInit(){
        return "role/add";
    }

    @RequestMapping(path = {"/add"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Message save(Role role){
        if(role == null || StringUtils.isEmpty(role.getRoleName())){
            return Message.failure();
        }

        if(roleService.saveEntry(role) > 0){
            return Message.success();
        }

        return Message.failure();
    }

    @RequestMapping(path = {"/edit"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Message edit(Role role){
        if(role == null || StringUtils.isEmpty(role.getRoleName()) || role.getId() < 1){
            return Message.failure();
        }

        if(roleService.modifyByKey(role) == 1){
            return Message.success();
        }
        return Message.failure();
    }


    @RequestMapping(path = {"/auth"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Message auth(Long roleId,Long[] usrIds){
        int rs = roleService.auth(roleId,usrIds);
        if (rs > 0){
            return Message.success();
        }
        return Message.failure();
    }

    @RequestMapping(path = {"/del"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Message del(Long[] roleIds){

        return Message.failure();
    }

}
