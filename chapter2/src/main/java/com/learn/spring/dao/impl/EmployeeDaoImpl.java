package com.learn.spring.dao.impl;

import com.learn.spring.dao.EmployeeDao;
import com.learn.spring.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

    private Employee employee1;
    private Employee employee2;

    @Override
    public Employee getEmployeeFromDb() {
        return employee1;
    }

    public Employee getEmployee1() {
        return employee1;
    }

    public void setEmployee1(Employee employee1) {
        this.employee1 = employee1;
    }

    public Employee getEmployee2() {
        return employee2;
    }

    public void setEmployee2(Employee employee2) {
        this.employee2 = employee2;
    }
}
