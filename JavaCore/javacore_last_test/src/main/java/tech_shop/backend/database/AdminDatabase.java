package tech_shop.backend.database;

import tech_shop.backend.model.Admin;
import tech_shop.backend.utils.FileUtils;

import java.util.List;

public class AdminDatabase {
    public static List<Admin>admins= FileUtils.getAdminFromFile("admin.json");
}
