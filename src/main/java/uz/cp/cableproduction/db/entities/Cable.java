package uz.cp.cableproduction.db.entities;

import lombok.*;
import uz.cp.cableproduction.db.entities.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity(name = "cables")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cable extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    private String description;

    private boolean deleted = false;

    @ManyToMany
    private List<Machine> machines;
}
