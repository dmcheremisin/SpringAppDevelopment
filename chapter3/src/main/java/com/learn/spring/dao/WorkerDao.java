package com.learn.spring.dao;

import com.learn.spring.entity.Worker;

import java.util.List;

public interface WorkerDao {

    Integer countWorkers();

    List<Worker> getWorkers();

    Worker getWorkerById(int id);

    int insertWorker(Worker worker);

    int deleteWorkerById(int id);

}
