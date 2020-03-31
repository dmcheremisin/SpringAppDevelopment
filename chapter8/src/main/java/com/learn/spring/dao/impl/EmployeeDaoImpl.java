package com.learn.spring.dao.impl;

import com.learn.spring.dao.EmployeeDao;
import com.learn.spring.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeDaoImpl implements EmployeeDao {

    private final SessionFactory sessionFactory;

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
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE FROM Employee E WHERE E.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void updateEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }
}
