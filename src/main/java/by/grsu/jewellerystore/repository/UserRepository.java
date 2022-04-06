package by.grsu.jewellerystore.repository;

import by.grsu.jewellerystore.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
