package tech_shop.backend.service;

import tech_shop.backend.model.User;
import tech_shop.backend.repository.UserRepository;
import tech_shop.backend.request.CreatAccountRequest;

import java.util.List;
import java.util.Objects;

public class UserSerVice {
   static UserRepository userRepository=new UserRepository();
    public List<User> allUser() {
        return userRepository.findAllUser();
    }
    public boolean userLogin(String email, String password) {
        for (User user:userRepository.findAllUser()) {
            if (user.getEmail().equals(email)&&user.getPassword().equalsIgnoreCase(password)) {
                return true;
            }
        }
        return false;
    }

    public void getName(String email) {
        for (User user:userRepository.findAllUser()) {
            if (user.getEmail().equalsIgnoreCase(email)){
                System.out.println("\n---------Xin chào " + user.getName()+"--------");
            }
        }
    }

    public String  getAddress(String email) {
        for (User user:userRepository.findAllUser()){
            if (user.getEmail().equalsIgnoreCase(email)){
                return user.getAddress();
            }
        }
        return null;
    }

    public void updatePassword(String email, String newPassword) {
        userRepository.updatePassword(email,newPassword);
    }

    public void updatePhoneNumber(String email, String newPhoneNumber) {
        userRepository.updatePhoneNumber(email,newPhoneNumber);
    }

    public void updateAddress(String email, String newAddress) {
        userRepository.updateAddress(email,newAddress);
    }

    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }

    

    public boolean checkEmailExist(String emailSignup) {
            for (User user : allUser()) {
                if (Objects.equals(user.getEmail(), emailSignup))
                    return true;
            }
            return false;
        }

    public void creatUser(CreatAccountRequest creatAccountRequest) {
        User user=new User();
        user.setId(userRepository.findAllUser().get(userRepository.findAllUser().size()-1).getId()+1);
        user.setName(creatAccountRequest.getName());
        user.setEmail(creatAccountRequest.getEmail());
        user.setPassword(creatAccountRequest.getPassword());
        user.setPhoneNumber(creatAccountRequest.getPhoneNumber());
        user.setAddress(creatAccountRequest.getAddress());
        userRepository.addUser(user);
    }

    public User getUser(String email) {
        for (User user:userRepository.findAllUser()) {
            if (user.getEmail().equalsIgnoreCase(email)){
                return user;
            }
        }
        return null;
    }
}
