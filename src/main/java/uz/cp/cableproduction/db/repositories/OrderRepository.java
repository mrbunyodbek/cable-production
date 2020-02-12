package uz.cp.cableproduction.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.cp.cableproduction.db.entities.documents.Order;

import java.sql.Timestamp;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAll();

    Order findByCableId(int id);

    Order findByOrderStartDate(Timestamp creationTime);

    Order findByPaymentStatus(boolean payment);

}
