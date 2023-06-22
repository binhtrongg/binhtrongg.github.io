package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Supporter;
import com.example.demo.entity.Topic;
import com.example.demo.model.request.CourseRequest;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.SupporterRepository;
import com.example.demo.repository.TopicRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    TopicRepository topicRepository;

    SupporterRepository supporterRepository;

    ObjectMapper objectMapper;

    Faker faker;

    public Page<Course> getAllCourse(Integer page, Integer pageSize) {
        Pageable pageRequest = PageRequest.of(page - 1, pageSize);
        return courseRepository.findAll(pageRequest);
    }

    public Page<Course> getAllCourse(Integer page, Integer pageSize, String type) {
        Pageable pageRequest = PageRequest.of(page - 1, pageSize);
        return courseRepository.findByType(pageRequest, type);
    }

    public List<Course> getAllCourse(String type) {
        return courseRepository.findByType(type);
    }

    public Course getCourseDetail(Integer id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("Not found course with id = " + id);
                });
    }

    public void save(CourseRequest courseRequest) {
        Set<Topic> topics=new LinkedHashSet<>();
        Supporter supporter=supporterRepository.findById(courseRequest.getSupporterId()).orElse(null);
        for (Integer topic:courseRequest.getTopicIds()) {
            topics.add(topicRepository.findById(topic).orElse(null));
        }
        Course course=objectMapper.convertValue(courseRequest,Course.class);
        course.setThumbnail(faker.company().logo());
        course.setTopics(topics);
        course.setSupporter(supporter);
        courseRepository.save(course);
    }

    public Course findById(Integer id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void updateCourse(Integer id, CourseRequest courseRequest) {
       Course course= courseRepository.findById(id).orElse(null);
        Set<Topic> topics=new LinkedHashSet<>();
        Supporter supporter=supporterRepository.findById(courseRequest.getSupporterId()).orElse(null);
        for (Integer topic:courseRequest.getTopicIds()) {
            topics.add(topicRepository.findById(topic).orElse(null));
        }
        if (course!=null){
            course.setName(courseRequest.getName());
            course.setDescription(courseRequest.getDescription());
            course.setType(courseRequest.getType());
            course.setSupporter(supporter);
            course.setTopics(topics);
            courseRepository.save(course);
        }
    }

    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }
}
