package com.example.jpareview.service;

import com.example.jpareview.entity.Cource;
import com.example.jpareview.entity.Supporter;
import com.example.jpareview.repository.CourceRepository;
import com.example.jpareview.repository.SupporterRepository;
import com.example.jpareview.statics.Type;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourceService {

    CourceRepository courceRepository;

    SupporterRepository supporterRepository;


    public List<Cource> getAll() {
        return courceRepository.findAll();
    }

    public List<Cource> getByType(Type onlab) {
        return courceRepository.getCourceByType(onlab);
    }

    public Supporter getSupporterByCourseid(Integer id) {
        Optional<Cource> courceOptional=courceRepository.findById(id);
        Cource cource=courceOptional.get();
        return supporterRepository.getSupporterByCources(cource);
    }

    public Cource getCourceById(Integer id) {
        return courceRepository.findById(id).get();
    }
}
