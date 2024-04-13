package africa.semicolon.contactsmanagement.service;

import africa.semicolon.contactsmanagement.data.model.Contact;
import africa.semicolon.contactsmanagement.data.model.User;
import africa.semicolon.contactsmanagement.data.repository.ContactRepository;
import africa.semicolon.contactsmanagement.data.repository.UserRepository;
import africa.semicolon.contactsmanagement.dtos.request.*;
import africa.semicolon.contactsmanagement.dtos.response.*;
import africa.semicolon.contactsmanagement.exception.UserExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

import static africa.semicolon.contactsmanagement.util.Mapper.map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContactRepository contactRepository;
    User user = new User();

    @Override
    public RegisterUserResponse register(RegisterUserRequest registerUserRequest) {
        String username = registerUserRequest.getUserName().toLowerCase();
       boolean userExist = userRepository.existsByUserName(username);
        if (userExist) throw new UserExistException("user already exist");
      //  User user = findByUserName(username);
       // checkIfUserExist(username);
        User user = map(registerUserRequest);
        userRepository.save(user);

       return map(user);
    }

//    public void checkIfUserExist(String username){
//        for (User user : userRepository.findAll()){
//            if (user.getUserName().equals(username)){
//                throw new UserExistException("User already exist");
//            }
//        }
//    }



    @Override
    public LoginUserResponse login(LoginUserRequest loginUserRequest) {
        String username = loginUserRequest.getUserName();
       // boolean userExist = userRepository.existsByUserName(username);
       // if (!userExist) throw new RuntimeException("user not found");
        // User user = userRepository.findUserByUserName(username);
        User user = findByUserName(username);
        if (!user.getPassword().equals(loginUserRequest.getPassword()))
            throw new RuntimeException("user does not exist");
        user.setLoggedIn(true);
        userRepository.save(user);


        LoginUserResponse loginUserResponse = new LoginUserResponse();
        loginUserResponse.setUserName(loginUserRequest.getUserName());
        loginUserResponse.setMessage("login successfully");
        return loginUserResponse;
    }

    @Override
    public LogOutUserResponse logOut(LogOutUserRequest logOutUserRequest) {
        String username = logOutUserRequest.getUserName();
        User user = findByUserName(username);
        user.setLoggedIn(false);
        userRepository.save(user);

        LogOutUserResponse logOutUserResponse = new LogOutUserResponse();
        logOutUserResponse.setUserName(username);
        logOutUserResponse.setMessage("logout successfully");

        return logOutUserResponse;
    }

    @Override
    public AddContactResponse addContact(AddContactRequest addContactRequest) {
        Contact contact = new Contact();
        contact.setFirstName(addContactRequest.getFirstName());
        contact.setLastName(addContactRequest.getLastName());
        contact.setPhoneNumber(addContactRequest.getPhoneNumber());
        contactRepository.save(contact);


        AddContactResponse addContactResponse = new AddContactResponse();
        addContactResponse.setFirstName(addContactRequest.getFirstName());
        addContactResponse.setLastname(addContactRequest.getLastName());
        addContactResponse.setMessage("contact added successfully");

        return addContactResponse;
    }

    private User findByUserName(String username){
        User user = userRepository.findByUserName(username);
        if(user == null)throw new RuntimeException("user not found");
        return user;
    }

}

