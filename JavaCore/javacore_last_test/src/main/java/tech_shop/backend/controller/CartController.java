package tech_shop.backend.controller;
import tech_shop.backend.model.CartItem;
import tech_shop.backend.model.Product;
import tech_shop.backend.service.CartService;

import java.util.List;

public class CartController {
    static final CartService cartService=new CartService();
    public List<CartItem> cart(String email) {
       return cartService.cart(email);
    }

    public void addItemToCart(int id, CartItem cartItem) {
        cartService.addItemToCart(id,cartItem);
    }

    public boolean checkQuantity(Product product, int quantity) {
       return cartService.checkQuantity(product,quantity);
    }

    public void deleteCartItem(int id) {
        cartService.deleteCartItem(id);
    }

    public void deleteAllItem(String email) {
        cartService.deleteAllItem(email);
    }

    public int getTotalMoney(String email) {
        return cartService.getTotalMoney(email);
    }

    public void updateQuantityOnCart(int id, int quantityOnCart) {
        cartService.updateQuantityOncart(id,quantityOnCart);
    }
}
