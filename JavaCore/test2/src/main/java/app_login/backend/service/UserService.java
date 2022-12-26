package app_login.backend.service;
import app_login.backend.database.UserDB;
import app_login.backend.model.Users;
import app_login.backend.regex.Regex;
import app_login.backend.repository.UserRepository;
import app_login.backend.request.UpdateEmailRequest;
import app_login.backend.request.UpdatePasswordRequest;
import app_login.backend.request.UpdateUserNameRequest;
import java.util.regex.Pattern;
public class UserService {
    public static UserRepository userRepository = new UserRepository();
    public boolean checkLogin(String email, String password) {
        for (Users user : UserDB.users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Chào mừng <" + user.getUsername() + ">, bạn có thể thực hiện các công việc sau:");
                return true;
            }
        }
        return false;
    }
    public boolean checkEmailExist(String emailSignup) {
        for (Users user : UserDB.users) {
            if (user.getEmail().equals(emailSignup))
                return true;
        }
        return false;
    }
    public boolean checkEmailRegex(String emailSignup) {
        Pattern p = Pattern.compile(Regex.mailRegex);
        return p.matcher(emailSignup).find();
    }
    public boolean checkPassRegex(String passwordSignup) {
        Pattern p = Pattern.compile(Regex.passwordRegex);
        return p.matcher(passwordSignup).find();
    }
    public void AddUser(Users user) {
        userRepository.addUser(user);
    }
    public void updatePassword(UpdatePasswordRequest updatePassword) {
        userRepository.updatePassword(updatePassword);
    }
    public void updateUsername(UpdateUserNameRequest updateUserNameRequest) {
        userRepository.updateUsername(updateUserNameRequest);
    }
    public void updateEmail(UpdateEmailRequest updateEmailRequest) {
        userRepository.updateEmail(updateEmailRequest);
    }
}
