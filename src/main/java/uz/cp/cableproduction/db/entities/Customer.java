package uz.cp.cableproduction.db.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.cp.cableproduction.db.entities.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "customers")
public class Customer extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

}
