package com.tw.apistackbase.dao;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;



import java.util.List;

public interface CompanyDao {

    List<Company> findAll();

    List<Employee> obtainCompanyEmployeesByName(String companyName);

    Company obtainCompanyByName(String companyName);

    List<Company> addCompanies(Company company);

    Company updateCompany(Company company);

    List<Company> delete(String companyName);

    List<Company> pageCompanies(int page,int pageSize);
}
