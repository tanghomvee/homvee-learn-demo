package com.water.web.usr;

import com.alibaba.druid.util.StringUtils;
import com.water.dao.domain.Msg;
import com.water.dao.domain.Usr;
import com.water.web.base.BaseCtrl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Package: com.water.web.usr
 * @Description: TODO
 * @date:2015年12月10日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2015, DMall All Rights Reserved.
 */
@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RequestMapping(value={"/usr"})
public class UsrCtrl extends BaseCtrl {

    public Msg addUsrInfo(Usr usr){

        return Msg.success();
    }
    private Msg verifyUsrInfo(Usr usr){
        if(StringUtils.isEmpty(usr.getUsrCode())){
            return Msg.error("请输入用户的订水编号");
        }



        return  Msg.success();
    }
}
