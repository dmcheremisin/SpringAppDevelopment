package com.learn.spring.dao;

import com.learn.spring.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getEmployees();

    Employee getEmployeeById(int id);

    void insertEmployee(Employee employee);

}
