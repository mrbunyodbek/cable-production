package uz.cp.cableproduction.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.cp.cableproduction.db.entities.CableProduction;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CableProductionAndMessage {
    private CableProduction cableProduction;
    private String message;
}
