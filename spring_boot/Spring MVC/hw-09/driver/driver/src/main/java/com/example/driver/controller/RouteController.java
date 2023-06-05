package com.example.driver.controller;

import com.example.driver.model.request.DriverCreateRequest;
import com.example.driver.model.request.DriverUpdateRequest;
import com.example.driver.model.request.RouteCreateRequest;
import com.example.driver.model.request.RouteUpdateRequest;
import com.example.driver.service.RouteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping
@AllArgsConstructor
public class RouteController {
    RouteService routeService;

    @GetMapping("/routes")
    public String getRoute(Model model){
        model.addAttribute("dsRoute",routeService.getRoutes());
        model.addAttribute("newRoute",new RouteCreateRequest());
        return "route-list";
    }

    @PostMapping("/routes")
    public String createNewRoute(@ModelAttribute("newRoute") RouteCreateRequest routeCreateRequest) {
        routeService.saveRoute(routeCreateRequest);
        return "redirect:/routes";
    }

    @PostMapping("routes/delete/{id}")
    public String deleteRoute(@PathVariable("id") int id){
        routeService.deleteRoute(id);
        return "redirect:/routes";
    }

    @GetMapping("/api/routes/{id}")
    public ResponseEntity<?> getRoute(@PathVariable Integer id) {
        return ResponseEntity.ok(routeService.findById(id));
    }

    @PutMapping("/api/routes/{id}")
    public ResponseEntity<?> updateRoute(@PathVariable Integer id, @RequestBody @Valid RouteUpdateRequest routeUpdateRequest) {
        routeUpdateRequest.setId(id);
        routeService.updateRoute(routeUpdateRequest);
        return ResponseEntity.ok(null);
    }
}
