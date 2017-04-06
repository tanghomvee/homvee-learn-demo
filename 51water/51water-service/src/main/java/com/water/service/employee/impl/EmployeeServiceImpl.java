package com.water.service.employee.impl;

import com.water.dao.base.BaseDao;
import com.water.dao.domain.Employee;
import com.water.dao.employee.EmployeeDao;
import com.water.service.base.impl.BaseServiceImpl;
import com.water.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Tang.Homvee
 * @email Tanghomvee@QQ.COM
 * @PackageName:com.water.service.employee
 * @Description:TODO
 * @Copyright:Homvee.Tang(c)2015
 * @date:2015年12月19日
 * @version:0.1
 */
public class EmployeeServiceImpl extends BaseServiceImpl<Employee,Long> implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public BaseDao<Employee, Long> getBaseDao() {
        return employeeDao;
    }
}
