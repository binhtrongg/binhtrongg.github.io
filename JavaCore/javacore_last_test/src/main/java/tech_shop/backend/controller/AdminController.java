package tech_shop.backend.controller;

import tech_shop.backend.service.AdminSerVice;

public class AdminController {
    static AdminSerVice adminSerVice=new AdminSerVice();
    public boolean adminLogin(String email, String password) {
        return adminSerVice.adminLogin(email,password);
    }
}
