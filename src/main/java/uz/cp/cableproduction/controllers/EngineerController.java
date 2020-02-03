package uz.cp.cableproduction.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.cp.cableproduction.collections.EngineerAndMessage;
import uz.cp.cableproduction.db.dao.EngineerDAO;
import uz.cp.cableproduction.db.entities.Engineer;

import java.util.List;

@RestController
@RequestMapping("/engineers")
public class EngineerController {
    EngineerDAO engineerDAO;

    public EngineerController(EngineerDAO engineerDAO) {
        this.engineerDAO = engineerDAO;
    }

    @GetMapping("/get")
    public ResponseEntity<List<Engineer>> getAll() {
        return new ResponseEntity<>(engineerDAO.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Engineer> getEngineerById(@PathVariable int id) {
        return new ResponseEntity<>(engineerDAO.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getName")
    public ResponseEntity<Engineer> getEngineerByName(@PathVariable String name) {
        return new ResponseEntity<>(engineerDAO.getByName(name), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<List<Engineer>> deleteEngineerById(@PathVariable int id) {
        engineerDAO.deleteById(id);
        return new ResponseEntity<>(engineerDAO.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<EngineerAndMessage> saveAndEditEngineer(@RequestBody Engineer engineer) {
        return new ResponseEntity<>(engineerDAO.saveEngineer(engineer), HttpStatus.CREATED);
    }

}
