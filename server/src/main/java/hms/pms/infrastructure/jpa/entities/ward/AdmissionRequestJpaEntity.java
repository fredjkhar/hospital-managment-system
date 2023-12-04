package hms.pms.infrastructure.jpa.entities.ward;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "admission_request")
public class AdmissionRequestJpaEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private UUID patientId;

    @Column(nullable = false, length = 128)
    private String rationaleForRequest;

    @Column(nullable = false)
    private int priorityAssessment;

    @Column(nullable = false)
    private UUID localDoctorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ward_id")
    private WardJpaEntity ward;
}
