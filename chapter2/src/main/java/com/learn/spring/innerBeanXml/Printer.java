package com.learn.spring.innerBeanXml;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Printer {

    private String message;

    public void printBalance(String accountNumber) {
        System.out.println(message + accountNumber);
    }
}
