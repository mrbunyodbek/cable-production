package uz.cp.cableproduction.db.dao;

import uz.cp.cableproduction.db.entities.documents.Payment;

import java.util.List;

public interface PaymentDAO {

    List<Payment> getAll();

    Payment getByOrderId(int orderId);
}