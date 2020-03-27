package com.learn.spring.impl;

import com.learn.spring.GreetingMessageService;
import org.springframework.stereotype.Service;

@Service
public class GreetingMessageServiceImpl implements GreetingMessageService {

    @Override
    public String greetUser() {
        return "Welcome to Chapter-1";
    }
}
