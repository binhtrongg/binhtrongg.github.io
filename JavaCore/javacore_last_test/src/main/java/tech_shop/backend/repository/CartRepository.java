package tech_shop.backend.repository;

import tech_shop.backend.database.CartDataBase;
import tech_shop.backend.model.CartItem;
import tech_shop.backend.utils.FileUtils;
import java.util.List;

public class CartRepository {
    public static List<CartItem>findAllCartItem(){
        return CartDataBase.cartItems;
    }
    public static CartItem findCartItemByid(int id){
        for (CartItem cartItem:findAllCartItem()) {
            if (cartItem.getProduct().getId()==id){
                return cartItem;
            }
        }
        return null;
    }

    public static void addItemToCart(int id,CartItem cartItem) {
        if (findCartItemByid(id)!=null){
            CartItem item=findCartItemByid(id);
            item.setQuantityOnCart(item.getQuantityOnCart()+cartItem.getQuantityOnCart());
        }
        else {
           findAllCartItem().add(cartItem);
        }
        FileUtils.saveDataToFile("cart.json",CartDataBase.cartItems);
    }

    public void deleteCartItem(int id) {
        CartDataBase.cartItems.removeIf(cartItem -> cartItem.getProduct().getId()==id);
        FileUtils.saveDataToFile("cart.json",CartDataBase.cartItems);
    }

    public void deleteAllItem(String email) {
        CartDataBase.cartItems.removeIf(cartItem -> cartItem.getEmail().equalsIgnoreCase(email));
        FileUtils.saveDataToFile("cart.json",CartDataBase.cartItems);
    }

    public int getTotalMoney(String email) {
        int total=0;
        for (CartItem item:CartDataBase.cartItems) {
            if (item.getEmail().equalsIgnoreCase(email)){
                total+=(item.getProduct().getPrice()*item.getQuantityOnCart());
            }
        }
        return total;
    }

    public void updateQuantityOnCart(int id, int quantityOnCart) {
        CartItem item=findCartItemByid(id);
        item.setQuantityOnCart(quantityOnCart);
    }
}
