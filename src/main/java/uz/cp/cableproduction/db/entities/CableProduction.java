package uz.cp.cableproduction.db.entities;


import lombok.*;
import uz.cp.cableproduction.db.entities.base.BaseEntity;
import uz.cp.cableproduction.db.enums.ProductionStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Time;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cableProduction")
public class CableProduction extends BaseEntity {

    @Column(nullable = false)
    private int machineId;

    @Column(nullable = false)
    private int cableId;

    @Column(nullable = false)
    private int customerId;

    @Column(nullable = false)
    private int userId;

    @Column(nullable = false)
    private double length;

    @Enumerated(value = EnumType.STRING)
    private ProductionStatus status;

    @Column(nullable = false)
    private LocalDateTime acceptedDate;

    @Column(nullable = false)
    private LocalDateTime startedAt;

    @Column(nullable = false)
    private LocalDateTime endedAt;

    @Column(nullable = false)
    private String description;

    private LocalDateTime errorStarted;

    private LocalDateTime errorEnd;

    @Column(nullable = false)
    private Time estimated;

    private String errorTime;
}
