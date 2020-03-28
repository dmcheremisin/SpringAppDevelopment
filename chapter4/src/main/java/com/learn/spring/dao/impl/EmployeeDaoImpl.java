package com.learn.spring.dao.impl;

import com.learn.spring.dao.EmployeeDao;
import com.learn.spring.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private final SessionFactory sessionFactory;

    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Employee");
        List<Employee> employees = (List<Employee>) query.list();
        return employees;
    }

    @Override
    public void insertEmployee(Employee employee) {
        employee.setId(null);
        Session session = sessionFactory.openSession();
        session.save(employee);
    }
}
