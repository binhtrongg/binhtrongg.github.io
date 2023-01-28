package tech_shop.backend.controller;

import tech_shop.backend.model.User;
import tech_shop.backend.request.CreatAccountRequest;
import tech_shop.backend.service.UserSerVice;

import java.util.List;

public class UserController {
    public static UserSerVice userSerVice=new UserSerVice();
    public boolean userLogin(String email, String password) {
        return userSerVice.userLogin(email,password);
    }

    public String getname(String email) {
        return userSerVice.getName(email);
    }

    public String getAddress(String email) {
       return userSerVice.getAddress(email);
    }

    public void updatePassword(String email, String newPassword) {
        userSerVice.updatePassword(email,newPassword);
    }

    public void updatePhoneNumber(String email, String newPhoneNumber) {
        userSerVice.updatePhoneNumber(email,newPhoneNumber);
    }

    public void updateAddress(String email, String newAddress) {
        userSerVice.updateAddress(email,newAddress);
    }

    public void deleteUser(int id) {
        userSerVice.deleteUser(id);
    }

    public List<User> allUser() {
       return userSerVice.allUser();
    }

    public boolean checkEmailExist(String emailSignup) {
        return userSerVice.checkEmailExist(emailSignup);
    }

    public void creatUser(CreatAccountRequest creatAccountRequest) {
        userSerVice.creatUser(creatAccountRequest);
    }

    public User getUser(String email) {
       return userSerVice.getUser(email);
    }

}
