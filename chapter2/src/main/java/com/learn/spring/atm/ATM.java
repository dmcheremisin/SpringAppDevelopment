package com.learn.spring.atm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ATM {

    private Printer printer;

    public void printBalance(String accountNumber) {
        getPrinter().printBalance(accountNumber);
    }

}
