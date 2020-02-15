package uz.cp.cableproduction.db.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MachinesDTO {
    private int id;
    private String machineName;
    private long oweralWorkTime;

}
