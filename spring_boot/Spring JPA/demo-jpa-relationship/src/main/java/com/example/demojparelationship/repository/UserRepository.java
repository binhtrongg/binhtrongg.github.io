package com.example.demojparelationship.repository;

import com.example.demojparelationship.entity.Image;
import com.example.demojparelationship.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {



}