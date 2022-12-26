package app_login.backend.controller;
import app_login.backend.model.Users;
import app_login.backend.request.UpdateEmailRequest;
import app_login.backend.request.UpdatePasswordRequest;
import app_login.backend.request.UpdateUserNameRequest;
import app_login.backend.service.UserService;
public class UserController {
    public static UserService userService=new UserService();
    public boolean checkLogin(String email, String password) {
        return userService.checkLogin(email,password);
    }
    public Boolean checkEmailExist(String emailSignup) {
       return userService.checkEmailExist(emailSignup);
    }
    public boolean checkEmailRegex(String emailSignup) {
       return userService.checkEmailRegex(emailSignup);
    }
    public boolean checkPassRegex(String passwordSignup) {
       return userService.checkPassRegex(passwordSignup);
    }
    public void AddUser(String username, String emailSignup, String passwordSignup) {
        Users user=new Users(username,emailSignup,passwordSignup);
        userService.AddUser(user);
    }
    public void updatePassword(UpdatePasswordRequest updatePassword) {
            userService.updatePassword(updatePassword);
        }
    public void updateUsername(UpdateUserNameRequest updateUserNameRequest) {
        userService.updateUsername(updateUserNameRequest);
    }
    public void updateEmail(UpdateEmailRequest updateEmailRequest) {
       userService.updateEmail(updateEmailRequest);
    }
}

