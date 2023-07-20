package com.example.chonqjetairwebapp.controller;
import com.example.chonqjetairwebapp.entity.Flight;
import com.example.chonqjetairwebapp.service.FlightService;
import com.example.chonqjetairwebapp.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/admin")
    public String adminProfile(){
        return "dashboard/db-dashboard";
    }


}
