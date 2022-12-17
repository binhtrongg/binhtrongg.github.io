package product_management.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Product {
    private int id;
    private String name;
    private String description;
    private int quantity;
    private int price;


}
