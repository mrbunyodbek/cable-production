package uz.cp.cableproduction.db.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import uz.cp.cableproduction.db.entities.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "machines")
public class Machine extends BaseEntity {
    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String model;

    private String description;

    @Column(nullable = false)
    private double speed;


}
