package tech_shop.backend.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartItem {
    private String email;
    private Product product;
    private int quantityOnCart;

    @Override
    public String toString() {
        return String.format("%s %-14s |",product,quantityOnCart);
    }
}
