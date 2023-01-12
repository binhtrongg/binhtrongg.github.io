package tech_shop.backend.database;

import tech_shop.backend.model.User;
import tech_shop.backend.utils.FileUtils;

import java.util.List;

public class UserDatabase {
    public static List<User>users= FileUtils.getUserFromFile("user.json");
}
