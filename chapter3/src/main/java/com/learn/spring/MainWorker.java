package com.learn.spring;

import com.learn.spring.dao.WorkerDao;
import com.learn.spring.entity.Employee;
import com.learn.spring.entity.Worker;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainWorker {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        WorkerDao dao = ctx.getBean(WorkerDao.class);

        System.out.println("Workers count: " + dao.countWorkers());

        System.out.println(">>> Before insert");
        dao.getWorkers().forEach(System.out::println);
        System.out.println(" ======================== ");

        System.out.println(">>> Get worker by id: ");
        System.out.println(dao.getWorkerById(1));
        System.out.println(" ======================== ");

        dao.insertWorker(new Worker(null, "Anna", 32));

        System.out.println(">>> After insert");
        dao.getWorkers().forEach(System.out::println);
        System.out.println(" ======================== ");

        System.out.println(">>> Delete first and print result");
        dao.deleteWorkerById(1);
        dao.getWorkers().forEach(System.out::println);
        System.out.println(" ======================== ");

        //Workers count: 2
        //>>> Before insert
        //Worker(id=1, name=Dmitrii, age=31)
        //Worker(id=2, name=Irina, age=58)
        // ========================
        //>>> Get worker by id:
        //Worker(id=1, name=Dmitrii, age=31)
        // ========================
        //>>> After insert
        //Worker(id=1, name=Dmitrii, age=31)
        //Worker(id=2, name=Irina, age=58)
        //Worker(id=3, name=Anna, age=32)
        // ========================
        //>>> Delete first and print result
        //Worker(id=2, name=Irina, age=58)
        //Worker(id=3, name=Anna, age=32)
        // ========================
    }

}
