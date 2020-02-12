package uz.cp.cableproduction.db.dao.implement;

import uz.cp.cableproduction.db.dao.OrderDAO;
import uz.cp.cableproduction.db.entities.documents.Order;
import uz.cp.cableproduction.db.repositories.OrderRepository;

import java.sql.Timestamp;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    OrderRepository repository;

    public OrderDAOImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Order> getAll() {
        return repository.findAll();
    }

    @Override
    public Order getByCableId(int cableId) {
        return repository.findByCableId(cableId);
    }

    @Override
    public Order getByOrderStartDate(Timestamp startDate) {
        return repository.findByOrderStartDate(startDate);
    }

    @Override
    public Order getByPaymentStatus(boolean paymentStatus) {
        return repository.findByPaymentStatus(paymentStatus);
    }
}
