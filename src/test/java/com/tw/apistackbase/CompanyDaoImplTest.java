package com.tw.apistackbase;

import com.tw.apistackbase.controller.CompanyController;
import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CompanyController.class)
public class CompanyDaoImplTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    CompanyService companyService;

    @Test
    void should_return_the_employee_when_given_a_valid_company_Name() throws Exception {

        Employee employee1 = new Employee(1,"LiMing",22,"male",6000);
        Employee employee2 = new Employee(2,"XiaoHong",11,"female",10000);
        Employee employee3 = new Employee(3,"HanMeimei",19,"male",9000);
        Employee employee4 = new Employee(4,"LiLei",15,"female",2000);
        Employee employee5 = new Employee(5,"LaoWang",21,"male",5000);
        Company company = new Company("alibaba",500,employee1,employee2,employee3);

        when(companyService.obtainCompanyEmployeesByName(anyString())).thenReturn(company.getEmployees());

        ResultActions resultActions = mvc.perform(get("companies/{companyName}",company.getCompanyName()));


    }
}
