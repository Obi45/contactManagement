package africa.semicolon.contactsmanagement.services;

import africa.semicolon.contactsmanagement.data.repository.ContactRepository;
import africa.semicolon.contactsmanagement.data.repository.UserRepository;
import africa.semicolon.contactsmanagement.dtos.request.*;
import africa.semicolon.contactsmanagement.dtos.response.*;
import africa.semicolon.contactsmanagement.service.ContactService;
import africa.semicolon.contactsmanagement.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ContactService contactService;
@BeforeEach
public void delete(){
    userRepository.deleteAll();
    contactRepository.deleteAll();

}

    @Test
    void testThatAnAccountCanBeCreatedWithAUserService(){

        RegisterUserRequest registerUserRequest = new RegisterUserRequest();

        registerUserRequest.setUserName("John324");
        registerUserRequest.setPassword("1234");
        registerUserRequest.setFirstName("mike");
        registerUserRequest.setLastName("peter");
        userService.register(registerUserRequest);
        assertEquals(1, userRepository.count());

    }
    @Test
    void testThatAUserCanLogin(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();

        registerUserRequest.setUserName("John324");
        registerUserRequest.setPassword("1234");
        registerUserRequest.setFirstName("mike");
        registerUserRequest.setLastName("peter");
        userService.register(registerUserRequest);
        assertEquals(1, userRepository.count());

        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setUserName("John324");
        loginUserRequest.setPassword("1234");
        LoginUserResponse loginUserResponse = userService.login(loginUserRequest);
        assertEquals("login successfully", loginUserResponse.getMessage());


    }
    @Test
    void testThatAUserCanLogOut(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();

        registerUserRequest.setUserName("John324");
        registerUserRequest.setPassword("1234");
        registerUserRequest.setFirstName("mike");
        registerUserRequest.setLastName("peter");
        userService.register(registerUserRequest);
        assertEquals(1, userRepository.count());

        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setUserName("John324");
        loginUserRequest.setPassword("1234");
        LoginUserResponse loginUserResponse = userService.login(loginUserRequest);
        assertEquals("login successfully", loginUserResponse.getMessage());

        LogOutUserRequest logOutUserRequest = new LogOutUserRequest();
        logOutUserRequest.setUserName("John324");
        LogOutUserResponse logOutUserResponse = userService.logOut(logOutUserRequest);
        assertEquals("logout successfully",logOutUserResponse.getMessage() );

    }
    @Test
    public void testThatContactCanBeAdded(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();

        registerUserRequest.setUserName("John324");
        registerUserRequest.setPassword("1234");
        registerUserRequest.setFirstName("mike");
        registerUserRequest.setLastName("peter");
        userService.register(registerUserRequest);
        assertEquals(1, userRepository.count());

        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setUserName("John324");
        loginUserRequest.setPassword("1234");
        LoginUserResponse loginUserResponse  = userService.login(loginUserRequest);
        assertEquals("login successfully", loginUserResponse.getMessage());

        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("Godwin");
        addContactRequest.setLastName("peter");
        addContactRequest.setPhoneNumber("0705");
        AddContactResponse addContactResponse = userService.addContact(addContactRequest);
        assertEquals("contact added successfully",addContactResponse.getMessage());
    }
    @Test
    public void testThatContactCanBeDeleted(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUserName("John324");
        registerUserRequest.setPassword("1234");
        registerUserRequest.setFirstName("mike");
        registerUserRequest.setLastName("peter");
        userService.register(registerUserRequest);
        assertEquals(1, userRepository.count());

        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setUserName("John324");
        loginUserRequest.setPassword("1234");
        LoginUserResponse loginUserResponse  = userService.login(loginUserRequest);
        assertEquals("login successfully", loginUserResponse.getMessage());

        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("Godwin");
        addContactRequest.setLastName("peter");
        addContactRequest.setPhoneNumber("0705");
        AddContactResponse addContactResponse = userService.addContact(addContactRequest);
        assertEquals("contact added successfully",addContactResponse.getMessage());

        DeleteContactRequest deleteContactRequest = new DeleteContactRequest();
        deleteContactRequest.setFirstName("Godwin");
        deleteContactRequest.setLastName("peter");
        deleteContactRequest.setPhoneNumber("0705");
        DeleteContactResponse deleteContactResponse = contactService.delete(deleteContactRequest);
        assertEquals("contact deleted successfully", deleteContactResponse.getMessage());
    }
    @Test
    public void testThatAContactCanBeUpdated(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUserName("John324");
        registerUserRequest.setPassword("1234");
        registerUserRequest.setFirstName("mike");
        registerUserRequest.setLastName("peter");
        userService.register(registerUserRequest);
        assertEquals(1, userRepository.count());

        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setUserName("John324");
        loginUserRequest.setPassword("1234");
        LoginUserResponse loginUserResponse  = userService.login(loginUserRequest);
        assertEquals("login successfully", loginUserResponse.getMessage());

        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("Godwin");
        addContactRequest.setLastName("peter");
        addContactRequest.setPhoneNumber("0705");
        AddContactResponse addContactResponse = userService.addContact(addContactRequest);
        assertEquals("contact added successfully",addContactResponse.getMessage());


        UpdateContactRequest updateContactRequest = new UpdateContactRequest();
        updateContactRequest.setFirstName("Godwin23");
        updateContactRequest.setLastName("peter");
        updateContactRequest.setNewPhoneNumber("0704");
        UpdateContactResponse updateContactResponse = contactService.update(updateContactRequest);
        assertEquals("contact updated successfully", updateContactResponse.getMessage());

    }
}
