package com.example.demojparelationship.controller;
import com.example.demojparelationship.entity.Image;
import com.example.demojparelationship.entity.User;
import com.example.demojparelationship.service.ImgService;
import com.example.demojparelationship.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@RequestMapping
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImgController {

    final ImgService imgService;

    final UserService userService;


    @PostMapping("api/v1/files")
    public ResponseEntity<?> uploadFile(@RequestParam("userId") Integer userId, @RequestParam("file") MultipartFile file) {
        try {
            byte[] fileContent = file.getBytes();
            Image uploadFile = new Image();
            uploadFile.setType(file.getOriginalFilename());
            uploadFile.setData(fileContent);
            User user=userService.findUserById(userId);
            uploadFile.setUser(user);

            imgService.saveFile(uploadFile);
            return ResponseEntity.ok("File uploaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }



    @DeleteMapping("api/v1/files/{id}")
    public ResponseEntity<?> deleteFile(@PathVariable Integer id) {
        imgService.deleteById(id);
        return ResponseEntity.ok("");
    }

}
