package africa.semicolon.contactsmanagement.dtos.response;

import lombok.Data;

@Data
public class DeleteContactResponse {
    private String firstName;
    private String lastname;
    private String phoneNumber;
    private String message = "contact deleted successfully";

}
