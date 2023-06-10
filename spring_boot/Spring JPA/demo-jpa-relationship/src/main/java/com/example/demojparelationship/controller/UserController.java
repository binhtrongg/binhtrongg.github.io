package com.example.demojparelationship.controller;

import com.example.demojparelationship.entity.Image;
import com.example.demojparelationship.entity.User;
import com.example.demojparelationship.service.ImgService;
import com.example.demojparelationship.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {

    final UserService userService;

    final ImgService imgService;

    @GetMapping("/")
    public String getUserPage(Model model) {
        List<User> allUser =userService.findAll();
        model.addAttribute("userList",allUser);
        return "index";
    }

    @GetMapping("/users/{id}/files")
    public String getFilesPage(Model model, @PathVariable Integer id) {
        List<Image>images=imgService.getListImgById(id);
        model.addAttribute("fileList",images);
        model.addAttribute("userId",id);
        return "file";
    }
}
