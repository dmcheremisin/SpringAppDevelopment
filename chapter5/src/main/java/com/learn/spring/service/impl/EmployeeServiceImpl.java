package com.learn.spring.service.impl;

import com.learn.spring.dao.EmployeeDao;
import com.learn.spring.entity.Employee;
import com.learn.spring.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

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

    @Override
    @Transactional(readOnly = true)
    public Employee getEmployeeById(Integer id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(Integer id) {
        employeeDao.deleteEmployeeById(id);
    }
}
