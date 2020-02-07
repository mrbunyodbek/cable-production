package uz.cp.cableproduction.db.dao.implement;


import org.springframework.stereotype.Service;
import uz.cp.cableproduction.collections.UserAndMessage;
import uz.cp.cableproduction.db.entities.User;
import uz.cp.cableproduction.db.dao.UserDAO;
import uz.cp.cableproduction.db.repositories.UserRepository;

import java.util.List;

@Service
public class UserDAOImpl implements UserDAO {
    UserRepository repository;

    public UserDAOImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getById(int id) {
        return repository.findById(id);
    }

    @Override
    public User getByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public User getByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }

    @Override
    public User getByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }


    @Override
    public UserAndMessage saveUser(User user) {
        User saved;

        User temp = repository.findById(user.getId());

//        if (temp != null) {
//            temp.setPassword(user.getPassword());
//            temp.setUsername(user.getUsername());
//            temp.setRoles(user.getRoles());
//
//            saved = repository.save(temp);
//        } else {
        saved = repository.save(user);
//        }

        UserAndMessage uam = new UserAndMessage();

        uam.setUser(saved);
        uam.setMessage("User has been saved.");
        return uam;
    }


    @Override
    public String deleteUserById(int id) {

        User user = repository.findById(id);
        user.setDeleted(true);
        repository.save(user);
        return "User was deleted!";
    }
}
