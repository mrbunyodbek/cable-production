package uz.cp.cableproduction.db.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import uz.cp.cableproduction.db.entities.enums.RoleName;

import javax.persistence.*;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Enumerated(value = EnumType.STRING)
    private RoleName roleName;

}
