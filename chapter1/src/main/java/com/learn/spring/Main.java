package com.learn.spring;

import com.learn.spring.impl.GreetingMessageServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        GreetingMessageService service1 = ctx.getBean(GreetingMessageService.class); // by interface
        System.out.println(service1.greetUser()); // "Welcome to Chapter-1"

        GreetingMessageService service2 = (GreetingMessageService) ctx.getBean("greetingMessageServiceImpl"); // by name
        System.out.println(service2.greetUser()); // "Welcome to Chapter-1"

        GreetingMessageService service3 = ctx.getBean("greetingMessageServiceImpl", GreetingMessageService.class); // by name
        System.out.println(service3.greetUser()); // "Welcome to Chapter-1"

        GreetingMessageService service4 = ctx.getBean("greetingMessageServiceImpl", GreetingMessageServiceImpl.class); // by name
        System.out.println(service4.greetUser()); // "Welcome to Chapter-1"

        GreetingMessageService service5 = ctx.getBean(GreetingMessageServiceImpl.class); // by class implementation
        System.out.println(service5.greetUser()); // "Welcome to Chapter-1"

        // GreetingMessageService service6 = (GreetingMessageService) ctx.getBean("GreetingMessageServiceImpl");// wrong bean name
        // NoSuchBeanDefinitionException: No bean named 'GreetingMessageServiceImpl' available
    }

}
