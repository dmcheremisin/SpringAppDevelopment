package com.learn.spring.dao.impl;

import com.learn.spring.dao.EmployeeDao;
import com.learn.spring.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

    private Employee employee;

    @Override
    public Employee getEmployeeFromDb() {
        return employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
