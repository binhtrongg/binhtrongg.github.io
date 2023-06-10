package com.example.demojparelationship.repository;

import com.example.demojparelationship.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImgRepository extends JpaRepository<Image,Integer> {


   List<Image> findImageByUserId(Integer id);
}
