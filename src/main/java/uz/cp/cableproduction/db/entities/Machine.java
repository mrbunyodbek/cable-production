package uz.cp.cableproduction.db.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.cp.cableproduction.db.entities.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "machines")
public class Machine extends BaseEntity {

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String model;

    private String description;

    @Column(nullable = false)
    private double speed;

}
