package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Supporter;
import com.example.demo.entity.Topic;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.TopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;

    CourseRepository courseRepository;

    public List<Topic> getAllTopic() {
        return topicRepository.findAll();
    }

    public Topic save(String name)throws RuntimeException {
        if (topicRepository.existsByName(name)){
            throw new RuntimeException("tên đã tồn tại");
        }
        Topic topic=new Topic();
        topic.setName(name);
        return topicRepository.save(topic);
    }

    public void deleteTopic(Integer id) {
            Optional<Topic> topicOptional = topicRepository.findById(id);
            if (topicOptional.isPresent()) {
                Topic thisTopic = topicOptional.get();
                List<Course> courses = courseRepository.findByTopics(thisTopic);
                for (Course course : courses) {
                    course.getTopics().remove(thisTopic);
                    courseRepository.save(course);
                }
                topicRepository.delete(thisTopic);
            }
        }

    public Topic getTopic(Integer id) {
        return topicRepository.findById(id).orElse(null);
    }

    public Topic update(Integer id, String name) throws RuntimeException{
        Topic topic=getTopic(id);
        for (Topic t:topicRepository.findAll()) {
            if (t.getName().equals(name)){
                throw new RuntimeException("tên đã tồn tại rồi");
            }
        }
        topic.setName(name);
        return topicRepository.save(topic);
    }
}
