package com.example.myjpa;

import com.example.myjpa.entity.Employee;
import com.example.myjpa.entity.User;
import com.example.myjpa.repository.EmployeeRepository;
import com.example.myjpa.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class MyJpaApplicationTests {
    @Autowired
    EmployeeRepository employeeRepository;




    @Test
    void saveUserList() {
        List<Employee>employees=List.of(
                new Employee(null,"tran van a","ban a", 200000L,LocalDate.now()),
                new Employee(null,"tran van b","ban b", 300000L,LocalDate.now()),
                new Employee(null,"tran van c","ban c", 400000L,LocalDate.now()),
                new Employee(null,"tran van d","ban d", 500000L,LocalDate.now())
        );
        employeeRepository.saveAll(employees);
    }
}
