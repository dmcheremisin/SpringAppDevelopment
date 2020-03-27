package com.learn.spring;

import com.learn.spring.dao.EmployeeDao;
import com.learn.spring.service.EmployeeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        EmployeeService employeeService = ctx.getBean("employeeService", EmployeeService.class);
        System.out.println(employeeService.generateEmployeeId()); // 66b082e1-61ff-4b4a-8384-cfa77b51091a

        System.out.println(employeeService.getEmployeeFromDb()); // Employee{employeeName='Ravi Kant Soni', employeeAge=31, married=true}

        EmployeeDao employeeDao = ctx.getBean(EmployeeDao.class);
        System.out.println(employeeDao.getEmployee2());// Employee{employeeName='John Thomson', employeeAge=55, married=true}
        System.out.println(employeeDao.getType()); // Stub Dao Impl
    }

}
