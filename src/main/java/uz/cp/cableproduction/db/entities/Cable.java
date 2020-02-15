package uz.cp.cableproduction.db.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.cp.cableproduction.db.entities.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

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


