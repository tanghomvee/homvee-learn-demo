package com.water.dao.waterbrand;

import com.water.dao.base.BaseDao;
import com.water.dao.domain.WaterBrand;
import org.springframework.stereotype.Repository;

/**
 * @author Tang.Homvee
 * @email Tanghomvee@QQ.COM
 * @PackageName:com.water.dao.waterbrand
 * @Description:TODO
 * @Copyright:Homvee.Tang(c)2015
 * @date:2015年12月19日
 * @version:0.1
 */
@Repository("waterBrandDao")
public interface WaterBrandDao extends  BaseDao<WaterBrand,Long> {
}
