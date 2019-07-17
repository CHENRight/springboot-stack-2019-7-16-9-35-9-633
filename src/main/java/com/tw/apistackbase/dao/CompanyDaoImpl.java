package com.tw.apistackbase.dao;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CompanyDaoImpl implements CompanyDao{
    public List<Company> companies = new ArrayList<>();
    Employee employee1 = new Employee(1, "LiMing", 22, "male", 6000);
    Employee employee2 = new Employee(2,"XiaoHong",11,"female",10000);
    Employee employee3 = new Employee(3,"HanMeimei",19,"male",9000);
    Employee employee4 = new Employee(4,"LiLei",15,"female",2000);
    Employee employee5 = new Employee(5,"LaoWang",21,"male",5000);

    public CompanyDaoImpl(){
        companies.add(new Company("alibaba",500,employee1,employee2));
        companies.add(new Company("tencent",400,employee3,employee4));
        companies.add(new Company("baidu",300,employee5));
    }

    @Override
    public List<Company> findAll() {
        return companies;
    }

    @Override
    public List<Employee> obtainCompanyEmployeesByName(String companyName) {
        List<Company> targetCompany = companies.stream().filter(company -> company.getCompanyName().equals(companyName)).collect(Collectors.toList());
        if(targetCompany.size() > 0){
            return targetCompany.get(0).getEmployees();
        }
        return null;
    }

    @Override
    public Company obtainCompanyByName(String companyName) {
        List<Company> targetCompany = companies.stream().filter(company -> company.getCompanyName().equals(companyName)).collect(Collectors.toList());
        if(targetCompany.size() > 0){
            return targetCompany.get(0);
        }
        return null;
    }

    @Override
    public List<Company> addCompanies(Company company) {
        if(companies.contains(company)){
            return null;
        }
        companies.add(company);
        return companies;
    }

    @Override
    public Company updateCompany(Company company) {
        List<Company> companies1 =  this.companies.stream().filter(company1 -> company.getCompanyName().equals(company1.getCompanyName())).collect(Collectors.toList());
        if(companies1.size() > 0){
            companies1.get(0).update(company);
            return companies1.get(0);
        }
        return null;
    }

    @Override
    public List<Company> delete(String companyName) {
        List<Company> companies1 =  this.companies.stream().filter(company -> companyName.equals(company.getCompanyName())).collect(Collectors.toList());
        if(companies1.size() > 0){
            this.companies.remove(companies1.get(0));
            return companies;
        }
        return null;
    }

    @Override
    public List<Company> pageCompanies(int page, int pageSize) {
        int startCompany = page * pageSize;
        int endCompany = Math.min(companies.size(),startCompany + pageSize);
        return companies.subList(startCompany,endCompany);
    }
}
