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
@Entity(name = "engineer")
public class Engineer extends BaseEntity {

    @Column(nullable = false)
    private String name;

}



