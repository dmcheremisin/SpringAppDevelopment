package com.learn.spring.dao.impl;

import com.learn.spring.dao.EmployeeDao;
import com.learn.spring.model.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDaoImpl implements EmployeeDao {

    private Employee employee1;
    private Employee employee2;

    private String type;

    @Override
    public Employee getEmployeeFromDb() {
        return employee1;
    }

}
