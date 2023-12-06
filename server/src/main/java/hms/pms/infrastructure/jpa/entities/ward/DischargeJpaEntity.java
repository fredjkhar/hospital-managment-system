package hms.pms.infrastructure.jpa.entities.ward;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "discharge")
public class DischargeJpaEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "patient_id", nullable = false)
    private UUID patientId;

    @Column(name = "discharge_summary", nullable = false)
    private String dischargeSummary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ward_id")
    private WardJpaEntity ward;
}
