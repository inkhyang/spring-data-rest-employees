package com.inkhyang.employees.repository;

import com.inkhyang.employees.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EmployeeRepositoryTest {
    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void should_save_employee(){
        //given
        var employee = new Employee();
        employee.setName("Vasya");
        employee.setRole("Alcoholic");
        //when
        employeeRepository.save(employee);
        //then
        var result = employeeRepository.findAll();
        assertThat(result)
                .isNotEmpty()
                .hasSize(1);
    }
}