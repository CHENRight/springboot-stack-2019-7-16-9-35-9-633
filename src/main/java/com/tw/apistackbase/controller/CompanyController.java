package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Company> findAll() {
        return companyService.findAll();
    }

    @GetMapping(value = "/{companyName}/employees")
    public List<Employee> obtainEmployeeById(@PathVariable("companyName") String companyName) {
        return companyService.obtainCompanyEmployeesByName(companyName);
    }

    @GetMapping(value = "/{companyName}")
    public Company obtainCompanyByName(@PathVariable("companyName") String companyName){
        return companyService.obtainCompanyByName(companyName);
    }

    @GetMapping(params = {"page","pageSize"})
    public List<Company> pageCompanies(@RequestParam(name = "page")int page,@RequestParam(name = "pageSize") int pageSize){
        return companyService.pageCompanies(page - 1,pageSize);
    }

    @PostMapping
    public List<Company> addCompany(@RequestBody Company company) {
        if(companyService.addCompanies(company)){
            return companyService.findAll();
        }
        return null;
    }

    @PutMapping
    public Company update(@RequestBody Company company) {
        return companyService.updateCompany(company) ? company : null;
    }

    @DeleteMapping("/{companyName}")
    public List<Company> delete(@PathVariable String companyName) {
        return companyService.delete(companyName) ? companyService.findAll() : null;
    }
}
