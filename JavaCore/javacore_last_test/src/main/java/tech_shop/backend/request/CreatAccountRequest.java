package tech_shop.backend.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CreatAccountRequest {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private String address;

    public CreatAccountRequest(String name, String email,String password){
        this.name=name;
        this.email=email;
        this.phoneNumber="";
        this.password=password;
        this.address="";
    }
}
