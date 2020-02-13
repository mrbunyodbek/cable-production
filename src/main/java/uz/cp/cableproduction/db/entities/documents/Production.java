package uz.cp.cableproduction.db.entities.documents;

import lombok.*;
import org.springframework.lang.Nullable;
import uz.cp.cableproduction.db.entities.base.BaseEntity;
import uz.cp.cableproduction.db.enums.ProductionStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity(name = "production")
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Production extends BaseEntity {

    @Column(name = "is_job_done")
    private Boolean jobDone = false;

    @Column(name = "engineer_id")
    private int engineerId;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "cabling_status")
    private ProductionStatus status = ProductionStatus.PENDING;

    @Column(name = "agent_id")
    private Integer agentId;

    @Column(name = "cable_type")
    private String cableType;

    @Column(name = "cable_weight")
    private Double cableLength;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Nullable
    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @Nullable
    @Column(name = "date_accepted")
    private LocalDateTime dateAccepted;

    @Nullable
    @Column(name = "date_loaded")
    private LocalDateTime dateLoaded;

    @Nullable
    @Column(name = "date_done")
    private LocalDateTime dateDone;

    @Column(name = "error_description", columnDefinition = "TEXT")
    private String descriptionError;

    @Column(name = "error_started")
    private LocalDateTime errorStarted;

    @Column(name = "error_ended")
    private LocalDateTime errorEnd;

    @Column(name = "error_time")
    private String errorTime;

    @Column
    private Time estimated;

    @Column()
    private int orderId;

    @Column(nullable = true)
    private int machineId;


}
