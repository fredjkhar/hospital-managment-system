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

    @Column(name = "patient_id", nullable = false)
    private UUID patientId;

    @Column(name = "rationale_for_request", nullable = false)
    private String rationaleForRequest;

    @Column(name = "priority_assessment", nullable = false)
    private int priorityAssessment;

    @Column(name = "local_doctor_id", nullable = false)
    private UUID localDoctorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ward_id")
    private WardJpaEntity ward;
}
