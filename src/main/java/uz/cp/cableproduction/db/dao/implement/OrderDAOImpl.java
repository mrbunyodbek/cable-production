package uz.cp.cableproduction.db.dao.implement;

import org.springframework.stereotype.Service;
import uz.cp.cableproduction.db.dao.OrderDAO;
import uz.cp.cableproduction.db.entities.documents.Order;
import uz.cp.cableproduction.db.entities.documents.Production;
import uz.cp.cableproduction.db.repositories.OrderRepository;

import java.sql.Timestamp;
import java.util.List;

@Service
public class OrderDAOImpl implements OrderDAO {
    OrderRepository repository;

    public OrderDAOImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Order> getAllByDeletedFalse() {
        return repository.findAllByDeletedFalse();
    }

    @Override
    public Order getByOrderId(int orderId) {
        return repository.findById(orderId);
    }

    @Override
    public Order getByOrderStartDate(Timestamp startDate) {
        return repository.findByOrderStartDate(startDate);
    }

    @Override
    public List<Production> getAllNotDoneProduction(int id) {
        return repository.getAllNotDoneProduction(id);
    }

    @Override
    public List<Order> getByPaymentStatus(boolean paymentStatus) {
        return repository.findByPaymentStatus(paymentStatus);
    }

    @Override
    public void saveAndEditOrder(Order order) {
        repository.save(order);
    }

    @Override
    public List<Order> deleteOrder(int id) {
        Order temp = repository.findById(id);
        temp.setDeleted(true);
        repository.save(temp);
        return repository.findAllByDeletedFalse();
    }
}
