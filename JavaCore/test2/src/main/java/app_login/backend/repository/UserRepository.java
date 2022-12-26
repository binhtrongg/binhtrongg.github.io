package app_login.backend.repository;

import app_login.backend.database.UserDB;
import app_login.backend.model.Users;
import app_login.backend.request.UpdateEmailRequest;
import app_login.backend.request.UpdatePasswordRequest;
import app_login.backend.request.UpdateUserNameRequest;
import app_login.backend.ultils.UserUltils;
public class UserRepository {
    public void addUser(Users user) {
        UserDB.users.add(user);
        UserUltils.addDataToFile("user.json", UserDB.users);
    }
    public void updatePassword(UpdatePasswordRequest updatePassword) {
        for (Users user : UserDB.users) {
            if (user.getEmail().equals(updatePassword.getEmail())) {
                user.setPassword(updatePassword.getNewPassword());
            }
        }
        UserUltils.addDataToFile("user.json", UserDB.users);
    }
    public void updateUsername(UpdateUserNameRequest updateUserNameRequest) {
        for (Users user : UserDB.users) {
            if (user.getEmail().equals(updateUserNameRequest.getEmail())) {
                user.setUsername(updateUserNameRequest.getNewUsername());
            }
        }
        UserUltils.addDataToFile("user.json", UserDB.users);
    }
    public void updateEmail(UpdateEmailRequest updateEmailRequest) {
        for (Users user : UserDB.users) {
            if (user.getEmail().equals(updateEmailRequest.getEmail())) {
                user.setEmail(updateEmailRequest.getNewEmail());
            }
        }
        UserUltils.addDataToFile("user.json", UserDB.users);
    }
}
