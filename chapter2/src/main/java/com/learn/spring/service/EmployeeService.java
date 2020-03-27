package com.learn.spring.service;

import com.learn.spring.model.Employee;

import java.util.UUID;

public interface EmployeeService {

    UUID generateEmployeeId();

    Employee getEmployeeFromDb();

}
