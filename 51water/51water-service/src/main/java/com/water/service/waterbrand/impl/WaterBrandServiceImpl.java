package com.water.service.waterbrand.impl;

import com.water.dao.base.BaseDao;
import com.water.dao.domain.WaterBrand;
import com.water.dao.waterbrand.WaterBrandDao;
import com.water.service.base.impl.BaseServiceImpl;
import com.water.service.waterbrand.WaterBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Tang.Homvee
 * @email Tanghomvee@QQ.COM
 * @PackageName:com.water.service.waterbrand.impl
 * @Description:TODO
 * @Copyright:Homvee.Tang(c)2015
 * @date:2015年12月19日
 * @version:0.1
 */
@Service("waterBrandService")
public class WaterBrandServiceImpl extends BaseServiceImpl<WaterBrand,Long> implements WaterBrandService {
   @Autowired
    private WaterBrandDao waterBrandDao;
    @Override
    public BaseDao<WaterBrand, Long> getBaseDao() {
        return waterBrandDao;
    }
}
