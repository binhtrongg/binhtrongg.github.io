package tech_shop.backend.database;

import tech_shop.backend.model.Cart;
import tech_shop.backend.model.CartItem;
import tech_shop.backend.utils.FileUtils;

import java.util.List;

public class CartDataBase {
    public static List<CartItem>cartItems= FileUtils.getCartFromFile("cart.json");
}
