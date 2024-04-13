package africa.semicolon.contactsmanagement.util;

import africa.semicolon.contactsmanagement.data.model.User;
import africa.semicolon.contactsmanagement.dtos.request.RegisterUserRequest;
import africa.semicolon.contactsmanagement.dtos.response.RegisterUserResponse;

public class Mapper {
    public static User map(RegisterUserRequest registerUserRequest) {
        User user = new User();
        user.setUserName(registerUserRequest.getUserName());
        user.setPassword(registerUserRequest.getPassword());
        user.setFirstName(registerUserRequest.getFirstName());
        user.setLastName(registerUserRequest.getLastName());
        user.setPhoneNumber(registerUserRequest.getPhoneNumber());
        return user;
    }

    public static RegisterUserResponse map(User user) {
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setId(user.getId());
        registerUserResponse.setUserName(user.getUserName());
        return registerUserResponse;

    }
}
