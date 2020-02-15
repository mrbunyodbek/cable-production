package uz.cp.cableproduction.db.entities.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.cp.cableproduction.db.entities.base.BaseEntity;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orders")
public class Order extends BaseEntity {

    private int cableId;

    private double amount;

    private LocalDateTime orderStartDate;

    private LocalDateTime estimatedDate;

    private String description;

    private String customer;

    private boolean paymentStatus;

    private double cost;

    private double balance;

    private boolean deleted;

}
