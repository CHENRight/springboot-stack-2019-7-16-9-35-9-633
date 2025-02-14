package com.tw.apistackbase.model;

import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private int age;
    private String gender;
    private int salary;

    Employee(){}

    public Employee(int id, String name, int age, String gender, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public void update(Employee employee){
        this.name = employee.name;
        this.age = employee.age;
        this.gender = employee.gender;
        this.salary = employee.salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getGender() {
        return gender;
    }

    public int getId() {
        return id;
    }

}
