package com.example.driver_car.controller;

import com.example.driver_car.model.DriverAssignmentModel;
import com.example.driver_car.model.DriverModel;
import com.example.driver_car.service.DriverAssService;
import com.example.driver_car.service.DriverService;
import com.example.driver_car.service.RouteService;
import com.example.driver_car.statics.DriverLicense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/driverAss")
@AllArgsConstructor
public class DriverAssignmentController {
    DriverAssService driverAssService;
    DriverService driverService;
    RouteService routeService;

    @GetMapping
    public String ShowDriverAss(Model model){
        model.addAttribute("dsDriver",driverService.getDrivers());
        model.addAttribute("dsRoute",routeService.getRoutes());
        model.addAttribute("dsDriverAss",driverAssService.getDriverAss());
        return "driverAss-list";
    }

    @GetMapping("/creat-form")
    public String showCreatForm(Model model, DriverAssignmentModel driverAssignmentModel){
        model.addAttribute("dsDriver",driverService.getDrivers());
        model.addAttribute("dsRoute",routeService.getRoutes());
        model.addAttribute("newDriverAss",driverAssignmentModel);
        return "creat-driverAss";
    }

    @PostMapping("/add-driverAss")
    public String addDriver(@ModelAttribute("newDriverAss") @Valid DriverAssignmentModel driverAssignmentModel, Errors errors,Model model){
        if (null != errors && errors.getErrorCount() > 0) {
            model.addAttribute("dsDriver",driverService.getDrivers());
            model.addAttribute("dsRoute",routeService.getRoutes());
            model.addAttribute("newDriverAss",driverAssignmentModel);
            return "creat-driverAss";
        } else {
            driverAssService.saveDriverAss(driverAssignmentModel);
            return "redirect:/driverAss";
        }
    }

    @GetMapping("update/{id}")
    public String ShowUpdateForm(@PathVariable int id, Model model){
        DriverAssignmentModel driverAssignmentModel=driverAssService.findById(id);
        model.addAttribute("dsDriver",driverService.getDrivers());
        model.addAttribute("dsRoute",routeService.getRoutes());
        model.addAttribute("updateDriverAss",driverAssignmentModel);
        return "update-driverAss";
    }

    @PostMapping("/update")
    public String updateDriverAss(@ModelAttribute("updateDriverAss") DriverAssignmentModel driverAssignmentModel){
        driverAssService.updateDriverAss(driverAssignmentModel);
        return "redirect:/driverAss";
    }
}
