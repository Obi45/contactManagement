package africa.semicolon.contactsmanagement.data.repository;

import africa.semicolon.contactsmanagement.data.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    void thatAUserCanBeSaved(){
        userRepository.deleteAll();
        User user = new User();
        userRepository.save(user);
        assertEquals(1,userRepository.count());
    }

}