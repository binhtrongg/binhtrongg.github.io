package tech_shop.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Feedback {
    private String name;
    private int id;
    private String feedback;

    @Override
    public String toString() {
        return String.format(" %-20s  %-15s  %s ", name,"Đơn Hàng #"+id,feedback);
    }
}
