package com.learn.spring;

import com.learn.spring.dao.EmployeeDao;
import com.learn.spring.entity.Employee;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEmployee {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        EmployeeDao dao = ctx.getBean(EmployeeDao.class);

        System.out.println(">>> Before insert");
        dao.getEmployees().forEach(System.out::println);
        System.out.println(" ======================== ");

        System.out.println(">>> Get employee by id: ");
        System.out.println(dao.getEmployeeById(1));
        System.out.println(" ======================== ");

        dao.insertEmployee(new Employee(null, "Anna"));

        System.out.println(">>> After insert");
        dao.getEmployees().forEach(System.out::println);
        System.out.println(" ======================== ");
    }

    //>>> Before insert
    //Employee(id=1, name=Dmitrii)
    //Employee(id=2, name=Irina)
    // ========================
    //>>> Get employee by id:
    //Employee(id=1, name=Dmitrii)
    // ========================
    //>>> After insert
    //Employee(id=1, name=Dmitrii)
    //Employee(id=2, name=Irina)
    //Employee(id=3, name=Anna)
    // ========================

}
