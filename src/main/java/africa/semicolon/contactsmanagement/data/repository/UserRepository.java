package africa.semicolon.contactsmanagement.data.repository;

import africa.semicolon.contactsmanagement.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByUserName(String userName);

    User findByPhoneNumber(String phoneNumber);

    User findUserByPhoneNumber(String phoneNumber);

    User findByUserName(String userName);
}
