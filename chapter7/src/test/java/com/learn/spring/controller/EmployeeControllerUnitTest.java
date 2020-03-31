package com.learn.spring.controller;

import com.learn.spring.entity.Employee;
import com.learn.spring.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerUnitTest {

    public static final String EMPLOYEE_PATH = "/employee";
    public static final String EMPLOYEE_PATH_ID = EMPLOYEE_PATH + "/{id}";
    public static final String ADD_EMPLOYEE_PAGE = EMPLOYEE_PATH + "/addEmployee";
    public static final String DELETE_EMPLOYEE = EMPLOYEE_PATH + "/delete";

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeController employeeController;

    private MockMvc mockMvc;

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
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    void getEmployees() throws Exception {
        when(employeeService.getAllEmployees()).thenReturn(List.of(employee));

        mockMvc.perform(get(EMPLOYEE_PATH))
                .andExpect(status().isOk())
                .andExpect(view().name("employee-list"))
                .andExpect(model().attributeExists("employees"))
                .andDo(print());

        verify(employeeService, times(1)).getAllEmployees();
    }

    @Test
    void getEmployeeById() throws Exception {
        when(employeeService.getEmployeeById(anyInt())).thenReturn(employee);

        mockMvc.perform(get(EMPLOYEE_PATH_ID, 1))
                .andExpect(status().isOk())
                .andExpect(view().name("employee"))
                .andExpect(model().attributeExists("employeeCommand"))
                .andDo(print());

        verify(employeeService, times(1)).getEmployeeById(anyInt());
    }

    @Test
    void getAddEmployeePage() throws Exception {
        mockMvc.perform(get(ADD_EMPLOYEE_PAGE))
                .andExpect(status().isOk())
                .andExpect(view().name("employee"))
                .andExpect(model().attributeExists("employeeCommand"))
                .andDo(print());
    }

    @Test
    void deleteEmployee() throws Exception {
        mockMvc.perform(get(DELETE_EMPLOYEE).param("id", "1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/employee"))
                .andDo(print());

        verify(employeeService, times(1)).deleteEmployeeById(anyInt());
    }

    @Test
    void addEmployeeTest() throws Exception {
        mockMvc.perform(
                post(EMPLOYEE_PATH)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("firstName", employee.getFirstName())
                        .param("lastName", employee.getLastName())
                        .param("jobTitle", employee.getJobTitle())
                        .param("department", employee.getDepartment())
                        .param("salary", employee.getSalary().toString()))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/employee"))
                .andDo(print());

        verify(employeeService, times(1)).insertEmployee(any(Employee.class));
    }

    @Test
    void updateEmployeeTest() throws Exception {
        mockMvc.perform(
                post(EMPLOYEE_PATH)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("id", "1")
                        .param("firstName", employee.getFirstName())
                        .param("lastName", employee.getLastName())
                        .param("jobTitle", employee.getJobTitle())
                        .param("department", employee.getDepartment())
                        .param("salary", employee.getSalary().toString()))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/employee"))
                .andDo(print());

        verify(employeeService, times(1)).updateEmployee(any(Employee.class));
    }
}