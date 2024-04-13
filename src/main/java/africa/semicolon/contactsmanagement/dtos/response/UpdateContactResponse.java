package africa.semicolon.contactsmanagement.dtos.response;

import lombok.Data;

@Data
public class UpdateContactResponse {
    private String firstName;
    private String lastName;
    private String newPhoneNumber;
    private String message = "contact updated successfully";
}
