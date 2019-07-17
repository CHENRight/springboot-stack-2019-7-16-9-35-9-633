package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Employee obtainEmployeeById(@PathVariable("id") int id) {
        return employeeService.obtainEmployeeById(id);
    }

    @GetMapping(params = {"page","pageSize"})
    public List<Employee> pageEmployees(@RequestParam(name = "page") int page,@RequestParam(name = "pageSize") int pageSize){
        return employeeService.pageEmployees(page,pageSize);
    }

    @GetMapping(params = "gender")
    public List<Employee> findEmployeeByGender(@RequestParam(name = "gender") String targetGender){
        return employeeService.findEmployeeByGender(targetGender);
    }

    @PostMapping
    public List<Employee> addEmployee(@RequestBody Employee employee) {
        if(employeeService.addEmployee(employee)){
            return employeeService.findAll();
        }
        return null;
    }

    @PutMapping
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee) ? employee : null;
    }

    @DeleteMapping("/{id}")
    public List<Employee> delete(@PathVariable int id) {
        return employeeService.delete(id) ? employeeService.findAll() : null;
    }

}
