package com.learn.spring;

import com.learn.spring.dao.EmployeeDao;
import com.learn.spring.entity.Employee;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        EmployeeDao employeeDao = ctx.getBean(EmployeeDao.class);

        System.out.println(">>> Before insert");
        employeeDao.getAllEmployees().forEach(System.out::println);
        System.out.println(" ======================== ");

        Employee employee = new Employee();
        employee.setFirstName("Vasya");
        employee.setLastName("Pupkin");
        employee.setJobTitle("Cleaner");
        employee.setDepartment("Office stuff");
        employee.setSalary(40000);
        employeeDao.insertEmployee(employee);

        System.out.println(">>> After insert");
        employeeDao.getAllEmployees().forEach(System.out::println);
        System.out.println(" ======================== ");

    }

}
