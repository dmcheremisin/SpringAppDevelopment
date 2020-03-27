package com.learn.spring;

import com.learn.spring.atm.ATM;
import com.learn.spring.containers.EmployeeContainer;
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

        EmployeeContainer employeeContainer = ctx.getBean(EmployeeContainer.class);
        System.out.println(employeeContainer.getLists()); // [Donald Trump, Barack Obama, George Bush]
        System.out.println(employeeContainer.getSets()); // [Emmanuel Macron, Francois Hollande]
        System.out.println(employeeContainer.getMaps()); // {Johnson=Boris, May=Theresa, Cameron=David}

        ATM atm = (ATM) ctx.getBean("com.learn.spring.atm.ATM");
        atm.printBalance("123"); // Account balance is 0.0 for account number = 123
    }

}
