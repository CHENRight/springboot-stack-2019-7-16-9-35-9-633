package com.tw.apistackbase.service;

import com.tw.apistackbase.dao.CompanyDao;
import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;

    public List<Company> findAll() {
        return companyDao.findAll();
    }


    public List<Employee> obtainCompanyEmployeesByName(String companyName) {
        return companyDao.obtainCompanyEmployeesByName(companyName);
    }


    public Company obtainCompanyByName(String companyName) {
        return companyDao.obtainCompanyByName(companyName);
    }


    public List<Company> addCompanies(Company company) {
       return companyDao.addCompanies(company);
    }


    public Company updateCompany(Company company) {
        return companyDao.updateCompany(company);
    }



    public List<Company> delete(String companyName) {
        return companyDao.delete(companyName);
    }



    public List<Company> pageCompanies(int page, int pageSize) {
       return companyDao.pageCompanies(page,pageSize);
    }
}
