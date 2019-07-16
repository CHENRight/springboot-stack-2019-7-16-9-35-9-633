package com.tw.apistackbase.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Company {
    private String companyName;
    private int employeesNumber;
    private List<Employee> employees = new ArrayList<>();

    Company(){}
    public Company(String companyName, int employeesNumber, Employee...employees1) {
        this.companyName = companyName;
        this.employeesNumber = employeesNumber;
        this.employees.addAll(Arrays.asList(employees1));
    }

    public String getCompanyName() {
        return companyName;
    }

    public void update(Company company){
        this.employeesNumber = company.employeesNumber;
        this.employees = company.employees;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(int employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
