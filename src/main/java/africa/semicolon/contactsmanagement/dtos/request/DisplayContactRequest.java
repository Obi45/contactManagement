package africa.semicolon.contactsmanagement.dtos.request;

import lombok.Data;

@Data
public class DisplayContactRequest {
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
