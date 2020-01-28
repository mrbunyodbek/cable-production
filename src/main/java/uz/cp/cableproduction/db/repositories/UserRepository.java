package uz.cp.cableproduction.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.cp.cableproduction.db.entities.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();

    User findById(int id);

    User findByUsername(String username);

    User findByFirstName(String firstName);

    User findByLastName(String lastName);


}
