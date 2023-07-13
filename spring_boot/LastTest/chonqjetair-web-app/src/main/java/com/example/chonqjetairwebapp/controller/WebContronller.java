package com.example.chonqjetairwebapp.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class WebContronller {

    @GetMapping("")
    public String web(){
        return "frontend/layout-index";
    }

    @GetMapping("/login")
    public String login(){
        return "frontend/layout-login";
    }

    @GetMapping("/my-profile")
    public String muprofile() {
        return "frontend/layout-my-profile";
    }
}
