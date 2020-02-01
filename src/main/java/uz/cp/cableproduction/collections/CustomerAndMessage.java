package uz.cp.cableproduction.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.cp.cableproduction.db.entities.Customer;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAndMessage {

    private Customer customer;

    private String message;

}
