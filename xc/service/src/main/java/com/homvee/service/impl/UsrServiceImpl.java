package com.homvee.service.impl;

import com.homvee.dao.UsrDao;
import com.homvee.dao.base.BaseDao;
import com.homvee.dao.domain.Role;
import com.homvee.dao.domain.Usr;
import com.homvee.service.UsrService;
import com.homvee.service.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package: com.homvee.service.impl
 * @Description:
 * @date:2016/11/2
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
@Service("usrService")
public class UsrServiceImpl extends BaseServiceImpl<Usr,Long> implements UsrService {
    @Autowired
    private UsrDao usrDao;
    @Override
    public BaseDao<Usr, Long> getBaseDao() {
        return usrDao;
    }
}
