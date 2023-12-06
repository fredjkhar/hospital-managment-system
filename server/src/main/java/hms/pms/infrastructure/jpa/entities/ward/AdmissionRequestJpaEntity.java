package hms.pms.infrastructure.jpa.entities.ward;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "admission_request")
public class AdmissionRequestJpaEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "patientid", nullable = false)
    private UUID patientId;

    @Column(name = "rationaleforrequest", nullable = false)
    private String rationaleForRequest;

    @Column(name = "priorityassessment", nullable = false)
    private int priorityAssessment;

    @Column(name = "localdoctorid", nullable = false)
    private UUID localDoctorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ward_id")
    private WardJpaEntity ward;
}
