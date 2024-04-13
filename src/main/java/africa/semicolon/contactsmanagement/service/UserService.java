package africa.semicolon.contactsmanagement.service;

import africa.semicolon.contactsmanagement.dtos.request.*;
import africa.semicolon.contactsmanagement.dtos.response.*;
import org.springframework.http.ResponseEntity;

public interface UserService {
    RegisterUserResponse register(RegisterUserRequest registerUserRequest);
    LoginUserResponse login(LoginUserRequest loginUserRequest);

    LogOutUserResponse logOut(LogOutUserRequest logOutUserRequest);

    AddContactResponse addContact(AddContactRequest addContactRequest);

   // UpdateContactResponse update(UpdateContactRequest updateContactRequest, String oldPhoneNumber);

    // DeleteContactResponse delete(DeleteContactRequest deleteContactRequest);

   // UpdateContactResponse update(UpdateContactRequest updateContactRequest, String oldPhoneNumber);

    //  DeleteContactResponse delete (DeleteContactRequest deleteContactRequest);

   // UpdateContactResponse update(UpdateContactRequest updateContactRequest, String oldPhoneNumber);

}
