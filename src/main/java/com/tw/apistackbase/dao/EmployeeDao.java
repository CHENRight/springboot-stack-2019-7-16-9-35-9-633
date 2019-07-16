package com.tw.apistackbase.dao;

import com.tw.apistackbase.model.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee obtainEmployeeById(int id);
    List<Employee> findAll();
    boolean addEmployee(Employee employee);
    boolean update(Employee employee);
    boolean delete(int id);

    List<Employee> pageEmployees(int page,int pageSize);

    List<Employee> findEmployeeByGender(String gender);

}
