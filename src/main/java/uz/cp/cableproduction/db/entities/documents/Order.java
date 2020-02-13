package uz.cp.cableproduction.db.entities.documents;

import com.helger.commons.lang.priviledged.IPrivilegedAction;
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
@Entity(name = "orders")
public class Order extends BaseEntity {

    @Column()
    private int cableId;

    @Column()
    private double amount;

    private LocalDateTime orderStartDate;

    @Column()
    private LocalDateTime estimatedDate;

    @Column()
    private String description;

    @Column()
    private String customer;

    @Column()
    private boolean paymentStatus;

    @Column()
    private double cost;

    @Column()
    private double balance;

    private boolean deleted;

}
