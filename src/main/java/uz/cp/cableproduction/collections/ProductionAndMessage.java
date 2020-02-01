package uz.cp.cableproduction.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.cp.cableproduction.db.entities.documents.Production;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductionAndMessage {

    private Production production;

    private String message;
}
