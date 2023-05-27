package com.example.spring_mvc.controller;

import com.example.spring_mvc.Service.CarService;
import com.example.spring_mvc.model.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/cars")
public class CarController {
    CarService carService;
    @GetMapping
    public String getCar(Model model){
        List<Car>cars=carService.getCars();
        model.addAttribute("dsCar",cars);
        return "list-car";
    }
}
