package uz.cp.cableproduction.db.entities.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.cp.cableproduction.db.entities.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment extends BaseEntity {

    private double amount;

    private LocalDateTime paymentDate;

    private int orderId;


}
