package uz.cp.cableproduction.collections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.cp.cableproduction.db.entities.Cable;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CableAndMessage {
    private Cable cable;
    private String message;
}
