package com.water.service.usr.impl;

import com.water.dao.base.BaseDao;
import com.water.dao.domain.Usr;
import com.water.dao.usr.UsrDao;
import com.water.service.usr.UsrService;
import com.water.service.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package: com.water.service.usr.impl
 * @Description: TODO
 * @date:2015年12月10日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2015, DMall All Rights Reserved.
 */
@Service
public class UsrServiceImpl extends BaseServiceImpl<Usr,Long> implements UsrService {
    @Autowired
    private UsrDao usrDao;
    @Override
    public BaseDao<Usr, Long> getBaseDao() {
        return usrDao;
    }

}
