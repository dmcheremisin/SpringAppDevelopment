package com.learn.spring.service;

import com.learn.spring.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void insertEmployee(Employee employee);

    Employee getEmployeeById(Integer id);

    void deleteEmployeeById(Integer id);

}
