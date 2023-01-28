package tech_shop.backend.database;

import tech_shop.backend.model.Feedback;
import tech_shop.backend.model.Order;
import tech_shop.backend.utils.FileUtils;

import java.util.ArrayList;

public class OrderDatabase {
    public static ArrayList<Order> allOders = FileUtils.getOrderDataFromFile("order.json");
    public static ArrayList<Feedback> allFb = FileUtils.getFbFromFile("feedback.json");
}
