package uz.cp.cableproduction.collections;

import lombok.*;
import uz.cp.cableproduction.db.entities.Cable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CableAndMessage {

    private Cable cable;

    private String message;
}
