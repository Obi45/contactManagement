package africa.semicolon.contactsmanagement.dtos.response;

import lombok.Data;

@Data
public class LogOutUserResponse {
    private  String userName;
    private String message = "logout successfully";
}
