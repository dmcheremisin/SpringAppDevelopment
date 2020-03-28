package com.learn.spring.dao;

import com.learn.spring.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getAllEmployees();

    void insertEmployee(Employee employee);

    Employee getEmployeeById(Integer id);

    void deleteEmployeeById(Integer id);

}
