package com.learn.spring;

import com.learn.spring.dao.EmployeeDao;
import com.learn.spring.entity.Employee;
import com.learn.spring.service.EmployeeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        EmployeeService employeeService = ctx.getBean(EmployeeService.class);

        System.out.println(">>> Before insert");
        employeeService.getAllEmployees().forEach(System.out::println);
        System.out.println(" ======================== ");

        Employee employee = new Employee();
        employee.setFirstName("Vasya");
        employee.setLastName("Pupkin");
        employee.setJobTitle("Cleaner");
        employee.setDepartment("Office stuff");
        employee.setSalary(40000);
        employeeService.insertEmployee(employee);

        System.out.println(">>> After insert");
        employeeService.getAllEmployees().forEach(System.out::println);
        System.out.println(" ======================== ");
    }

    //>>> Before insert
    //Hibernate: select employee0_.id as id1_0_, employee0_.department as departme2_0_, employee0_.first_name as first_na3_0_, employee0_.job_title as job_titl4_0_, employee0_.last_name as last_nam5_0_, employee0_.salary as salary6_0_ from employee employee0_
    //Employee(id=1, firstName=Dmitrii, lastName=Cheremisin, jobTitle=Software Developer, department=IT, salary=100000)
    //Employee(id=2, firstName=Irina, lastName=Cheremisina, jobTitle=CEO, department=Administrative, salary=200000)
    // ========================
    //Hibernate: insert into employee (department, first_name, job_title, last_name, salary) values (?, ?, ?, ?, ?)
    //>>> After insert
    //Hibernate: select employee0_.id as id1_0_, employee0_.department as departme2_0_, employee0_.first_name as first_na3_0_, employee0_.job_title as job_titl4_0_, employee0_.last_name as last_nam5_0_, employee0_.salary as salary6_0_ from employee employee0_
    //Employee(id=1, firstName=Dmitrii, lastName=Cheremisin, jobTitle=Software Developer, department=IT, salary=100000)
    //Employee(id=2, firstName=Irina, lastName=Cheremisina, jobTitle=CEO, department=Administrative, salary=200000)
    //Employee(id=3, firstName=Vasya, lastName=Pupkin, jobTitle=Cleaner, department=Office stuff, salary=40000)
    // ========================

}
