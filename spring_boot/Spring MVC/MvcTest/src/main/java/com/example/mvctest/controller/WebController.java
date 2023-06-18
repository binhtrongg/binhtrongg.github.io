package com.example.mvctest.controller;

import com.example.mvctest.entity.BookingScheduler;
import com.example.mvctest.entity.Product;
import com.example.mvctest.model.request.CreatBookingRequest;
import com.example.mvctest.model.request.ProductRequest;
import com.example.mvctest.service.BookingService;
import com.example.mvctest.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
public class WebController {
    ProductService productService;

    BookingService bookingService;


    @GetMapping("/")
    public String getUserWeb(Model model){
       List<Product> products= productService.getProducts();
        model.addAttribute("allProduct",products);
        return "index";
    }

    @GetMapping("/admin")
    public String getAdminWeb(Model model){
        List<Product> products= productService.getProducts();
        model.addAttribute("allProduct",products);
        model.addAttribute("newProduct",new ProductRequest());
        return "productList";
    }

    @GetMapping("/admin/bookings")
    public String getAdminWebBooking(Model model){
        List<BookingScheduler>bookingSchedulers=bookingService.getBookings();
        model.addAttribute("allBooking",bookingSchedulers);
        return "bookingScheduleList";

    }

}
