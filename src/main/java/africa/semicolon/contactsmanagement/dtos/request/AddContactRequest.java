package africa.semicolon.contactsmanagement.dtos.request;

import lombok.Data;

@Data
public class AddContactRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;

}
