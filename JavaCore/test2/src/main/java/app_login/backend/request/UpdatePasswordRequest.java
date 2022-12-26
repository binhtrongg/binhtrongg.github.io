package app_login.backend.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class UpdatePasswordRequest {
    private String newPassword;
    private String email;

    public UpdatePasswordRequest(String email, String newPassword) {
        this.email=email;
        this.newPassword=newPassword;
    }
}
