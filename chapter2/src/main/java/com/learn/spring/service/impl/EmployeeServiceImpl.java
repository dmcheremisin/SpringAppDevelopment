package com.learn.spring.service.impl;

import com.learn.spring.dao.EmployeeDao;
import com.learn.spring.service.EmployeeService;

import java.util.UUID;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public UUID generateEmployeeId() {
        return UUID.randomUUID();
    }

    @Override
    public String getEmployeeFromDb() {
        return employeeDao.getEmployeeFromDb();
    }
}
