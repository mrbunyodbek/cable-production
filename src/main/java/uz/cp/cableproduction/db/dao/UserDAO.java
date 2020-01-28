package uz.cp.cableproduction.db.dao;

import uz.cp.cableproduction.collections.UserAndMessage;
import uz.cp.cableproduction.db.entities.User;

import java.util.List;

public interface UserDAO {
    List<User> getAll();

    User getById(int id);

    User getByUsername(String username);

    User getByFirstName(String firstName);

    User getByLastName(String lastName);

    UserAndMessage saveUser(User user);

    String deleteUserById(int id);

}
