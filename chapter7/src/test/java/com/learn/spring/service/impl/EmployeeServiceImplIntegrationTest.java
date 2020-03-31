package com.learn.spring.service.impl;

import com.learn.spring.entity.Employee;
import com.learn.spring.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring-context-test.xml")
@Transactional
class EmployeeServiceImplIntegrationTest {

    @Autowired
    EmployeeService employeeService;

    Employee employee;

    @BeforeEach
    void setUp() {
        employee = Employee.builder()
                .firstName("Vasya")
                .lastName("Pupkin")
                .department("Stuff")
                .jobTitle("Random")
                .salary(30000)
                .build();
    }

    @Test
    void getAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        assertEquals(allEmployees.size(), 2);
    }

    @Test
    void insertEmployee() {
        employeeService.insertEmployee(employee);
        assertNotNull(employee.getId());
    }

    @Test
    void getEmployeeById() {
        employeeService.insertEmployee(employee);
        Employee employeeById = employeeService.getEmployeeById(employee.getId());
        assertThat(employee).isEqualToComparingFieldByField(employeeById);
    }

    @Test
    void deleteEmployeeById() {
        employeeService.insertEmployee(employee);
        employeeService.deleteEmployeeById(employee.getId());
        Employee employeeById = employeeService.getEmployeeById(employee.getId());
        assertNull(employeeById);
    }

    @Test
    void updateEmployee() {
        employeeService.insertEmployee(employee);
        employee.setFirstName("Kolya");
        employee.setLastName("Zaikin");
        employee.setJobTitle("Manager");
        employee.setDepartment("Office management");
        employee.setSalary(40000);
        employeeService.updateEmployee(employee);

        Employee employeeById = employeeService.getEmployeeById(employee.getId());
        assertThat(employee).isEqualToComparingFieldByField(employeeById);
    }
}