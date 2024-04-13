package africa.semicolon.contactsmanagement.dtos.response;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class LoginUserResponse {
    private String userName;
    private String message = "login successfully";

}
