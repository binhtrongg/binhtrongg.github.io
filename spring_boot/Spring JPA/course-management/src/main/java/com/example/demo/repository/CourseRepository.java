package com.example.demo.repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Page<Course> findByType(Pageable pageable, String type);

    List<Course> findByType(String type);

    List<Course> findByTopics(Topic thisTopic);
}