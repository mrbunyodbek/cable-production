package uz.cp.cableproduction.db.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.cp.cableproduction.db.entities.base.BaseEntity;
import uz.cp.cableproduction.db.entities.enums.RoleName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class User extends BaseEntity {

    @Column(nullable = true)
    private String firstName;

    @Column(nullable = true)
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    private RoleName roleName;

    @Column(nullable = true)
    private String username;

    @Column(nullable = true)
    private String password;

}

