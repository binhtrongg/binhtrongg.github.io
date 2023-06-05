package com.example.driver.controller;

import com.example.driver.model.request.DriverCreateRequest;
import com.example.driver.model.request.DriverUpdateRequest;
import com.example.driver.service.DriverService;
import com.example.driver.statics.DriverLicense;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping
public class DriverController {
    DriverService driverService;

    @GetMapping("/drivers")
    public String getDriver(Model model){
        model.addAttribute("dsDriver",driverService.getDrivers());
        model.addAttribute("driverLicenses", DriverLicense.values());
        model.addAttribute("newDriver",new DriverCreateRequest());
        return "driver-list";
    }


    @PostMapping("/drivers")
    public String createNewStudent(@ModelAttribute("newDriver")  DriverCreateRequest newDriver) {
        driverService.saveDriver(newDriver);
        return "redirect:/drivers";
    }
    @PostMapping("drivers/delete/{id}")
    public String deleteDriver(@PathVariable("id") int id){
        driverService.deleteDriver(id);
        return "redirect:/drivers";
    }

    @GetMapping("/api/drivers/{id}")
    public ResponseEntity<?> getDriver(@PathVariable Integer id) {
        return ResponseEntity.ok(driverService.findById(id));
    }

    @PutMapping("/api/drivers/{id}")
    public ResponseEntity<?> updateDriver(@PathVariable Integer id, @RequestBody @Valid DriverUpdateRequest driverUpdateRequest) {
        driverUpdateRequest.setId(id);
        driverService.updateDriver(driverUpdateRequest);
        return ResponseEntity.ok(null);
    }
}
