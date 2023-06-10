package com.example.demojparelationship.service;

import com.example.demojparelationship.entity.Image;
import com.example.demojparelationship.repository.ImgRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImgService {

    final ImgRepository imgRepository;




    public List<Image> getListImgById(Integer id) {
       return imgRepository.findImageByUserId(id);
    }

    public void deleteById(Integer id) {
        imgRepository.deleteById(id);
    }
    public void saveFile(Image uploadFile) {
        imgRepository.save(uploadFile);
    }
}
