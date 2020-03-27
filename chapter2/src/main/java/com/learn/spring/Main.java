package com.learn.spring;

import com.learn.spring.innerBeanXml.ATM;
import com.learn.spring.collections.EmployeeContainer;
import com.learn.spring.dao.EmployeeDao;
import com.learn.spring.inheritance.Worker;
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

        ATM atm = (ATM) ctx.getBean("com.learn.spring.innerBeanXml.ATM");
        atm.printBalance("123"); // Account balance is 0.0 for account number = 123

        Worker russianWorker = ctx.getBean("russianWorker", Worker.class);
        System.out.println(russianWorker); //Worker(id=0, name=null, country=Russia)

        Worker realRussianWorker = ctx.getBean("realRussianWorker", Worker.class);
        System.out.println(realRussianWorker); //Worker(id=333, name=Vasilii Ivanov, country=Russia)

//        Worker abstractWorker = ctx.getBean("abstractWorker", Worker.class); Error creating bean with name 'abstractWorker':
//        Bean definition is abstract

        Worker implRussianWorker = ctx.getBean("implRussianWorker", Worker.class);
        System.out.println(implRussianWorker); //Worker(id=444, name=Fedor Petrov, country=Russia)

        ctx.close();

        // InitializationDisposableBean lifecycle methods:
        // >>> Initialization
        // 1. Annotated @PostConstruct Method
        // 2. InitializingBean's afterPropertiesSet method
        // 3. XML declared init method
        // >>> Destruction
        // 1. Annotated @PreDestroy Method
        // 2. DisposableBean's bean afterPropertiesSet method
        // 3. XML declared destroy method
    }

}
