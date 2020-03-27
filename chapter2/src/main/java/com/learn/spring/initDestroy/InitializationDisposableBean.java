package com.learn.spring.initDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class InitializationDisposableBean implements InitializingBean, DisposableBean {

    // ----------- Initialization --------------

    @PostConstruct
    public void postConstructMethod() {
        System.out.println("Annotated @PostConstruct Method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean's afterPropertiesSet method");
    }

    public void myInit() {
        System.out.println("XML declared init method");
    }

    // ----------- Destruction --------------

    @PreDestroy
    public void preDestroyMethod() {
        System.out.println("Annotated @PreDestroy Method");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean's bean afterPropertiesSet method");
    }


    public void myDestroy() {
        System.out.println("XML declared destroy method");
    }
}
