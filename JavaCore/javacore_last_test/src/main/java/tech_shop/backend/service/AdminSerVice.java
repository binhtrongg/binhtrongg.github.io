package tech_shop.backend.service;

import tech_shop.backend.model.Admin;
import tech_shop.backend.repository.AdminRepository;

public class AdminSerVice {
    static AdminRepository adminRepository=new AdminRepository();
    public boolean adminLogin(String email, String password) {
        for (Admin admin:adminRepository.findAllAdmin(email,password)) {
            if (admin.getEmail().equals(email)&&admin.getPassword().equalsIgnoreCase(password)){
                return true;
            }
        }
        return false;
    }
}
