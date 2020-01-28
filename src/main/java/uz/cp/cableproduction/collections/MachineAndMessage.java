package uz.cp.cableproduction.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.cp.cableproduction.db.entities.Machine;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MachineAndMessage {
    private Machine machine;
    private String message;

}
