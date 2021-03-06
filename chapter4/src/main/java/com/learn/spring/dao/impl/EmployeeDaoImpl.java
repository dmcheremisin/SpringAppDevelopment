package com.learn.spring.dao.impl;

import com.learn.spring.dao.EmployeeDao;
import com.learn.spring.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private final SessionFactory sessionFactory;

    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee>  query = session.createQuery("FROM Employee", Employee.class);
        return query.list();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("FROM Employee E WHERE E.id = :id", Employee.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void insertEmployee(Employee employee) {
        employee.setId(null);
        Session session = sessionFactory.openSession();
        session.save(employee);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE FROM Employee E WHERE E.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
