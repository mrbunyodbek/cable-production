package uz.cp.cableproduction.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import uz.cp.cableproduction.collections.MachineAndMessage;
import uz.cp.cableproduction.db.dao.OrderDAO;
import uz.cp.cableproduction.db.entities.Machine;
import uz.cp.cableproduction.db.entities.documents.Order;
import uz.cp.cableproduction.db.entities.documents.Production;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/orders")
@Service
public class OrderController {
    OrderDAO orderDAO;

    public OrderController(OrderDAO order) {
        orderDAO=order;
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<Order>> getAllMachines() {
        orderDAO.getAll();
        return new ResponseEntity<>(orderDAO.getAll(), HttpStatus.OK);

    }


    @GetMapping(value = "/get/{id}")
    public ResponseEntity<List<Production>> getById(@PathVariable int id) {
        return new ResponseEntity<>(orderDAO.getAllNoDoneProduction(id), HttpStatus.OK);
    }


    @GetMapping(value = "/get/startdate")
    public ResponseEntity<Order> getByModel(@PathVariable Timestamp date) {
        return new ResponseEntity<>(orderDAO.getByOrderStartDate(date), HttpStatus.OK);
    }

    @GetMapping(value = "/get")
    public ResponseEntity<Order> getBySpeed(@PathVariable boolean b) {
        return new ResponseEntity<>(orderDAO.getByPaymentStatus(b), HttpStatus.OK);
    }






}
