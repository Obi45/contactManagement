package africa.semicolon.contactsmanagement.dtos.response;

import lombok.Data;

@Data
public class AddContactResponse {

private String firstName;
private String lastname;
private String message = "Contact added";
}
