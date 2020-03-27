package com.learn.spring.dao;

import com.learn.spring.model.Employee;

public interface EmployeeDao {

    Employee getEmployeeFromDb();

    Employee getEmployee2();

    String getType();

}
