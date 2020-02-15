package uz.cp.cableproduction.db.dao;

import uz.cp.cableproduction.db.entities.documents.Order;
import uz.cp.cableproduction.db.entities.documents.Production;

import java.sql.Timestamp;
import java.util.List;

public interface OrderDAO {


    List<Order> getAllByDeletedFalse();

    Order getByOrderId(int orderId);

    Order getByOrderStartDate(Timestamp startDate);

    List<Production> getAllNotDoneProduction(int id);

    List<Order> getByPaymentStatus(boolean paymentStatus);

    void saveAndEditOrder(Order order);

    List<Order> deleteOrder(int id);
}
