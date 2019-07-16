package com.tw.apistackbase;

import com.tw.apistackbase.controller.EmployeeController;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeDaoImplTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    EmployeeService employeeService;

    @Test
    void should_find_the_employee_when_given_a_valid_employee_ID() throws Exception {

        Employee employee = new Employee(1,"LiMing",22,"male",6000);

        when(employeeService.obtainEmployeeById(anyInt())).thenReturn(employee);
        ResultActions resultActions = mvc.perform(get("/employees/{id}",employee.getId()));

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.id",is(1)));

    }
}
