package tech_shop.backend.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CreatProductRequest {
    private String name;
    private String brand;
    private int quantity;
    private int price;

    private void creatProductRequest(String name,String brand,int quantity,int price){
        this.name=name;
        this.brand=brand;
        this.quantity=quantity;
        this.price=price;
    }
}
