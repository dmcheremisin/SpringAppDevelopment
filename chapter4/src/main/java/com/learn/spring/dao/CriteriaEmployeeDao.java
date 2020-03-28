package com.learn.spring.dao;

import com.learn.spring.entity.Employee;

import java.util.List;

public interface CriteriaEmployeeDao {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id);

    List<Employee> getEmployeesBySalaryBetween(Integer min, Integer max);
}
