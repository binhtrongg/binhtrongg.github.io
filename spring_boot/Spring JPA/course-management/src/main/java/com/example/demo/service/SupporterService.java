package com.example.demo.service;
import com.example.demo.entity.Supporter;
import com.example.demo.repository.SupporterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class SupporterService {
    SupporterRepository supporterRepository;

    public List<Supporter> getSupporter(){
        return supporterRepository.findAll();
    }
}
