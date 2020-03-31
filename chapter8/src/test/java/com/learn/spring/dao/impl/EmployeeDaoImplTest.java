package com.learn.spring.dao.impl;

import com.learn.spring.dao.EmployeeDao;
import com.learn.spring.entity.Employee;
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
class EmployeeDaoImplTest {

    @Autowired
    private EmployeeDao employeeDao;

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
        List<Employee> allEmployees = employeeDao.getAllEmployees();
        assertEquals(allEmployees.size(), 2);
    }

    @Test
    void getEmployeeById() {
        employeeDao.insertEmployee(employee);
        Employee employeeById = employeeDao.getEmployeeById(employee.getId());
        assertThat(employee).isEqualToComparingFieldByField(employeeById);
    }

    @Test
    void insertEmployee() {
        employeeDao.insertEmployee(employee);
        assertNotNull(employee.getId());
    }

    @Test
    void deleteEmployeeById() {
        employeeDao.insertEmployee(employee);
        employeeDao.deleteEmployeeById(employee.getId());
        Employee employeeById = employeeDao.getEmployeeById(employee.getId());
        assertNull(employeeById);
    }

    @Test
    void updateEmployee() {
        employeeDao.insertEmployee(employee);
        employee.setFirstName("Kolya");
        employee.setLastName("Zaikin");
        employee.setJobTitle("Manager");
        employee.setDepartment("Office management");
        employee.setSalary(40000);
        employeeDao.updateEmployee(employee);

        Employee employeeById = employeeDao.getEmployeeById(employee.getId());
        assertThat(employee).isEqualToComparingFieldByField(employeeById);
    }
}