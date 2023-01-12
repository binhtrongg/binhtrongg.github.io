package tech_shop.backend.service;

import tech_shop.backend.database.CartDataBase;
import tech_shop.backend.model.CartItem;
import tech_shop.backend.model.Product;
import tech_shop.backend.repository.CartRepository;
import tech_shop.backend.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    static final CartRepository cartRepository=new CartRepository();
    public List<CartItem> cart(String email) {
        List<CartItem>cartItems=new ArrayList<>();
        for (CartItem cartItem:cartRepository.findAllCartItem()) {
            if (cartItem.getEmail().equalsIgnoreCase(email)){
                cartItems.add(cartItem);
            }
        }
        return cartItems;
    }
    public void addItemToCart(int id,CartItem cartItem) {
        cartRepository.addItemToCart(id,cartItem);
    }
    public boolean checkQuantity(Product product, int quantity) {
        return product.getQuantity() < quantity;
    }
    public void deleteCartItem(int id) {
        cartRepository.deleteCartItem(id);
    }
    public void deleteAllItem(String email) {
        cartRepository.deleteAllItem(email);
    }
    public int getTotalMoney(String email) {
        return cartRepository.getTotalMoney(email);
    }

    public void updateQuantityOncart(int id, int quantityOnCart) {
        cartRepository.updateQuantityOnCart(id,quantityOnCart);
    }
}
