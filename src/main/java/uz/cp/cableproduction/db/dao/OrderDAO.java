package uz.cp.cableproduction.db.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import uz.cp.cableproduction.db.entities.documents.Order;
import uz.cp.cableproduction.db.entities.documents.Production;

import java.sql.Timestamp;
import java.util.List;

public interface OrderDAO {
    List<Order> getAll();

    List<Production> getAllNoDoneProduction(int id);

    Order getByCableId(int cableId);

    Order getByOrderStartDate(Timestamp startDate);

    Order getByPaymentStatus(boolean paymentStatus);

}
