package tech_shop.backend.model;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cart {
    private String email;
    private List<CartItem>cart;
}
