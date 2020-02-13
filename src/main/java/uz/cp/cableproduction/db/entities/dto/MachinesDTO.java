package uz.cp.cableproduction.db.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MachinesDTO {
    private int id;
    private String machineName;
    private long oweralWorkTime;
}
