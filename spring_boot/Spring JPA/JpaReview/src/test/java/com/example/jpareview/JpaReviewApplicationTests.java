package com.example.jpareview;

import com.example.jpareview.entity.Cource;
import com.example.jpareview.entity.Supporter;
import com.example.jpareview.entity.Topic;
import com.example.jpareview.repository.CourceRepository;
import com.example.jpareview.repository.SupporterRepository;
import com.example.jpareview.repository.TopicReposiory;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class JpaReviewApplicationTests {
    @Autowired
    CourceRepository courceRepository;

    @Autowired
    SupporterRepository supporterRepository;

    @Autowired
    TopicReposiory topicReposiory;

    @Autowired
    Faker faker;
    

}
