package app_login.backend.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateEmailRequest {
    private String email;
    private String newEmail;

    public void updateEmail(UpdateEmailRequest updateEmailRequest) {
    }
}
