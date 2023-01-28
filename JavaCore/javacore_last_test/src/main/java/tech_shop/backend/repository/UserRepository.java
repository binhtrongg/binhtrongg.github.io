package tech_shop.backend.repository;

import tech_shop.backend.database.UserDatabase;
import tech_shop.backend.exception.NotFoundException;
import tech_shop.backend.model.User;
import tech_shop.backend.utils.FileUtils;

import java.util.List;

public class UserRepository {
    public List<User> findAllUser() {
        return UserDatabase.users;
    }
    public User findUserById(int id){
        for (User user:findAllUser()) {
            if (user.getId()==id){
                return user;
            }
        }
        throw new NotFoundException("Không có User nào có id "+id);
    }

    public void updatePassword(String email, String newPassword) {
        for (User user:findAllUser()) {
            if (user.getEmail().equals(email)){
                user.setPassword(newPassword);
            }
        }
        FileUtils.saveDataToFile("user.json",findAllUser());
    }

    public void updatePhoneNumber(String email, String newPhoneNumber) {
        for (User user:findAllUser()) {
            if (user.getEmail().equals(email)){
                user.setPhoneNumber(newPhoneNumber);
            }
        }
        FileUtils.saveDataToFile("user.json",findAllUser());
    }

    public void updateAddress(String email, String newAddress) {
        for (User user:findAllUser()) {
            if (user.getEmail().equals(email)){
                user.setAddress(newAddress);
            }
        }
        FileUtils.saveDataToFile("user.json",findAllUser());
    }

    public void deleteUser(int id) {
        User user=findUserById(id);
        findAllUser().remove(user);
        FileUtils.saveDataToFile("user.json",findAllUser());
    }

    public void addUser(User user) {
        findAllUser().add(user);
        FileUtils.saveDataToFile("user.json",findAllUser());
    }
}
