package tech_shop.backend.model;

import lombok.*;
import tech_shop.backend.utils.FunctionUtils;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    private int id;
    private String email;
    private List<CartItem> cart;
    private String name;
    private String phone;
    private String address;
    private String time;
    private OrderStatus orderStatus;

    @Override
    public String toString() {
        return String.format("Mã Đơn Hàng : "+id
        +"\nEmail : "+email
        +"\nF");
    }
}
