package tech_shop.backend.repository;

import tech_shop.backend.database.AdminDatabase;
import tech_shop.backend.model.Admin;

import java.util.List;

public class AdminRepository {
    public List<Admin> findAllAdmin(String email, String password) {
        return AdminDatabase.admins;
    }
}
