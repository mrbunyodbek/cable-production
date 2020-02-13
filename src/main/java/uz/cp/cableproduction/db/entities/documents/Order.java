package uz.cp.cableproduction.db.entities.documents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import uz.cp.cableproduction.db.entities.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name="orders")
public class Order extends BaseEntity {

    @Column(nullable = false)
    private int cableId;

    @Column(nullable = false)
    private double amount;

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp orderStartDate;

    @Column(nullable = false)
    private LocalDateTime estimatedDate;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private String customer;

    @Column(nullable = false)
    private boolean paymentStatus;

    @Column(nullable = false)
    private double cost;

    @Column(nullable = false)
    private double balance;

}
