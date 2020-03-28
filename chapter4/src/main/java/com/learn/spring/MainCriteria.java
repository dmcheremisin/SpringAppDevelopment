package com.learn.spring;

import com.learn.spring.dao.CriteriaEmployeeDao;
import com.learn.spring.entity.Employee;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainCriteria {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        CriteriaEmployeeDao dao = ctx.getBean(CriteriaEmployeeDao.class);

        System.out.println(">>> All employees");
        dao.getAllEmployees().forEach(System.out::println);
        System.out.println(" ======================== ");

        System.out.println("Employee by id: " + dao.getEmployeeById(1));

        System.out.println("Employee by salary between 90000 and 110000: ");
        List<Employee> employeesBySalaryBetween = dao.getEmployeesBySalaryBetween(90000, 110000);
        System.out.println(employeesBySalaryBetween);

        //Employee(id=1, firstName=Dmitrii, lastName=Cheremisin, jobTitle=Software Developer, department=IT, salary=100000)
        //Employee(id=2, firstName=Irina, lastName=Cheremisina, jobTitle=CEO, department=Administration, salary=200000)
        // ========================
        //Employee by id: Employee(id=1, firstName=Dmitrii, lastName=Cheremisin, jobTitle=Software Developer, department=IT, salary=100000)
        //Employee by salary between 90000 and 110000:
        //[Employee(id=1, firstName=Dmitrii, lastName=Cheremisin, jobTitle=Software Developer, department=IT, salary=100000)]
    }
}
