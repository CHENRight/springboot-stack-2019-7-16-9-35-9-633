package com.tw.apistackbase.dao;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;

import java.util.List;

public interface CompanyDao {

    List<Company> findAll();

    List<Employee> obtainCompanyEmployeesByName(String companyName);

    Company obtainCompanyByName(String companyName);

    boolean addCompanies(Company company);

    boolean updateCompany(Company company);

    boolean delete(String companyName);

    List<Company> pageCompanies(int page,int pageSize);
}
