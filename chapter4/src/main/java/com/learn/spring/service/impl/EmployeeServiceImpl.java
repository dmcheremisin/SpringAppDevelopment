package com.learn.spring.service.impl;

import com.learn.spring.dao.EmployeeDao;
import com.learn.spring.entity.Employee;
import com.learn.spring.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    @Transactional
    public void insertEmployee(Employee employee) {
        employeeDao.insertEmployee(employee);
    }
}
