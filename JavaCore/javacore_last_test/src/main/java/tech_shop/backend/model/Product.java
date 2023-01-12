package tech_shop.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech_shop.backend.utils.FunctionUtils;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private String brand;
    private int quantity;
    private int price;
    @Override
    public String toString() {
        return String.format("| %-2s | %-23s | %-10s | %-8s | %-12s |",id,name,brand,quantity, FunctionUtils.currency(price));
    }
}
