package com.example.demo.service;
import com.example.demo.controller.CourseController;
import com.example.demo.entity.Course;
import com.example.demo.entity.Supporter;
import com.example.demo.entity.Topic;
import com.example.demo.model.request.CreatSupporterRequest;
import com.example.demo.model.request.UpdateSupporterRequest;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.SupporterRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class SupporterService {
    SupporterRepository supporterRepository;

    ObjectMapper objectMapper;

    Faker faker;
    CourseRepository courseRepository;

    public List<Supporter> getSupporter(){
        return supporterRepository.findAll();
    }

    public void deleteSp(Integer id) {
        Optional<Supporter> supporterOptional = supporterRepository.findById(id);
        if (supporterOptional.isPresent()) {
            Supporter supporter = supporterOptional.get();
            for (Course course : courseRepository.findAll()) {
                if (course.getSupporter().getId().equals(supporter.getId())){
                    courseRepository.delete(course);
                }
            }
            supporterRepository.delete(supporter);
        }
    }

    public Supporter save(CreatSupporterRequest creatSupporterRequest) {
            if (supporterRepository.existsByEmail(creatSupporterRequest.getEmail())){
                throw new RuntimeException("email đã tồn tại");
            }
            Supporter supporter=objectMapper.convertValue(creatSupporterRequest,Supporter.class);
            supporter.setAvatar(faker.company().logo());
            return supporterRepository.save(supporter);
    }

    public Supporter getSupporterId(Integer id) {
        Optional<Supporter> optional=supporterRepository.findById(id);
        return optional.orElse(null);
    }

    public void update(Integer id, UpdateSupporterRequest update) {
        Supporter supporter=supporterRepository.findById(id).orElse(null);
        if (supporter==null){
            return;
        }
        supporter.setName(update.getName());
        supporter.setPhone(update.getPhone());
        supporter.setAvatar(faker.company().logo());
        supporterRepository.save(supporter);
    }
}
