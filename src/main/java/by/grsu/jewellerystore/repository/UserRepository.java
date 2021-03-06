package by.grsu.jewellerystore.repository;

import by.grsu.jewellerystore.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Boolean existsByPhoneNumberAndFirstNameAndLastName(String phoneNumber, String firstName, String lastName);

    Optional<User> findUserByFirstNameAndLastName(String firstName, String lastName);

}
