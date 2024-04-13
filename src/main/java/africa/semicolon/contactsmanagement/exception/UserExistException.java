package africa.semicolon.contactsmanagement.exception;

public class UserExistException extends RuntimeException{
    public UserExistException(String message){
        super(message);
    }
}
