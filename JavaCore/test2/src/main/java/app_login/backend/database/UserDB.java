package app_login.backend.database;

import app_login.backend.model.Users;
import app_login.backend.ultils.UserUltils;

import java.util.ArrayList;
public class UserDB {
    public static ArrayList<Users>users= UserUltils.getDataFromFile("user.json");
}
