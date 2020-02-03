package uz.cp.cableproduction.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.cp.cableproduction.collections.UserAndMessage;
import uz.cp.cableproduction.db.dao.UserDAO;
import uz.cp.cableproduction.db.entities.User;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<User>> getAllUsers() {
        userDAO.getAll();
        return new ResponseEntity<>(userDAO.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<User> getById(@PathVariable int id) {
        return new ResponseEntity<>(userDAO.getById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/getName")
    public ResponseEntity<User> getUserByName(@PathVariable String firstName) {
        return new ResponseEntity<>(userDAO.getByFirstName(firstName), HttpStatus.OK);
    }

    @GetMapping(value = "/getUsername")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        return new ResponseEntity<>(userDAO.getByUsername(username), HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<List<User>> deleteUserById(@PathVariable int id) {
        userDAO.deleteUserById(id);
        return new ResponseEntity<>(userDAO.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<UserAndMessage> saveAndEditUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userDAO.saveUser(user), HttpStatus.OK);

    }

}
