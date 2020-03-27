package com.learn.spring.service.impl;

import com.learn.spring.service.EmployeeService;

import java.util.UUID;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public UUID generateEmployeeId() {
        return UUID.randomUUID();
    }
}
