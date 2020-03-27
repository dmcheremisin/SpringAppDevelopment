package com.learn.spring.model;

public class Employee {

    private String employeeName;
    private int employeeAge;
    private boolean married;

    public Employee(String employeeName, int employeeAge, boolean married) {
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.married = married;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
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
