package com.tw.apistackbase.service;

import com.tw.apistackbase.dao.EmployeeDao;
import com.tw.apistackbase.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;


    public Employee obtainEmployeeById(int id) {
        return employeeDao.obtainEmployeeById(id);
    }


    public List<Employee> findAll() {
        return employeeDao.findAll();
    }


    public List<Employee> findEmployeeByGender(String gender) {
        return employeeDao.findEmployeeByGender(gender);
    }


    public boolean addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }


    public boolean update(Employee employee) {
       return employeeDao.update(employee);
    }


    public boolean delete(int id) {
        return employeeDao.delete(id);
    }


    public List<Employee> pageEmployees(int page, int pageSize) {
       return employeeDao.pageEmployees(page,pageSize);
    }

}
