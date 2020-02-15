package uz.cp.cableproduction.collections;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductionStats {

    private int machineId;
    private double overallLoadHours;

}
