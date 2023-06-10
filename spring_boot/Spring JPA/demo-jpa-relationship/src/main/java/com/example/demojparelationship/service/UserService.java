package com.example.demojparelationship.service;

import com.example.demojparelationship.entity.User;
import com.example.demojparelationship.repository.UserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserService {

    final UserRepository userRepository;


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findUserById(Integer id){
        User user=userRepository.findById(id).get();
        return user ;
    }
}
