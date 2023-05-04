package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BillDetail {
    private Service service;
    private int quantity;
    public int getUsage() {
        return this.quantity;
    }
}
