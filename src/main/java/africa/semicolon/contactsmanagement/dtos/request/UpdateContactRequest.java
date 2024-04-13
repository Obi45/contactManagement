package africa.semicolon.contactsmanagement.dtos.request;

import lombok.Data;

@Data
public class UpdateContactRequest {
    private String firstName;
    private String lastName;
    private String OldPhoneNumber;
    private String newPhoneNumber;
}
