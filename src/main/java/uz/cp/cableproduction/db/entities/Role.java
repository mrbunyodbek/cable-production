package uz.cp.cableproduction.db.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import uz.cp.cableproduction.db.entities.base.BaseEntity;
import uz.cp.cableproduction.db.enums.RoleName;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "roles")
public final class Role extends BaseEntity  {

    @Enumerated(value = EnumType.STRING)
    private RoleName roleName;

//    @Override
//    public String getAuthority() {
//        return roleName.name();
//    }
}
