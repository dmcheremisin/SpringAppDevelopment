package com.learn.spring.dao.impl;

import com.learn.spring.dao.WorkerDao;
import com.learn.spring.entity.Worker;
import com.learn.spring.mapper.WorkerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkerDaoImpl implements WorkerDao {

    private final WorkerMapper workerMapper = new WorkerMapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer countWorkers() {
        return jdbcTemplate.queryForObject("select count(*) from worker", Integer.class);
    }

    @Override
    public List<Worker> getWorkers() {
        return jdbcTemplate.query("select * from worker", workerMapper);
    }

    @Override
    public Worker getWorkerById(int id) {
        return jdbcTemplate.queryForObject("select * from worker where id = ?", new Object[]{id}, workerMapper);
    }

    @Override
    public int insertWorker(Worker worker) {
        String insertQuery = "insert into worker (id, name, age) values (?, ?, ?) ";
        Object[] params = { worker.getId(), worker.getName(), worker.getAge() };
        return jdbcTemplate.update(insertQuery, params);
    }

    @Override
    public int deleteWorkerById(int id) {
        return jdbcTemplate.update("delete from worker where id = ?", id);
    }
}
