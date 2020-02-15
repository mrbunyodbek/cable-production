package uz.cp.cableproduction.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.cp.cableproduction.db.dao.OrderDAO;
import uz.cp.cableproduction.db.entities.documents.Order;
import uz.cp.cableproduction.db.entities.documents.Production;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    OrderDAO orderDAO;

    public OrderController(OrderDAO order) {
        orderDAO = order;
    }

    @GetMapping(value = "/getByNotDone")
    public ResponseEntity<List<Production>> getAllByNotDone(@PathVariable int id) {
        return new ResponseEntity<>(orderDAO.getAllNotDoneProduction(id), HttpStatus.OK);
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<Order>> getAllOrders() {
        return new ResponseEntity<>(orderDAO.getAllByDeletedFalse(), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        return new ResponseEntity<>(orderDAO.getByOrderId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/get/start")
    public ResponseEntity<Order> getByStartDate(@PathVariable Timestamp startDate) {
        return new ResponseEntity<>(orderDAO.getByOrderStartDate(startDate), HttpStatus.OK);
    }

//    @GetMapping(value = "/get")
//    public ResponseEntity<List<Order>> getByPayment(@PathVariable boolean payment) {
//        return new ResponseEntity<>(orderDAO.getByPaymentStatus(payment), HttpStatus.OK);
//    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<List<Order>> deleteOrderById(@PathVariable int id) {
        orderDAO.deleteOrder(id);
        return new ResponseEntity<>(orderDAO.getAllByDeletedFalse(), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<List<Order>> saveUser(@Valid @RequestBody Order order) {
        orderDAO.saveAndEditOrder(order);
        return new ResponseEntity<>(orderDAO.getAllByDeletedFalse(), HttpStatus.CREATED);
    }

}
