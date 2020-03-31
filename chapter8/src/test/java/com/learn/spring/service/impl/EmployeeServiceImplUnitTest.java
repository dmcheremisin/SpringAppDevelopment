package com.learn.spring.service.impl;

import com.learn.spring.dao.EmployeeDao;
import com.learn.spring.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplUnitTest {

    @Mock
    EmployeeDao employeeDao;

    @InjectMocks
    EmployeeServiceImpl employeeService;

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
        when(employeeDao.getAllEmployees()).thenReturn(List.of(employee));
        List<Employee> employees = employeeService.getAllEmployees();

        assertEquals(employees.size(), 1);
        assertEquals(employees.get(0), employee);
        verify(employeeDao, times(1)).getAllEmployees();
    }

    @Test
    void insertEmployee() {
        employeeService.insertEmployee(employee);

        verify(employeeDao, times(1)).insertEmployee(any(Employee.class));
    }

    @Test
    void getEmployeeById() {
        when(employeeDao.getEmployeeById(anyInt())).thenReturn(employee);

        Employee employeeById = employeeService.getEmployeeById(1);

        assertThat(employee).isEqualToComparingFieldByField(employeeById);
        verify(employeeDao, times(1)).getEmployeeById(anyInt());
    }

    @Test
    void deleteEmployeeById() {
        employeeService.deleteEmployeeById(1);

        verify(employeeDao, times(1)).deleteEmployeeById(anyInt());
    }

    @Test
    void updateEmployee() {
        employeeService.updateEmployee(employee);

        verify(employeeDao, times(1)).updateEmployee(any(Employee.class));
    }
}