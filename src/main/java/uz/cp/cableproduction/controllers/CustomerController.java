package uz.cp.cableproduction.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.cp.cableproduction.collections.CustomerAndMessage;
import uz.cp.cableproduction.db.dao.CustomerDAO;
import uz.cp.cableproduction.db.entities.Customer;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    CustomerDAO customerDAO;

    public CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;

    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerDAO.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Customer> getById(@PathVariable int id) {
        return new ResponseEntity<>(customerDAO.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/getName")
    public ResponseEntity<Customer> s(@PathVariable String name) {
        return new ResponseEntity<>(customerDAO.getByName(name), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<CustomerAndMessage> saveCustomer(@Valid @RequestBody Customer customer) {
        return new ResponseEntity<>(customerDAO.saveEdit(customer), HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<List<Customer>> deleteById(@PathVariable int id) {
        customerDAO.deleteCustomerById(id);
        return new ResponseEntity<>(customerDAO.getAll(), HttpStatus.OK);
    }
}
