package com.example.myjpa.repository;

import com.example.myjpa.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
//    sử dụng method query
//    tìm kiếm theo tên và phân trang
    Page<Student>findByName (String name, Pageable pageable);

    List<Student> findByNameOrderByNameDesc(String name);

    List<Student> findByName(String name, Sort sort);

    @Query(nativeQuery = true,value = "select * from student where name=?1 order by name desc ")
    List<Student> findByNameSort(String name);

    Page<Student>findByNameContainingIgnoreCase (String name, Pageable pageable);

//    sử dụng native Query
    @Query(nativeQuery = true,value = "select * from student",countQuery = "select count(id) from student")
    Page<Student> getAllStudent(Pageable pageable);

    @Query(nativeQuery = true,value = "SELECT * FROM student WHERE LOWER(name) LIKE CONCAT('%', LOWER(:name), '%')",
            countQuery = "select count(student.id) from student WHERE LOWER(student.name) LIKE CONCAT('%', LOWER(:name), '%')")
    Page<Student>findByNameContainingIgnoreCaseUsingNQ (@Param("name") String name, Pageable pageable);
}
