package com.water.dao.employee;

import com.water.dao.base.BaseDao;
import com.water.dao.domain.Employee;
import org.springframework.stereotype.Repository;

/**
 * @author Tang.Homvee
 * @email Tanghomvee@QQ.COM
 * @PackageName:com.water.dao.employee
 * @Description:TODO
 * @Copyright:Homvee.Tang(c)2015
 * @date:2015年12月19日
 * @version:0.1
 */
@Repository("employeeDao")
public interface EmployeeDao extends BaseDao<Employee,Long>{
}
