package tech_shop.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;

    @Override
    public String toString() {
        return String.format("| %-2s | %-23s | %-23s | %-11s | %-17s |",id,name,email,phoneNumber,address);
    }
}
