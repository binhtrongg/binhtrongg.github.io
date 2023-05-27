package com.example.driver_car.controller;

import com.example.driver_car.model.DriverModel;
import com.example.driver_car.service.DriverService;
import com.example.driver_car.statics.DriverLicense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/drivers")
public class DriverController {
    DriverService driverService;

    @GetMapping
    public String getDriver(Model model){
        model.addAttribute("dsDriver",driverService.getDrivers());
        model.addAttribute("driverLicenses", DriverLicense.values());
        return "driver-list";
    }

    @GetMapping("/creat-form")
    public String showCreatForm(Model model, DriverModel driverModel){
        model.addAttribute("driverLicenses", DriverLicense.values());
        model.addAttribute("newDriver",driverModel);
        return "creat-driver";
    }

    @PostMapping("/add-driver")
    public String addDriver(@ModelAttribute("newDriver") @Valid DriverModel driverModel, Errors errors,Model model){
        if (null != errors && errors.getErrorCount() > 0) {
            model.addAttribute("driverLicenses", DriverLicense.values());
            return "creat-driver";
        } else {
            driverService.saveDriver(driverModel);
            return "redirect:/drivers";
        }
    }
    @GetMapping("update/{id}")
    public String ShowUpdateForm(@PathVariable int id,Model model){
        DriverModel driverModel=driverService.findById(id);
        model.addAttribute("driverLicenses", DriverLicense.values());
        model.addAttribute("updateDriver",driverModel);
        return "update-driver";
    }

    @PostMapping("/update")
    public String updateDriver(@ModelAttribute("updateDriver") @Valid DriverModel driverModel,Errors errors,Model model){
        if (null != errors && errors.getErrorCount() > 0) {
            model.addAttribute("driverLicenses", DriverLicense.values());
            return "update-driver";
        } else {
            driverService.updateDriver(driverModel);
            return "redirect:/drivers";
        }
    }
    @PostMapping("/delete/{id}")
    public String deleteDriver(@PathVariable("id") int id){
        driverService.deleteDriver(id);
        return "redirect:/drivers";
    }
}
