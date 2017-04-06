package com.homvee.web;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.homvee.dao.domain.Place;
import com.homvee.dao.domain.Role;
import com.homvee.dao.domain.Usr;
import com.homvee.dao.domain.common.Message;
import com.homvee.dao.domain.common.Page;
import com.homvee.dao.domain.enums.YN;
import com.homvee.service.PlaceService;
import com.homvee.service.RoleService;
import com.homvee.service.UsrService;
import com.homvee.service.utils.EncryptUtils;
import com.homvee.web.common.BaseController;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
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
 * @Description: TODO
 * @date:2016/11/2
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
@Controller
@RequestMapping(path = {"/usr"})
public class UsrCtrl extends BaseController {
    @Resource(name = "usrService")
    private UsrService usrService;
    @Resource(name = "placeService")
    private PlaceService placeService;
    @Resource(name = "roleService")
    private RoleService roleService;
    @RequestMapping(path = {"/list"},method = {RequestMethod.GET,RequestMethod.POST})
    public String list(Model view, Page<Usr> page,Usr usr) throws Exception {
        page = usrService.queryPageByCondition(usr,page);

        List<Usr> usrs = page.getResult();
        //获取用户ID
        if (CollectionUtils.isNotEmpty(usrs)){
            List<Long> usrIds = Lists.transform(usrs, new Function<Usr, Long>() {
                @Override
                public Long apply(Usr usr) {
                    return usr.getId();
                }
            });
            Long[] tmpUsrIds = new Long[usrIds.size()];
            usrIds.toArray(tmpUsrIds);
            //获取角色名称
            List<Map<String,Object>> roles = roleService.queryRoleNameByUsrIds(tmpUsrIds);
            if(CollectionUtils.isNotEmpty(roles)){
                Map<Long,String> tempMap = Maps.newHashMap();
                for (Map<String,Object> role : roles){
                    Long usrId = (Long) role.get("usrId");
                    String roleName = (String) role.get("roleName");
                    if(tempMap.containsKey(usrId)){
                        roleName = tempMap.get(usrId) + ","+roleName;
                    }
                    tempMap.put(usrId,roleName);
                }
                for (Usr usrTmp : usrs){
                    Long usrId = usrTmp.getId();
                    if(!tempMap.containsKey(usrId)){
                        continue;
                    }
                    usrTmp.setRoleName(tempMap.get(usrId));
                }
            }
            //获取宣传名称
            List<Map<String,Object>> places = placeService.queryPlaceNameByUsrIds(tmpUsrIds);
            if(CollectionUtils.isNotEmpty(places)){
                Map<Long,String> tempMap = Maps.newHashMap();
                for (Map<String,Object> place : places){
                    Long usrId = (Long) place.get("usrId");
                    String placeName = (String) place.get("placeName");
                    if(tempMap.containsKey(usrId)){
                        placeName = tempMap.get(usrId) + "," + placeName;
                    }
                    tempMap.put(usrId,placeName);
                }

                for (Usr usrTmp : usrs){
                    Long usrId = usrTmp.getId();
                    if(!tempMap.containsKey(usrId)){
                        continue;
                    }
                    usrTmp.setPlaceName(tempMap.get(usrId));
                }
            }

        }

        view.addAttribute("page",page);
        view.addAttribute("usr",usr);
        return "usr/list";
    }
    @RequestMapping(path = {"/initAdd"},method = {RequestMethod.GET,RequestMethod.POST})
    public String initAdd(Model view){
        Place place = new Place();
        place.setYn(YN.YES.getVal());
        List<Place> places = placeService.queryEntryListByCondition(place);
        view.addAttribute("places",places);
        Role role = new Role();
        role.setYn(YN.YES.getVal());
        List<Role> roles = roleService.queryEntryListByCondition(role);
        view.addAttribute("roles",roles);
        return "usr/add";
    }
    @RequestMapping(path = {"/initEdit"},method = {RequestMethod.GET,RequestMethod.POST})
    public String initEdit(Model view,Long usrId){
        Place place = new Place();
        place.setYn(YN.YES.getVal());
        List<Place> places = placeService.queryEntryListByCondition(place);
        view.addAttribute("places",places);
        //负责宣传地
        List<Map<String,Object>> placesTemp = placeService.queryPlaceNameByUsrIds(usrId);
        if(CollectionUtils.isNotEmpty(placesTemp) && CollectionUtils.isNotEmpty(places)){
            Map<Long,Place> temp = Maps.uniqueIndex(places, new Function<Place, Long>() {
                @Override
                public Long apply(Place place) {
                    return place.getId();
                }
            });
            for (Map<String,Object> placeMap : placesTemp){
                Long placeId = (Long) placeMap.get("placeId");
                Place tmpPlace = temp.get(placeId);
                if(tmpPlace == null){
                    continue;
                }
                tmpPlace.setSelected(true);
            }
        }

        Usr usr = usrService.queryEntryByKey(usrId);
        view.addAttribute("usr",usr);
        return "usr/edit";
    }
    @RequestMapping(path = {"/add"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Message saveUsr(Usr usr, Long[] places){
        if(usr == null || StringUtils.isEmpty(usr.getPhoneNum()) || StringUtils.isEmpty(usr.getUsrName())){
            return Message.failure("请填写用户名和手机号");
        }
        usr.setUsrPwd(EncryptUtils.encodeMD5String("123456"));
        if(usrService.saveEntry(usr) == 1){
            Long usrId = usr.getId();
            if(!ArrayUtils.isEmpty(places)){
                placeService.addUsrPlace(usrId,places);
            }

            return Message.success();
        }
        return Message.failure();
    }

    @RequestMapping(path = {"/edit"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Message editUsr(Usr usr, Long[] places){
        if(usr == null || StringUtils.isEmpty(usr.getPhoneNum()) || StringUtils.isEmpty(usr.getUsrName())){
            return Message.failure("请填写用户名和手机号");
        }
        if(usrService.modifyByKey(usr) == 1){
            Long usrId = usr.getId();
            if(placeService.delUsrPlaceByUsrIds(usrId) >= 0){
                if(!ArrayUtils.isEmpty(places)){
                    placeService.addUsrPlace(usrId,places);
                }
            }
            return Message.success();
        }
        return Message.failure();
    }
    @RequestMapping(path = {"/del"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Message delUsr(Long[] usrIds){
        if(ArrayUtils.isEmpty(usrIds)){
            return Message.failure("无效的参数信息");
        }
        if(usrService.deleteByKey(usrIds) > 0){
            return Message.success();
        }
        return Message.failure();
    }

    @RequestMapping(path = {"/reset"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Message resetPwd(Long usrId){
        if(usrId < 1){
            return Message.failure("无效的用户信息");
        }
        Usr usr = new Usr();
        usr.setId(usrId);
        usr.setUsrPwd(EncryptUtils.encodeMD5String("123456"));
        usr.setYn(YN.YES.getVal());
        if(usrService.modifyByKey(usr) > 0){
            return Message.success();
        }
        return Message.failure();
    }
}
