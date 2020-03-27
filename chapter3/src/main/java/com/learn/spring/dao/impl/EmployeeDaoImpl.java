package com.learn.spring.dao.impl;

import com.learn.spring.dao.EmployeeDao;
import com.learn.spring.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = new LinkedList<>();
        try(Connection conn = dataSource.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("select * from employee");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                employees.add(new Employee(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        try(Connection conn = dataSource.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("select * from employee where id = ? ");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                employee = new Employee(id, rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    @Override
    public void insertEmployee(Employee employee) {
        employee.setId(null);
        try(Connection conn = dataSource.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("insert into employee (name) values (?) ");
            ps.setString(1, employee.getName());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
