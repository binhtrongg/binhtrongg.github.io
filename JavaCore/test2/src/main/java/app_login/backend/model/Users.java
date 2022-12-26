package app_login.backend.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Users {
    private String username;
    private String email;
    private String password;
}
