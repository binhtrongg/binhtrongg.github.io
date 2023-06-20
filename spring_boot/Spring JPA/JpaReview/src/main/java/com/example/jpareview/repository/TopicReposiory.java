package com.example.jpareview.repository;

import com.example.jpareview.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicReposiory extends JpaRepository<Topic,Integer> {
}
