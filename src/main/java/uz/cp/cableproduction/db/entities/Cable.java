package uz.cp.cableproduction.db.entities;


import lombok.*;
import uz.cp.cableproduction.db.entities.base.BaseEntity;
import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cables")

public class Cable extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    private String description;

    private boolean deleted = false;

}


