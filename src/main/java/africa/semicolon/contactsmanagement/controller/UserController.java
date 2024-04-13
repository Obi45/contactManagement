package africa.semicolon.contactsmanagement.controller;

import africa.semicolon.contactsmanagement.dtos.request.*;
import africa.semicolon.contactsmanagement.dtos.response.*;
import africa.semicolon.contactsmanagement.exception.UserDoesNotExistException;
import africa.semicolon.contactsmanagement.exception.UserExistException;
import africa.semicolon.contactsmanagement.service.ContactService;
import africa.semicolon.contactsmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ContactService contactService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserRequest registerUserRequest) {
        try {
            var result = userService.register(registerUserRequest);
            return new ResponseEntity<>(new ApiResponse(true,result),CREATED);
        }catch (RuntimeException e){
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()), BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginUserRequest loginUserRequest) {
        try {
            var result = userService.login(loginUserRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (UserExistException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }

    @PostMapping("/logOut")
    public ResponseEntity<?> logOut(@RequestBody LogOutUserRequest logOutUserRequest) {
        try {
            var result = userService.logOut(logOutUserRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }

    @GetMapping("/addContact")
    public ResponseEntity<?> addContact(@RequestBody AddContactRequest addContactRequest) {
        try {
            var result = userService.addContact(addContactRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }

    @PostMapping ("/update")
    public ResponseEntity<?> update(@RequestBody UpdateContactRequest updateContactRequest) {
        try {
            var result = contactService.update(updateContactRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);

        }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody DeleteContactRequest deleteContactRequest) {
        try {
            var result = contactService.delete(deleteContactRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()), BAD_REQUEST);
        }
    }
}

