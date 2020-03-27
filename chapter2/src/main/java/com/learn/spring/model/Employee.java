package com.learn.spring.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    private String employeeName;
    private int employeeAge;
    private boolean married;

    public Employee(String employeeName, int employeeAge, boolean married) {
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.married = married;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeAge=" + employeeAge +
                ", married=" + married +
                '}';
    }
}
