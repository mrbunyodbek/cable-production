package uz.cp.cableproduction.db.entities.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import uz.cp.cableproduction.db.entities.base.BaseEntity;
import uz.cp.cableproduction.db.enums.ProductionStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Time;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "production")
public class Production extends BaseEntity {

    @Column(name = "is_job_done")
    private Boolean jobDone = false;

    @Column(name = "engineer_id")
    private Integer engineerId;

    @Nullable
    @Column(name = "customer_id")
    private Integer customerId;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "cabling_status")
    private ProductionStatus status = ProductionStatus.PENDING;

    @Column(name = "agent_id")
    private Integer agentId;

    @Column(name = "cable_length")
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

    @Column(nullable = false)
    private Time estimated;


}
