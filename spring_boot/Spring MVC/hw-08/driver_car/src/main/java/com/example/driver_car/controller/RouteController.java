package com.example.driver_car.controller;

import com.example.driver_car.model.DriverModel;
import com.example.driver_car.model.RouteModel;
import com.example.driver_car.service.RouteService;
import com.example.driver_car.statics.DriverLicense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("routes")
public class RouteController {
    RouteService routeService;

    @GetMapping
    public String showRoute(Model model){
        model.addAttribute("dsRoute",routeService.getRoutes());
        return "route-list";
    }

    @GetMapping("/creat-form")
    public String showCreatForm(Model model, RouteModel routeModel){
        model.addAttribute("newRoute",routeModel);
        return "creat-route";
    }

    @PostMapping("/add-route")
    public String addRoute(@ModelAttribute("newRoute") @Valid RouteModel routeModel, Errors errors){
        if (null != errors && errors.getErrorCount() > 0) {
            return "creat-route";
        } else {
            routeService.saveRoute(routeModel);
            return "redirect:/routes";
        }
    }

    @GetMapping("update/{id}")
    public String ShowUpdateForm(@PathVariable int id, Model model){
        RouteModel routeModel=routeService.findById(id);
        model.addAttribute("updateRoute",routeModel);
        return "update-route";
    }

    @PostMapping("/update")
    public String updateRoute(@ModelAttribute("updateRoute") @Valid RouteModel routeModel,Errors errors){
        if (null != errors && errors.getErrorCount() > 0) {
            return "update-route";
        } else {
            routeService.updateRoute(routeModel);
            return "redirect:/routes";
        }
    }
    @PostMapping("/delete/{id}")
    public String deleteRoute(@PathVariable("id") int id){
        routeService.deleteRoute(id);
        return "redirect:/routes";
    }
}
