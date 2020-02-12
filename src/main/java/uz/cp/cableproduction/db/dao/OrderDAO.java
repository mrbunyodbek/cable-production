package uz.cp.cableproduction.db.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.cp.cableproduction.db.entities.documents.Order;

import java.sql.Timestamp;
import java.util.List;

public interface OrderDAO {
    List<Order> getAll();

    Order getByCableId(int cableId);

    Order getByOrderStartDate(Timestamp startDate);

    Order getByPaymentStatus(boolean paymentStatus);

}
