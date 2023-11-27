package hms.pms.Infrastructure.jpa.entities.prescription;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "prescription")
public class PrescriptionJpaEntity {
    @Id
    @GeneratedValue
    private UUID prescriptionId;

    @Column(nullable = false)
    private String drugNumber;

    @Column(nullable = false)
    private String drugName;

    @Column(nullable = false)
    private int unitsByDay;

    @Column(nullable = false)
    private int numberOfAdminsPerDay;

    @ElementCollection
    @CollectionTable(name = "administration_times", joinColumns = @JoinColumn(name = "prescription_id"))
    private List<AdministrationTimesJpaEntity> administrationTimes;

    @Column(nullable = false)
    private String methodOfAdministration;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date finishDate;
}
