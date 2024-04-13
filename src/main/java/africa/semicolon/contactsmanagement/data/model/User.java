package africa.semicolon.contactsmanagement.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class User {
    @Id
    private String id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isLoggedIn;
    @DBRef
    private List<Contact> contact;
    @DBRef
    private String phoneNumber;




}
