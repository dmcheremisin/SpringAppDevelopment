package com.learn.spring.mapper;

import com.learn.spring.entity.Worker;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkerMapper implements RowMapper<Worker> {

    @Override
    public Worker mapRow(ResultSet rs, int rowNum) throws SQLException {
        Worker worker = new Worker();
        worker.setId(rs.getInt("id"));
        worker.setName(rs.getString("name"));
        worker.setAge(rs.getInt("age"));
        return worker;
    }
}
