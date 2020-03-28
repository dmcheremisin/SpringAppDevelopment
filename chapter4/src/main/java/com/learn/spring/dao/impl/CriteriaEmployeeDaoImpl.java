package com.learn.spring.dao.impl;

import com.learn.spring.dao.CriteriaEmployeeDao;
import com.learn.spring.entity.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CriteriaEmployeeDaoImpl implements CriteriaEmployeeDao {

    private final SessionFactory sessionFactory;

    public CriteriaEmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Employee.class);
        return criteria.list();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.add(Restrictions.eq("id", id));
        return (Employee) criteria.list().get(0);
    }

    @Override
    public List<Employee> getEmployeesBySalaryBetween(Integer min, Integer max) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.add(Restrictions.between("salary", min, max));
        return criteria.list();
    }
}
