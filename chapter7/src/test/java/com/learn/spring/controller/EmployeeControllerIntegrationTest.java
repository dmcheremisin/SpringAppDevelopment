package com.learn.spring.controller;

import com.learn.spring.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static com.learn.spring.controller.EmployeeControllerUnitTest.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring-context-test.xml")
@WebAppConfiguration
@Transactional
class EmployeeControllerIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

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
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void getEmployees() throws Exception {
        mockMvc.perform(get(EMPLOYEE_PATH))
                .andExpect(status().isOk())
                .andExpect(view().name("employee-list"))
                .andExpect(model().attributeExists("employees"))
                .andDo(print());
    }

    @Test
    void getEmployeeById() throws Exception {
        mockMvc.perform(get(EMPLOYEE_PATH_ID, 1))
                .andExpect(status().isOk())
                .andExpect(view().name("employee"))
                .andExpect(model().attributeExists("employeeCommand"))
                .andDo(print());
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
    }
}