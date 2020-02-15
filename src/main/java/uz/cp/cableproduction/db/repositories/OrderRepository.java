package uz.cp.cableproduction.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.cp.cableproduction.db.entities.documents.Order;
import uz.cp.cableproduction.db.entities.documents.Production;

import java.sql.Timestamp;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAllByDeletedFalse();

    Order findById(int id);

    Order findByOrderStartDate(Timestamp creationTime);

    List<Order> findByPaymentStatus(boolean payment);

    @Query("SELECT p FROM production p WHERE p.orderId=:id and p.status  <> 'DONE'")
    List<Production> getAllNotDoneProduction(int id);


}
