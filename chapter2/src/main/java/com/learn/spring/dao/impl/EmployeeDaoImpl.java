package com.learn.spring.dao.impl;

import com.learn.spring.dao.EmployeeDao;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public String getEmployeeFromDb() {
        return "Employee {id=1, name='Mister Fromm Db'}";
    }
}
