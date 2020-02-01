package uz.cp.cableproduction.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.cp.cableproduction.db.entities.Engineer;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EngineerAndMessage {

    private String message;

    private Engineer engineer;
}
