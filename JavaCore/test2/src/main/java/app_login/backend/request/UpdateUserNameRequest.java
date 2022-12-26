package app_login.backend.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UpdateUserNameRequest {
    private String email;
    private String newUsername;

    public UpdateUserNameRequest(String email, String newUsername) {
        this.email = email;
        this.newUsername = newUsername;
    }
}
