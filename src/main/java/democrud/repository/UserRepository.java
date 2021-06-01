package democrud.repository;

import democrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);

    @Query(value="select u from User u")
    List<User> readAllUsers();
}
