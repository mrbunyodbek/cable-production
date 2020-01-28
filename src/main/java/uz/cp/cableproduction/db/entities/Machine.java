package uz.cp.cableproduction.db.entities;

import lombok.*;
import uz.cp.cableproduction.db.entities.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "machine")
public class Machine extends BaseEntity {
    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String model;

    private String description;

    @Column(nullable = false)
    private double speed;

    @ManyToMany
    private List<Cable> cables;
}
