package hms.pms.infrastructure.jpa.entities.ward;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "admission")
public class AdmissionJpaEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private UUID patientId;

    @Column(nullable = false)
    private UUID localDoctorId;

    @Column(nullable = false)
    private UUID roomNbr;

    @Column(nullable = false)
    private UUID bedNbr;

    @Column(nullable = false)
    private String privateInsuranceNumber;

    @Column(nullable = false)
    private String rationaleForRequest;

    @Column(nullable = false)
    private int priorityAssessment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ward_id")
    private WardJpaEntity ward;
}
