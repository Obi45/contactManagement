package africa.semicolon.contactsmanagement.dtos.request;

import africa.semicolon.contactsmanagement.data.model.Contact;
import lombok.Data;

import java.util.List;

@Data
public class RegisterUserRequest {
    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String phoneNumber;
    private List<Contact> contact;
}
