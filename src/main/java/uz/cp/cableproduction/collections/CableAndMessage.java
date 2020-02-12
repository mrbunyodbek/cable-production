package uz.cp.cableproduction.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.cp.cableproduction.db.entities.Cable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CableAndMessage {

    private Cable cable;

    private String message;
}
