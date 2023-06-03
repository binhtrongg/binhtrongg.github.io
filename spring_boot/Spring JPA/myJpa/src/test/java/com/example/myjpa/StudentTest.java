package com.example.myjpa;

import com.example.myjpa.entity.Student;
import com.example.myjpa.repository.StudentRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
public class StudentTest {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    Faker faker;


    @Test
    void saverUser(){
        for (int i = 0; i <30 ; i++) {
            Student student=new Student(
                    null,
                    faker.name().fullName(),
                    faker.internet().emailAddress()
            );
            studentRepository.save(student);
        }
    }

    @Test
    void findAllPageable(){
        PageRequest request=PageRequest.of(0,10);
        Page<Student> page=studentRepository.findAll(request);

        page.getContent().forEach(System.out::println);


        PageRequest request1=PageRequest.of(0,10);
        Page<Student> page1=studentRepository.getAllStudent(request1);

        page1.getContent().forEach(System.out::println);
    }

    @Test
    void findStudent(){
        PageRequest request=PageRequest.of(0,10);
        Page<Student> page=studentRepository.findByNameContainingIgnoreCase("a",request);

        page.getContent().forEach(System.out::println);


        PageRequest request1=PageRequest.of(0,10);
        Page<Student> page1=studentRepository.findByNameContainingIgnoreCaseUsingNQ("a",request1);

        page1.getContent().forEach(System.out::println);
    }
}
