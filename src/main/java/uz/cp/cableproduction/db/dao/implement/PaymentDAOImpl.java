package uz.cp.cableproduction.db.dao.implement;

import uz.cp.cableproduction.db.dao.PaymentDAO;
import uz.cp.cableproduction.db.entities.documents.Payment;
import uz.cp.cableproduction.db.repositories.PaymentRepository;

import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {
    PaymentRepository repository;

    public PaymentDAOImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Payment> getAll() {
        return repository.findAll();
    }

    @Override
    public Payment getByOrderId(int orderId) {
        return repository.findByOrderId(orderId);
    }
}
