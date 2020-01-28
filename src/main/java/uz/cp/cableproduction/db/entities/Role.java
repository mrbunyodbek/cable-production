package uz.cp.cableproduction.db.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import uz.cp.cableproduction.db.entities.base.BaseEntity;
import uz.cp.cableproduction.db.enums.RoleName;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "roles")
public final class Role extends BaseEntity implements GrantedAuthority  {

    @Enumerated(value = EnumType.STRING)
    private RoleName roleName;

    @Override
    public String getAuthority() {
        return roleName.name();
    }
}
