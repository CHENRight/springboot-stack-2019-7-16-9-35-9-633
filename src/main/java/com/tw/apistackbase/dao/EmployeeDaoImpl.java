package com.tw.apistackbase.dao;

import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.stream.Collectors;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    public List<Employee> employees = new ArrayList<>();

    public EmployeeDaoImpl(){
        employees.add(new Employee(1,"LiMing",22,"male",6000));
        employees.add(new Employee(2,"XiaoHong",11,"female",10000));
        employees.add(new Employee(3,"HanMeimei",19,"male",9000));
        employees.add(new Employee(4,"LiLei",15,"female",2000));
        employees.add(new Employee(5,"LaoWang",21,"male",5000));
    }

    @Override
    public Employee obtainEmployeeById(int id) {
        List<Employee> employees1 =  employees.stream().filter(employee1 -> id == employee1.getId()).collect(Collectors.toList());
        return employees1.size() > 0 ? employees1.get(0) : null;
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public List<Employee> findEmployeeByGender(String gender){
        List<Employee> sameGenderEmployees = employees.stream().filter(employee -> gender.equals(employee.getGender())).collect(Collectors.toList());
        return sameGenderEmployees.size() > 0 ? sameGenderEmployees : null;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if(employees.contains(employee)){
            return false;
        }
        employees.add(employee);
        return true;
    }


    @Override
    public boolean update(Employee employee) {
        List<Employee> employees =  this.employees.stream().filter(employee1 -> employee.equals(employee1)).collect(Collectors.toList());
        if(employees.size() > 0){
            employees.get(0).update(employee);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        List<Employee> employees =  this.employees.stream().filter(employee1 -> id == employee1.getId()).collect(Collectors.toList());
        if(employees.size() > 0){
            this.employees.remove(employees.get(0));
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> pageEmployees(int page, int pageSize) {
        int startEmployee = page * pageSize;
        int endEmployee = Math.min(employees.size(),startEmployee + pageSize);
        return employees.subList(startEmployee,endEmployee);
    }
}
